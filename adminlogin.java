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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class adminlogin extends JFrame implements ActionListener{
	
	private JLabel jl1,jl2,jl3,jbg;
	
	private JTextField jt1,jt2;
	
	private JButton jb1,jb2,jb3;
	
	String name;
	
	String pass;
	
	
	public adminlogin() {
		
		jl1=new JLabel("Admin Login");
		
		
		
		jl2=new JLabel("Username :");
		
		jl3=new JLabel("Password :");
		
		
		jt1=new JTextField();
		
		jt2=new JPasswordField();
		
		jb1=new JButton("Login");
		
		jb2=new JButton("Clear");
		
		jb3=new JButton("Back");
		
		
		setLayout(null);
		
		jl1.setBounds(350, 50, 300, 50);
		
		jl1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		jl1.setForeground(Color.getHSBColor(0.12f, 0.74f, 0.83f));
		
		jl2.setBounds(300, 150, 300, 25);
		
		jl2.setForeground(Color.getHSBColor(0.12f, 0.74f, 0.83f));
		
		jt1.setBounds(300, 178, 300, 40);
		
		jl3.setBounds(300, 235, 300, 25);
		
		jl3.setForeground(Color.getHSBColor(0.12f, 0.74f, 0.83f));
		
		jt2.setBounds(300, 263, 300, 40);
		
		
		jb1.setBounds(350, 325, 200, 48);
		
		jb1.setBackground(Color.getHSBColor(0.12F, 0.55F, 0.32F));
		
		jb1.setForeground(Color.getHSBColor(0.17f, 0.02f, 0.96f));
		
		jb1.setFocusPainted(false);
		
		jb1.setBorder(BorderFactory.createLineBorder( Color.getHSBColor(0.12f, 0.74f, 0.83f), 1));
		
		
		
		jb2.setBounds(300, 395, 100, 42);
		
		jb2.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.25f));
		jb2.setForeground(Color.getHSBColor(0.17f, 0.02f, 0.96f));
		jb2.setFocusPainted(false);
		
		jb2.setBorder(BorderFactory.createLineBorder( Color.getHSBColor(0.12f, 0.74f, 0.83f), 1));
		
		jb3.setBounds(500, 395, 100, 42);
		
		jb3.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.25f));
		jb3.setForeground(Color.getHSBColor(0.17f, 0.02f, 0.96f));
		jb3.setFocusPainted(false);
		
		jb3.setBorder(BorderFactory.createLineBorder( Color.getHSBColor(0.12f, 0.74f, 0.83f), 1));
		
		
		ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\1.png");
		
		jbg=new JLabel(ii);
		
		jbg.setBounds(0,0,900,600);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jt1);
		add(jt2);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jbg);
		
		
		jb1.addActionListener(this);
		
		jt1.addActionListener(this);
		
		jt2.addActionListener(this);
		
		jb2.addActionListener(this);
		
		jb3.addActionListener(this);
		
		
		
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//bt1
		
		if(e.getSource().equals(jb1)) {
			
			if(jt1.getText().isEmpty() && jt2.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(this, "Enter username & password");
			}
			
			
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
		
		PreparedStatement pst=	con.prepareStatement("select name,password from adminlogin");
	
		ResultSet rs=	pst.executeQuery();
		
		
		for(;rs.next();) {
			
			
			 name=rs.getString("name");
			
			pass=rs.getString("password");
			
			
		}
		
		if(jt1.getText().equals(name) && jt2.getText().equals(pass)) {
			
			
			
			
			admindash al=new admindash();
			
			al.setTitle("dashboard");
			
			al.setSize(900,600);
			
			al.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			al.setVisible(true);
			
		}else {
			
			JOptionPane.showMessageDialog(this, "Incorrect name or password");
		}
	
	
	
			
			}catch (Exception l) {
				// TODO: handle exception
				l.printStackTrace();
			}	
			
		}
		
		//bt2
		if(e.getSource().equals(jb2)) {
			
			jt1.setText("");
			jt2.setText("");
			
		}
		
		
		//bt3
		if(e.getSource().equals(jb3)) {
			
			firstlogin fl=new firstlogin();
			
			fl.setTitle("companylogin");
			
			fl.setSize(900,600);
			
			fl.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			fl.setVisible(true);
			
			
			
			
		}
		
		
		
	}
	

}
