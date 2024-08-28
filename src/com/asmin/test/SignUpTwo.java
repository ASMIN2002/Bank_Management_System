package com.asmin.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
	
//	long random;
	JButton next;
	JRadioButton eyes,eno,syes,sno;
	JComboBox religion,category,occuption,education,income;
	JTextField pan,adhar;
	String formNo;
	
	SignUpTwo(String formNo){
		this.formNo=formNo;
		
		setLayout(null);		
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
				
		JLabel additionalDetails = new JLabel("Page  2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel name = new JLabel("Religion :");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Chistian","Other"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);

		
		JLabel fname = new JLabel("Category :");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		String valCategory[]= {"General","OBC","SC","ST","Other"};
		category = new JComboBox(valCategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel dob = new JLabel("Income :");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		String valincome[] = {"No Income","Less Then 1,50,000","Less Then 2,50,000","Less Then 5,00,000","Less Then 10,00,000","More Then 10,00,000"};
		income = new JComboBox(valincome);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		JLabel email = new JLabel("Qualification : ");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 315, 200, 30);
		add(email);
		
		String valeducation[] = {"Non-Graduate","Post-Graduate","Bachelor-Degree","Master-Degree","Other"};
		education = new JComboBox(valeducation);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);

		JLabel marital = new JLabel("Occupation :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		String valOccup[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
		occuption = new JComboBox(valOccup);
		occuption.setBounds(300, 390, 400, 30);
		occuption.setBackground(Color.WHITE);
		add(occuption);
		
		
		
		JLabel address = new JLabel("PAN Number :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel city = new JLabel("Adhar Number :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		adhar = new JTextField();
		adhar.setFont(new Font("Raleway", Font.BOLD, 14));
		adhar.setBounds(300, 490, 400, 30);
		add(adhar);
		
		JLabel state = new JLabel("Senior Citizon :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
	
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(syes);
		maritalGroup.add(sno);
		
		JLabel pincode = new JLabel("Existing Account :");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
	
		ButtonGroup eaccount = new ButtonGroup();
		eaccount.add(eyes);
		eaccount.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next); 
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(350, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = "";
		String sreligion = (String)religion.getSelectedItem();
		String scategory = (String)category.getSelectedItem();
		String sincome =(String) income.getSelectedItem();
		String seducation =(String) education.getSelectedItem();
		String soccuption = (String) occuption.getSelectedItem();
		
		String seniorcitizen = null;
		if(syes.isSelected()) {
			seniorcitizen = "Yes";
		}else if(sno.isSelected()) {
			seniorcitizen = "No";
		}
		String existingAccount = null;
		if(eyes.isSelected()) {
			existingAccount = "Yes";
		}else if(eno.isSelected()) {
			existingAccount = "No";
		}	
		
		
		String span= pan.getText();
		String sadhar = adhar.getText();

			try {
					Conn c = new Conn();
					String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccuption+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingAccount+"')";     
					c.s.executeUpdate(query);
					
					//SignUpThree Object
					setVisible(false);
					new SignUpThree(formNo).setVisible(true);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		new SignUpTwo("");
	}
}










