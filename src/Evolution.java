/**
 * Abstracts all SQL code relating to the Evolution table away from the Java application code.
 *
 * @author Josh Ashton
 */
public class Evolution {
    /**
     * <p>Generates a SQL statement to create the Evolution table. Drops the table if it already exists, and creates the table.</p>
     *
     * @return
     */
    public static String createTable() {
        return ("CREATE TABLE Evolution (" +
                "EvolutionID int not null primary key,\n" +
                "DexID int not null,\n" +
                "PrevID int,\n" +
                "NextID int,\n" +
                "MethodID int not null)");
    }

    /**
     * <p>Generates a SQL statement to insert all pokemon evolutions into the Evolution table.</p>
     *
     * @return a SQL INSERT statement
     */
    public static String fillTable() {
        return "INSERT INTO Evolution(EvolutionID,DexID,PrevID,NextID,MethodID) VALUES " +
                "(1,1,null,2,1),\n" +
                "(2,2,1,3,1),\n" +
                "(3,3,2,null,1)";
    }

    /**
     * <p>Generates a SQL statement to drop the Evolution table.</p>
     *
     * @return a SQL DROP statement
     */
    public static String dropTable() {
        return ("DROP TABLE Evolution");
    }

    /**
     * <p>Generates a SQL statement to select all data from the Evolution table.</p>
     *
     * @return a SQL SELECT statement
     */
    public static String selectData() {
        return ("SELECT * FROM Evolutions;");
    }

    /**
     * <p>Generates a SQL statement to select a specific data entry by a National Pokedex ID number.</p>
     *
     * @param dexID
     * @return
     */
    public static String selectData(int dexID) {
        return ("SELECT * FROM Evolutions " +
                "WHERE DexID=" + dexID + ";");
    }

    /**
     * <p>Generates a SQL statement to delete a specific data entry by a National Pokedex ID number.</p>
     *
     * @param dexID
     * @return a SQL DELETE statement
     */
    public static String deleteData(int dexID) {
        return ("DELETE FROM Evolutions " +
                "WHERE DexID=" + dexID + ";");
    }

    /**
     * <p>Generates a SQL statement to delete all data entries that evolve via a specific method.</p>
     *
     * @param methodID
     * @return a SQL DELETE statement
     */
    public static String deleteDataByMethod(int methodID) {
        return ("DELETE FROM Evolutions " +
                "WHERE methodID=" + methodID + ";");
    }

    /**
     * <p>Generates SQL statement to sort data by a given option input.</p>
     * <br>
     * <p>1 = dexID ascending, 2 = dexID descending, 3 = methodID ascending, 4 = methodID descending/p>
     *
     * @param option
     * @return a SQL ORDER BY statement
     */
    public static String order(int option) {
        switch (option) {
            case 1:
                return ("SELECT * FROM Evolutions ORDER BY DexID ASC;");
            case 2:
                return ("SELECT * FROM Evolutions ORDER BY DexID DESC;");
            case 3:
                return ("SELECT * FROM Evolutions ORDER BY MethodID ASC;");
            case 4:
                return ("SELECT * FROM Evolutions ORDER BY MethodID DESC;");
            default:
                return ("SELECT * FROM Evolutions;");
        }
    }
}
