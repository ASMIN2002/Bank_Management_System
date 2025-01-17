package com.asmin.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinNumber;
	
	JButton change, back;
	
	BalanceEnquiry(String pinNumber) {
		this.pinNumber=pinNumber;
		
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn = new Conn();
		int balance = 0;
		try {
			ResultSet resultSet = conn.s.executeQuery("select * from transaction where pin='"+pinNumber+"'");
	
			while(resultSet.next()) {
				if(resultSet.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(resultSet.getString("amount"));
				}else {
					balance -= Integer.parseInt(resultSet.getString("amount"));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel text = new JLabel("Your Current Account Balance is  :  Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction(pinNumber).setVisible(true);
		
	}
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

	

}
