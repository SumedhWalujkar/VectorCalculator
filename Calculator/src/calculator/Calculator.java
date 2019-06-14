package calculator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.PointerInfo;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.lang.Math.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private double firstMagnitude;
	private double firstAngle;
	private double secondMagnitude;
	private double secondAngle;
	private double middleMagnitude;
	private double middleAngle;
	private double ansMagnitude;
	private double ansAngle;
	private String action;
	private String solutionMagnitude;
	private String solutionAngle;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
					window.frame.setTitle("Vector calculator 1.0");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAmp = new JLabel("Amp");
		lblAmp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAmp.setBounds(68, 11, 46, 33);
		frame.getContentPane().add(lblAmp);
		
		JLabel lblPhase = new JLabel("Phase");
		lblPhase.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhase.setBounds(198, 11, 46, 33);
		frame.getContentPane().add(lblPhase);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char demo=e.getKeyChar();
				if(!(Character.isDigit(demo)) && !(demo=='-') && !(demo=='.'))  {
					e.consume();
				}
			}
		});
		textField.setBounds(22, 42, 120, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char demo=e.getKeyChar();
				if(!(Character.isDigit(demo)) && !(demo=='-') && !(demo=='.'))  {
					e.consume();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(158, 42, 120, 40);
		frame.getContentPane().add(textField_1);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondMagnitude=Double.parseDouble(textField.getText());
				secondAngle=Double.parseDouble(textField_1.getText());
				if(action=="+") {
					 double temp1=firstMagnitude*Math.cos(Math.toRadians(firstAngle));
					 double temp2=secondMagnitude*Math.cos(Math.toRadians(secondAngle));
					 double temp1N2=temp1+temp2;
					 double temp3=firstMagnitude*Math.sin(Math.toRadians(firstAngle));
					 double temp4=secondMagnitude*Math.sin(Math.toRadians(secondAngle));
					 double temp3N4=temp3+temp4;
					 System.out.print(360%(Math.toDegrees(Math.atan2(temp3N4, temp1N2))));
					 ansMagnitude=Math.sqrt(Math.pow(temp1N2, 2)+Math.pow(temp3N4, 2));
					 ansAngle=(Math.toDegrees(Math.atan2(temp3N4, temp1N2)));
					 if(ansAngle<0) {
						 ansAngle=360+ansAngle;
					 }
					 else
						 ansAngle=ansAngle%360;
					 solutionMagnitude=String.format("%2f",ansMagnitude);
					 solutionAngle=String.format("%2f",ansAngle);
					 textField.setText(solutionMagnitude);
					 textField_1.setText(solutionAngle);
					 
				}
				else if(action=="-") {
					 double temp1=firstMagnitude*Math.cos(Math.toRadians(firstAngle));
					 double temp2=secondMagnitude*Math.cos(Math.toRadians(secondAngle));
					 double temp1N2=temp1-temp2;
					 double temp3=firstMagnitude*Math.sin(Math.toRadians(firstAngle));
					 double temp4=secondMagnitude*Math.sin(Math.toRadians(secondAngle));
					 double temp3N4=temp3-temp4;
					 System.out.print(Math.toDegrees(Math.atan2(temp3N4, temp1N2)));
					 ansMagnitude=Math.sqrt(Math.pow(temp1N2, 2)+Math.pow(temp3N4, 2));
					 ansAngle= (Math.toDegrees(Math.atan2(temp3N4, temp1N2)));
					 if(ansAngle<0) {
						 ansAngle=360+ansAngle;
					 }
					 else
						 ansAngle=ansAngle%360;
					 solutionMagnitude=String.format("%2f",ansMagnitude);
					 solutionAngle=String.format("%2f",ansAngle);
					 textField.setText(solutionMagnitude);
					 textField_1.setText(solutionAngle);
					 
				}
				else if(action=="*") {
					 ansMagnitude=firstMagnitude*secondMagnitude;
					 ansAngle=firstAngle+secondAngle;
					 if(ansAngle<0) {
						 ansAngle=360+ansAngle;
					 }
					 else
						 ansAngle=ansAngle%360;
					 solutionMagnitude=String.format("%2f",ansMagnitude);
					 solutionAngle=String.format("%2f",ansAngle);
					 textField.setText(solutionMagnitude);
					 textField_1.setText(solutionAngle);
				}
				else if(action=="/") {
					 ansMagnitude=firstMagnitude/secondMagnitude;
					 ansAngle=firstAngle-secondAngle;
					 if(ansAngle<0) {
						 ansAngle=360+ansAngle;
					 }
					 else
						 ansAngle=ansAngle%360;
					 solutionMagnitude=String.format("%2f",ansMagnitude);
					 solutionAngle=String.format("%2f",ansAngle);
					 textField.setText(solutionMagnitude);
					 textField_1.setText(solutionAngle);
				}
				else if(action=="SPB") {
					 double temp1=firstMagnitude*Math.cos(Math.toRadians(firstAngle));
					 double temp2=middleMagnitude*Math.cos(Math.toRadians(middleAngle));
					 double temp1N2=temp1-temp2;
					 double temp3=firstMagnitude*Math.sin(Math.toRadians(firstAngle));
					 double temp4=middleMagnitude*Math.sin(Math.toRadians(middleAngle));
					 double temp3N4=temp3-temp4;
					 System.out.print(Math.toDegrees(Math.atan2(temp3N4, temp1N2)));
					 double dummyMagnitude=Math.sqrt(Math.pow(temp1N2, 2)+Math.pow(temp3N4, 2));
					 double dummyAngle= (Math.toDegrees(Math.atan2(temp3N4, temp1N2)));
					 if(dummyAngle<0) {
						 dummyAngle=360+dummyAngle;
					 }
					 else
						 dummyAngle=dummyAngle%360;
					 System.out.println(dummyMagnitude+" "+dummyAngle);
					 
					 double answerMagnitude=dummyMagnitude/secondMagnitude;
					 double answerAngle=dummyAngle-secondAngle;
					 if(answerAngle<0) {
						 answerAngle=360+answerAngle;
					 }
					 else
						 answerAngle=answerAngle%360;
					 System.out.println(answerMagnitude+" "+answerAngle);
					 ansMagnitude=middleMagnitude/answerMagnitude;
					 ansAngle=middleAngle-180-answerAngle;
					 if(ansAngle<0) {
						 ansAngle=360+ansAngle;
					 }
					 else
						 ansAngle=ansAngle%360;
					 solutionMagnitude=String.format("%2f",ansMagnitude);
					 solutionAngle=String.format("%2f",ansAngle);
					 textField.setText(solutionMagnitude);
					 textField_1.setText(solutionAngle);
					 
				}
			}
		});
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnEnter.setBounds(22, 93, 120, 45);
		frame.getContentPane().add(btnEnter);
		
		JButton btn = new JButton("CL x/A");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btn.setBounds(158, 93, 120, 45);
		frame.getContentPane().add(btn);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setForeground(Color.RED);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstMagnitude=Double.parseDouble(textField.getText());
				firstAngle=Double.parseDouble(textField_1.getText());
				action="+";
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnPlus.setFont(new Font("Stencil", Font.BOLD, 21));
		btnPlus.setBounds(22, 141, 51, 100);
		frame.getContentPane().add(btnPlus);
		
		JButton btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstMagnitude=Double.parseDouble(textField.getText());
				firstAngle=Double.parseDouble(textField_1.getText());
				action="-";
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnminus.setForeground(Color.RED);
		btnminus.setFont(new Font("Stencil", Font.BOLD, 21));
		btnminus.setBounds(91, 142, 51, 99);
		frame.getContentPane().add(btnminus);
		
		JButton btnmultiply = new JButton("*");
		btnmultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstMagnitude=Double.parseDouble(textField.getText());
				firstAngle=Double.parseDouble(textField_1.getText());
				action="*";
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnmultiply.setForeground(Color.RED);
		btnmultiply.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnmultiply.setBounds(158, 142, 51, 99);
		frame.getContentPane().add(btnmultiply);
		
		JButton btndivide = new JButton("/");
		btndivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstMagnitude=Double.parseDouble(textField.getText());
				firstAngle=Double.parseDouble(textField_1.getText());
				action="/";
				textField.setText("");
				textField_1.setText("");
			}
		});
		btndivide.setForeground(Color.RED);
		btndivide.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btndivide.setBounds(227, 142, 51, 99);
		frame.getContentPane().add(btndivide);
		
		JButton singleplaneBalancing = new JButton("Single Plane Balancing");
		singleplaneBalancing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstMagnitude=Double.parseDouble(textField.getText());
				firstAngle=Double.parseDouble(textField_1.getText());
				action="SPB";
				textField.setText("");
				textField_1.setText("");
			}
		});
		singleplaneBalancing.setFont(new Font("Times New Roman", Font.BOLD, 21));
		singleplaneBalancing.setBounds(22, 255, 256, 45);
		frame.getContentPane().add(singleplaneBalancing);
		
		JButton trialweight = new JButton("Trial Weight");
		trialweight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				middleMagnitude=Double.parseDouble(textField.getText());
				middleAngle=Double.parseDouble(textField_1.getText());
				action="SPB";
				textField.setText("");
				textField_1.setText("");
			}
		});
		trialweight.setFont(new Font("Times New Roman", Font.BOLD, 21));
		trialweight.setBounds(22, 311, 256, 45);
		frame.getContentPane().add(trialweight);
	}
}
