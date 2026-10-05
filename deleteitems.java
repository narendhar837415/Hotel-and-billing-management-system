package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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

public class deleteitems extends JFrame implements ActionListener{
	
	private JLabel jl1,jl2,jbg;
	
	private JTextField jt1;
	
	private JButton jb1,jb2;
	
	
	public deleteitems() {
		
		jl1=new JLabel("Delete Items");
		
		jl2=new JLabel("Itemname :");
		
		jt1=new JTextField();
		
		jb1=new JButton("Delete");
		
		jb2=new JButton("Cancel");
		
		
		setLayout(null);
		
		jl1.setBounds(350, 100, 300, 50);
		
		jl1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		jl1.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jl2.setBounds(250, 200, 150, 35);
		
		jl2.setFont(new Font("Arial", Font.BOLD, 15));
		
		jl2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jt1.setBounds(340, 200, 280, 35);
		
		jb1.setBounds(300, 300, 130, 50);
		
		jb1.setBackground(Color.black);
		
		jb1.setForeground(Color.orange);
		
		jb1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.40f, 0.65f),1));
		
		jb2.setBounds(470, 300, 130, 50);
		
		jb2.setBackground(Color.black);
		
		jb2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
		
		jb2.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.40f, 0.65f),2));
		
		ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\deleteitem1.png");
		
		jbg=new JLabel(ii);
		
		jbg.setBounds(0,0,900,600);
		
		add(jl1);
		add(jl2);
		add(jt1);
		add(jb1);
		add(jb2);
		
		add(jbg);
		
		jb1.addActionListener(this);
		
		jt1.addActionListener(this);
		
		jb2.addActionListener(this);
		
				
				
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jb1)) {
			
			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
		
	PreparedStatement pst=	con.prepareStatement("Delete from additems where name=?");
	
	pst.setString(1, jt1.getText());
	
	int r=pst.executeUpdate();
	
	if(r>0) {
		
		JOptionPane.showMessageDialog(this, " Item Deleted");
	}
	else {
		JOptionPane.showMessageDialog(this, " Invalid item");
		
	}
	
	jt1.setText("");
			
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
