
import java.sql.*;

public class c1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "admin";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            
            // Create table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS employees "
                                     + "(id INT NOT NULL AUTO_INCREMENT, "
                                     + "name VARCHAR(255) NOT NULL, "
                                     + "salary DOUBLE NOT NULL, "
                                     + "PRIMARY KEY (id))";
            stmt.executeUpdate(createTableQuery);
            
            // Insert data
            String insertDataQuery = "INSERT INTO employees (name, salary) VALUES "
                                     + "('durgesh', 50000.0), "
                                     + "('rahim', 60000.0)";
            stmt.executeUpdate(insertDataQuery);
            
            // Update data
            String updateDataQuery = "UPDATE employees SET salary = 55000.0 WHERE name = 'zubiya'";
            stmt.executeUpdate(updateDataQuery);
            
            // Search for data
            String searchQuery = "SELECT * FROM employees WHERE name = 'durgesh'";
            ResultSet rs = stmt.executeQuery(searchQuery);
            if (rs.next()) {
                System.out.println("Found employee: " + rs.getString("name") + ", Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee not found.");
            }
            
            // Display data
            String displayQuery = "SELECT * FROM employees";
            rs = stmt.executeQuery(displayQuery);
            System.out.println("Employee Table:");
            System.out.println("ID\tName\tSalary");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}


