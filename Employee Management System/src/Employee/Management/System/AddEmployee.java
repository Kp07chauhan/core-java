package Employee.Management.System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddEmployee extends JFrame  implements ActionListener  {

    JTextField tname,tfname,taddress,tphone,taadhar,tsalary,tgmail;
    JComboBox Boxeducation;
    JButton add,back;

    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(270,30,500,50);
        heading.setFont(new Font("seeif",Font.BOLD,25));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(50,200,150,30);
        salary.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(200,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address=new JLabel("Address");
        address.setBounds(400,200,150,30);
        address.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(600,200,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel aadhar=new JLabel("Aadhar Number");
        aadhar.setBounds(50,250,150,30);
        aadhar.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar=new JTextField();
        taadhar.setBounds(200,250,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);
       
        JLabel phone=new JLabel("Phone Number");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel education = new JLabel("Higest Eduction");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        String item[] = {"BBA","B.Tech","M.Ca","M.Ba","B.Sc","M.Sc","MBA","PHD"};
        Boxeducation = new JComboBox(item);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);

        JLabel gmail=new JLabel("Gmail");
        gmail.setBounds(50,300,150,30);
        gmail.setFont(new Font ("SAN_SERIF",Font.BOLD,20));
        add(gmail);

        tgmail=new JTextField();
        tgmail.setBounds(200,300,150,30);
        tgmail.setBackground(new Color(177,252,197));
        add(tgmail);

        add = new JButton("ADD");
        add.setBounds(230,350,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(420,350,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

       setSize(800,500);
       setLocation(320,130);
       setLayout(null);
       setVisible(true);

    }
    @Override
    public  void actionPerformed(ActionEvent e){
        if(e.getSource()== add){
            String name= tname.getText();
            String fname =tfname.getText();
            String salary =tsalary.getText();
            String address =taddress.getText();
            String aadhar =taadhar.getText();
            String phone =tphone.getText();
            String gmail =tgmail.getText();
            String education = (String)Boxeducation.getSelectedItem();


            try {

                conn c = new conn();
                String query = "insert into  employeee values('"+name+"','"+fname+"','"+salary+"','"+address+"','"+aadhar+"','"+phone+"','"+gmail+"','"+education+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Detail added successfully");
                setVisible(false);
                new Main();

            } catch (Exception E) {
                E.printStackTrace();
            }

        }else{
            setVisible(false);
            new Main();
        }
    }
    
    

    public static void main(String[] args) {
        new AddEmployee();
    }

    
}
