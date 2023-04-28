
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastCash,balance,pinchange,mini,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
                
        
        JLabel text = new JLabel("PLEASE SELECT WITHDRAWL AMOUNT");
        text.setBounds(180,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs.100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs.500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Rs.1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        mini = new JButton("Rs.2000");
        mini.setBounds(355,450,150,30);
        mini.addActionListener(this);
        image.add(mini);
        
        pinchange = new JButton("Rs.5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Rs.10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
       setUndecorated(true);
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
           String amount = ((JButton)e.getSource()).getText().substring(3);
           Conn c = new Conn();
           try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                 if(e.getSource()!=exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }
                 Date date =  new Date();
                 String query = "insert into bank values ('"+pinnumber+"', '"+date+"' , 'Withdrawl', '"+amount+"' )";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited sucessfully");
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
           }catch(Exception ae){
               System.out.println(ae);
           }
        }
        
    }
}
