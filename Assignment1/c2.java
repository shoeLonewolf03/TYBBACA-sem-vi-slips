import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class c2 extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField txtEmpNo, txtEmpName, txtEmpSalary;
    JButton btnUpdate;
    JTable table;
    DefaultTableModel model;

    public c2() {
        setTitle("Employee Salary Updater");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        label1 = new JLabel("Employee No:");
        txtEmpNo = new JTextField(10);

        label2 = new JLabel("Employee Name:");
        txtEmpName = new JTextField(20);

        label3 = new JLabel("Employee Salary:");
        txtEmpSalary = new JTextField(10);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);

        model = new DefaultTableModel();
        model.addColumn("Employee No");
        model.addColumn("Employee Name");
        model.addColumn("Employee Salary");

        table = new JTable(model);

        add(label1);
        add(txtEmpNo);
        add(label2);
        add(txtEmpName);
        add(label3);
        add(txtEmpSalary);
        add(btnUpdate);
        add(new JScrollPane(table));

        setVisible(true);
    }

    public static void main(String[] args) {
        new c2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUpdate) {
            int empNo = Integer.parseInt(txtEmpNo.getText());
            String empName = txtEmpName.getText();
            double empSalary = Double.parseDouble(txtEmpSalary.getText());

            try {
                // Connect to the database
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");

                // Update the salary of the employee
                String updateQuery = "UPDATE Emp SET Sal=? WHERE ENo=?";
                PreparedStatement pstmt = con.prepareStatement(updateQuery);
                pstmt.setDouble(1, empSalary);
                pstmt.setInt(2, empNo);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected == 1) {
                    // Display the updated details in the JTable
                    model.setRowCount(0);
                    String selectQuery = "SELECT * FROM Emp";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(selectQuery);
                    while (rs.next()) {
                        int empNoDB = rs.getInt("ENo");
                        String empNameDB = rs.getString("EName");
                        double empSalaryDB = rs.getDouble("Sal");
                        model.addRow(new Object[]{empNoDB, empNameDB, empSalaryDB});
                    }
                    JOptionPane.showMessageDialog(this, "Salary updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to update salary.");
                }

                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }
}
