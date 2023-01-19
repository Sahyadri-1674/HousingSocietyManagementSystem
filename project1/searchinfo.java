package project1;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchinfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchinfo frame = new searchinfo();
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
	public searchinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(365, 85, 129, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Vehicle No");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(48, 86, 214, 21);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(365, 203, 129, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("FLAT NO");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(48, 206, 171, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
    				Class.forName("com.mysql.jdbc.Driver");
    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
    				//Statement stmt = con.createStatement();
    				//System.out.println("Inserting Records");
    				//String sql="select Flat_no from Vehicle_details where Vehicle_no=? ";
    				//PreparedStatement pst = con.prepareStatement(sql);
    				PreparedStatement pst = (PreparedStatement) con
	                        .prepareStatement("select Flat_no from Vehicle_details where Vehicle_no=? ");

    				pst.setString(1, textField.getText());
    				ResultSet rs =  pst.executeQuery();
    				if(rs.next())
    				{
    					String setFlat_no= rs.getString("Flat_no");
    					textField_1.setText(setFlat_no);
    			    }
    				else
    				{
    					JOptionPane.showMessageDialog(null,"Data doesn't exists!");
    				}
    				  
    				
    			}catch(Exception p){
    	System.out.println(p);}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(247, 331, 123, 34);
		contentPane.add(btnNewButton);
		
	}
}
