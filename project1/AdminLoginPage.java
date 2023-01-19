package project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class AdminLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage frame = new AdminLoginPage();
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
	public AdminLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1093, 634);
		setTitle("ADMIN LOGIN");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(131, 129, 333, 320);
		contentPane.add(panel);
		String imagePath="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\password.jpg";
		JLabel label = new JLabel(new ImageIcon(imagePath));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(573, 81, 287, 70);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(583, 161, 366, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(583, 272, 155, 36);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(583, 335, 366, 42);
		contentPane.add(passwordField);
		
		final JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton.setBounds(632, 451, 274, 42);
		btnNewButton.addActionListener(new ActionListener() {
			
				 public void actionPerformed(ActionEvent e) {
		                String userName = textField.getText();
		                String password = passwordField.getText();
		                try {
		                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem",
		                        "root", "PrasadSQL2022");

		                    PreparedStatement st = (PreparedStatement) connection
		                        .prepareStatement("Select username, password_info from login_inform where username=? and password_info=?");

		                    st.setString(1, userName);
		                    st.setString(2, password);
		                    ResultSet rs = st.executeQuery();
		                    if (rs.next()) {
		                       
		                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
		                    	dispose();
		        				DashBoard d1 = new DashBoard();
		        				d1.setVisible(true);
		                    } else {
		                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
		                    }
		                } catch (Exception p) {
		                    System.out.println(p);
		                }

				
				
			
				
				
			}
		});
		contentPane.add(btnNewButton);
	}
}

