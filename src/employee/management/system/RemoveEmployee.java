
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class RemoveEmployee extends JFrame implements ActionListener  {

JLabel labelempId;
Choice cEmpId;
JButton delete,back;

RemoveEmployee(){

    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
    
    labelempId = new JLabel("Employee Id");
    labelempId.setBounds(400,200,180,30);
    labelempId.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(labelempId);
    
    cEmpId = new Choice();
    cEmpId.setBounds(600,200,150, 30);
    cEmpId.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(cEmpId);
    
    try{
        Conn c = new Conn();
        String query = "select * from employee";
        ResultSet rs = c.s.executeQuery(query);
        while (rs.next()){
            cEmpId.add(rs.getString("empId"));
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }
    
    JLabel labelname = new JLabel("Name");
    labelname.setBounds(400,250,100,30);
    labelname.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(labelname);
    
    JLabel lblname = new JLabel();
    lblname.setBounds(600,250,100,30);
    lblname.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(lblname);
    
    JLabel labelphone = new JLabel("Phone");
    labelphone.setBounds(400,300,100,30);
    labelphone.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(labelphone);
    
    JLabel lblphone = new JLabel();
    lblphone.setBounds(600,300,150,30);
    lblphone.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(lblphone);
    
    JLabel labelemail = new JLabel("Email");
    labelemail.setBounds(400,350,100,30);
    labelemail.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(labelemail);
    
    JLabel lblemail = new JLabel();
    lblemail.setBounds(600,350,200,30);
    lblemail.setFont(new Font("Tahoma",Font.BOLD,20));
    image.add(lblemail);

    
    cEmpId.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent ie){
                      
    try{
        Conn c = new Conn();
        String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
        ResultSet rs = c.s.executeQuery(query);
        while (rs.next()){
            lblname.setText(rs.getString("name"));
            lblphone.setText(rs.getString("phone"));
            lblemail.setText(rs.getString("email"));
                    
        }        
    }catch(Exception e){
        e.printStackTrace();
    }  
        }
    });
    
    delete = new JButton("Delete");
    delete.setBounds(420, 450, 150, 30);
    delete.setFont(new Font("Tahoma",Font.BOLD,20));
    delete.setBackground(Color.PINK);
    delete.addActionListener(this);
    image.add(delete);
    
    back = new JButton("Back");
    back.setBounds(620, 450, 150, 30);
    back.setFont(new Font("Tahoma",Font.BOLD,20));
    back.setBackground(Color.PINK);
    back.addActionListener(this);
    image.add(back);
    
    
    setSize(1120, 630);
    setLocation(150, 50); 
    setVisible(true);
}
    
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == delete){
        try{
            Conn c = new Conn();
            String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
            setVisible(false);
            new Home();
        }catch(Exception e){
            e.printStackTrace();
        }
    }else{
        setVisible(false);
        new Home();
    }
}
public static void main(String aff[]){
    
    new RemoveEmployee();
}
}
