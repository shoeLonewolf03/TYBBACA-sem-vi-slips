
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class a3
{
  public static void main(String[] args) throws SQLException 
  {
    try 
    {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
    String createTable = "CREATE TABLE student2 " + "(rno INTEGER not NULL, " + " sname VARCHAR(255), " + " per DOUBLE, " + " PRIMARY KEY ( rno ))";
    PreparedStatement createTableStmt = connection.prepareStatement(createTable);
    createTableStmt.executeUpdate();
    createTableStmt.close();
    connection.close();
    }
   catch (SQLException e) 
    {
    System.out.println("Error: " + e.getMessage());
    }
  }
}

