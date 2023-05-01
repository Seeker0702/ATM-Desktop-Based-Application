
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
     JTextField panText,adharText;
     JButton next;
     JRadioButton syes,sno,eyes,eno;
     
     JComboBox religion,category,occupation,education,income;
     String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        JLabel personaldetails = new JLabel ("PAGE 2: Additional Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,30));
       personaldetails.setBounds(180,20,600,40);
        add(personaldetails);
        
        
        JLabel name = new JLabel ("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        
         String VarRel[] ={"Hindus","Muslims","Sikhs","Christians","Others"};
         religion = new JComboBox(VarRel);
        religion.setBounds(300,140,200,30);
        religion.setBackground(Color.WHITE);
        add(religion);
         
        
        JLabel fname = new JLabel ("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        
        String varCat[]={"General","OBC","SC","ST"};
          category = new JComboBox(varCat);
        category.setBounds(300,190,200,30);
        add(category);
        
        
        
        
        JLabel dob = new JLabel ("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
         String varInc[]={"Null","< 1,50,000","< 2,50,0000","5,00,000","Upto 10,00,000"};
          income = new JComboBox(varInc);
        income.setBounds(300,240,200,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel ("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,315,200,30);
        add(gender);
        
         
        
        
        JLabel qualification = new JLabel ("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,340,200,30);
        add(qualification);
        
        
        String eduval[]={"Non-Graduate","Graduate","Post Graduate","Doctrate","Others"};
         education = new JComboBox(eduval);
        education.setBounds(300,315,200,30);
        education.setBackground(Color.WHITE);
        add(education);
        
         
        
        JLabel shadi = new JLabel ("Occupation:");
        shadi.setFont(new Font("Raleway",Font.BOLD,20));
        shadi.setBounds(100,390,200,30);
        add(shadi);
        
        
        String occuval[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
         occupation = new JComboBox(occuval);
        occupation.setBounds(300,390,200,30);
        occupation.setBackground(Color.WHITE);
        add(occupation); 
       
        
        JLabel pan = new JLabel ("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        
         panText =  new JTextField ();
        panText.setFont(new Font("Raleway",Font.BOLD,14));
        panText.setBounds(300,440,400,30);
        add(panText);
        
        JLabel adhar = new JLabel ("Adhar Number:");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        
        
         adharText =  new JTextField ();
       adharText.setFont(new Font("Raleway",Font.BOLD,14));
        adharText.setBounds(300,490,400,30);
        add(adharText);
        
        
        JLabel state = new JLabel ("Senior Citezen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);    
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
         ButtonGroup senior = new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
        
       
        JLabel pcode = new JLabel ("Existing Account:");
        pcode.setFont(new Font("Raleway",Font.BOLD,20));
        pcode.setBounds(100,590,200,30);
        add(pcode);
        
         eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);    
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
         ButtonGroup exist = new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
        
        

        
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
         new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();


        String seniorCitezen = null;
         if(syes.isSelected()){
             seniorCitezen="Yes";
         }else if(sno.isSelected()){
            seniorCitezen="No";  
    }
        String existingAccount =null;
        if(eyes.isSelected()){
            existingAccount="Yes";
        }else if(eno.isSelected()){
            existingAccount="No";
        }
        String span = panText.getText();
        String sadhar = adharText.getText();
        
        
        try{
           
               Conn c = new Conn();
               String query = "insert into signuptwo values('"+formno+"' , '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' ,'"+seducation+"' , '"+soccupation+"' , '"+span+"' ,'"+sadhar+"','"+seniorCitezen+"','"+existingAccount+"')";
               c.s.executeUpdate(query);
            
                //SignUp3 Object
                
                setVisible(false);
                new signupThree(formno).setVisible(true);
                
           
        } catch(Exception ae){
           System.out.println(ae);
        }
        
        
    }
    }

    
    

    

