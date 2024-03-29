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
                "EvMethodID int not null primary key,\n" +
                "EvMethod varchar(255))");
    }

    /**
     * <p>Generates a SQL statement to insert all pokemon evolution methods into the EvMethod table.</p>
     *
     * @return a SQL INSERT statement
     */
    public static String fillTable() {
        return ("INSERT INTO EvMethod(EvMethodID,EvMethod) VALUES " +
                "(1, 'Level Up'), " +
                "(2,'Thunderstone'), " +
                "(3,'Water stone'), " +
                "(4,'Firestone'), " +
                "(5,'Friendship')");
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
