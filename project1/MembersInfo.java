package project1;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JButton;
import java.awt.Font;

public class MembersInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembersInfo frame = new MembersInfo();
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
	public MembersInfo() {
		setTitle("MEMBERS INFO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("VIEW DATA");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(347, 295, 165, 50);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 873, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int td=1;
				while(td<2) {
					td=2;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
					Statement st = con.createStatement();
					String query = "select * from info1";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int cols = rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
				String Fname,Lname,Email,Mob,date1,month1,year1,adhaar,room,floor,occup,wing,nom,flat;
				while(rs.next()) {
					Fname=rs.getString(1);
					Lname=rs.getString(2);
					Email=rs.getString(3);
					Mob=rs.getString(4);
					date1=rs.getString(5);
					month1=rs.getString(6);
					year1=rs.getString(7);
					adhaar=rs.getString(8);
					room=rs.getString(9);
					floor=rs.getString(10);
					occup=rs.getString(11);
					wing=rs.getString(12);
					nom=rs.getString(13);
					flat=rs.getString(14);
					String[] row = {Fname,Lname,Email,Mob,date1,month1,year1,adhaar,room,floor,occup,wing,nom,flat};
					model.addRow(row);
					
				}
				st.close();
				con.close();
				} catch (Exception p) {
					// TODO Auto-generated catch block
					System.out.println(p);
				}
				}
				
			}
		});
	}
}
