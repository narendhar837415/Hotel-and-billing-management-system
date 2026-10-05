package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class userdashboard extends JFrame implements ActionListener {

    private JLabel jl1, jl2,jbg;
    private JButton jb1, jb2, jb3, jb4, jb5;

    public userdashboard() {

        jl1 = new JLabel("User Dashboard");
        jl2 = new JLabel("Welcome User");

        jb1 = new JButton("View Menu");
        jb2 = new JButton("Place Order");
        jb3 = new JButton("Show Orders");
        jb4 = new JButton("Print Bill");
        jb5 = new JButton("Logout");

        setLayout(null);

        jl1.setBounds(350, 30, 300, 50);
        jl1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jl1.setForeground(
                Color.getHSBColor(0.12f, 0.35f, 0.95f)
        );

        jl2.setBounds(390, 95, 300, 30);
        jl2.setFont(new Font("Arial", Font.BOLD, 16));
        jl2.setForeground(
                Color.getHSBColor(0.12f, 0.20f, 0.90f)
        );

        jb1.setBounds(180, 180, 220, 55);
        jb2.setBounds(500, 180, 220, 55);

        jb3.setBounds(180, 280, 220, 55);
        jb4.setBounds(500, 280, 220, 55);

        jb5.setBounds(340, 400, 220, 55);

        jb1.setBackground(   Color.getHSBColor(0.59f, 0.35f, 0.24f) );
        jb1.setForeground(Color.WHITE);

        jb2.setBackground( Color.getHSBColor(0.59f, 0.35f, 0.24f) );
        jb2.setForeground(Color.WHITE);

        jb3.setBackground(Color.getHSBColor(0.59f, 0.35f, 0.24f) );
        jb3.setForeground(Color.WHITE);

        jb4.setBackground(Color.getHSBColor(0.12f, 0.55f, 0.35f) );
        jb4.setForeground(Color.WHITE);

        jb5.setBackground(Color.BLACK);
        jb5.setForeground( Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jb1.setFocusPainted(false);
        jb2.setFocusPainted(false);
        jb3.setFocusPainted(false);
        jb4.setFocusPainted(false);
        jb5.setFocusPainted(false);

        jb1.setBorder(BorderFactory.createLineBorder(  Color.getHSBColor(0.12f, 0.55f, 0.70f), 1));

        jb2.setBorder(BorderFactory.createLineBorder( Color.getHSBColor(0.12f, 0.55f, 0.70f), 1 ));

        jb3.setBorder(BorderFactory.createLineBorder( Color.getHSBColor(0.12f, 0.55f, 0.70f), 1 ));

        jb4.setBorder(BorderFactory.createLineBorder(  Color.getHSBColor(0.12f, 0.55f, 0.70f), 1 ));

        jb5.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f), 1));
        
        ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\update1.png");
        
        jbg=new JLabel(ii);
        
        jbg.setBounds(0,0,900,600);

        add(jl1);
        add(jl2);

        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jbg);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(jb1)) {

            viewitems vi = new viewitems();

            vi.setTitle("View Menu");
            vi.setSize(900,600);
            vi.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
            vi.setVisible(true);

            this.dispose();
        }

        if(e.getSource().equals(jb2)) {

            placeorder po = new placeorder();

            po.setTitle("Place Order");
            po.setSize(900,600);
            po.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
            po.setVisible(true);

            this.dispose();
            
        }

        if(e.getSource().equals(jb3)) {

           showorders so = new showorders();

            so.setTitle("Show Orders");
            so.setSize(900,600);
            so.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
            so.setVisible(true);

            this.dispose();
            
        }

        if(e.getSource().equals(jb4)) {

          printbill pb = new printbill();

            pb.setTitle("Print Bill");
            pb.setSize(900,600);
            pb.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
            pb.setVisible(true);

            this.dispose();
            
        }

        if(e.getSource().equals(jb5)) {

            firstlogin fl = new firstlogin();

            fl.setTitle("Hotel Billing System");
            fl.setSize(900,600);
            fl.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
            fl.setVisible(true);

            this.dispose();
        }
    }
}