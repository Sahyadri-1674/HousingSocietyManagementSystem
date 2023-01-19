package project1;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DashBoard extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
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
	public DashBoard() {
		setTitle("ADMIN DASHBOARD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen.width,screen.height);
		setBounds(100, 100, 1666, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		//contentPane.setBounds(new Rectangle(100, 100, 300, 300));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(345, 25, 954, 121);
		contentPane.add(panel_1);
		String imagePath="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\EHousing1.jpg";
		panel_1.setBackground(Color.white);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label = new JLabel(new ImageIcon(imagePath));
		panel_1.add(label);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(58, 182, 266, 514);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		btnNewButton = new JButton("NOTICE BOARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Noticeboard1 n1 = new Noticeboard1();
				n1.setVisible(true);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(40, 33, 185, 44);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("COMPLAINT BOX");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_complaintbox a1 =  new Admin_complaintbox ();
				a1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(40, 254, 185, 44);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VISITORS INFO");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visitors1 v1 = new Visitors1();
				v1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(40, 177, 185, 44);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("VEHICLE INFO");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vehicle1 veh1 = new Vehicle1();
				veh1.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_4.setBounds(40, 387, 185, 44);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("MAINTENANCE");
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_5.setBounds(40, 320, 185, 44);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Maintenance1 maint1 = new Maintenance1();
				maint1.setVisible(true);
			}
		});
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("MEMBERS INFO");
		btnNewButton_3.setBounds(40, 100, 185, 44);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				MembersInfo m1 = new MembersInfo();
				m1.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewButton_6 = new JButton("ADD MEMBERS");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration1 r1 = new Registration1();
				r1.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_6.setBounds(40, 454, 185, 38);
		panel.add(btnNewButton_6);
		
		panel_2 = new JPanel();
		panel_2.setBounds(345, 182, 948, 519);
		contentPane.add(panel_2);
		String imagePath2="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\EHousing2.jpg";
		panel_2.setBackground(Color.white);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label2 = new JLabel(new ImageIcon(imagePath2));
		panel_2.add(label2);
		

	}
}
