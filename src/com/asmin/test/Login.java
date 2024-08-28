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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	JButton login,signUp,clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	public Login() {
		
		setTitle("AUTOMATED TELLER MECHINE");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);		
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("Card No : ");
		cardno.setFont(new Font("Raieway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
		add(cardTextField);
		
		JLabel pin = new JLabel("Pin :");
		pin.setFont(new Font("Osward", Font.BOLD, 30));
		pin.setBounds(120, 220, 250, 30);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 16));
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(300, 350, 230, 30);
		signUp.setBackground(Color.BLACK);
		signUp.setForeground(Color.WHITE);
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(750, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(350, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if(e.getSource()==login) {
			Conn conn = new Conn();
			String cardNumber = cardTextField.getText();
			String pinNumber = pinTextField.getText();
			
			String query = "select * from login where cardNo='"+cardNumber+"'and pin='"+pinNumber+"'";
			try {
				ResultSet resultSet = conn.s.executeQuery(query);
				if(resultSet.next()) {
					setVisible(false);
					new Transaction(pinNumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()==signUp) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();
	}	
}
