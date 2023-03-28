import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class slip24_2 {
    public static void main(String args[]) 
    {
        BufferedReader din= new BufferedReader(new InputStreamReader(System.in));
        int rno,k,ch,per;
        String nm,des;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
            Statement st=con.createStatement();
            do            {
                System.out.println(" 1. Insert \n 2. Update \n 3. Delete \n 4. Search \n 5. Display \n 6. Exit");
                System.out.print("Enter your choice: ");
                ch=Integer.parseInt(din.readLine());
                System.out.println("............................................");
                switch(ch)
                {
                    case 1:
                        System.out.print("How many records you want to inserted ? ");
                        int n=Integer.parseInt(din.readLine());
                        for(int i=0;i<n;i++)
                        {
                            System.out.println("Enter Employee id : ");
                            rno=Integer.parseInt(din.readLine());
                            System.out.println("Enter Name : ");
                            nm=din.readLine();
                            System.out.println("Enter Salary: ");
                            per=Integer.parseInt(din.readLine());
                            System.out.println("Enter Designation : ");
                            des=din.readLine();
                            k=st.executeUpdate("insert into emp values(" + rno + ",'"+ nm + "'," + per +",'"+des+"')");
                            if(k>0)
                            {
                                System.out.println("Record Inserted Successfully..!!");
                                System.out.println("..............................................");
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter the Emp id no: ");
                        rno=Integer.parseInt(din.readLine());
                        System.out.print("Enter the Employee name: ");
                        nm=din.readLine();
                        k=st.executeUpdate("update emp set empname='" + nm + "' where empid="+rno);
                        if(k>0)
                        {
                            System.out.println("Record Is Updated..!!");
                        }
                        System.out.println("...............................................");
                        break;
                    case 3:
                        System.out.print("Enter the Emp id ");
                        rno=Integer.parseInt(din.readLine());
                        k=st.executeUpdate("delete from emp where empid=" +rno);
                        if(k>0)
                        {
                            System.out.println("Record Is Deleted..!!");
                        }
                       System.out.println(".............................................");
                        break;
                    case 4:
                        System.out.print("Enter the Emp id Whoes search record: ");
                        rno=Integer.parseInt(din.readLine());
                        System.out.println(".............................................");
                        ResultSet rs1=st.executeQuery("select * from emp where empid=" +rno);
                        while(rs1.next())
                        {
                            System.out.println(rs1.getInt(1) +"\t" +rs1.getString(2)+"\t"+rs1.getInt(3));
                        }
                        System.out.println(".........................................");
                        break;
                    case 5:
                        ResultSet rs=st.executeQuery("select * from emp");
                        while(rs.next())
                        {
                            System.out.println(rs.getInt(1) +"\t" +rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
                        }
                        System.out.println(".............................................");
                        break;
                    case 6:
                        System.exit(0);
                }
            }
            while(ch!=6);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
