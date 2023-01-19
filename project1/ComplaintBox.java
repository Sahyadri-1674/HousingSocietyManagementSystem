package project1;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ComplaintBox extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintBox frame = new ComplaintBox();
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
	public ComplaintBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1197, 697);
		setTitle("COMPLAINT BOX");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setSize(screen.width,screen.height);
		contentPane = new JPanel();
		//FlowLayout flowLayout = (FlowLayout) contentPane.getLayout();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 255, 0));
		progressBar.setBackground(new Color(255, 0, 0));
		progressBar.setValue(100);
		progressBar.setStringPainted(true);
		contentPane.add(progressBar);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Make Complaint");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		/*
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(302, 393, 1038, 181);
		
		contentPane.add(textArea_1);
		*/
		textField = new JTextField();
		textField.setBounds(258, 298, 813, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 452, 813, 66);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 187, 164, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SUBJECT :-");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBounds(64, 239, 170, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DESCRIPTION :-");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_2.setBounds(64, 367, 258, 47);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(722, 581, 113, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Make Complain");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_3.setBounds(505, 58, 319, 58);
		contentPane.add(lblNewLabel_3);
		
		//JLabel lblNewLabel_4 = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\complainicon.png")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(img));
		String imagePath="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\office-building-icon.png";
		JLabel label = new JLabel(new ImageIcon(imagePath));
		label.setHorizontalAlignment(SwingConstants.CENTER);
	//	lblNewLabel_4.setBounds(610, 21, 108, 143);
		//contentPane.add(lblNewLabel_4);
		JPanel panel = new JPanel();
		panel.add(label);
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panel);
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(505, 581, 113, 47);
		contentPane.add(btnNewButton);
		
		String imagePath3="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\complainicon.png";
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(imagePath3));
		lblNewLabel_4.setBounds(81, 22, 134, 125);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FLAT NO:-");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_5.setBounds(64, 180, 186, 30);
		contentPane.add(lblNewLabel_5);
		
//		textField_1 = new JTextField();
//		textField_1.setBounds(302, 180, 164, 30);
//		contentPane.add(textField_1);
//		textField_1.setColumns(10);
//		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flat_no = textField_2.getText();
		    	String subject = textField.getText();
		    	String description  = textField_1.getText();
		    	
		    	
				
		        	try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
						Statement stmt = con.createStatement();
						System.out.println("Inserting Records");
						String sql = "insert into complaint_box values('"+flat_no+"','"+subject+"','"+description+"')";
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"Complaint Registered Successfully");
					}catch(Exception p){
						JOptionPane.showMessageDialog(null, "Some Error Occurred!");
			System.out.println(p);}
    	
				
				//dispose();
				/*
				UserDashboard d2 = new UserDashboard();
				d2.setVisible(true);
				*/
			}
			
	});
}
}
