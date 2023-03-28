import java.sql.*;

public class slip8_1 {
    public static void main(String args[]) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement stmt = con.createStatement();

            ResultSet rs0 = stmt.executeQuery("select * from emp");
            while(rs0.next())
            {
              System.out.println(rs0.getInt(1)+ "  "+rs0.getString(2));
            }
            System.out.println("The result set with 'A' is:");
            ResultSet rs = stmt.executeQuery("select * from emp where emp_name like 'A%'");
            while(rs.next())
            {
              System.out.println(rs.getInt(1)+ "  "+rs.getString(2));
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
