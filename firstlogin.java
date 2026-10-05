package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class firstlogin extends JFrame implements ActionListener{
	
	private JLabel jl1,jl2,jl3,jbg;
	
	private JButton jb1,jb2,jb3;
	
	
	public firstlogin() {
		
		jl1=new JLabel("HOTEL BILLING SYSTEM");
		
		jl2=new JLabel("WELCOME");
		
		jl3=new JLabel("Please select your login type");
		
		jb1=new JButton("Admin Login");
		
		jb2=new JButton("User Login");
		
		jb3=new JButton("Exit");
		
		
		
		setLayout(null);
		
		jl1.setBounds(280, 20, 400, 50);
		
		jl1.setFont(new Font("Arial", Font.BOLD, 30));
		
		jl1.setForeground(Color.getHSBColor(0.17f, 0.02f, 0.96f));
		
		jl2.setBounds(390, 100, 200, 35);
		
		jl2.setFont(new Font("Arial", Font.BOLD, 21));
		
		jl2.setForeground(Color.getHSBColor(0.12f, 0.25f, 0.82f));
		
		
		jl3.setBounds(290, 225, 300, 25);
		
		jl3.setFont(new Font("Arial", Font.PLAIN, 14));
		
		jl3.setForeground(Color.getHSBColor(0.17f, 0.03f, 0.78f));
		
		
		jb1.setBounds(220,260, 250, 55);
		
		jb1.setBackground(Color.getHSBColor(0.59f,0.53f, 0.20f));
		
		jb1.setForeground(Color.getHSBColor(0.17F,0.02F,0.96F));
		
		jb1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.74f, 0.83f), 1));
		
		jb1.setFocusPainted(false);
		
		jb2.setBounds(480,260, 250,55);
		
		
		jb2.setBackground(Color.getHSBColor(0.59f,0.53f, 0.20f));
		
		jb2.setForeground(Color.getHSBColor(0.17F,0.02F,0.96F));
		
		jb2.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.74f, 0.83f), 1));
		
		jb2.setFocusPainted(false);
		
		jb3.setBounds(350, 350, 250, 55);
		
		jb3.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.22f));
		jb3.setForeground(Color.getHSBColor(0.17f, 0.02f, 0.96f));

		jb3.setBorder(BorderFactory.createLineBorder(
		    Color.getHSBColor(0.12f, 0.74f, 0.83f), 1
		));
		
		jb3.setFocusPainted(false);
		
	
		
		
		ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\first1.png");
		
		jbg=new JLabel(ii);
		
		jbg.setBounds(0, 0, 900, 600);
		
		
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jbg);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jb1)) {
			
			adminlogin ad=new adminlogin();
			
			ad.setTitle("adminlogin");
			
			ad.setSize(900,600);
			
			ad.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			ad.setVisible(true);
			

			
			
		}
		
		
		if(e.getSource().equals(jb2)) {
			
			userlogin ul=new userlogin();
			ul.setTitle("companylogin");
			
			ul.setSize(900,600);
			
			ul.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			ul.setVisible(true);
			
			
			
			
			
		}
		
		
		if(e.getSource().equals(jb3)) {
			
			
			
			
		}
		
	}
	
	
	

}
