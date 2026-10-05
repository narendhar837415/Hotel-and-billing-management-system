package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class additems extends JFrame implements ActionListener{
	
	private JLabel jl1,jl2,jl3,jbg;
	
	private JTextField jt1,jt2;
	
	private JButton jb1,jb2;
	
	
	public additems() {
		
		
		jl1=new JLabel("Additems");
		
		jl2=new JLabel("Itemname :");
		
		jl3=new JLabel("Price    :");
		
		jt1=new JTextField();
		
		jt2=new JTextField();
		
		jb1=new JButton("Submit");
		
		jb2=new JButton("Cancel");
		
		
		
		setLayout(null);
		
		jl1.setBounds(370, 30, 300, 50);
		
		jl1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		jl1.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jl2.setBounds(220, 150, 150, 35);
		
		jl2.setFont(new Font("Arial", Font.BOLD, 15));
		
		jl2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
	
		jl3.setBounds(220,220,150, 35);
		
		jl3.setFont(new Font("Arial", Font.BOLD, 15));
		
		jl3.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jt1.setBounds(340,150,280, 35);
		
		jt2.setBounds(340, 220,280, 35);
		
		jb1.setBounds(300, 320, 130,50);
		
		jb1.setBackground(Color.getHSBColor(0.12f, 0.35f, 0.28f));
		
		jb1.setForeground(Color.getHSBColor(0.12f, 0.15f, 0.95f));
		
		jb1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.40f, 0.65f)));
		
		jb2.setBounds(470, 320, 130,50);
		
		
		jb2.setBackground(Color.getHSBColor(0.00f, 0.00f, 0.16f));
		
		jb2.setForeground(Color.getHSBColor(0.00f,0.00f,0.90f));
		
		jb2.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f,0.40f,0.55f)));
		
		
		
		ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\additems1.png");
		
		jbg=new JLabel(ii);
		
		jbg.setBounds(0,0,900,600);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jt1);
		add(jt2);
		add(jb1);
		add(jb2);
		add(jbg);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jt1.addActionListener(this);
		jt2.addActionListener(this);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		
		if(e.getSource().equals(jb1)) {
			
			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
			
			PreparedStatement pst=	con.prepareStatement("insert into additems(name, price) values(?,?)");
			
			pst.setString(1, jt1.getText());
			
			pst.setFloat(2, Float.parseFloat(jt2.getText()));
			
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Success");
			
			jt1.setText("");
			jt2.setText("");
			
			}
			catch (Exception k) {
				// TODO: handle exception
				k.printStackTrace();
			}
			
			
			
			
			
			
			
			
		}
		
		if(e.getSource().equals(jb2)) {
			
			admindash al=new admindash();
			
			al.setTitle("dashboard");
			
			al.setSize(900,600);
			
			al.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			al.setVisible(true);
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
