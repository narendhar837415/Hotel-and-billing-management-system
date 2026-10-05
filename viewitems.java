package com.miniproject;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class viewitems extends JFrame{
	
	private JTable jt;
	
	private JScrollPane jp;
	
	String name,id;
	
	Float price;
	
	public viewitems() {
		
		jt=new JTable();
		
		jp=new JScrollPane(jt);
		
		setLayout(null);
		
		jp.setBounds(250,60,400,500);
		
		add(jp);
		
		task();
		
	}
	
	
	
	public void task() {
		
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
		
		DefaultTableModel dt=new DefaultTableModel();
		dt.addColumn("Id");
		dt.addColumn("Itemname");
		dt.addColumn("Price");
		
		
		PreparedStatement pst=	con.prepareStatement("select * from additems order by id asc");
	
		ResultSet rs=pst.executeQuery();
		
		
		for(;rs.next();) {
			
			
			id=rs.getString("id");
			name=	rs.getString("name");
			
		price=Float.parseFloat(	rs.getString("price"));
			
			dt.addRow(new Object[] {id,name,price});
			
		} 
		
		jt.setModel(dt);
		
		
		jt.setModel(dt);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < jt.getColumnCount(); i++) {
		    jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		jt.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		
		jt.getTableHeader().setFont(new Font("Arial", Font.BOLD,20));
		
		
		
		
		
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
