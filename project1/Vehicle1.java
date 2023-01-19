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

public class Vehicle1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicle1 frame = new Vehicle1();
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
	  public Vehicle1() {
	        // create JFrame and JTable
	        JFrame frame = new JFrame("VEHICLE INFO");
	        final JTable table = new JTable();

	        // create a table model and set a Column Identifiers to this model
	        Object[] columns = { "FLAT NO","VEHICLE NO", "OWNER NAME", "PARKING ALLOTMENT NO", "VEHICLE TYPE"};
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
	        TX4.setBounds(639, 342, 200, 30);
	        TX5.setBounds(639, 404, 200, 30);

	        btnAdd.setBounds(336, 486, 100, 35);
	        btnUpdate.setBounds(497, 486, 100, 35);
	        btnDelete.setBounds(650, 486, 100, 35);

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

	        JLabel lblNewLabel = new JLabel("FLAT NO :-");
	        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel.setBounds(84, 257, 113, 51);
	        frame.getContentPane().add(lblNewLabel);

	        JLabel lblNewLabel_1 = new JLabel("VEHICLE NO :-");
	        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_1.setBounds(42, 331, 155, 46);
	        frame.getContentPane().add(lblNewLabel_1);

	        JLabel lblNewLabel_2 = new JLabel("OWNER NAME :-");
	        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_2.setBounds(27, 401, 155, 46);
	        frame.getContentPane().add(lblNewLabel_2);

	        JLabel lblNewLabel_3 = new JLabel("PARKING ALLOTMENT NO :-");
	        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_3.setBounds(464, 259, 286, 46);
	        frame.getContentPane().add(lblNewLabel_3);

	        JLabel lblNewLabel_4 = new JLabel("VEHICLE TYPE :-");
	        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
	        lblNewLabel_4.setBounds(464, 391, 188, 51);
	        frame.getContentPane().add(lblNewLabel_4);
	        
	        JButton btnNewButton = new JButton("View Data");
	        btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
	        btnNewButton.setBounds(143, 486, 113, 30);
	        frame.getContentPane().add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("Search");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		searchinfo s = new searchinfo();
	        		s.setVisible(true);
	        	}
	        	
	        });
	        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
	        btnNewButton_1.setBounds(10, 490, 100, 26);
	        frame.getContentPane().add(btnNewButton_1);

	        // create an array of objects to set the row data
	        final Object[] row = new Object[5];

btnNewButton.addActionListener(new ActionListener(){
	        	
	        	public void actionPerformed(ActionEvent e){
	        		try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				String query = "select *from Vehicle_details";
	    				ResultSet rs = stmt.executeQuery(query);
	    				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	    				DefaultTableModel model = (DefaultTableModel) table.getModel();
	    				
	    				int cols = rsmd.getColumnCount();
	    				String[] colName = new String[cols];
	    				for(int  i=0;i<cols;i++) 
	    					colName[i]=rsmd.getColumnName(i+1);
	    					model.setColumnIdentifiers(colName);
	    					String Flat_no,Parking_no,Vehicle_no,Owner_name,Vehicle_type;
	    					while(rs.next()) {
	    						Flat_no = rs.getString(1);
	    						Parking_no = rs.getString(2);
	    						Vehicle_no = rs.getString(3);
	    						Owner_name = rs.getString(4);
	    						Vehicle_type = rs.getString(5);
	    						String[] row = {Flat_no,Parking_no,Vehicle_no,Owner_name,Vehicle_type};
	    						model.addRow(row);
	    					}
	    					stmt.close();
	    					con.close();
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}	     
	        	}
	        	
	        } );
	        

	        // button add row
	        btnAdd.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {

	            	String Flat_no = TX1.getText();
	            	String Parking_no = TX4.getText();
	            	String Vehicle_no = TX2.getText();
	            	String Owner_name= TX3.getText();
	            	String Vehicle_Type = TX5.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into Vehicle_details(Flat_no,Parking_no,Vehicle_no,Owner_name,Vehicle_Type) values('"+Flat_no+"','"+Parking_no+"','"+Vehicle_no+"','"+Owner_name+"','"+Vehicle_Type+"')";
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

	            	String Flat_no = TX1.getText();
	            	String Parking_no = TX4.getText();
	            	String Vehicle_no = TX2.getText();
	            	String Owner_name= TX3.getText();
	            	String Vehicle_Type = TX5.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into Vehicle_details(Flat_no,Parking_no,Vehicle_no,Owner_name,Vehicle_Type) values('"+Flat_no+"','"+Parking_no+"','"+Vehicle_no+"','"+Owner_name+"','"+Vehicle_Type+"')";
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