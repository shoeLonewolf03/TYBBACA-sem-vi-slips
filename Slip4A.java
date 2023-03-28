import java.sql.*;
public class Slip4A {
    public static void main(String args[]) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement stmt = con.createStatement();

            ResultSet rs0 = stmt.executeQuery("select * from student");
            while(rs0.next())
            {
              System.out.println(rs0.getInt(1)+ "  "+rs0.getString(2));
            }
            int rs = stmt.executeUpdate("delete from student where name like 'S%'");
            System.out.println("Sucessfully deleted "+rs+" records.");
            ResultSet rs1 = stmt.executeQuery("select * from student");
            while(rs1.next())
            {
              System.out.println(rs1.getInt(1)+ "  "+rs1.getString(2));
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}