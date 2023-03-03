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
    private JTable[] tables = {table1, table2, table3, resultingTable};


    public DatabaseApplication() {
        tableStringMap = new HashMap<>();
        updateTableDataModel(table1, "Student"); // update the first table to make it show up on launch
        addModifyPanel.setVisible(false); // don't wanna see those yet
        removeModifyPanel.setVisible(false);
        updateModifyPanel.setVisible(false);
        for (JTable table: tables) {
            table.setEnabled(false);
        }
        tableStringMap.put(table1, "Student");
        tableStringMap.put(table2, "College");
        tableStringMap.put(table3, "StudentCollege");


        tableTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (tableTabbedPane.getSelectedIndex()) {
                    case 0:
                        updateTableDataModel(table1, tableStringMap.get(table1)); // TODO: 3/1/2023
                        break;
                    case 1:
                        updateTableDataModel(table2, tableStringMap.get(table2)); // TODO: 3/1/2023
                        break;
                    case 2:
                        updateTableDataModel(table3, tableStringMap.get(table3)); // TODO: 3/1/2023
                        break;
                    default:
                        resultingTable.setModel(new DefaultTableModel(defaultTable, new String[1]));
//                        System.out.println("There was an issue with getting what to do at tab index " + tableTabbedPane.getSelectedIndex() + ".");
                        break;
                }
            }
        });

        submitModifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModifyComboBox.getSelectedIndex() != 0) {
                    switch (modifyOperationComboBox.getSelectedIndex()) {
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

                    Object[] addColumnHeaders;
                    switch (tableModifyComboBox.getSelectedIndex()) {
                        case 1:
                            addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table1));
                            addTable.setModel(new DefaultTableModel(new Object[1][addColumnHeaders.length], addColumnHeaders));
                            break;
                        case 2:
                            addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table2));
                            addTable.setModel(new DefaultTableModel(new Object[1][addColumnHeaders.length], addColumnHeaders));
                            break;
                        case 3:
                            addColumnHeaders = dbOperations.getColumnHeaders(tableStringMap.get(table3));
                            addTable.setModel(new DefaultTableModel(new Object[1][addColumnHeaders.length], addColumnHeaders));
                            break;

                    }

                } else {
                    addModifyPanel.setVisible(false);
                    removeModifyPanel.setVisible(false);
                    updateModifyPanel.setVisible(false);
                }
            }
        });
        addSubmitChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Arrays.deepToString(getTableData(addTable)));
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatMacDarkLaf() );
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", true);
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        dbOperations = new DatabaseOperations("FirstDatabase", true);
        app = new DatabaseApplication();

//        System.out.println(Arrays.toString(dbOperations.getColumnHeaders("Student")))

        JFrame frame = new JFrame("Database Application");
        frame.setContentPane(app.rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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

    public static String[][] getTableData(JTable table) {
        String[][] out;
        out = new String[table.getRowCount()][table.getColumnCount()];

        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                out[i][j] = table.getValueAt(i, j).toString();
            }
        }

        return out;
    }

    private static void print2DArray(Object[][] arr) {
        System.out.println("==============ARRAY PRINT==============");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
