import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DatabaseApplication {
    private JTabbedPane tableTabbedPane;
    private JPanel table1Panel;
    private JTable table1;
    private JPanel rootPanel;
    private JPanel table2Panel;
    private JTable table2;
    private JPanel table3Panel;
    private JTable table3;
    private JPanel modifyPanel;
    private JComboBox modifyOperationComboBox;
    private JLabel recordModifyLabel;
    private JComboBox tableModifyComboBox;
    private JPanel resultingTablePanel;
    private JTable resultingTable;
    private JButton submitModifyButton;
    private JPanel addModifyPanel;
    private JPanel removeModifyPanel;
    private JPanel updateModifyPanel;
    private JTextField IDTextField;
    private JScrollPane table1ScrollPane;
    private JScrollPane table2ScrollPane;
    private JScrollPane table3ScrollPane;
    private JScrollPane resultingTableScrollPane;
    private JTable addTable;
    private JButton addSubmitChanges;
    private JPanel table4Panel;
    private JScrollPane table4ScrollPane;
    private JTable table4;
    private JButton removeSubmitButton;
    private JTable updateTable;
    private JButton updateSubmitChanges;

    //    = = = = USER NEEDED FIELDS = = = =
    private static DatabaseApplication app;
    private static DatabaseOperations dbOperations;
    private static String[][] defaultTable = {
            {"There"},
            {"is"},
            {"no"},
            {"data"},
            {"to"},
            {"show"},
            {"here"},
            {"man"}
    };
    private static String[] tableColHeaders;
    private static String[][] tableData;
    private static String currentTableName;
    private Map<JTable, String> tableStringMap;


    /**
     * Mostly auto-generated event-listeners on what happens in the app.
     */
    public DatabaseApplication(boolean create) {
        tableStringMap = new HashMap<>(); // linking the JTable to the SQL table name
        tableStringMap.put(table1, "natdex");
        tableStringMap.put(table2, "type");
        tableStringMap.put(table3, "evmethod");
        tableStringMap.put(table4, "evolution");

        dbOperations = new DatabaseOperations("pokemon", create);
        if(create) dropCreateFillTables();
        updateTableDataModel(table1, tableStringMap.get(table1)); // update the first table to make it show up on launch

//        Don't want to see modify panels at launch.
        addModifyPanel.setVisible(false);
        removeModifyPanel.setVisible(false);
        updateModifyPanel.setVisible(false);

//        Makes sure the main-view tables are not user-editable.
        JTable[] tables = {table1, table2, table3, table4, resultingTable};
        for (JTable table : tables) {
            table.setEnabled(false);
        }


        tableTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (tableTabbedPane.getSelectedIndex()) {
                    case 0:
                        updateTableDataModel(table1, tableStringMap.get(table1));
                        break;
                    case 1:
                        updateTableDataModel(table2, tableStringMap.get(table2));
                        break;
                    case 2:
                        updateTableDataModel(table3, tableStringMap.get(table3));
                        break;
                    case 3:
                        updateTableDataModel(table4, tableStringMap.get(table4));
                    default:
                        resultingTable.setModel(new DefaultTableModel(defaultTable, new String[1]));
//                        For whatever reason, Swing doesn't like when System.out.print happens. Kinda just breaks.
//                        System.out.println("There was an issue with getting what to do at tab index " + tableTabbedPane.getSelectedIndex() + ".");
                        break;
                }
            }
        });

        submitModifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] addColumnHeaders = new Object[0];
                switch (modifyOperationComboBox.getSelectedIndex()) {
                    case 0:
                        addModifyPanel.setVisible(false);
                        removeModifyPanel.setVisible(false);
                        updateModifyPanel.setVisible(false);
                    case 1:
                        addModifyPanel.setVisible(true);
                        removeModifyPanel.setVisible(false);
                        updateModifyPanel.setVisible(false);
                        break;
                    case 2:
                        addModifyPanel.setVisible(false);
                        removeModifyPanel.setVisible(true);
                        updateModifyPanel.setVisible(false);
                        break;
                    case 3:
                        addModifyPanel.setVisible(false);
                        removeModifyPanel.setVisible(false);
                        updateModifyPanel.setVisible(true);
                        break;
                }
