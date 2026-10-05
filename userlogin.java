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

public class userlogin extends JFrame implements ActionListener {

    private JLabel jl1, jl2, jl3, jlbg;
    private JTextField jt1;
    private JPasswordField jp1;
    private JButton jb1, jb2, jb3;

    public userlogin() {

        jl1 = new JLabel("User Login");
        jl2 = new JLabel("Username :");
        jl3 = new JLabel("Password :");

        jt1 = new JTextField();
        jp1 = new JPasswordField();

        jb1 = new JButton("Login");
        jb2 = new JButton("Clear");
        jb3 = new JButton("Back");

        setLayout(null);

        jl1.setBounds(350, 50, 300, 50);
        jl1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jl1.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jl2.setBounds(220, 160, 150, 35);
        jl2.setFont(new Font("Arial", Font.BOLD, 16));
        jl2.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jt1.setBounds(370, 160, 280, 35);

        jl3.setBounds(220, 220, 150, 35);
        jl3.setFont(new Font("Arial", Font.BOLD, 16));
        jl3.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));

        jp1.setBounds(370, 220, 280, 35);

        jb1.setBounds(250, 310, 130, 50);
        jb2.setBounds(400, 310, 130, 50);
        jb3.setBounds(550, 310, 130, 50);

        jb1.setBackground(Color.getHSBColor(0.59f, 0.35f, 0.24f));
        jb1.setForeground(Color.getHSBColor(0.17f, 0.03f, 0.95f));
        jb1.setFocusPainted(false);
        jb1.setBorder(BorderFactory.createLineBorder(
                Color.getHSBColor(0.12f, 0.55f, 0.70f), 1));

        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));
        jb2.setFocusPainted(false);

        jb3.setBackground(Color.BLACK);
        jb3.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f));
        jb3.setFocusPainted(false);
        
        ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\manage1.png");
        
        jlbg=new JLabel(ii);
        
        jlbg.setBounds(0,0,900,600);

        add(jl1);
        add(jl2);
        add(jl3);

        add(jt1);
        add(jp1);

        add(jb1);
        add(jb2);
        add(jb3);
        
        add(jlbg);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			
			String name=jt1.getText();
			String pass=jp1.getText();
			
			
			if(jt1.getText().isEmpty() || jp1.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(this, "Please enter username & password");
				
				
			}
			
			
			
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
		
		PreparedStatement pst=	con.prepareStatement("select * from users where name=?");
	
		pst.setString(1, name);
	
		ResultSet rs=	pst.executeQuery();
		
		for(;rs.next();) {
			
			
			
			String dbpass=rs.getString("password");
			
			String status=rs.getString("status");
			
			
			if(dbpass.equals(pass)) {
				
				if(status.endsWith("ACTIVE")) {
					
					JOptionPane.showMessageDialog(this, "Login success");
					
					userdashboard us=new userdashboard();
					us.setTitle("userdashboard");
					
					us.setSize(900,600);
					
					us.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
					
					us.setVisible(true);
					
				}
				else if(status.equals("BLOCKED")){
					
					JOptionPane.showMessageDialog(this, "This Acoount is blocked!");
				}
				else {
					
					JOptionPane.showMessageDialog(this, "Invalid username or password");
				}
				
			}else {
				
				JOptionPane.showMessageDialog(this, "Invalid username or password");
			}
			
		}
	
	
			
			
			}catch (Exception l) {
				// TODO: handle exception
				l.printStackTrace();
			}
			
			
			
		}
		
		if(e.getSource().equals(jb2)) {
			
			jt1.setText("");
			jp1.setText("");
			
		}
		
		if(e.getSource().equals(jb3)) {
			

			firstlogin fl=new firstlogin();
			
			fl.setTitle("companylogin");
			
			fl.setSize(900,600);
			
			fl.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			fl.setVisible(true);
			
			
		}
		
		
	}
}
