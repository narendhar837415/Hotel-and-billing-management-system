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
import javax.swing.JTextField;

public class updateitem extends JFrame implements ActionListener{
	
	private JLabel jl1,jl2,jl3,jl4,jbg;
	
	private JTextField jt1,jt2,jt3;
	
	private JButton jb1,jb2;
	
	
	int id;
	String name;
	Float price;
	
	public updateitem() {
		
		jl1=new JLabel("Update Items");
		
		jl2=new JLabel("Id       :");
		
		jl3=new JLabel("Itemname :");
		
		jl4=new JLabel("Price    :");
		
		
		
		
		
		
		jt1=new JTextField();
		
		jt2=new JTextField();
		
		jt3=new JTextField();
		
		
		jb1=new JButton("Update");
		
		jb2=new JButton("Cancel");
		
		
		setLayout(null);
		
		jl1.setBounds(350, 30, 300, 50);
		
		jl1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		jl1.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jl2.setBounds(220, 130, 150, 35);
		
		jl2.setFont(new Font("Arial", Font.BOLD, 15));
		
		jl2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jl3.setBounds(220, 200, 150, 35);
		
		jl3.setFont(new Font("Arial", Font.BOLD, 15));
		
		jl3.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jl4.setBounds(220, 270, 150, 35);
		
		jl4.setFont(new Font("Arial", Font.BOLD, 15));
		
		jl4.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jt1.setBounds(340, 130, 280, 35);
		
		jt2.setBounds(340, 200, 280, 35);
		
		jt3.setBounds(340, 270, 280, 35);
		
		jb1.setBounds(300, 360, 130, 50);
		
		jb1.setBackground(Color.black);
		
		jb1.setForeground(Color.orange);
		
		jb1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.40f, 0.65f),1));
		
		jb2.setBounds(470, 360, 130, 50);
		
		jb2.setBackground(Color.black);
		
		jb2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jb2.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.40f, 0.65f),2));
		
		ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\update1.png");
		
		jbg=new JLabel(ii);
		
		jbg.setBounds(0,0,900,600);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jt1);
		add(jt2);
		add(jt3);
		add(jb1);
		add(jb2);
		
		add(jbg);
		
		jb1.addActionListener(this);
		jt1.addActionListener(this);
		jt2.addActionListener(this);
		jt3.addActionListener(this);
		jb2.addActionListener(this);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jb1)) {
			
			id=Integer.parseInt(jt1.getText());
			name=jt2.getText();
			price=Float.parseFloat(jt3.getText());
			
			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
		
			PreparedStatement pst=	con.prepareStatement("update additems set name=?,price=? where id=?");
	
			
			
			 
				
				pst.setInt(3, id);
				
				pst.setString(1, name);
				
				pst.setFloat(2, price);
				
				
				int rows=pst.executeUpdate();
				
			
				if(rows > 0) {
		            JOptionPane.showMessageDialog(this, "Updated Successfully");
		        } else {
		            JOptionPane.showMessageDialog(this, "ID not found");
		        }
				
			
			jt1.setText("");
			jt2.setText("");
			jt3.setText("");
			
			}catch (Exception l) {
				// TODO: handle exception
				l.printStackTrace();
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
