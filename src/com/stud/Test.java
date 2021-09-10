package com.stud;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



				
@SuppressWarnings("serial")
public class Test extends JFrame {

public JLabel TimeCount = new JLabel("");
					
private JPanel contentPane;
private	JTextArea QueWithOptions = new JTextArea();
private Button NextButton = new Button("Next");
private Button QuitButton = new Button("Quit");
 private CheckboxGroup cbg=new CheckboxGroup();

    private ArrayList<String> QnOList=new ArrayList<String>(); //ArrayList to store the  String line read from file. 
	private static String FileName;                   //to store the filename which we get from the FrameIntermediate frame
	private static int index=0;      /*this is to increment the index of QnOList ,so that the question and 4 options can be loaded to the textField*/
	/*
	 * evaluationBoolean,evaluation,FinalMarks are used for the evaluation of marks at the end of test.
	 * 
	 *  */
    private  ArrayList<Boolean> evaluationBoolean=new ArrayList<Boolean>();
    private ArrayList<String> evaluation=new ArrayList<String>();
    private static int FinalMarks;
	private static int unAnswered=0;
    int RunningTime=30;  //This is used in displaying the time/seconds running (with the help of Label named TimeCount   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	@SuppressWarnings("unused")
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 527, 135);
		contentPane.add(scrollPane);
		
		
		QueWithOptions.setLineWrap(true);
		scrollPane.setViewportView(QueWithOptions);
		
		
		
		JPanel OptionsPanel = new JPanel();
		OptionsPanel.setBounds(20, 157, 517, 56);
		contentPane.add(OptionsPanel);
		OptionsPanel.setLayout(null);
		
		
		Checkbox c1 = new Checkbox("1",cbg,false);
		c1.setBounds(10, 10, 62, 22);
		OptionsPanel.add(c1);
		
		Checkbox c2 = new Checkbox("2",cbg,false);
		c2.setBounds(92, 10, 62, 22);
		OptionsPanel.add(c2);
		
		Checkbox checkbox3 = new Checkbox("3",cbg,false);
		checkbox3.setBounds(164, 10, 62, 22);
		OptionsPanel.add(checkbox3);
		
		Checkbox checkbox4 = new Checkbox("4",cbg,false);
		checkbox4.setBounds(232, 10, 49, 22);
		OptionsPanel.add(checkbox4);
		
		
		
		NextButton.setBounds(438, 229, 70, 22);
		contentPane.add(NextButton);
		NextButton.addKeyListener(new NextButtonListener());
		NextButton.addActionListener(new NextButtonListener());
		
		
		QuitButton.addActionListener(new QuitButton());
		QuitButton.setBounds(537, 229, 70, 22);
		contentPane.add(QuitButton);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(574, 88, 46, 14);
		contentPane.add(lblTime);
		TimeCount.setBounds(561, 113, 46, 14);
		contentPane.add(TimeCount);
		
		new QuestionOptionDisplay().display();
		TimeCount tc=new TimeCount();  //creating an object of inner class TimeCount (used to keep the time/seconds counting)
		
		System.out.println("filename inside default constructor "+FileName);
	}
	public Test(String filename) {
/*
parameterised constructor for Test class .
this is to get the subject selected from the checkbox from FrameIntermediate class.                  // C:/ProjQuestionPapers
*/

		FileName=filename;
		System.out.println(FileName+" is the file name....inside parameterised");
	}
	
	class QuestionOptionDisplay /*implements Runnable*/ {
		
		String line;
		String f;
		String QnOp[];
		BufferedReader read;
		 
		public void display() {
		try {
			f=FileName+".txt";
			System.out.println(FileName+" is the file name");
			System.out.println(f+" is the file name");
			 read=new BufferedReader(new FileReader("C:/ProjQuestionPapers/"+FileName+".txt"));
			 
		while((line=read.readLine())!=null)
		{
			QnOList.add(line);        // adding  the string line into ArrayList of String called QnO
		}
		QnOp=QnOList.get(0).split("/");	     
/*
* QnOp[0] would be question . QnOp[1],QnOp[2],QnOp[3],QnOp[4] would be 4 options .
* QnOp[5] would be the correct answer of the question (which is used in FinalMarksEvaluationFunction() function of NextButtonListener class
*/
 QueWithOptions.setText(QnOp[0]+"\n"+"\n"+QnOp[1]+"\n"+QnOp[2]+"\n"+QnOp[3]+"\n"+QnOp[4]+"\n"); //Setting the TextField with Questions and options
	read.close();
		
		}catch(Exception io) {
			io.printStackTrace();
			System.out.println("file not found or somrthing");
		}}
	}
	
	class NextButtonListener extends QuestionOptionDisplay implements ActionListener,KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 RunningTime=30;
			
			index++;    //incrementing the index to access the string line which was loaded into ArrayList
		//	System.out.println(index+" "+QnOList.size());
		//	cbg.setSelectedCheckbox(null);
			if(cbg.getSelectedCheckbox()!=null) {
	
			if(index==QnOList.size()) {           //if all the questions are over, evaluation will be done 
				
				//NextButton.disable();
				evaluation.add(cbg.getSelectedCheckbox().getLabel());
				                                                     
				FinalMarksEvaluationFunction();   //function which computes the marks obtained by the student
				                                              
				for(int i=0;i<evaluationBoolean.size();i++) {
					                                            //This for loop also is a part of computing marks obtained
					if(evaluationBoolean.get(i)) {
						FinalMarks++;               
				}
				}
				JOptionPane.showMessageDialog(null, "That was the last question. you'll get the result now.");
				JOptionPane.showMessageDialog(null,"your score is "+ FinalMarks+"/"+QnOList.size()+""+"\n"+unAnswered+" Unanswered questions "+"");
				}
		//	else if(cbg.getSelectedCheckbox()==null&&){
			else
			{
				//index++; 
			QnOp=QnOList.get(index).split("/");	            //QnOp is the string array . QnOList is the arrayList
			QueWithOptions.setText(QnOp[0]+"\n"+"\n"+QnOp[1]+"\n"+QnOp[2]+"\n"+QnOp[3]+"\n"+QnOp[4]+"\n");
			//if(!(cbg.getSelectedCheckbox().getLabel().)
			//if(cbg.getSelectedCheckbox()!=null)
			evaluation.add(cbg.getSelectedCheckbox().getLabel());
		//	else
				
			//JOptionPane.showMessageDialog(null,cbg.getSelectedCheckbox().getLabel());
		
			}
			}
			else if(index==QnOList.size()&&cbg.getSelectedCheckbox()==null) {
				
				evaluation.add("duhh");     //this "duhh" is to keep count of questions which are unanswered
				
				FinalMarksEvaluationFunction(); 
				
				for(int i=0;i<evaluationBoolean.size();i++) {
                    //This for loop also is a part of computing marks obtained
                if(evaluationBoolean.get(i)) {
                             FinalMarks++;               
                                   }
                                                  }
          JOptionPane.showMessageDialog(null, "That was the last question. you'll get the result now.");
          JOptionPane.showMessageDialog(null,"your score is "+ FinalMarks+"/"+QnOList.size()+""+"\n"+unAnswered+" Unanswered questions "+"");
				
			}
			else {
				if(index<QnOList.size()) {
					
				evaluation.add("duhh");     //this "duhh" is to keep count of questions which are unanswered
				
				System.out.println("phani "+index);
				QnOp=QnOList.get(index).split("/");	            //QnOp is the string array . QnOList is the arrayList
				QueWithOptions.setText(QnOp[0]+"\n"+"\n"+QnOp[1]+"\n"+QnOp[2]+"\n"+QnOp[3]+"\n"+QnOp[4]+"\n");
			//	index++; 
				}
			}
			cbg.setSelectedCheckbox(null);  
		}
		void FinalMarksEvaluationFunction() {
			String t5[];
			int j=0;
		
			System.out.println(evaluation.toString());
			 try {
				read=new BufferedReader(new FileReader("C:/ProjQuestionPapers/"+FileName+".txt"));
				while((line=read.readLine())!=null) {
					//j++;
					t5=line.split("/");
					if(t5[5].equals(evaluation.get(j))) {
						evaluationBoolean.add(true);
						j++;
					}	
					else if(evaluation.get(j).equals("duhh")) {
						unAnswered++;
					j++;
					}
					else {
						evaluationBoolean.add(false);
					j++;
					}
				}
				//System.out.println(evaluation.toString());
				read.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	class QuitButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			System.exit(0);
			/*Login l1=new Login();
			l1.setVisible(true);
			l1.panel1.setVisible(true);
			l1.panel2.setVisible(false);*/
			//new Login().panel2.setVisible(true);
		}
		
	}
	
	class TimeCount implements Runnable{
		
		//int RunningTime=30;
					public TimeCount() {
						Thread th=new Thread(this);
					th.start();
					}
					@Override
					public void run() {
						// TODO Auto-generated method stub
						String QnOpp[];
						while(index!=QnOList.size()) {
							try {
							if(RunningTime==0) {
								if(cbg.getSelectedCheckbox()==null) {
									evaluation.add("duhh");
								
								}
				RunningTime=30;
				index++;
				QnOpp=QnOList.get(index).split("/");	   //QnOpp is the string array(local) . QnO is the arrayList(of outer class)
				QueWithOptions.setText(QnOpp[0]+"\n"+"\n"+QnOpp[1]+"\n"+QnOpp[2]+"\n"+QnOpp[3]+"\n"+QnOpp[4]+"\n");
								
							}
							
				TimeCount.setText(RunningTime+"");
				RunningTime--;
				System.out.println(RunningTime);
				Thread.sleep(1000);
								
							}
							catch(InterruptedException ie) {
								ie.printStackTrace();
							}
						}
					}
	}
				}

