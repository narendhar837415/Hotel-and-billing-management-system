package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
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

public class printbill extends JFrame implements ActionListener {

    private JLabel jl1,jl2,jbg;
    private JTable jt;
    private JScrollPane jp;
    private JButton jb1,jb2;

    public printbill() {

        jl1=new JLabel("Print Bill");
        jl2=new JLabel("Grand Total : ₹0.00");

        jt=new JTable();
        jp=new JScrollPane(jt);

        jb1=new JButton("Print Bill");
        jb2=new JButton("Back");

        setLayout(null);

        jl1.setBounds(350,30,300,50);
        jl1.setFont(new Font("Segoe UI",Font.BOLD,28));
        jl1.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));

        jp.setBounds(100,120,700,300);

        jl2.setBounds(500,440,280,40);
        jl2.setFont(new Font("Arial",Font.BOLD,20));
        jl2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));

        jb1.setBounds(250,510,150,50);
        jb2.setBounds(420,510,150,50);

        jb1.setBackground(Color.getHSBColor(0.59f,0.35f,0.24f));
        jb1.setForeground(Color.WHITE);
        jb1.setFocusPainted(false);
        jb1.setBorder(BorderFactory.createLineBorder(
                Color.getHSBColor(0.12f,0.55f,0.70f),1));

        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.getHSBColor(0.12f,0.35f,0.95f));
        jb2.setFocusPainted(false);
        jb2.setBorder(BorderFactory.createLineBorder(
                Color.getHSBColor(0.12f,0.55f,0.70f),1));
        
        ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\update1.png");
        
        jbg=new JLabel(ii);
        
        jbg.setBounds(0,0,900,600);

        add(jl1);
        add(jp);
        add(jl2);
        add(jb1);
        add(jb2);
        add(jbg);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        viewBill();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(jb1)) {
			
			try {
			
			boolean t=jt.print();
			
			
			if(t) {
				
				JOptionPane.showMessageDialog(this, "Printing Bill");
				
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Billing Failed");
				
			}
			
			
			
			
			}catch (PrinterException l) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "printer not found");
			}
			
			
		}
		
		if(e.getSource().equals(jb2)) {
			
			userdashboard us=new userdashboard();
			us.setTitle("userdashboard");
			
			us.setSize(900,600);
			
			us.setDefaultCloseOperation(firstlogin.EXIT_ON_CLOSE);
			
			us.setVisible(true);
			
		}
		
	}
    
    

	private void viewBill() {
		// TODO Auto-generated method stub
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
		
		DefaultTableModel dt=new DefaultTableModel();
		
		dt.addColumn("Id");
        dt.addColumn("Item Name");
        dt.addColumn("Price");
        dt.addColumn("Quantity");
        dt.addColumn("Total");
		
	PreparedStatement pst=	con.prepareStatement("select * from orders order by id ASC");
			
	ResultSet rs=	pst.executeQuery();
	
	float grandtotal=0;
	
	for(;rs.next();) {
		
		int id=rs.getInt("id");
		
		String name=rs.getString("itemname");
		
		float price=rs.getFloat("price");
		
		int quantity=rs.getInt("quantity");

        float total=rs.getFloat("total");
        
        
        grandtotal=grandtotal+total;
        
        dt.addRow(new Object[] {id,name,price,quantity,total});
        
        
		
        
		
	}
	jt.setModel(dt);
	
	jl2.setText( "Grand Total : ₹"  +String.format("%.2f",grandtotal)
	);
	
	
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}




    
    
    
    
}
