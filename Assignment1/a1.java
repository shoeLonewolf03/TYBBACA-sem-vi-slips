

import java.sql.*;
public class a1
{
    public static void main(String[] args) 
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;

        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(*) AS count FROM employee";
            rs = stmt.executeQuery(sql);
            while (rs.next()) 
            {
                count = rs.getInt("count");
            }
            System.out.println("Number of employee records: " + count);
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) 
        {
            System.out.println("Error: " + se.getMessage());
        } catch (Exception e) 
        {
            // Handle errors for Class.forName
            e.printStackTrace();
        } 
        
    }   
}

