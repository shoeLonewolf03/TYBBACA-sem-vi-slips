
import java.sql.*;
import java.io.*;

public class slip16_2 {
    public static void main(String args[]) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement stmt = con.createStatement();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String query = "insert into stud values(?,?,?)";
            ps = con.prepareStatement(query);
            System.out.println("Enter roll no : ");
            int rno = Integer.parseInt(br.readLine());
            System.out.println("Enter name : ");
            String name = br.readLine();
            System.out.println("Enter per : ");
            int per = Integer.parseInt(br.readLine());
            ps.setInt(1, rno);
            ps.setString(2, name);
            ps.setInt(3, per);
            int no = ps.executeUpdate();
            if (no != 0)
                System.out.println("Data inserted succesfully.....");
            else
                System.out.println("Data not inserted");
            // display details
            rs = stmt.executeQuery("select MAX(per) from Stud");
            System.out.println("Maximum percentage\t");
            while (rs.next()) {
                System.out.println("\n" + rs.getInt(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
