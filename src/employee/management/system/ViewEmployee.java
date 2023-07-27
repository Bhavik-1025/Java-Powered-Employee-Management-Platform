
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class ViewEmployee extends JFrame implements ActionListener  {
JTable table;
JLabel heading;
JButton search,back,update,print;
Choice cemployeeid;

ViewEmployee(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    table = new JTable();
    
    heading = new JLabel("Search by Id : ");
    heading.setBounds(10,10,100,30);
    heading.setFont(new Font("Algeria",Font.BOLD,15));
    add(heading);
    
    cemployeeid = new Choice();
    cemployeeid.setBounds(120,12,100,130);
    add(cemployeeid);
    
    search = new JButton("SEARCH");
    search.setBounds(250, 10, 100, 30);
    search.addActionListener(this);
    add(search);
    
    update = new JButton("UPDATE");
    update.setBounds(370, 10, 100, 30);
    update.addActionListener(this);
    add(update);
    
    print = new JButton("PRINT");
    print.setBounds(490, 10, 100, 30);
    print.addActionListener(this);
    add(print);
    
    back = new JButton("Back");
    back.setBounds(610, 10, 100, 30);
    back.addActionListener(this);
    add(back);
    
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from employee");
        while(rs.next()){
            cemployeeid.add(rs.getString("empId"));
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from employee");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        e.printStackTrace();
    }
    
    JScrollPane jsp = new JScrollPane(table);
    jsp.setBounds(0,100,1120,630);
    add(jsp);
    
    setSize(1120, 630);
    setLocation(150, 50);
    setVisible(true);
}
    
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == search){
        String query = "select * from employee where empId = '"+cemployeeid.getSelectedItem()+"'";
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if (ae.getSource() == update){
        setVisible(false);
        new UpdateEmployee(cemployeeid.getSelectedItem());
        
    }else if (ae.getSource() == print){
        try{
            table.print();
        }catch(Exception e){
            e.printStackTrace();
        }
    }else{
        setVisible(false);
        new Home();
    }
}
public static void main(String aff[]){
    
    new ViewEmployee();
}
}
