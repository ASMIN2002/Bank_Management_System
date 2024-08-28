package com.asmin.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit,withdraw,miniStatement,pinchange,fastcash,balanceEnquiry,exit;
	String pinNumber;
	
	FastCash(String pinNumber) {
		this.pinNumber=pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Rs 500");
		withdraw.setBounds(355, 415, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		miniStatement = new JButton("Rs 2000");
		miniStatement.setBounds(355, 450, 150, 30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceEnquiry = new JButton("Rs 10000");
		balanceEnquiry.setBounds(355, 485, 150, 30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("BACK");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900, 900);
		setLocation(300, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}else{
			String amount = ((JButton)e.getSource()).getText().substring(3);
			Conn conn = new Conn();
			try {
				ResultSet resultSet = conn.s.executeQuery("select * from transaction where pin='"+pinNumber+"'");
				int balance = 0;
				
				while(resultSet.next()) {
					if(resultSet.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(resultSet.getString("amount"));
					}else {
						balance -= Integer.parseInt(resultSet.getString("amount"));
					}
				}
				
				if(e.getSource() != exit && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();
				String query = "insert into transaction values ('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrawl Successfully");
				
				setVisible(false);
				new Transaction(pinNumber).setVisible(true);
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new FastCash("");
	}
}
