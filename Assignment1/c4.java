
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class c4 extends JFrame implements ActionListener {

    private JTextField txtENo, txtEName, txtSalary;
    private JButton btnAdd, btnSave;
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;

    public c4() {
        super("Employee Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create UI components
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ENo:"));
        txtENo = new JTextField();
        inputPanel.add(txtENo);
        inputPanel.add(new JLabel("EName:"));
        txtEName = new JTextField();
        inputPanel.add(txtEName);
        inputPanel.add(new JLabel("Salary:"));
        txtSalary = new JTextField();
        inputPanel.add(txtSalary);
        btnAdd = new JButton("Add");
        btnAdd.addActionListener(this);
        inputPanel.add(btnAdd);
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        inputPanel.add(btnSave);
        add(inputPanel, BorderLayout.NORTH);

        // create table
        model = new DefaultTableModel(new String[]{"ENo", "EName", "Sal"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // connect to database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // display the window
        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            // add new row to table
            String[] rowData = new String[3];
            rowData[0] = txtENo.getText();
            rowData[1] = txtEName.getText();
            rowData[2] = txtSalary.getText();
            model.addRow(rowData);

            // clear input fields
            txtENo.setText("");
            txtEName.setText("");
            txtSalary.setText("");
        } else if (e.getSource() == btnSave) {
            // save data to database
            try {
                Statement stmt = conn.createStatement();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String eno = (String) model.getValueAt(i, 0);
                    String ename = (String) model.getValueAt(i, 1);
                    String sal = (String) model.getValueAt(i, 2);
                    String sql = "INSERT INTO emp (eno, ename, sal) VALUES ('" + eno + "', '" + ename + "', '" + sal + "')";
                    stmt.executeUpdate(sql);
                }
                JOptionPane.showMessageDialog(this, "Data saved successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new c4();
    }
}
