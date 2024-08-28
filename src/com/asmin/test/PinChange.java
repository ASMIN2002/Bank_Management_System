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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {

	JPasswordField pin, repin;
	JButton change, back;
	String pinNumber;

	PinChange(String pinNumber) {
		this.pinNumber=pinNumber;

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(250, 280, 500, 35);
		image.add(text);

		JLabel pintext = new JLabel("New Pin : ");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setBounds(165, 320, 100, 25);
		image.add(pintext);

		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(330, 320, 180, 25);
		add(pin);

		JLabel repintext = new JLabel("Re-Enter New Pin : ");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setBounds(165, 360, 180, 25);
		image.add(repintext);

		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(330, 360, 180, 25);
		add(repin);

		change = new JButton("CHANGE");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();

				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Enterd Pin Does Not Match");
					return;
				}
				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Pin");
					return;
				}
				
				if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
					return;
				}
				
				Conn conn = new Conn();
				String query1="update transaction set pin='"+rpin+"' where pin='"+pinNumber+"'";
				String query2="update login set pin='"+rpin+"' where pin='"+pinNumber+"'";
				String query3="update signupthree set pin='"+rpin+"' where pin='"+pinNumber+"'";

				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
				setVisible(false);
				new Transaction(rpin).setVisible(true);

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);

	}

}
