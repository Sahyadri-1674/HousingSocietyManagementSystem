package project1;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Welcome extends JFrame
{
	public static void main(String[] args) {
		new Welcome();
		
	}
	
	public Welcome()
	{
		displayWelcomeScreen();
		//setVisible(true);
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		JLabel label = new JLabel("Welcome to Housing Society Management System");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		JButton b = new JButton("START");
		b.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login loc = new Login();
				loc.setVisible(true);
			}
				});
		b.setBounds(300,300,100,30);
		add(b);
		
	}
	
	
	private void displayWelcomeScreen() 
	{
		final JWindow w = new JWindow(this);
		w.setSize(600,400);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		
		JPanel panel = new JPanel();
		w.add(panel);
		String imagePath="C:\\Users\\Pratik Arote\\eclipse-workspace\\HousingSocietyManagementSystem\\img\\office-building-icon.png";
		JLabel label = new JLabel(new ImageIcon(imagePath));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		final JProgressBar progress = new JProgressBar(0,100);
		progress.setForeground(Color.orange);
		w.add(BorderLayout.PAGE_END,progress);
		w.revalidate();
		
		 timer = new Timer(100,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = progress.getValue();
				if(x==100) {
					w.dispose();
					Welcome.this.setVisible(true);
					
					timer.stop();
				}else {
					progress.setValue(x+4);
				}
				
			}
		});
		
		timer.start();
		}
	Timer timer;
}