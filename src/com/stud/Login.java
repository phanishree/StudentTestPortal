package com.stud;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

class Saving implements Serializable{
	public String email;
	public String password;
	public String number;
	public Saving(String mail,String pw,String num) {
		email=mail;
		password=pw;
		number=num;
	}
	public String getMail() {
		return email;
	}
	public String getPassword() { //serialize , 
		return password;
	}
	public String getNumber() {
		return number;
	}
}


public class Login   extends JFrame {
	
public	JLabel aaraLabel = new JLabel("hullow aara girl");

class gif implements Runnable{
Thread th;
boolean bool=false;
int i=2;
	public gif() {
		th=new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				if(i%2==0)
				aaraLabel.setVisible(true);
				else
					aaraLabel.setVisible(false);	
				i++;
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				
			}
		}
	}
	
}
 
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JButton login = new JButton("Login");
	
	public String username;
	
	 File file=new File("LoginCredentials.txt");//file where login credentials are stored
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
		            frame.panel2.setVisible(false);
		           
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel1.setBackground(new Color(153, 102, 255));
	//	ht.put(key, value);
		
		panel1.setBounds(22, 70, 361, 62);
		contentPane.add(panel1);
		
		JButton b1 = new JButton("Sign Up");
		b1.setBounds(29, 11, 124, 33);
		b1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
				login.setVisible(false);
			new gif();
				
			}
		});
		panel1.setLayout(null);
		panel1.add(b1);
		
		JButton b2 = new JButton("Sign in");
		b2.setBounds(210, 11, 124, 33);
		b2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				new gif();
			}
		});
		panel1.add(b2);
		panel2.setBackground(new Color(153, 102, 255));
		
		
		panel2.setBounds(10, 136, 414, 166);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 11));
		lblEmail.setBounds(64, 11, 46, 14);
		panel2.add(lblEmail);
		
		t1 = new JTextField();
		t1.setBounds(111, 8, 86, 20);
		panel2.add(t1);
		t1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 11));
		lblPassword.setBounds(41, 36, 69, 14);
		panel2.add(lblPassword);
		
		t2 = new JTextField();
		t2.setBounds(111, 33, 86, 20);
		panel2.add(t2);
		t2.setColumns(10);
		login.setFont(new Font("Georgia", Font.PLAIN, 15));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br=new BufferedReader(new FileReader(file));
					String reader="";
					 Hashtable<String,String> ht=new Hashtable();
					while((reader=br.readLine())!=null) {
						String[] tokens=reader.split("/");
						ht.put(tokens[0],tokens[1]);
					}
					if(ht.containsKey(t1.getText())) {
						if(ht.get(t1.getText()).equals(t2.getText())) {
							//JOptionPane.showMessageDialog(null, "Login succesfull !");
							//Login frameToSwitch = new Login();
							setVisible(false);
							FrameIntermediate1 objOfThis=new FrameIntermediate1();
							objOfThis.userNameShift(t1.getText());
							objOfThis.setVisible(true);
							
							JOptionPane.showMessageDialog(null, "Login succesfull !");
							//frameToSwitch.setVisible(false);
							//username=t1.getText();
							//new FrameIntermediate1(t1.getText());
						}
						else
							JOptionPane.showMessageDialog(null, "incorrect email/password");
					}
					else
						JOptionPane.showMessageDialog(null, "You haven't registered yet , please get registered in order to login.");
					/*if(ht.containsKey(t1.getText())&&ht.containsValue(t2.getText())){
						JOptionPane.showMessageDialog(null, "YAAY !");
					}else
						JOptionPane.showMessageDialog(null, "incorrect email/password");*/
					
				}catch(IOException io1) {
					
				}
						}
		});
		
		
		login.setBounds(38, 132, 89, 23);
		panel2.add(login);
		panel3.setBackground(new Color(153, 102, 255));
		
		
		panel3.setBounds(41, 61, 333, 60);
		panel2.add(panel3);
		panel3.setLayout(null);
		
		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 11));
		lblMobile.setBounds(20, 11, 52, 14);
		panel3.add(lblMobile);
		
		t3 = new JTextField();
		t3.setBounds(72, 8, 86, 20);
		panel3.add(t3);
		t3.setColumns(10);
		
		JButton register = new JButton("Register");
		register.setFont(new Font("Georgia", Font.PLAIN, 15));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel3.setVisible(false);
			   
				try {
					
					PrintWriter p=new PrintWriter(new FileWriter(file,true));
					BufferedReader brr=new BufferedReader(new FileReader(file));
					String reader="";
					 Hashtable<String,String> htt=new Hashtable();
					while((reader=brr.readLine())!=null) {
						String[] tokens=reader.split("/"); //key/valu
						htt.put(tokens[0],tokens[1]);
					}
					if(htt.containsKey(t1.getText())) {
					String NamePartInEmail[]	=t1.getText().split("@");
						JOptionPane.showMessageDialog(null, "Hey "+NamePartInEmail[0]+" you have already reistered.");
					}
					else {
					p.write(t1.getText()+"/"+t2.getText()+"/"+t3.getText()+"\n");
					p.close();
					}
				}
				catch(IOException io) {
					System.out.println("Something wrong");
					io.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Now try logging in.");
				t1.setText("");
				t2.setText("");
				login.setVisible(true);
				
		
				
			}
		});
		register.setBounds(203, 37, 89, 23);
		panel3.add(register);
		
		
		aaraLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 16));
		aaraLabel.setForeground(Color.PINK);
		aaraLabel.setBounds(245, 21, 107, 14);
		panel2.add(aaraLabel);
		
		JLabel lblHelloNerd = new JLabel("Hello Nerd :)");
		lblHelloNerd.setFont(new Font("Ravie", Font.PLAIN, 20));
		lblHelloNerd.setBounds(111, 22, 185, 37);
		contentPane.add(lblHelloNerd);
	}
	
	

	
}
/*	 ArrayList<MobileNumbers> mobileNumbers=new ArrayList();
ht.put(t1.getText(), t2.getText());
MobileNumbers m=new MobileNumbers(t1.getText(),t3.getText());
mobileNumbers.add(m);
// mobileNumbers.add(t3.getText());

File file2=new File("MobileNums.txt"); // to store mobile numbers of all the registries
try {

FileOutputStream fos1=new FileOutputStream(file);
ObjectOutputStream os1=new ObjectOutputStream(fos1);
os1.writeObject(ht);

FileOutputStream fos2=new FileOutputStream(file2);
ObjectOutputStream os2=new ObjectOutputStream(fos2);
os2.writeObject(mobileNumbers);
}catch(IOException io) {
	 io.printStackTrace();
}*/
/*try {
FileInputStream fis1=new FileInputStream(file);
ObjectInputStream oi=new ObjectInputStream(fis1);
Hashtable ht1=(Hashtable)oi.readObject();
if(ht1.containsKey(t1.getText())&&ht1.containsValue(t2.getText()));
{
	JOptionPane.showMessageDialog(null, "UH-OH :(");
}
} catch ( IOException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}*/

