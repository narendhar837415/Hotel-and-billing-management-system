package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class manageusers extends JFrame implements ActionListener {

    private JLabel jl1, jl2, jl3, jlbg;
    private JTextField jt1, jt2;
    private JButton jb1, jb2, jb3, jb4, jb5;
    private JTable jt;
    private JScrollPane jp;

    public manageusers() {

        jl1 = new JLabel("Manage Users");
        jl2 = new JLabel("Username :");
        jl3 = new JLabel("Password :");

        jt1 = new JTextField();
        jt2 = new JTextField();

        jb1 = new JButton("Add User");
        jb2 = new JButton("Allow");
        jb3 = new JButton("Block");
        jb4 = new JButton("Delete");
        jb5 = new JButton("Back");

        jt = new JTable();
        jp = new JScrollPane(jt);

        setLayout(null);

        jl1.setBounds(350, 20, 300, 50);
        
        jl1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        
        jl1.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jl2.setBounds(150, 100, 120, 35);
        
        jl2.setFont(new Font("Arial", Font.BOLD, 15));
        
        jl2.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jt1.setBounds(250, 100, 200, 35);

        jl3.setBounds(150, 150, 120, 35);
        
        jl3.setFont(new Font("Arial", Font.BOLD, 15));
        
        jl3.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jt2.setBounds(250, 150, 200, 35);

        jb1.setBounds(80, 210, 140, 45);
        
        jb2.setBounds(240, 210, 100, 45);
        
        jb3.setBounds(350, 210, 100, 45);
        
        jb4.setBounds(460, 210, 100, 45);
        
        jb5.setBounds(570, 210, 100, 45);

        jb1.setBackground(Color.getHSBColor(0.59f, 0.35f, 0.24f));
        
        jb1.setForeground(Color.getHSBColor(0.17f, 0.03f, 0.95f));
        
        jb1.setFocusPainted(false);
        
        jb1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f), 1));

        jb2.setBackground(Color.getHSBColor(0.30f, 0.40f, 0.25f));
        
        jb2.setForeground(Color.WHITE);
        
        jb2.setFocusPainted(false);

        jb3.setBackground(Color.getHSBColor(0.00f, 0.55f, 0.25f));
        
        jb3.setForeground(Color.WHITE);
        
        jb3.setFocusPainted(false);

        jb4.setBackground(Color.BLACK);
        
        jb4.setForeground(Color.ORANGE);
        
        jb4.setFocusPainted(false);

        jb5.setBackground(Color.BLACK);
        
        jb5.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));
        
        jb5.setFocusPainted(false);

        jp.setBounds(80, 280, 700, 220);
        
        ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\manage1.png");
        
        jlbg=new JLabel(ii);
        
        jlbg.setBounds(0,0,900,600);

        add(jl1);
        add(jl2);
        add(jl3);
        add(jt1);
        add(jt2);

        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);

        add(jp);
        
        add(jlbg);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);

        viewUsers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(jb1)) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mini",
                        "root",
                        "root"
                );

                PreparedStatement pst = con.prepareStatement( "insert into users(name,password,status) values(?,?,?)" );

                pst.setString(1, jt1.getText());
                pst.setString(2, jt2.getText());
                pst.setString(3, "ACTIVE");

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "User Added");

                jt1.setText("");
                jt2.setText("");

                viewUsers();

            } catch(Exception l) {
                l.printStackTrace();
            }
        }

        if(e.getSource().equals(jb2)) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mini", "root","root");

                PreparedStatement pst = con.prepareStatement("update users set status=? where name=?");

                pst.setString(1, "ACTIVE");
                pst.setString(2, jt1.getText());

                int r = pst.executeUpdate();

                if(r > 0) {
                    JOptionPane.showMessageDialog(this, "User Allowed");
                } else {
                    JOptionPane.showMessageDialog(this, "User Not Found");
                }

                viewUsers();

            } catch(Exception l) {
                l.printStackTrace();
            }
        }

        if(e.getSource().equals(jb3)) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mini",  "root", "root" );

                PreparedStatement pst = con.prepareStatement( "update users set status=? where name=?");

                pst.setString(1, "BLOCKED");
                pst.setString(2, jt1.getText());

                int r = pst.executeUpdate();

                if(r > 0) {
                    JOptionPane.showMessageDialog(this, "User Blocked");
                } else {
                    JOptionPane.showMessageDialog(this, "User Not Found");
                }

                viewUsers();

            } catch(Exception l) {
                l.printStackTrace();
            }
        }

        if(e.getSource().equals(jb4)) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mini", "root","root");

                PreparedStatement pst = con.prepareStatement("delete from users where name=?" );

                pst.setString(1, jt1.getText());

                int r = pst.executeUpdate();

                if(r > 0) {
                    JOptionPane.showMessageDialog(this, "User Deleted");
                } else {
                    JOptionPane.showMessageDialog(this, "User Not Found");
                }

                jt1.setText("");
                jt2.setText("");

                viewUsers();

            } catch(Exception l) {
                l.printStackTrace();
            }
        }

        if(e.getSource().equals(jb5)) {

            admindash al = new admindash();

            al.setTitle("dashboard");
            al.setSize(900,600);
            al.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
            al.setVisible(true);
        }
    }

    public void viewUsers() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mini","root","root" );

            DefaultTableModel dt = new DefaultTableModel();

            dt.addColumn("Id");
            dt.addColumn("Name");
            dt.addColumn("Password");
            dt.addColumn("Status");

            PreparedStatement pst = con.prepareStatement( "select * from users order by id asc" );

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                dt.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("status")
                });
            }

            jt.setModel(dt);

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
