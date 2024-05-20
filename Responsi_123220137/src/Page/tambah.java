/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;
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
public class tambah extends JFrame implements ActionListener{
//    JLabel ltitle = new JLabel("Selamat Datang");
    JLabel ltitle2 = new JLabel("Silahkan Masuk untuk melanjutkan");
    JLabel lid  = new JLabel("ID");
    JLabel lnama  = new JLabel("Nama");
        JLabel lkelas  = new JLabel("Kelas");
    JLabel ljenis  = new JLabel("Jenis_Makanan");
    
    JTextField tid = new JTextField();
    JTextField tnama = new JTextField();
    JTextField tkelas = new JTextField();
    JTextField tjenis = new JTextField();
    JButton blogin = new JButton("Tambah");
    
String nama;
    public tambah(String nama) {
        this.nama = nama;
        setSize(500,400);
        setTitle("Tambah Page");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
//    add(ltitle );
    add(ltitle2);
    add(lid);
    add(lnama);
    add(ljenis);
    add(lkelas);
     add(tid);
    add(tnama);
    add(tjenis);
    add(tkelas);
    add(blogin);
   
//ltitle.setBounds(20, 10, 250, 50);
ltitle2.setBounds(20, 30, 250, 50);
lid.setBounds(20, 55, 250, 50);
lnama.setBounds(20, 115, 250, 50);
lkelas.setBounds(20, 175, 250, 50);
ljenis.setBounds(20, 235, 250, 50);

tid.setBounds(20, 95, 400, 30);
tnama.setBounds(20, 155, 400, 30);
tkelas.setBounds(20, 215, 400, 30);
tjenis.setBounds(20, 275, 400, 30);

blogin.setBounds(20, 315, 400, 30);
//ltitle.setBounds(20, 10, 250, 50);
blogin.addActionListener(this);
    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

         if(e.getSource() == blogin){
                 String id =tid.getText();
                String nama =tnama.getText();
                String kelas =tkelas.getText();
                String jenis =tjenis.getText();
                
                try{
                            String DBurl = "jdbc:mysql://localhost:3306/zoo";
        String DBuser="root";
        String DBpass = "";
//        String username = tuser.getText();
//        String pass = tpass.getText();
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection(DBurl,DBuser,DBpass);
            Statement stm = conn.createStatement();
                        String sql = "INSERT INTO 'hewan'('id','nama','kelas','jenis_makanan')" + "VALUES('"+id+"','"
                                + nama+"','"
                                + kelas+"','"
                                + jenis+"')";
            
            stm.executeUpdate(sql);
                }catch (Exception eror){
                    JOptionPane.showMessageDialog(this, eror.getMessage());
                }
       }
        
    }
}
