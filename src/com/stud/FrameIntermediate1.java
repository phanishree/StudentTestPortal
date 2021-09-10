package com.stud;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Label;

public class FrameIntermediate1 extends JFrame {

	private JPanel contentPane;
	private JPanel SubjectsDropdownPanel = new JPanel();
	public String UN;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameIntermediate1 frame = new FrameIntermediate1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameIntermediate1() {
		setForeground(new Color(255, 153, 153));
		setBackground(new Color(102, 102, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel TestButtonsSelectionPanel = new JPanel();
		TestButtonsSelectionPanel.setBackground(new Color(153, 102, 255));
		TestButtonsSelectionPanel.setBounds(0, 0, 434, 250);
		contentPane.add(TestButtonsSelectionPanel);
		TestButtonsSelectionPanel.setLayout(null);
		
		JButton btnMyTest = new JButton("My Test");
		btnMyTest.setBounds(123, 11, 144, 33);
		TestButtonsSelectionPanel.add(btnMyTest);
		btnMyTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MyTestJTable obj1=new MyTestJTable();//.setVisible(true);
				
				obj1.UserNameShift(UN);
				System.out.println("insisde FrasmeInbtermediate constructor "+UN);
				obj1.setVisible(true);
			}
		});
		btnMyTest.setForeground(new Color(70, 130, 180));
		btnMyTest.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		btnMyTest.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 58, 325, 2);
		TestButtonsSelectionPanel.add(separator);
		separator.setBackground(UIManager.getColor("Separator.background"));
		
		JButton btnNewTest = new JButton("New Test");
		btnNewTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestButtonsSelectionPanel.setVisible(false);
				SubjectsDropdownPanel.setVisible(true);
			}
		});
		btnNewTest.setBounds(123, 71, 144, 33);
		TestButtonsSelectionPanel.add(btnNewTest);
		btnNewTest.setForeground(new Color(70, 130, 180));
		btnNewTest.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		btnNewTest.setBackground(UIManager.getColor("Button.darkShadow"));
		SubjectsDropdownPanel.setBackground(new Color(153, 102, 255));
		
		
		SubjectsDropdownPanel.setBounds(0, 0, 434, 250);
		contentPane.add(SubjectsDropdownPanel);
		SubjectsDropdownPanel.setVisible(false);
		SubjectsDropdownPanel.setLayout(null);
		
		Choice dropdownSubs = new Choice();
		dropdownSubs.setBounds(111, 38, 162, 20);
		dropdownSubs.add("Java");
		dropdownSubs.add("Operating systems");
		dropdownSubs.add("C++");
		dropdownSubs.add("Potter head");
		
		
		SubjectsDropdownPanel.add(dropdownSubs);
		
		Label label = new Label("Select the subject !");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(126, 10, 132, 22);
		SubjectsDropdownPanel.add(label);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectsDropdownPanel.setVisible(false);
				TestButtonsSelectionPanel.setVisible(true);
			}
		});
		backButton.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		backButton.setBounds(0, 0, 62, 23);
		SubjectsDropdownPanel.add(backButton);
		
		JButton StartButton = new JButton("Start");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Subject selected is "+dropdownSubs.getSelectedItem());
				setVisible(false);
			new Test(dropdownSubs.getSelectedItem());
				new Test().setVisible(true);
				
				//TimeCount tc=new TimeCount();
			
			}
		});
		StartButton.setFont(new Font("Niagara Solid", Font.PLAIN, 22));
		StartButton.setBounds(315, 76, 89, 23);
		SubjectsDropdownPanel.add(StartButton);
	}
	public FrameIntermediate1(String s) {
		
	}
	void userNameShift(String un) {
		UN=un;
		System.out.println("Inside FrameIntermediate and userNameShift metrhod "+UN);
	}
}
