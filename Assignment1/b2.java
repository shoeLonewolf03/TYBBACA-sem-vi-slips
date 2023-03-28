
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class b2 extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    public b2() {
        String[] columnNames = {"Doctor No", "Doctor Name", "Specialization"};
        Object[][] data = {};

        // Create a JTable with the data and column names
        table = new JTable(data, columnNames);
        // Add the JTable to a JScrollPane
        scrollPane = new JScrollPane(table);
        // Add the JScrollPane to the JFrame
        this.add(scrollPane);
        
        this.setTitle("Doctor Details Table");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        // Load the data into the JTable
        loadDoctorData();
    }
    
    private void loadDoctorData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            
            String sql = "SELECT dno, dname, specialization FROM doctor";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            rs.last();
            int numRows = rs.getRow();
            rs.beforeFirst();
            Object[][] data = new Object[numRows][3];
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getInt("dno");
                data[i][1] = rs.getString("dname");
                data[i][2] = rs.getString("specialization");
                i++;
            }

            // Set the data and column names in the JTable
            table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Doctor No", "Doctor Name", "Specialization"}));

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + se.getMessage());
        } catch (Exception ex) {
            // Handle errors for Class.forName
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new b2();
    }
}

