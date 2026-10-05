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

public class admindash extends JFrame implements ActionListener{

	private JLabel jl1,jl2,jbg;
	
	private JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	
	public admindash()
	{
		
		jl1=new JLabel("Admin Dashboard");
		
		jl1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		jl2=new JLabel("Welcome");
		
		jl2.setFont(new Font("Arial", Font.BOLD, 17));
		
		jb1=new JButton("Additem");
		
		jb2=new JButton("Updateitem");
		
		jb3=new JButton("Deleteitem");
		
		jb4=new JButton("Viewitem");
		
		jb5=new JButton("Logout");
		
		jb6=new JButton("Manage Users");
		
		
		setLayout(null);
		
		jl1.setBounds(350, 20, 400, 50);
		
		jl1.setForeground(Color.getHSBColor(0.12f, 0.50f,0.83f));
		
		jl2.setBounds(410, 95, 300, 30);
		
		jl2.setForeground(Color.white);
		
		jb1.setBounds(180, 180, 220, 55);
		
		jb1.setBackground(Color.getHSBColor(0.59f, 0.35f, 0.24f));
		jb1.setForeground(Color.getHSBColor(0.17f, 0.03f, 0.95f));
		
		jb1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f),1));
		
		jb2.setBounds(500, 180, 220, 55);
		
		jb2.setBackground(Color.getHSBColor(0.12f, 0.55f, 0.25f));
		jb2.setForeground(Color.getHSBColor(0.12f, 0.20f, 0.95f));
		jb2.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f),1));

		
		jb3.setBounds(180, 270, 220, 55);
		
		jb3.setBackground(Color.getHSBColor(0.00f, 0.55f, 0.25f));
		jb3.setForeground(Color.getHSBColor(0.00f, 0.05f, 0.95f));
		jb3.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f),1));
		
		jb4.setBounds(500, 270, 220, 55);
		
		jb4.setBackground(Color.getHSBColor(0.00f, 0.35f, 0.22f));
		jb4.setForeground(Color.getHSBColor(0.00f, 0.03f, 0.95f));
		
		jb4.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.00f, 0.55f, 0.65f),1));
		
		jb5.setBounds(340, 400, 220, 55);
		
		jb5.setBackground(Color.getHSBColor(0.00f, 0.00f, 0.16f));
		jb5.setForeground(Color.getHSBColor(0.17f, 0.03f, 0.95f));
		
		jb5.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f),1));
		
		jb6.setBounds(340, 480, 220, 55);

		jb6.setBackground(Color.getHSBColor(0.59f, 0.35f, 0.24f));
		jb6.setForeground(Color.getHSBColor(0.17f, 0.03f, 0.95f));
		jb6.setBorder(BorderFactory.createLineBorder(
		    Color.getHSBColor(0.12f, 0.55f, 0.70f), 1
		));
		
		ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\admindash1.jpg");
		
		jbg=new JLabel(ii);
		
		jbg.setBounds(0, 0, 900, 600);
		
		
		add(jl1);
		add(jl2);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jb5);
		add(jb6);
		add(jbg);
		
		jb1.addActionListener(this);
		jb4.addActionListener(this);
		jb2.addActionListener(this);
		
		jb3.addActionListener(this);
		jb6.addActionListener(this);
		jb5.addActionListener(this);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jb1)) {
			
			
			additems ai=new additems();
			

			
			ai.setTitle("additems");
			
			ai.setSize(900,600);
			
			ai.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			ai.setVisible(true);
		}
		
		if(e.getSource().equals(jb4)) {
			
			
			viewitems vi=new viewitems();
			

			
			vi.setTitle("table");
			
			vi.setSize(900,600);
			
			vi.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			vi.setVisible(true);
			
			
			
			
		}
		
		if(e.getSource().equals(jb2)) {
			
			
			updateitem up=new updateitem();
			
			up.setTitle("updateitem");
			
			up.setSize(900,600);
			
			up.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			up.setVisible(true);
		}
		
		if(e.getSource().equals(jb3)) {
			
			
			deleteitems dl=new deleteitems();
			
			
			dl.setTitle("deleteitems");
			
			dl.setSize(900,600);
			
			dl.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			dl.setVisible(true);
		}
		
		if(e.getSource().equals(jb6)) {

		    manageusers mu=new manageusers();

		    mu.setTitle("Manage Users");
		    mu.setSize(900,600);
		    mu.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
		    mu.setVisible(true);
		}
		
		if(e.getSource().equals(jb5)) {

			firstlogin fl=new firstlogin();
			
			fl.setTitle("companylogin");
			
			fl.setSize(900,600);
			
			fl.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			fl.setVisible(true);
			
		}
		
		
		
		
	}	
	
}
