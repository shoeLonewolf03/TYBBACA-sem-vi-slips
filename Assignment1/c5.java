
import java.sql.*;

public class c5 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/jdbc";

    static final String USER = "root";
    static final String PASS = "admin";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            // Creating tables
            String sql1 = "CREATE TABLE Employees1 " +
                    "(id INT not NULL, " +
                    " name VARCHAR(255), " +
                    " age INT, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql1);

            String sql2 = "CREATE TABLE Departments " +
                    "(id INT not NULL, " +
                    " dept_name VARCHAR(255), " +
                    " location VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql2);

            String sql3 = "CREATE TABLE Salaries " +
                    "(emp_id INT not NULL, " +
                    " salary INT, " +
                    " from_date DATE, " +
                    " to_date DATE)";
            stmt.executeUpdate(sql3);

            String sql4 = "CREATE TABLE Titles " +
                    "(emp_id INT not NULL, " +
                    " title VARCHAR(255), " +
                    " from_date DATE, " +
                    " to_date DATE)";
            stmt.executeUpdate(sql4);

            String sql5 = "CREATE TABLE Departments_Employees " +
                    "(dept_id INT not NULL, " +
                    " emp_id INT not NULL)";
            stmt.executeUpdate(sql5);

            System.out.println("Tables created successfully");

            // Adding a column to a table
            String sql6 = "ALTER TABLE Employees ADD salary INT";
            stmt.executeUpdate(sql6);
            System.out.println("Column added successfully");

            // Dropping a table from the database
            String sql7 = "DROP TABLE Employees";
            stmt.executeUpdate(sql7);
            System.out.println("Table dropped successfully");

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
