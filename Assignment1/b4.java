
import java.sql.*;

public class b4 {

    public static void main(String[] args) {
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin")) {
          
            // Create a new table
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE users (id INT NOT NULL, name VARCHAR(255), email VARCHAR(255), PRIMARY KEY (id))";
                stmt.executeUpdate(sql);
                System.out.println("Table created successfully.");
            } catch (SQLException ex) {
                System.err.println("Error creating table: " + ex.getMessage());
            }
            
            // Alter the table to add a new column
            try (Statement stmt = conn.createStatement()) {
                String sql = "ALTER TABLE users ADD COLUMN age INT";
                stmt.executeUpdate(sql);
                System.out.println("Table altered successfully.");
            } catch (SQLException ex) {
                System.err.println("Error altering table: " + ex.getMessage());
            }
            
            //Drop the table
            try (Statement stmt = conn.createStatement()) {
                String sql = "DROP TABLE users";
                stmt.executeUpdate(sql);
                System.out.println("Table dropped successfully.");
            } catch (SQLException ex) {
                System.err.println("Error dropping table: " + ex.getMessage());
            } 
            
        } catch (SQLException ex) {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
    }
}
