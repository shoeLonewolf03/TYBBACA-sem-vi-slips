import java.sql.*;
public class slip12_1 {
    public static void main(String args[]) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from emp");
            rs.next();
            int count=rs.getInt(1);
            System.out.println("Number of rows are: "+ count );
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
