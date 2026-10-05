package com.miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class placeorder extends JFrame implements ActionListener {

    private JLabel jl1, jl2, jlTotal,jbg;
    private JButton jb1, jb2;
    private JScrollPane jp;
    private JPanel panel;

    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<Float> itemPrices = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();

    public placeorder() {

        jl1 = new JLabel("Place Order");
        jl2 = new JLabel("Select Items");
        jlTotal = new JLabel("Total : ₹0.00");

        jb1 = new JButton("Place Order");
        jb2 = new JButton("Back");

        panel = new JPanel();
        jp = new JScrollPane(panel);

        setLayout(null);

        jl1.setBounds(350, 20, 300, 50);
        
        jl1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        
        jl1.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f) );

        jl2.setBounds(80, 90, 200, 35);
        
        jl2.setFont(new Font("Arial", Font.BOLD, 18));
        jl2.setForeground( Color.getHSBColor(0.12f, 0.35f, 0.95f) );

        jp.setBounds(80, 130, 700, 300);

        panel.setLayout(null);

        jlTotal.setBounds(500, 450, 250, 40);
        jlTotal.setFont(new Font("Arial", Font.BOLD, 20));
        jlTotal.setForeground(Color.getHSBColor(0.12f, 0.35f, 0.95f) );

        jb1.setBounds(250, 510, 150, 45);
        jb2.setBounds(420, 510, 150, 45);

        jb1.setBackground( Color.getHSBColor(0.59f, 0.35f, 0.24f) );
        jb1.setForeground(Color.WHITE);
        jb1.setFocusPainted(false);

        jb2.setBackground(Color.BLACK);
        jb2.setForeground( Color.getHSBColor(0.12f, 0.35f, 0.95f) );
        jb2.setFocusPainted(false);

        jb1.setBorder(BorderFactory.createLineBorder( Color.getHSBColor(0.12f, 0.55f, 0.70f), 1));

        jb2.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.12f, 0.55f, 0.70f), 1 ));
        
        ImageIcon ii=new ImageIcon("C:\\Users\\S Narendhar\\OneDrive\\Desktop\\additems1.png");
        
        jbg=new JLabel(ii);
        
        jbg.setBounds(0,0,900,600);

        add(jl1);
        add(jl2);
        add(jp);
        add(jlTotal);
        add(jb1);
        add(jb2);
        add(jbg);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        loadItems();
    }

    public void loadItems() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mini", "root","root");

            PreparedStatement pst = con.prepareStatement( "select * from additems order by id asc" );

            ResultSet rs = pst.executeQuery();

            int y = 20;

            while(rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");

                itemNames.add(name);
                itemPrices.add(price);
                quantities.add(0);

                JLabel nameLabel = new JLabel(name + "  ₹" + price );
 
                JButton minus = new JButton("-");
                JButton plus = new JButton("+");

                JLabel quantity = new JLabel("0");

                nameLabel.setBounds(20, y, 300, 35);

                minus.setBounds(400, y, 50, 35);

                quantity.setBounds(460, y, 40, 35);

                plus.setBounds(510, y, 50, 35);

                nameLabel.setFont(new Font("Arial", Font.BOLD, 15) );

                minus.setFocusPainted(false);
                plus.setFocusPainted(false);

                panel.add(nameLabel);
                panel.add(minus);
                panel.add(quantity);
                panel.add(plus);

                int index = itemNames.size() - 1;

                minus.addActionListener(e -> {

                    if(quantities.get(index) > 0) { quantities.set( index,quantities.get(index) - 1 );
                    	quantity.setText(String.valueOf( quantities.get(index) ));

                        calculateTotal();
                    }
                });

                plus.addActionListener(e -> {

                    quantities.set(
                            index,
                            quantities.get(index) + 1
                    );

                    quantity.setText(
                            String.valueOf(
                                    quantities.get(index)
                            )
                    );

                    calculateTotal();
                });

                y = y + 50;
            }

            panel.setPreferredSize(
                    new java.awt.Dimension(650, y)
            );

        } catch(Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error"
            );
        }
    }

    public void calculateTotal() {

        float total = 0;

        for(int i = 0; i < itemPrices.size(); i++) {

            total = total + (itemPrices.get(i) * quantities.get(i));
        }

        jlTotal.setText("Total : ₹" + String.format("%.2f", total) );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	if(e.getSource().equals(jb1)) {

    	    float total = 0;

    	    boolean selected = false;

    	    try {

    	        Class.forName("com.mysql.cj.jdbc.Driver");

    	        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mini","root","root");

    	        PreparedStatement pst = con.prepareStatement( "insert into orders(itemname,price,quantity,total) values(?,?,?,?)" );

    	        for(int i = 0; i < itemPrices.size(); i++) {

    	            if(quantities.get(i) > 0) {

    	                selected = true;

    	                float itemTotal =
    	                        itemPrices.get(i) * quantities.get(i);

    	                total = total + itemTotal;

    	                pst.setString(1, itemNames.get(i));
    	                pst.setFloat(2, itemPrices.get(i));
    	                pst.setInt(3, quantities.get(i));
    	                pst.setFloat(4, itemTotal);

    	                pst.executeUpdate();
    	            }
    	        }

    	        if(!selected) {

    	            JOptionPane.showMessageDialog(
    	                    this,
    	                    "Please select at least one item"
    	            );

    	            return;
    	        }

    	        JOptionPane.showMessageDialog( this, "Order Placed\nTotal : ₹" + String.format("%.2f", total));

    	    } catch(Exception ex) {

    	        ex.printStackTrace();

    	        JOptionPane.showMessageDialog( this, "Database Error" );
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
}
