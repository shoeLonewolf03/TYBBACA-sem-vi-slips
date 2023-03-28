import java.sql.*;
import java.util.Scanner;;

public class slip27_2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int ch;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from teacher");
            int count=0;
            while(rs.next())
            count++;
            System.out.println("Which Record u want");
            System.out.println("Records are = "+count);
            do
            { System.out.println("1 First \n2 last \n3 next \n4 prev \n0 Exit");
            ch=s.nextInt();
            switch(ch)
            {
            case 1: rs.first();
            System.out.println("Tid :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
            case 2: rs.last();
            System.out.println("Tid :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
            case 3 : rs.next();
            if(rs.isAfterLast())
            System.out.println("can't move forword");
            else
            System.out.println("Tid :"+rs.getInt(1)+" Name :"+rs.getString(2));
            break;
            case 4 : rs.previous();
                if(rs.isBeforeFirst())
            System.out.println("can't move backword");
            else
            System.out.println("Tid :"+rs.getInt(1)+" Name :"+rs.getString(2));
            break;
            case 0 : break;
            default:System.out.println("Enter valid operation");
            }//switch
            }while(ch!=0);


        }
        catch(Exception e){

        }
    s.close();
    }
}
