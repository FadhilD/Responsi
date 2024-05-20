/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;

//import com.sun.jdi.connect.spi.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Lab Informatika
 */
public class Login extends JFrame implements ActionListener {
    JLabel ltitle = new JLabel("Selamat Datang");
    JLabel ltitle2 = new JLabel("Silahkan Masuk untuk melanjutkan");
    JLabel lusername  = new JLabel("Username");
    JLabel lpass  = new JLabel("Password");
    
    JTextField tuser = new JTextField();
    JTextField tpass = new JTextField();
    JButton blogin = new JButton("Login");
    

    public Login() {
        setSize(500,400);
        setTitle("Login Page");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    add(ltitle );
    add(ltitle2);
    add(lusername);
    add(lpass);
    add(tuser);
    add(tpass);
    add(blogin);
//    add();
//    add();
//    add();
ltitle.setBounds(20, 10, 250, 50);
ltitle2.setBounds(20, 30, 250, 50);
lusername.setBounds(20, 55, 250, 50);
lpass.setBounds(20, 115, 250, 50);
tuser.setBounds(20, 95, 400, 30);
tpass.setBounds(20, 155, 400, 30);
blogin.setBounds(20, 195, 400, 30);
//ltitle.setBounds(20, 10, 250, 50);
blogin.addActionListener(this);
    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
        String DBurl = "jdbc:mysql://localhost:3306/zoo";
        String DBuser="root";
        String DBpass = "";
        String username = tuser.getText();
        String pass = tpass.getText();
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection(DBurl,DBuser,DBpass);
            Statement stm = conn.createStatement();
            String sql = "select * from pegawai where nama ='"+username+"' and password = '"+pass+"'";
            
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                String role = rs.getString("role");
                String nama = rs.getString("nama");
                if("admin".equals(role)){
                    System.out.println("admin)");           
                    new menu(nama);
                }else if ("pegawai".equals(role)){
                   new menu(nama);
                }
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "username or password salah");
                tuser.setText(" ");
                tpass.setText(" ");
            }
        } catch (Exception eror) {
            JOptionPane.showMessageDialog(this, eror.getMessage());
        }
        
    }
  
}
