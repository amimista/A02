/**
 * Abstracts all SQL code relating to the Type table away from the Java application code.
 *
 * @author Josh Ashton
 */
public class TypeSQL {
    /**
     * <p>Generates a SQL statement to create the Type table. Drops the table if it already exists, and creates the table.</p>
     *
     * @return a SQL CREATE statement
     */
    public static String createTable() {
        return ("CREATE TABLE Type (" +
                "TypeID int not null primary key,\n" +
                "Type char(10))");
    }

    /**
     * <p>Generates a SQL statement to insert all pokemon types into the Type table.</p>
     *
     * @return a SQL INSERT statement
     */
    public static String fillTable() {
        return ("INSERT INTO Type VALUES (" +
                "(1, 'Normal'), " +
                "(2,'Fire'), " +
                "(3,'Water'), " +
                "(4,'Grass'), " +
                "(5,'Electric'), " +
                "(6,'Ice'), " +
                "(7,'Fighting'), " +
                "(8,'Poison'), " +
                "(9,'Ground'), " +
                "(10,'Flying'), " +
                "(11,'Psychic'), " +
                "(12,'Bug'), " +
                "(13,'Rock'), " +
                "(14,'Ghost'), " +
                "(15,'Dark'), " +
                "(16,'Dragon'), " +
                "(17,'Steel'), " +
                "(18,'Fairy'))");
    }

    /**
     * <p>Generates a SQL statement to drop the Type table.</p>
     *
     * @return a SQL DROP statement
     */
    public static String dropTable() {
        return ("DROP TABLE Type");
    }

    /**
     * <p>Generates a SQL statement to select all data from the Type table.</p>
     *
     * @return a SQL SELECT statement
     */
    public static String selectData() {
        return ("SELECT * FROM Type");
    }
}
