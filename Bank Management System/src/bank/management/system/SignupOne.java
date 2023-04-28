
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    long random;
     JTextField nameText,fnameText,emailText,addressText,cityText,stateText,pcodeText;
     JButton next;
     JRadioButton male,female,other,married,unmarried;
     JDateChooser dobText;
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
         random=(Math.abs((ran.nextLong()%9000L)+1000L));
        
        JLabel formno = new JLabel ("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(180,20,600,40);
        add(formno);
        
        
        JLabel name = new JLabel ("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        
         nameText =  new JTextField ();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,140,400,30);
        add(nameText);
         
        
        JLabel fname = new JLabel ("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         fnameText =  new JTextField ();
        fnameText.setFont(new Font("Raleway",Font.BOLD,14));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);
        
        
        
        
        JLabel dob = new JLabel ("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
         dobText =  new JDateChooser ();
        dobText.setForeground(new Color(105,150,150));
        dobText.setBounds(300,240,200,30);
        add(dobText);
        
        JLabel gender = new JLabel ("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
         male = new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        JLabel email = new JLabel ("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
         emailText =  new JTextField ();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,340,400,30);
        add(emailText);
        
        JLabel shadi = new JLabel ("Marital Status:");
        shadi.setFont(new Font("Raleway",Font.BOLD,20));
        shadi.setBounds(100,390,200,30);
        add(shadi);
        
         married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
         other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup shadiGroup = new ButtonGroup();
        shadiGroup.add(married);
        shadiGroup.add(unmarried);
        shadiGroup.add(other);
        
        JLabel address = new JLabel ("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        
         addressText =  new JTextField ();
        addressText.setFont(new Font("Raleway",Font.BOLD,14));
        addressText.setBounds(300,440,400,30);
        add(addressText);
        
        JLabel city = new JLabel ("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        
         cityText =  new JTextField ();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,490,400,30);
        add(cityText);
        
        
        JLabel state = new JLabel ("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        
         stateText =  new JTextField ();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,540,400,30);
        add(stateText);
        
        JLabel pcode = new JLabel ("PinCode:");
        pcode.setFont(new Font("Raleway",Font.BOLD,20));
        pcode.setBounds(100,590,200,30);
        add(pcode);
        
         pcodeText =  new JTextField ();
        pcodeText.setFont(new Font("Raleway",Font.BOLD,14));
        pcodeText.setBounds(300,590,400,30);
        add(pcodeText);
        
        JLabel personalDetails = new JLabel ("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    
        
    public static void main(String args[]){
         new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+ random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField)dobText.getDateEditor().getUiComponent()).getText();
        String gender = null;
         if(male.isSelected()){
             gender="Male";
         }else if(female.isSelected()){
            gender="Female";  
    }
        String email = emailText.getText();
        String shadi=null;
        if(married.isSelected()){
            shadi="Married";
        }else if(unmarried.isSelected()){
            shadi="Unmarried";
        }else if(other.isSelected()){
            shadi="other";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pcode = pcodeText.getText();
        
        try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is required");
           } else{
               Conn c = new Conn();
               String query = "insert into signup values('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' ,'"+gender+"' , '"+email+"' , '"+shadi+"' ,'"+address+"','"+city+"','"+state+"','"+pcode+"')";
               c.s.executeUpdate(query);
               
               setVisible(false);
               new SignupTwo(formno).setVisible(true);
           }
           
        } catch(Exception ae){
           System.out.println(ae);
        }
        
        
    }
    }

    
    

    

