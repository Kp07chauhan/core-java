package Employee.Management.System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;

    JTextField tpassword;

    JButton login,back;

    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword =new JPasswordField();
        tpassword .setBounds(150,70,150,30);
        add(tpassword );

        login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back=new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg= new JLabel(i33);
        imgg.setBounds(400,20,700,400);
        add(imgg);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,700,400);
        add(img);
        


        setSize(700,400);
        setLocation(320,160);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
             try {
                    String username=tusername.getText();
                    String password=tpassword.getText();

                    conn conn = new conn();

                    String query = "select * from login where username = '"+ username +"'and password = '"+ password +"'";

                    ResultSet resultSet = conn.statement.executeQuery(query);

                    if(resultSet.next()){
                        setVisible(false);
                        new Main();

                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid username or password" );
                    }

             } catch (Exception E) {
                    E.printStackTrace();
             }

        }else{
            System.exit(111);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
