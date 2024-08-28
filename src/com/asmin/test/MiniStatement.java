package com.asmin.test;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.cj.xdevapi.Result;

public class MiniStatement extends JFrame {

	String pinNumber;

	MiniStatement(String pinNumber) {
		this.pinNumber = pinNumber;

		setTitle("Mini Statement");
		setLayout(null);

		JLabel mini = new JLabel();
		add(mini);

		JLabel bank = new JLabel("Asmin Bank");
		bank.setBounds(150, 20, 100, 20);
		add(bank);

		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);

		JLabel balance = new JLabel();
		card.setBounds(20, 400, 300, 20);
		add(card);

		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from login where pin='" + pinNumber + "'");
			while (rs.next()) {
				card.setText("Card Number  : " + rs.getString("cardNo").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("cardNo").substring(12));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Conn conn = new Conn();
			int bal = 0;
			ResultSet resultSet = conn.s.executeQuery("select * from transaction where pin='" + pinNumber + "'");
			while (resultSet.next()) {
				mini.setText(mini.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ resultSet.getString("amount") + "<br><br></html>");

				if (resultSet.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(resultSet.getString("amount"));
				} else {
					bal -= Integer.parseInt(resultSet.getString("amount"));
				}
			}
			balance.setText("Your Current Balance is Rs "+bal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mini.setBounds(20, 140, 400, 200);

		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}
}
