package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,forgot,newuser;
    JTextField tfuser, tfpass;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        JLabel image2 = new JLabel(i3);
        image2.setBounds(0, 0, 500, 500);
        add(image2);
        
        JLabel lblheading = new JLabel("User Name :");
        lblheading.setBounds(30,50,100,30);
        image2.add(lblheading);
        
        tfuser = new JTextField();
        tfuser.setBounds(120,50,300,30);
        image2.add(tfuser);
        
        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setBounds(30,120,100,30);
        image2.add(lblpassword);
        
        tfpass = new JTextField();
        tfpass.setBounds(120,120,300,30);
        image2.add(tfpass);
        
        login = new JButton("LOGIN");
        login.setBounds(300,200,110,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image2.add(login);
        
        forgot = new JButton("Forgot Password");
        forgot.setBounds(100,200,170,40);
        forgot.setBackground(Color.BLACK);
        forgot.setForeground(Color.WHITE);
        image2.add(forgot);
        
        newuser = new JButton("New User");
        newuser.setBounds(250,340,170,40);
        newuser.setBackground(Color.RED);
        newuser.setForeground(Color.BLACK);
        newuser.setFont(new Font("Tohama",Font.BOLD,15));
        newuser.addActionListener(this);
        image2.add(newuser);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i2);
        JLabel image = new JLabel(i5);
        image.setBounds(30, 250, 200, 200);
        image2.add(image);
        
        setBounds(400,150,500,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfuser.getText();
                String password = tfpass.getText();
                
                Conn c = new Conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Home();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
         }else if(ae.getSource() == newuser){
             setVisible(false);
             new Registration();
         }
    }
    
    public static void main(String adar[]){
        
        new Login();
    }
}
