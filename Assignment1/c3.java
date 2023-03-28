
import java.sql.*;
public class c3 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            // Execute a query to retrieve all rows from the Teacher table
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            
            // Move the cursor to the last row of the ResultSet
            rs.last();
            
            // Get the number of rows in the ResultSet
            int rowCount = rs.getRow();
            System.out.println("Number of rows: " + rowCount);
            
            // Move the cursor to the first row of the ResultSet
            rs.beforeFirst();
            
            // Iterate over the ResultSet and print each row
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
            /*     String subject = rs.getString("Subject");
                System.out.println("Tno: " + tno + ", TName: " + tname + ", Subject: " + subject);*/
            }
            
            // Close the ResultSet, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
