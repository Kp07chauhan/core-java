

package Employee.Management.System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewEmployee extends JFrame implements ActionListener {

    JButton update,back;

    JTable table;
    Choice choiceEMP;

    ViewEmployee() {
        getContentPane().setBackground(new Color(255, 131, 122));
        JLabel search = new JLabel("Search by employee Name");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employeee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employeee");
            table.setModel(resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 80, 800, 500);
        add(jp);

        update = new JButton("Update");
        update.setBounds(10,50,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(150,50,100,30);
        back.addActionListener(this);
        add(back);

        setSize(800, 500);
        setLocation(320, 130);
        setLayout(null);
        setVisible(true);
    }

    public static DefaultTableModel resultSetToTableModel(ResultSet resultSet) throws Exception {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i);
            }
            model.addRow(row);
        }

        return model;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==update){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
            
        }else {
            setVisible(false);
            new Main();
        }



    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}

