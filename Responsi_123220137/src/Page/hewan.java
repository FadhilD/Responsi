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
public class hewan extends JFrame implements ActionListener {
      JFrame window = new JFrame("Pegawai");
     JLabel ltitle = new JLabel("Selamat Datang");

     
     String []columnNames = {"ID","Nama","Kelas","Jenis"};
      String[][]data=new String[100][5];
     
      DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
      JTable table = new JTable(tableModel);
      JScrollPane sp = new JScrollPane(table);
     public JButton bkembali = new JButton("Kembali");
     public JButton btambah = new JButton("Tambah");
     public JButton bedit = new JButton("Edit");
     public JButton bhapus = new JButton("Hapus");
     String nama;
    public hewan(String nama) {
        this.nama = nama;
        window.setSize(700,700);
//        window.setTitle("Pegawai Page");
        window.setVisible(true);
        window.setLayout(null);
       window. setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(sp);
        window.add(bkembali);
        window.add(btambah);
        window.add(bedit);
        window.add(bhapus);
        sp.setBounds(20, 35, 650, 250);
        bkembali.setBounds(20, 320, 650, 50);
        btambah.setBounds(20, 390, 650, 50);
        bedit.setBounds(20, 460, 650, 50);
        bhapus.setBounds(20, 530, 650, 50);
        showdata();
        bkembali.addActionListener(this);
        btambah.addActionListener(this);
        bedit.addActionListener(this);
        bhapus.addActionListener(this);
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
            String sql = "select * from hewan ";
            
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String id =rs.getString("id");
                String nama =rs.getString("nama");
                String kelas =rs.getString("kelas");
                String jenis =rs.getString("jenis_makanan");
                
                String[]rowData ={id,nama,kelas,jenis};
                tableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:"+ e.getMessage());
        }
     }
        @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == bkembali){
           window.dispose();
           new menu(nama);
       }else if (e.getSource() == btambah){
           new tambah(nama);
       }else if (e.getSource() == bhapus){
                  try {
        String DBurl = "jdbc:mysql://localhost:3306/zoo";
        String DBuser="root";
        String DBpass = "";
//        String username = tuser.getText();
//        String pass = tpass.getText();
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection(DBurl,DBuser,DBpass);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM hewan WHERE id = ? ";
            
            
            
        } catch (Exception eror) {
            JOptionPane.showMessageDialog(null,"Error:"+ eror.getMessage());
        }
           
       }
    } 
}
