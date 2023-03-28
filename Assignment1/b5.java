
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class b5 extends JFrame implements ActionListener
{
    JLabel lblid,lblname,lbladdr,lblyr;
    JTextField txtid,txtname,txtaddr,txtyr;
    JButton btninsert,btnclear,btnexit;
    b5()
    {
        setLayout(null);
        lblid=new JLabel("College id");
        lblname=new JLabel("College Name");
        lbladdr=new JLabel("College Address");
        lblyr=new JLabel("Year");
        txtid=new JTextField();
        txtname=new JTextField();
        txtaddr=new JTextField();
        txtyr=new JTextField();
        btninsert=new JButton("Insert");
        btnclear=new JButton("Clear");
        btnexit=new JButton("Exit");
        lblid.setBounds(20,30,100,20);
        lblname.setBounds(20,70,150,30);
        lbladdr.setBounds(20,110,150,30);
        lblyr.setBounds(20,150,150,30);
        txtid.setBounds(120,30,150,30);
        txtname.setBounds(120,70,150,30);
        txtaddr.setBounds(120,110,150,30);
        txtyr.setBounds(120,150,150,30);
        btninsert.setBounds(10,200,100,50);
        btnclear.setBounds(120,200,100,50);
        btnexit.setBounds(230,200,100,50);
        btninsert.addActionListener(this);
        btnclear.addActionListener(this);
        btnexit.addActionListener(this);
        add(lblid); add(txtid);
        add(lblname); add(txtname);
        add(lbladdr); add(txtaddr);
        add(lblyr); add(txtyr);
        add(btninsert);
        add(btnclear);
        add(btnexit);
        setSize(500,400);
    }
    public void actionPerformed(ActionEvent a)
    {
        try        {
            if(a.getSource()==btninsert)
            {
                int id,yr;
                String nm,add;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "admin");
                PreparedStatement pst = con.prepareStatement("insert into College values(?,?,?,?)");
                id=Integer.parseInt(txtid.getText());
                nm=txtname.getText();
                add=txtaddr.getText();
                yr=Integer.parseInt(txtyr.getText());
                pst.setInt(1,id);
                pst.setString(2,nm);
                pst.setString(3,add);
                pst.setInt(4,yr);
                pst.executeUpdate();
           
                JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
                con.close();
           }
            if(a.getSource()==btnclear)
            {
                txtid.setText("");
                txtname.setText("");
                txtaddr.setText("");
                txtyr.setText("");
            }
            if(a.getSource()==btnexit)
            {
                System.exit(0);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error is :"+e);
        }
    }
    public static void main(String args[])
        {
        new b5().show();
    }
}