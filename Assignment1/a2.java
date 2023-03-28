
import java.sql.*;
public class a2 {
    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            
            // Create a statement object
            Statement stmt = conn.createStatement();
            
            // Execute a query to retrieve employee names starting with 'A'
            String sql = "SELECT name FROM employee ";
            ResultSet rs = stmt.executeQuery(sql);
            
            // Loop through the result set and print the names
            System.out.println("Employees names :");
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}