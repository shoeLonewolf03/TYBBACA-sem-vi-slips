//Semi working
import java.sql.*;

public class slip20_1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            PreparedStatement ps = con.prepareStatement("delete from emp where empid=?");
            int id = Integer.parseInt(args[0]);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            System.out.println("Row deleted, " + rs + "rows affected");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
