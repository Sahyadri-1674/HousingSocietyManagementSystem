package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Visitors1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visitors1 frame = new Visitors1();
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
	  public Visitors1() {
	        // create JFrame and JTable
	        JFrame frame = new JFrame("VISITORS INFO");
	        final JTable table = new JTable();

	        // create a table model and set a Column Identifiers to this model
	        Object[] columns = {"DATE", "NAME", "MOBILE NO", "FLAT NO", "IN TIME"};
	        final DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columns);

	        // set the model to the table
	        table.setModel(model);

	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("Arial", Font.PLAIN, 18);
	        table.setFont(font);
	        table.setRowHeight(30);

	        // create JTextFields
	        final JTextField TX1 = new JTextField();
	        final JTextField TX2 = new JTextField();
	        final JTextField TX3 = new JTextField();
	        final JTextField TX4 = new JTextField();
	        final JTextField TX5 = new JTextField();

	        // create JButtons
	        JButton btnAdd = new JButton("Add");
	        btnAdd.setFont(new Font("Arial", Font.BOLD, 18));
	        JButton btnDelete = new JButton("Delete");
	        btnDelete.setFont(new Font("Arial", Font.BOLD, 18));
	        JButton btnUpdate = new JButton("Update");
	        btnUpdate.setFont(new Font("Arial", Font.BOLD, 18));

	        TX1.setBounds(207, 270, 200, 30);
	        TX2.setBounds(207, 342, 200, 30);
	        TX3.setBounds(207, 412, 200, 30);
	        TX4.setBounds(639, 270, 200, 30);
	        TX5.setBounds(639, 342, 200, 30);

	        btnAdd.setBounds(212, 486, 100, 35);
	        btnUpdate.setBounds(407, 486, 100, 35);
	        btnDelete.setBounds(609, 486, 100, 35);

	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 880, 200);

	        frame.getContentPane().setLayout(null);

	        frame.getContentPane().add(pane);

	        // add JTextFields to the jframe
	        frame.getContentPane().add(TX1);
	        frame.getContentPane().add(TX2);
	        frame.getContentPane().add(TX3);
	        frame.getContentPane().add(TX4);
	        frame.getContentPane().add(TX5);

	        // add JButtons to the jframe
	        frame.getContentPane().add(btnAdd);
	        frame.getContentPane().add(btnDelete);
	        frame.getContentPane().add(btnUpdate);

	        JLabel lblNewLabel = new JLabel("DATE :-");
	        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel.setBounds(84, 257, 113, 51);
	        frame.getContentPane().add(lblNewLabel);

	        JLabel lblNewLabel_1 = new JLabel("NAME :-");
	        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_1.setBounds(57, 331, 140, 46);
	        frame.getContentPane().add(lblNewLabel_1);

	        JLabel lblNewLabel_2 = new JLabel("MOBILE NO :-");
	        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_2.setBounds(42, 401, 120, 46);
	        frame.getContentPane().add(lblNewLabel_2);

	        JLabel lblNewLabel_3 = new JLabel("FLAT NO :-");
	        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_3.setBounds(491, 267, 113, 30);
	        frame.getContentPane().add(lblNewLabel_3);

	        JLabel lblNewLabel_4 = new JLabel("IN TIME :-");
	        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_4.setBounds(487, 329, 142, 51);
	        frame.getContentPane().add(lblNewLabel_4);
	        
	        JButton btnNewButton = new JButton("VIEW ");
	        btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
	        btnNewButton.setBounds(50, 486, 100, 30);
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement st = con.createStatement();
	    				String query = "select *from visitor";
	    				ResultSet rs = st.executeQuery(query);
	    				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	    				DefaultTableModel model = (DefaultTableModel) table.getModel();
	    				
	    				int cols = rsmd.getColumnCount();
	    				String[] colName = new String[cols];
	    				for(int  i=0;i<cols;i++) 
	    					colName[i]=rsmd.getColumnName(i+1);
	    					model.setColumnIdentifiers(colName);
	    					String dateinfo ,Flat_no ,Name ,timing ,mob_no ;
	    					while(rs.next()) {
	    						dateinfo = rs.getString(1);
	    						Flat_no = rs.getString(2);
	    						Name = rs.getString(3);
	    						timing = rs.getString(4);
	    						mob_no = rs.getString(5);
	    						String[] row = {dateinfo ,Flat_no ,Name ,timing ,mob_no};
	    						model.addRow(row);
	    					}
	    					st.close();
	    					con.close();
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}	    
	        		
	        	}
	        });
	        frame.getContentPane().add(btnNewButton);

	        // create an array of objects to set the row data
	        final Object[] row = new Object[5];

	        // button add row
	        btnAdd.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String Date=TX1.getText();
	            	String Flat_no=TX2.getText();
	            	String Name=TX3.getText();
	            	String Time=TX4.getText();
	            	String Mobile_no=TX5.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","root@1234");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into visitor values('"+Date+"','"+Flat_no+"','"+Name+"','"+Time+"','"+Mobile_no+"')";
	    				stmt.executeUpdate(sql);
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}
	    	

	                if (TX1.getText().toString().isEmpty() || TX2.getText().toString().isEmpty() || TX3.getText().toString().isEmpty() || TX4.getText().toString().isEmpty() || TX5.getText().toString().isEmpty() ) {
	                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
	                    //  JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
	                    return;
	                }
	                row[0] = TX1.getText();
	                row[1] = TX2.getText();
	                row[2] = TX3.getText();
	                row[3] = TX4.getText();
	                row[4] = TX5.getText();

	                // add row to the model
	                model.addRow(row);
	                TX1.setText(null);
	                TX2.setText(null);
	                TX3.setText(null);
	                TX4.setText(null);
	                TX5.setText(null);

	            }
	            
	        });

	        // button remove row
	        btnDelete.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String Date=TX1.getText();
	            	String Flat_no=TX2.getText();
	            	String Name=TX3.getText();
	            	String Time=TX4.getText();
	            	String Mobile_no=TX5.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into visitor values('"+Date+"','"+Flat_no+"','"+Name+"','"+Time+"','"+Mobile_no+"')";
	    				stmt.executeUpdate(sql);
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}

	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                if (i >= 0) {
	                    // remove a row from jtable
	                    int selection = JOptionPane.showConfirmDialog(null, "Do you want to delete this record", "Confirm", JOptionPane.YES_NO_OPTION);
	                    if (selection == JOptionPane.YES_OPTION) {
	                        model.removeRow(i);
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Please select the record to be deleted", "Error", JOptionPane.ERROR_MESSAGE);
	                    //System.out.println("Delete Error");
	                }
	            }
	        });

	        // get selected row data From table to textfields
	        table.addMouseListener(new MouseAdapter() {

	            @Override
	            public void mouseClicked(MouseEvent e) {

	                // i = the index of the selected row
	                int i = table.getSelectedRow();

	                TX1.setText(model.getValueAt(i, 0).toString());
	                TX2.setText(model.getValueAt(i, 1).toString());
	                TX3.setText(model.getValueAt(i, 2).toString());
	                TX4.setText(model.getValueAt(i, 3).toString());
	                TX5.setText(model.getValueAt(i, 4).toString());
	                
	            }
	        });

	        // button update row
	        btnUpdate.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String Date=TX1.getText();
	            	String Flat_no=TX4.getText();
	            	String Name=TX2.getText();
	            	String Time=TX5.getText();
	            	String Mobile_no=TX3.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into visitor values('"+Date+"','"+Flat_no+"','"+Name+"','"+Time+"','"+Mobile_no+"')";
	    				stmt.executeUpdate(sql);
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}

	                // i = the index of the selected row
	                int i = table.getSelectedRow();

	                if (i >= 0) {
	                    model.setValueAt(TX1.getText(), i, 0);
	                    model.setValueAt(TX2.getText(), i, 1);
	                    model.setValueAt(TX3.getText(), i, 2);
	                    model.setValueAt(TX4.getText(), i, 3);
	                    model.setValueAt(TX5.getText(), i, 4);
	                   
	                } else {
	                    System.out.println("Update Error");
	                }
	            }
	        });

	        frame.setSize(900, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	    }