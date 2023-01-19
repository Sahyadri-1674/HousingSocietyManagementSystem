package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Registration1 extends JFrame {

	private JPanel contentPane;
	JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t12;
    JRadioButton rb1,rb2;
    JComboBox cb1,cb2,cb3,cb4;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration1 frame = new Registration1();
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
	 public Registration1(){
	        f=new JFrame("Registration");
	        l1=new JLabel("FirstName");
	        l2=new JLabel("LastName");
	        l3=new JLabel("Email");
	        l4=new JLabel("Mobile No");
	        l5=new JLabel("BirthDate(DD/MM/YYYY)");
	        l6=new JLabel("Room No");
	        l7=new JLabel("Floor");
	        l8=new JLabel("Occupation");
	        l9=new JLabel("Wing");
	        l10=new JLabel("Gender");
	        l11=new JLabel("Flat type");
	        l12=new JLabel("Aadhaar No");
	        l13=new JLabel("Number of Members");

	        t1=new JTextField();
	        t2=new JTextField();
	        t3=new JTextField();
	        t4=new JTextField();
	        t5=new JTextField();
	        t6=new JTextField();
	        t7=new JTextField();
	        t8=new JTextField();
	        t9=new JTextField();
	        t12 =new JTextField();

	         rb1=new JRadioButton("A) Male");
	         rb2=new JRadioButton("B) Female");
	         final ButtonGroup bg=new ButtonGroup();
	         bg.add(rb1);bg.add(rb2);

	         l1.setBounds(20,40,80,20);
	         t1.setBounds(100,40,200,30);
	         f.getContentPane().add(l1);f.getContentPane().add(t1);
	         l2.setBounds(400,40,80,20);
	         t2.setBounds(480,40,200,30);
	         f.getContentPane().add(l2);f.getContentPane().add(t2);
	         l3.setBounds(20,90,80,20);
	         t3.setBounds(100,90,250,30);
	         f.getContentPane().add(l3);f.getContentPane().add(t3);
	         l4.setBounds(400,90,80,20);
	         t4.setBounds(480,90,150,30);
	         f.getContentPane().add(l4);f.getContentPane().add(t4);
	         l10.setBounds(20,140,80,20);
	         rb1.setBounds(100,140,80,30);
	         rb2.setBounds(180,140,100,30);
	         f.getContentPane().add(l10);f.getContentPane().add(rb1);f.getContentPane().add(rb2);
	         l5.setBounds(300,140,140,20);
	        String DD[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21",
	                "22","23","24","25","26","27","28","29","30","31"};
	        String MM[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	        String YYYY[]={"1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973",
	                "1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988",
	                "1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003"};
	        cb1 = new JComboBox(DD);
	        cb1.setBounds(450,140,50,20);
	        cb2 = new JComboBox(MM);
	        cb2.setBounds(500,140,50,20);
	        cb3 = new JComboBox(YYYY);
	        cb3.setBounds(550,140,140,20);
	        f.getContentPane().add(l5);
	        f.getContentPane().add(cb1);f.getContentPane().add(cb2);f.getContentPane().add(cb3);

	        l12.setBounds(20,190,80,20);
	        t12.setBounds(100,190,200,30);
	        l8.setBounds(400,190,80,20);
	        t8.setBounds(480,190,200,30);
	        f.getContentPane().add(l12);f.getContentPane().add(t12);
	        f.getContentPane().add(l8);f.getContentPane().add(t8);

	        l9.setBounds(20,240,80,20);
	        t9.setBounds(100,240,200,30);
	        l7.setBounds(400,240,80,20);
	        t7.setBounds(480,240,200,30);
	        f.getContentPane().add(l7);f.getContentPane().add(t7);f.getContentPane().add(l9);f.getContentPane().add(t9);

	        l6.setBounds(20,290,80,20);
	        t6.setBounds(100,290,200,30);
	        f.getContentPane().add(l6);f.getContentPane().add(t6);
	        l11.setBounds(400,290,80,20);
	        String type[]={"1 RK","1 BHK","2 BHK","3 BHK"};
	        cb4=new JComboBox(type);
	        cb4.setBounds(480,290,200,30);
	        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        f.getContentPane().add(l11);f.getContentPane().add(cb4);

	        l13.setBounds(20,340,150,20);
	        t5.setBounds(150,340,200,30);
	        f.getContentPane().add(l13);f.getContentPane().add(t5);
	      
	        f.setSize(800,600);
	        f.getContentPane().setLayout(null);
	        
	        btnNewButton = new JButton("SAVE");
	        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
	        btnNewButton.setBounds(236, 441, 100, 39);
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String Fname = t1.getText();
	            	String Lname = t2.getText();
	            	String Email  = t3.getText();
	            	String Mob = t4.getText();
	            	String dobD = cb1.getSelectedItem().toString();
	            	String dobM = cb2.getSelectedItem().toString();
	            	String dobY = cb3.getSelectedItem().toString();
	            	String room = t6.getText();
	            	String floor = t7.getText();
	            	String occup = t8.getText();
	            	String wing = t9.getText();
	            	String adhaar = t12.getText();
	            	
	            	String flat = cb4.getSelectedItem().toString();
	            	String nom = t5.getText();
	            	
	            	
	                
	                	try {
	        				Class.forName("com.mysql.jdbc.Driver");
	        				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	        				Statement stmt = con.createStatement();
	        				System.out.println("Inserting Records");
	        				String sql = "insert into info1 values('"+Fname+"','"+Lname+"','"+Email+"','"+Mob+"','"+dobD+"','"+dobM+"','"+dobY+"','"+adhaar+"','"+room+"','"+floor+"','"+occup+"','"+wing+"','"+nom+"','"+flat+"')";
	        				stmt.executeUpdate(sql);
	        				
	        			}catch(Exception p){
	        	System.out.println(p);}
	        	
	        		 JOptionPane.showMessageDialog(f,"Member Registered Successfully");
	        	}
	        });
	        	

	        f.getContentPane().add(btnNewButton);
	        
	        btnNewButton_1 = new JButton("CANCEL");
	        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
	        btnNewButton_1.setBounds(448, 441, 102, 32);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		 JOptionPane.showMessageDialog(f,"Entered Information will be Lost.","Alert",JOptionPane.WARNING_MESSAGE);
	        	}
	        });
	       
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.getContentPane().add(btnNewButton_1);
	        f.setVisible(true);
	      
	    }
	  
	  
	}



