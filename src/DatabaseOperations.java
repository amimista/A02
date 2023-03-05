import java.sql.*;

/**
 * Eliminates the need for all the try-catch jargon that would otherwise fill up many lines of code in the Applications' main method.
 *
 * @author Marcus Walker
 */
public class DatabaseOperations {
    private String database_url;

    /**
     * Creates an Apache Derby Database. Also creates an instance of class along with related
     * operations in the class.
     * @param db_name JDBC Database Name <code>jdbc:derby:[DATABASE];</code>
     * @param create (recommended) asks if you would like to put a <code>create=true</code> at the end of the URL. Used to make a new database if not already created.
     */
    public DatabaseOperations(String db_name, boolean create) {
        if (create) {
            database_url = "jdbc:derby:" + db_name + ";create=true";
        } else {
            database_url = "jdbc:derby:" + db_name + ";";
        }
    }

    /**
     * Simply just makes it where you don't need to include the try-catch with resources. Equivalent to statement.executeQuery();
     *
     * @param sql SQL text to run
     * @return 2D String Array of what is queried.
     */
    public String[][] executeQuery(String sql) {
        String[][] resultArr = null;

        try (Connection connection = DriverManager.getConnection(database_url);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData meta = resultSet.getMetaData();

            int rowCount = 0;
            while (resultSet.next())
                rowCount++;
            while (resultSet.previous())
                resultSet.previous();

            resultArr = new String[rowCount][meta.getColumnCount()];
//            first row is table headers
            for (int i = 1; i <= resultArr[0].length; i++) {
                resultArr[0][i - 1] = meta.getColumnLabel(i);
            }

//            the rest is the actual data
            for (int i = 1; resultSet.next(); i++) {
                for (int j = 1; j <= meta.getColumnCount(); j++) {
                    resultArr[i][j - 1] = resultSet.getObject(j).toString();
                }
            }

        } catch (SQLException sqlException) {
            System.out.println("There was in issue accessing requested data.");
            sqlException.printStackTrace();
        }

        return resultArr;
    }

    /**
     * Simply just makes it where you don't need to include the try-catch with resources. Equivalent to statement.execute();
     *
     * @param sql SQL text to run
     */
    public void execute(String sql) {
        try (Connection connection = DriverManager.getConnection(database_url);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            statement.execute(sql);

        } catch (SQLException sqlException) {
            System.out.println("There was in issue accessing requested data.");
            sqlException.printStackTrace();
        }
    }

    /**
     * Gets the table column headers for the requested table.
     *
     * @param tableName desired table to get column headers from. Must be a SQL table name
     * @return Array of column headers. Always uppercase.
     */
    public String[] getColumnHeaders(String tableName) {
        String[] out = null;
        try (Connection connection = DriverManager.getConnection(database_url);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData meta = resultSet.getMetaData();

            out = new String[meta.getColumnCount()];
            for (int i = 1; i <= out.length; i++) {
                out[i - 1] = meta.getColumnLabel(i);
            }

        } catch (SQLException sqlException) {
            System.out.println("There was in issue accessing requested data.");
            sqlException.printStackTrace();
        }
        return out;
    }

    /**
     * Gets table data from requested table.
     *
     * @param tableName SQL table name
     * @return 2D array of what is queried.
     */
    public String[][] getRowData(String tableName) {
        String[][] out = null;

        try (Connection connection = DriverManager.getConnection(database_url);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData meta = resultSet.getMetaData();

            int rowCount = 0;
            while (resultSet.next())
                rowCount++;
            while (resultSet.previous())
                resultSet.previous();

            out = new String[rowCount-1][meta.getColumnCount()];

            resultSet.next();
            for (int i = 0; resultSet.next(); i++) {
                for (int j = 1; j <= meta.getColumnCount(); j++) {
                    if (resultSet.getObject(j) != null) {
                        out[i][j - 1] = resultSet.getObject(j).toString();
                    }
                }
            }

        } catch (SQLException sqlException) {
            System.out.println("There was in issue accessing requested data.");
            sqlException.printStackTrace();
        }

        return out;
    }

    public static void main(String[] args) {
        DatabaseOperations db_opp = new DatabaseOperations("pokemon", true);
        db_opp.execute("DROP TABLE NATDEX");
        db_opp.execute(NatDexSQL.createTable());
        db_opp.execute(NatDexSQL.fillTable());

//        db_opp.execute("DROP TABLE Type");
//        db_opp.execute(TypeSQL.createTable());
//        db_opp.execute(TypeSQL.fillTable());

//        db_opp.execute(EvMethod.createTable());
//        db_opp.execute(EvMethod.fillTable());
//
//        db_opp.execute(Evolution.createTable());
//        db_opp.execute(Evolution.fillTable());
    }
}
