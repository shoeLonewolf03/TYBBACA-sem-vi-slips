
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class b1 extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4;
    private JTextField text1, text2, text3, text4;
    private JButton button;
    public b1() {
        label1 = new JLabel("Hospital ID:");
        label2 = new JLabel("Hospital Name:");
        label3 = new JLabel("Address:");
        label4 = new JLabel("Phone Number:");
        
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        
        button = new JButton("Submit");
        
        button.addActionListener(this);
        
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(label3);
        panel.add(text3);
        panel.add(label4);
        panel.add(text4);
        panel.add(button);
        
        this.add(panel);
        this.pack();
        this.setTitle("Hospital Details Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String hid = text1.getText();
            String hname = text2.getText();
            String address = text3.getText();
            String phno = text4.getText();
            
            Connection conn = null;
            Statement stmt = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
                
                String sql = "INSERT INTO hospital (HId, HName, Address, PH_No) " +
                             "VALUES ('" + hid + "', '" + hname + "', '" + address + "', '" + phno + "')";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Hospital details added to the database");

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
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException se2) {
                } // nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new b1();
    }
}

