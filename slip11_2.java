import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class slip11_2 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Sales WHERE Date BETWEEN ? AND ?");
             Scanner scanner = new Scanner(System.in)) {

            // get the start and end dates from the user
            System.out.print("Enter start date (yyyy-mm-dd): ");
            String startDate = scanner.nextLine();
            System.out.print("Enter end date (yyyy-mm-dd): ");
            String endDate = scanner.nextLine();

            // set the start and end dates as parameters in the query
            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);

            // execute the query and get the result set
            ResultSet rs = pstmt.executeQuery();

            // display the sales details in the console
            while (rs.next()) {
                int pid = rs.getInt("PID");
                String pname = rs.getString("PName");
                int qty = rs.getInt("Qty");
                double rate = rs.getDouble("Rate");
                double amount = rs.getDouble("Amount");

                System.out.printf("%d\t%s\t%d\t%.2f\t%.2f\n", pid, pname, qty, rate, amount);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
