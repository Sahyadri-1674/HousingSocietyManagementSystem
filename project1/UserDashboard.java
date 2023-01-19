package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard frame = new UserDashboard();
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
	public UserDashboard() {
		setTitle("USER DASHBOARD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1281, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(378, 28, 785, 121);
		contentPane.add(panel_1);
		String imagePath="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\EHousing1.jpg";
		panel_1.setBackground(Color.white);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label = new JLabel(new ImageIcon(imagePath));
		panel_1.add(label);
	
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(309, 174, 948, 519);
		contentPane.add(panel_2);
		String imagePath2="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\EHousing2.jpg";
		panel_2.setBackground(Color.white);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label2 = new JLabel(new ImageIcon(imagePath2));
		panel_2.add(label2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(35, 179, 266, 514);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton btnNewButton = new JButton("NOTICE BOARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Noticeboard1 n1 = new Noticeboard1();
				n1.setVisible(true);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(40, 43, 185, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("COMPLAINT BOX");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComplaintBox c1 = new ComplaintBox();
				c1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(40, 279, 185, 44);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VISITORS INFO");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitors1 v1 = new Visitors1();
				v1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(40, 155, 185, 44);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("VEHICLE INFO");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_4.setBounds(40, 397, 185, 44);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vehicle1 veh1 = new Vehicle1();
				veh1.setVisible(true);
			}
		});
		panel.add(btnNewButton_4);
		
	}
}
