package com.miniproject;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

public class showorders extends JFrame implements ActionListener {

    private JLabel jl1,jbg;
    private JTable jt;
    private JScrollPane jp;
    
    private JButton jb1;

    public showorders() {

        jl1 = new JLabel("Show Orders");

        jt = new JTable();
        jp = new JScrollPane(jt);
        
        jb1=new JButton("Back");

        setLayout(null);

        jl1.setBounds(350, 30, 300, 50);
        jl1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jl1.setForeground( Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jp.setBounds(100, 120, 700, 300);
        
        jb1.setBounds(365,500,150,50);;
        
        jb1.setBackground(Color.getHSBColor(0.59f,0.35f,0.24f));
        jb1.setForeground(Color.WHITE);
        jb1.setFocusPainted(false);
        jb1.setBorder(BorderFactory.createLineBorder(
                Color.getHSBColor(0.12f,0.55f,0.70f),1));
        
        ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\update1.png");
        
        jbg=new JLabel(ii);
        
        jbg.setBounds(0,0,900,600);

        add(jl1);
        add(jp);
        add(jbg);
        add(jb1);

        
        jb1.addActionListener(this);
        viewOrders();
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jb1)) {
			
			userdashboard us=new userdashboard();
			us.setTitle("userdashboard");
			
			us.setSize(900,600);
			
			us.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			us.setVisible(true);
			
			viewOrders();
		}
		
	}

    public void viewOrders() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mini",
                    "root",
                    "root"
            );

            DefaultTableModel dt = new DefaultTableModel();

            dt.addColumn("Id");
            dt.addColumn("Item Name");
            dt.addColumn("Price");
            dt.addColumn("Quantity");
            dt.addColumn("Total");

            PreparedStatement pst = con.prepareStatement("select * from orders order by id asc" );

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                dt.addRow(new Object[] {

                    rs.getInt("id"),
                    rs.getString("itemname"),
                    rs.getFloat("price"),
                    rs.getInt("quantity"),
                    rs.getFloat("total")

                });
            }

            jt.setModel(dt);

        } catch(Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error"
            );
        }
    }

	
}