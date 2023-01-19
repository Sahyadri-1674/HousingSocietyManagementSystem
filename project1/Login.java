package project1;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class Login extends JFrame  {

	/**
	 * 
	 */
	
	private JPanel contentPane;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame= new Login();
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
	public Login() {
		
		setTitle("SELECT ROLE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1183, 694);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(168, 95, 330, 334);
		contentPane.add(panel);
		String imagePath="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\user1.jpg";
		JLabel label = new JLabel(new ImageIcon(imagePath));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(label);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(675, 111, 319, 318);
		contentPane.add(panel_1);
		String imagePath1="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\admin.jpg";
		JLabel label1 = new JLabel(new ImageIcon(imagePath1));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.add(label1);
		
		JButton btnNewButton = new JButton("USER");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Loginpage lp1 = new Loginpage();
				lp1.setVisible(true);
			}
		});
		btnNewButton.setBounds(210, 500, 238, 61);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADMIN");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLoginPage lp2 = new AdminLoginPage();
				lp2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(717, 500, 238, 61);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("SELECT LOGIN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(64, 27, 304, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("SECURITY");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(717, 593, 215, 31);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Visitors1 v2 = new Visitors1();
				v2.setVisible(true);
			}
		});
		  
	}
}
