/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Lab Informatika
 */
public class menu extends JFrame implements ActionListener {

    JLabel ltitle = new JLabel("Selamat Datang");
JLabel ltitle2 = new JLabel("Silahkan Klik untuk melanjutkan");
    
    JButton bhewan = new JButton("hewan");
    JButton bpegawai = new JButton("pegawai");
    JButton blogout = new JButton("Logout");
    String nama;
    public menu(String nama) {
        
        this.nama = nama;
          setSize(500,300);
        setTitle("Login Page");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    add(ltitle );
    add(ltitle2);
    ltitle.setText("Selamat Datang  "+nama);
;
    add(bhewan);
    add(bpegawai);
    add(blogout);
//    add();
//    add();
//    add();
ltitle.setBounds(20, 10, 250, 50);
ltitle2.setBounds(20, 30, 250, 50);

bhewan.setBounds(20, 95, 400, 30);
bpegawai.setBounds(20, 145, 400, 30);
blogout.setBounds(20, 195, 400, 30);
//ltitle.setBounds(20, 10, 250, 50);
blogout.addActionListener(this);
bhewan.addActionListener(this);
bpegawai.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == bhewan){
           new hewan(nama);
       }else if (e.getSource() == bpegawai){
           new pegawai(nama);
       }else if (e.getSource() == blogout){
           new Login();
       }
    }
    
}
