package com.asmin.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
	
	JButton deposit,withdraw,miniStatement,pinchange,fastcash,balanceEnquiry,exit;
	String pinNumber;
	
	Transaction(String pinNumber) {
		this.pinNumber=pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 415, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355, 450, 150, 30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(355, 485, 150, 30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Exit");
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
			System.exit(0);
		}else if(e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}else if(e.getSource()==withdraw) {
			setVisible(false);
			new Withdraw(pinNumber).setVisible(true);
		}else if(e.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}else if(e.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}else if(e.getSource()==balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}else if(e.getSource()==miniStatement) {
			new MiniStatement(pinNumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Transaction("");
	}
}
