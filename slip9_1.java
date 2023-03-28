import java.sql.*;

public class slip9_1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE Employee (EmpID int,Ename varchar(255), Salary float);");
            PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
            ps.setInt(1, 102);
            ps.setString(2, "Floyd");
            ps.setFloat(3, (float) 10000.00);
            int rs = ps.executeUpdate();
            System.out.println("Row inserted, " + rs + " rows affected");
            ResultSet rs1 = stmt.executeQuery("select * from employee");
            while (rs1.next()) {
                System.out.println(rs1.getInt(1) + "  " + rs1.getString(2) + "  " + rs1.getInt(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
