
import java.sql.*;
import java.util.Scanner;

public class a5 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter teacher tno: ");
      int tno = input.nextInt();

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "admin");
         String sql = "DELETE FROM teacher WHERE tno = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, tno);
         int rows = stmt.executeUpdate();
         if (rows == 0) {
            System.out.println("teacher with tno " + tno + " not found.");
         } else {
            System.out.println("teacher with tno " + tno + " deleted.");
         }
      } catch (SQLException e) {
         System.err.println("Error: " + e.getMessage());
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
         }
      }
   }
}
