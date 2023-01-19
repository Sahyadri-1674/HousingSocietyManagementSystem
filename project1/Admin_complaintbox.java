package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_complaintbox extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_complaintbox frame = new Admin_complaintbox();
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
	public Admin_complaintbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1101, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 53, 957, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FLAT NO", "SUBJECT", "DESCRIPTION", "REPLY"
			}
		));
		   table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("Arial", Font.PLAIN, 18);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        lblNewLabel = new JLabel("REPLY :-");
	        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
	        lblNewLabel.setBounds(52, 373, 120, 29);
	        contentPane.add(lblNewLabel);
	        
	        textField = new JTextField();
	        textField.setBounds(52, 427, 957, 39);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        
	        btnNewButton = new JButton("VIEW DATA");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				String query = "select *from complaint_box";
	    				ResultSet rs = stmt.executeQuery(query);
	    				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	    				DefaultTableModel model = (DefaultTableModel) table.getModel();
	    				
	    				int cols = rsmd.getColumnCount();
	    				String[] colName = new String[cols];
	    				for(int  i=0;i<cols;i++) 
	    					colName[i]=rsmd.getColumnName(i+1);
	    					model.setColumnIdentifiers(colName);
	    					String flat_no,subj,descript;
	    					while(rs.next()) {
	    						flat_no = rs.getString(1);
	    						subj = rs.getString(2);
	    						descript = rs.getString(3);
	    						String[] row = {flat_no,subj,descript};
	    						model.addRow(row);
	    					}
	    					stmt.close();
	    					con.close();
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}	    
	        		
	        	}
	        	
	        });
	        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
	        btnNewButton.setBounds(343, 531, 148, 50);
	        contentPane.add(btnNewButton);
	        
	        btnNewButton_1 = new JButton("SEND");
	        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
	        btnNewButton_1.setBounds(562, 531, 120, 50);
	        contentPane.add(btnNewButton_1);
	}
}
