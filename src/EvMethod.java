/**
 * Abstracts all SQL code relating to the EvMethod table away from the Java application code.
 *
 * @author Josh Ashton
 */
public class EvMethod {
    /**
     * <p>Generates a SQL statement to create the EvMethod table. Drops the table if it already exists, and creates the table.</p>
     *
     * @return a SQL CREATE statement
     */
    public static String createTable() {
        return ("CREATE TABLE EvMethod (" +
                "EvMethodID int not null primary key GENERATED,\n" +
                "EvMethod char(255))");
    }

    /**
     * <p>Generates a SQL statement to insert all pokemon evolution methods into the EvMethod table.</p>
     *
     * @return a SQL INSERT statement
     */
    public static String fillTable() {
        return null; // TODO
    }

    /**
     * <p>Generates a SQL statement to drop the EvMethod table.</p>
     *
     * @return a SQL DROP statement
     */
    public static String dropTable() {
        return ("DROP TABLE EvMethod");
    }

    /**
     * <p>Generates a SQL statement to select all data from the EvMethod table.</p>
     *
     * @return a SQL SELECT statement
     */
    public static String selectData() {
        return ("SELECT * FROM EvMethod;");
    }
}
