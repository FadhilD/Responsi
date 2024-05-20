/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class pegawai extends JFrame implements ActionListener{
     JFrame window = new JFrame("Pegawai");
     JLabel ltitle = new JLabel("Selamat Datang");

     
     String []columnNames = {"ID","Nama","Email","Password","Role"};
     public String[][]data=new String[100][6];
     
     public DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
     public JTable table = new JTable(tableModel);
     public JScrollPane sp = new JScrollPane(table);
     public JButton bkembali = new JButton("Kembali");
     String nama;
    public pegawai(String nama) {
        this.nama =nama;
        window.setSize(700,600);
//        window.setTitle("Pegawai Page");
        window.setVisible(true);
        window.setLayout(null);
       window. setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(sp);
        window.add(bkembali);
        sp.setBounds(20, 35, 650, 300);
        bkembali.setBounds(20, 350, 100, 50);
        showdata();
        bkembali.addActionListener(this);
    }
     
     public void showdata(){
          try {
        String DBurl = "jdbc:mysql://localhost:3306/zoo";
        String DBuser="root";
        String DBpass = "";
//        String username = tuser.getText();
//        String pass = tpass.getText();
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection(DBurl,DBuser,DBpass);
            Statement stm = conn.createStatement();
            String sql = "select * from pegawai ";
            
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String id =rs.getString("id");
                String nama =rs.getString("nama");
                String email =rs.getString("email");
                String password =rs.getString("password");
                String role =rs.getString("role");
                
                String[]rowData ={id,nama,email,password,role};
                tableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:"+ e.getMessage());
        }
     }
        @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == bkembali){
           new menu(nama);
           window.dispose();
       }
    }
     
}
