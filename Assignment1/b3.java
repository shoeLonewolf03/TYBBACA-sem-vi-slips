
import java.sql.*;

public class b3{
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM mytable");
            
            System.out.println("Initial ResultSet:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getInt("age"));
            }
            
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE mytable SET age = ? WHERE id = ?");
            updateStmt.setInt(1, 30);
            updateStmt.setInt(2, 1);
            updateStmt.executeUpdate();
            
            rs.refreshRow();
            
            System.out.println("Updated ResultSet:");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getInt("age"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
