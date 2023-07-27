package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener {
    JLabel labelUN,labelPass,labelCpass,Question1,Question2;
    JButton Register;
    JTextField tfusername,tfpass,tfCP;
    JComboBox Q1,Q2;
  
    Registration(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        labelUN = new JLabel("UserName : ");
        labelUN.setBounds(10, 10, 100, 30);
        labelUN.setFont(new Font("Tahoma",Font.BOLD,12));
        add(labelUN);
        
        tfusername = new JTextField();
        tfusername.setBounds(110, 10, 130, 30);
        tfusername.setFont(new Font("Tahoma",Font.BOLD,12));
        add(tfusername);
        
        labelPass = new JLabel("Password : ");
        labelPass.setBounds(10, 60, 100, 30);
        labelPass.setFont(new Font("Tahoma",Font.BOLD,12));
        add(labelPass);
        
        tfpass = new JTextField();
        tfpass.setBounds(110, 60, 130, 30);
        tfpass.setFont(new Font("Tahoma",Font.BOLD,12));
        add(tfpass);
        
        labelCpass = new JLabel("Confirm Password : ");
        labelCpass.setBounds(10, 110, 150, 30);
        labelCpass.setFont(new Font("Tahoma",Font.BOLD,12));
        add(labelCpass);
        
        tfCP = new JTextField();
        tfCP.setBounds(160, 110, 130, 30);
        tfCP.setFont(new Font("Tahoma",Font.BOLD,12));
        add(tfCP);
        
        Question1 = new JLabel("Security Quetion 1 ! What is favorite Dish ? ");
        Question1.setBounds(10, 160, 370, 30);
        Question1.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Question1);
        
        String food[] = {"Pav Bhaji", "Dosa", "Chole Bhature", "Noodles", "Pizza"};
        Q1 = new JComboBox(food);
        Q1.setBackground(Color.WHITE);
        Q1.setBounds(10, 200, 150, 30);
        add(Q1);
        
        Question2 = new JLabel("Security Quetion 2 ! What is favorite Place ? ");
        Question2.setBounds(10, 250, 370, 30);
        Question2.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Question2);
        
        String place[] = {"South India", "Himalyas", "Goa", "Gujrat", "Rajeshthan"};
        Q2 = new JComboBox(place);
        Q2.setBackground(Color.WHITE);
        Q2.setBounds(10, 300, 150, 30);
        add(Q2);
        
        Register = new JButton("Register");
        Register.setBounds(160, 400, 150, 40);
        Register.addActionListener(this);
        Register.setBackground(Color.BLACK);
        Register.setForeground(Color.WHITE);
        add(Register);
        
        
        
        setBounds(400,150,500,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String UName = tfusername.getText();
        String Pass = tfpass.getText();
        String ConPass = tfCP.getText();
        String Que1 = (String) Q1.getSelectedItem();
        String Que2 = (String) Q2.getSelectedItem();
        try{
            if(Pass.equals(ConPass)){
                Conn c = new Conn();
            String query = "INSERT INTO login VALUES ('"+UName+"','"+Pass+"','"+ConPass+"','"+Que1+"','"+Que2+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Registration successfully");
            setVisible(false);
        new Login();
            }
            else{
                JOptionPane.showMessageDialog(null, "Cross Check the Passwords");
                setVisible(false);
        new Registration();
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String afa[]){
        new Registration();
    }
}