//                Gets what table is requested to change. changes Add and Update panels.
                int tableToModify = tableModifyComboBox.getSelectedIndex();
                switch (tableModifyComboBox.getSelectedIndex()) {
                    case 1 -> {
                        addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table1));
                    }
                    case 2 -> {
                        addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table2));
                    }
                    case 3 -> {
                        addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table3));
                    }
                    case 4 -> {
                        addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table4));
                    }
                }
                addTable.setModel(new DefaultTableModel(new Object[1][addColumnHeaders.length], addColumnHeaders));
                updateTable.setModel(new DefaultTableModel(new Object[1][addColumnHeaders.length], addColumnHeaders));
            }

        });
        addSubmitChanges.addActionListener(new ActionListener() {
            /**
             * When the Submit button is pressed, create a 2D String array of the resulting record data. Execute a SQL statement on the NatDex table.
             *
             * @author Josh Ashton
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] s = new String[1][addTable.getColumnCount()];
                for (int i = 0; i < s.length; i++) {
                    for (int j = 0; j < s[i].length; j++) {
                        s[i][j] = addTable.getValueAt(i, j).toString();
                    }
                }
                dbOperations.execute(NatDexSQL.addData(Integer.parseInt(s[0][0]), s[0][1], Double.parseDouble(s[0][2]), Double.parseDouble(s[0][3]), s[0][4], s[0][5]));
                updateTableDataModel(table1, "natdex");
            }
        });
        removeSubmitButton.addActionListener(new ActionListener() {
            /**
             * When the submit button is pressed, read the text in the text field and parse the NatDexID. Execute a SQL DELETE statement.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dbOperations.execute(NatDexSQL.deleteData(Integer.parseInt(IDTextField.getText())));
                updateTableDataModel(table1, "natdex");
            }
        });


        updateSubmitChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] s = new String[1][updateTable.getColumnCount()];
                for (int i = 0; i < s.length; i++) {
                    for (int j = 0; j < s[i].length; j++) {
                        s[i][j] = updateTable.getValueAt(i, j).toString();
                    }
                }
                dbOperations.execute(NatDexSQL.updateData(Integer.parseInt(s[0][0]), s[0][1], Double.parseDouble(s[0][2]), Double.parseDouble(s[0][3]), s[0][4], s[0][5]));
                updateTableDataModel(table1, "natdex");
            }
        });
    }

    /**
     * Method should be called to drop all tables, create all tables, and fill all tables with pre-determined records.
     */
    private void dropCreateFillTables() {
        dbOperations.execute(NatDexSQL.dropTable());
        dbOperations.execute(NatDexSQL.createTable());
        dbOperations.execute(NatDexSQL.fillTable());

        dbOperations.execute(TypeSQL.dropTable());
        dbOperations.execute(TypeSQL.createTable());
        dbOperations.execute(TypeSQL.fillTable());

        dbOperations.execute(EvMethod.dropTable());
        dbOperations.execute(EvMethod.createTable());
        dbOperations.execute(EvMethod.fillTable());

        dbOperations.execute(Evolution.dropTable());
        dbOperations.execute(Evolution.createTable());
        dbOperations.execute(Evolution.fillTable());
    }

    /**
     * I know that this looks convoluted, but there's a method to the madness.
     * @param targetTable JTable you would like to update.
     * @param tableName getting data from the SQL table.
     */
    public static void updateTableDataModel(JTable targetTable, String tableName) {
        tableColHeaders = dbOperations.getColumnHeaders(tableName);
        tableData = dbOperations.getRowData(tableName);
        currentTableName = tableName;
        targetTable.setModel(new DefaultTableModel(tableData, tableColHeaders));
    }

    /**
     * Asks Swing what data is in the table. Mostly used in Adding and Updating rows in the Application
     *
     * @param table of desired data. Implies that target table is user-editable.
     * @return of strings because dynamically changing data stored is hard.
     */
    public static String[][] getTableData(JTable table) {
        String[][] out;
        out = new String[table.getRowCount()][table.getColumnCount()];

        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                if(table.getValueAt(i, j) == null) {
                    out[i][j] = null; // Detects last col as a null value even when data is entered.
                } else {
                    out[i][j] = table.getValueAt(i, j).toString();
                }
            }
        }

        return out;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatMacDarkLaf() );
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", true);
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        // CREATE = TRUE means all tables are dropped, created, and filled.
        app = new DatabaseApplication(true);

        JFrame frame = new JFrame("Database Application");
            frame.setContentPane(app.rootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
    }
}
