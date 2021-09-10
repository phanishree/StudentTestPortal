package com.stud;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyTestJTable extends JFrame {

	private JPanel contentPane;
private	JScrollPane scrollPane;
	public String username;
public 	ArrayList<String> arr=new ArrayList();
public String a[][];
public String b[]= {"Name","Date","Subject","Score"};
private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTestJTable frame = new MyTestJTable();
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

	public MyTestJTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 67, 467, 292);
		contentPane.add(scrollPane);
		Image image= new ImageIcon(this.getClass().getResource("/Back-2-2-icon.png")).getImage();
		
		Button backButtonJTable = new Button("Back");
		backButtonJTable.setBounds(10, 20, 45, 22);
		contentPane.add(backButtonJTable);
		backButtonJTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrameIntermediate1().setVisible(true);
				
			}
		});
		
		
	}
	
	/*public MyTestJTable(String username) {
		this.username=username;
		System.out.println("inside para const "+username);
	}*/
	
	void readFile() {
	
	}
	void LoadData() {
		String chunks[];
		System.out.println(arr.toString());
		for(int i=0;i<arr.size();i++) {
		chunks=arr.get(i).split(",");
		//JOptionPane.showMessageDialog(null, chunks[0]+" "+arr.get(i));
	/*	JOptionPane.showMessageDialog(null, chunks[0]+" "+arr.get(i));
		JOptionPane.showMessageDialog(null, chunks[1]+" "+arr.get(i));
		JOptionPane.showMessageDialog(null, chunks[2]+" "+arr.get(i));
		JOptionPane.showMessageDialog(null, chunks[3]+" "+arr.get(i));*/
		a[i][0]=chunks[0];
		a[i][1]=chunks[1];
		a[i][2]=chunks[2];
		a[i][3]=chunks[3];
		//a[i][4]=chunks[4];
	}
		table = new JTable(a,b);
		scrollPane.setViewportView(table);
		
	
}
	void UserNameShift(String UN) {
		this.username=UN;
	//	System.out.println("inside MyTestJTasble and usenameshift method "+username);
		BufferedReader read;
		String line;
		String tokens[];
	//	System.out.println("inside para const "+this.username);
		try {
			read=new BufferedReader(new FileReader("C:/ProjQuestionPapers/TrailForTable.txt"));
			while((line=read.readLine())!=null) {
				tokens=line.split(",");
				if(tokens[0].equals(username)) {
					arr.add(line);
				}
			}
			read.close();
		 a=new String [arr.size()][4];
			LoadData();
		}
		catch(Exception ec) {
			System.out.println("duhh");
			ec.printStackTrace();
		}
	}
}