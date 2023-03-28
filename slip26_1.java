import java.sql.*;

class slip26_1{

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select colname from college");
            System.out.println("College name\n-------------");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}