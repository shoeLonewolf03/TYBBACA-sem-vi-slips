
import java.sql.*;
public class a4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
          String sql = "ALTER TABLE emp ADD COLUMN Sal";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("Salary column deleted from Emp table");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
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
