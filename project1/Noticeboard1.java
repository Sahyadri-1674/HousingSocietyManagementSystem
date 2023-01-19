package project1;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

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

public class Noticeboard1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Noticeboard1 frame = new Noticeboard1();
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
	                                                                                                                                                                                                                  
	                                                                                                                                                                                                                          
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                               
	    public Noticeboard1() {                                                                                                                                                                                                                                     
	                                                                                                                                                                                                                                                               
	        // create JFrame and JTable                                                                                                                                                                                                                            
	        JFrame frame = new JFrame("NOTICE BOARD");                                                                                                                                                                                                             
	        final JTable table = new JTable();                                                                                                                                                                                                                     
	                                                                                                                                                                                                                                                               
	        // create a table model and set a Column Identifiers to this model                                                                                                                                                                                     
	        Object[] columns = {"TITLE","CATEGORY","DATE","SENDER","DESCRIPTION"};                                                                                                                                                                                 
	        final DefaultTableModel model = new DefaultTableModel();                                                                                                                                                                                               
	        model.setColumnIdentifiers(columns);                                                                                                                                                                                                                   
	                                                                                                                                                                                                                                                               
	        // set the model to the table                                                                                                                                                                                                                          
	        table.setModel(model);                                                                                                                                                                                                                                 
	                                                                                                                                                                                                                                                               
	        // Change A JTable Background Color, Font Size, Font Color, Row Height                                                                                                                                                                                 
	        table.setBackground(Color.LIGHT_GRAY);                                                                                                                                                                                                                 
	        table.setForeground(Color.black);                                                                                                                                                                                                                      
	        Font font = new Font("Arial", Font.PLAIN,18);                                                                                                                                                                                                          
	        table.setFont(font);                                                                                                                                                                                                                                   
	        table.setRowHeight(30);                                                                                                                                                                                                                                
	                                                                                                                                                                                                                                                               
	        // create JTextFields                                                                                                                                                                                                                                  
	        final JTextField TITLE = new JTextField();                                                                                                                                                                                                             
	        final JTextField CATEGORY = new JTextField();                                                                                                                                                                                                          
	        final JTextField DATE = new JTextField();                                                                                                                                                                                                              
	        final JTextField SENDER = new JTextField();                                                                                                                                                                                                            
	        final JTextField DESCRIPTION = new JTextField();                                                                                                                                                                                                       
	                                                                                                                                                                                                                                                               
	        // create JButtons                                                                                                                                                                                                                                     
	        JButton btnAdd = new JButton("Add");                                                                                                                                                                                                                   
	        btnAdd.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                                      
	        JButton btnDelete = new JButton("Delete");                                                                                                                                                                                                             
	        btnDelete.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                                   
	        JButton btnUpdate = new JButton("Update");                                                                                                                                                                                                             
	        btnUpdate.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                                   
	                                                                                                                                                                                                                                                               
	        TITLE.setBounds(207, 270, 200, 30);                                                                                                                                                                                                                    
	        CATEGORY.setBounds(207, 342, 200, 30);                                                                                                                                                                                                                 
	        DATE.setBounds(207, 412, 200, 30);                                                                                                                                                                                                                     
	        SENDER.setBounds(639, 270, 200, 30);                                                                                                                                                                                                                   
	        DESCRIPTION.setBounds(639, 342, 200, 30);                                                                                                                                                                                                              
	                                                                                                                                                                                                                                                               
	        btnAdd.setBounds(212, 486, 100, 35);                                                                                                                                                                                                                   
	        btnUpdate.setBounds(407, 486, 100, 35);                                                                                                                                                                                                                
	        btnDelete.setBounds(609, 486, 100, 35);                                                                                                                                                                                                                
	                                                                                                                                                                                                                                                               
	        // create JScrollPane                                                                                                                                                                                                                                  
	        JScrollPane pane = new JScrollPane(table);                                                                                                                                                                                                             
	        pane.setBounds(0, 0, 880, 200);                                                                                                                                                                                                                        
	                                                                                                                                                                                                                                                               
	        frame.getContentPane().setLayout(null);                                                                                                                                                                                                                
	                                                                                                                                                                                                                                                               
	        frame.getContentPane().add(pane);                                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                               
	        // add JTextFields to the jframe                                                                                                                                                                                                                       
	        frame.getContentPane().add(TITLE);                                                                                                                                                                                                                     
	        frame.getContentPane().add(CATEGORY);                                                                                                                                                                                                                  
	        frame.getContentPane().add(DATE);                                                                                                                                                                                                                      
	        frame.getContentPane().add(SENDER);                                                                                                                                                                                                                    
	        frame.getContentPane().add(DESCRIPTION);                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	        // add JButtons to the jframe                                                                                                                                                                                                                          
	        frame.getContentPane().add(btnAdd);                                                                                                                                                                                                                    
	        frame.getContentPane().add(btnDelete);                                                                                                                                                                                                                 
	        frame.getContentPane().add(btnUpdate);                                                                                                                                                                                                                 
	                                                                                                                                                                                                                                                               
	        JLabel lblNewLabel = new JLabel("TITLE :-");                                                                                                                                                                                                           
	        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                                 
	        lblNewLabel.setBounds(84, 257, 113, 51);                                                                                                                                                                                                               
	        frame.getContentPane().add(lblNewLabel);                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	        JLabel lblNewLabel_1 = new JLabel("CATEGORY :-");                                                                                                                                                                                                      
	        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                               
	        lblNewLabel_1.setBounds(57, 331, 140, 46);                                                                                                                                                                                                             
	        frame.getContentPane().add(lblNewLabel_1);                                                                                                                                                                                                             
	                                                                                                                                                                                                                                                               
	        JLabel lblNewLabel_2 = new JLabel("DATE :-");                                                                                                                                                                                                          
	        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                               
	        lblNewLabel_2.setBounds(84, 401, 78, 46);                                                                                                                                                                                                              
	        frame.getContentPane().add(lblNewLabel_2);                                                                                                                                                                                                             
	                                                                                                                                                                                                                                                               
	        JLabel lblNewLabel_3 = new JLabel("SENDER :-");                                                                                                                                                                                                        
	        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                               
	        lblNewLabel_3.setBounds(491, 267, 113, 30);                                                                                                                                                                                                            
	        frame.getContentPane().add(lblNewLabel_3);                                                                                                                                                                                                             
	                                                                                                                                                                                                                                                               
	        JLabel lblNewLabel_4 = new JLabel("DESCRIPTION :-");                                                                                                                                                                                                   
	        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));                                                                                                                                                                                               
	        lblNewLabel_4.setBounds(487, 329, 142, 51);                                                                                                                                                                                                            
	        frame.getContentPane().add(lblNewLabel_4);                                                                                                                                                                                                             
	        
	        final JButton btnNewButton = new JButton("VIEW");
	        btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				String query = "select *from notice";
	    				ResultSet rs = stmt.executeQuery(query);
	    				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	    				DefaultTableModel model = (DefaultTableModel) table.getModel();
	    				
	    				int cols = rsmd.getColumnCount();
	    				String[] colName = new String[cols];
	    				for(int  i=0;i<cols;i++) 
	    					colName[i]=rsmd.getColumnName(i+1);
	    					model.setColumnIdentifiers(colName);
	    					String title,category,issued_date,sender,descript;
	    					while(rs.next()) {
	    						title = rs.getString(1);
	    						category = rs.getString(2);
	    						issued_date = rs.getString(3);
	    					    sender = rs.getString(4);
	    						descript = rs.getString(5);
	    						String[] row = {title,category,issued_date,sender,descript};
	    						model.addRow(row);
	    					}
	    					stmt.close();
	    					con.close();
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}	     
	        	    
	        	}
	        });
	        btnNewButton.setBounds(28, 486, 113, 35);
	       
	        frame.getContentPane().add(btnNewButton);
	                                                                                                                                                                                                                                                               
	        // create an array of objects to set the row data                                                                                                                                                                                                      
	        final Object[] row = new Object[5];                                                                                                                                                                                                                    
	                                                                                                                                                                                                                                                               
	        // button add row                                                                                                                                                                                                                                      
	        btnAdd.addActionListener(new ActionListener(){                                                                                                                                                                                                         
	                                                                                                                                                                                                                                                               
	            @Override                                                                                                                                                                                                                                          
	            public void actionPerformed(ActionEvent e) {  
	            	String title =TITLE.getText();
	            	String category = CATEGORY.getText();
	            	String date  = DATE.getText();
	            	String sender = SENDER.getText();
	            	String description = DESCRIPTION.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into notice values('"+title+"','"+category+"','"+date+"','"+sender+"','"+description+"')";
	    				stmt.executeUpdate(sql);
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}
	    	
	                                                                                                                                                                                                                                                               
	                if(TITLE.getText().toString().isEmpty()||TITLE.getText().toString().isEmpty()||CATEGORY.getText().toString().isEmpty()||DATE.getText().toString().isEmpty()||SENDER.getText().toString().isEmpty()||DESCRIPTION.getText().toString().isEmpty())
	                {                                                                                                                                                                                                                                              
	                  JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);                                                                                                                                          
	                  //  JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);                                                                                                                                      
	                      return;                                                                                                                                                                                                                                  
	                }                                                                                                                                                                                                                                              
	                row[0] = TITLE.getText();                                                                                                                                                                                                                      
	                row[1] = CATEGORY.getText();                                                                                                                                                                                                                   
	                row[2] = DATE.getText();                                                                                                                                                                                                                       
	                row[3] = SENDER.getText();                                                                                                                                                                                                                     
	                row[4] = DESCRIPTION.getText();                                                                                                                                                                                                                
	                                                                                                                                                                                                                                                               
	                // add row to the model                                                                                                                                                                                                                        
	                model.addRow(row);                                                                                                                                                                                                                             
	                TITLE.setText(null);                                                                                                                                                                                                                           
	                CATEGORY.setText(null);                                                                                                                                                                                                                        
	                DATE.setText(null);                                                                                                                                                                                                                            
	                SENDER.setText(null);                                                                                                                                                                                                                          
	                DESCRIPTION.setText(null);                                                                                                                                                                                                                     
	                                                                                                                                                                                                                                                               
	            }                                                                                                                                                                                                                                                  
	        });                                                                                                                                                                                                                                                    
	                                                                                                                                                                                                                                                               
	        // button remove row                                                                                                                                                                                                                                   
	        btnDelete.addActionListener(new ActionListener(){                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                               
	            @Override                                                                                                                                                                                                                                          
	            public void actionPerformed(ActionEvent e) {                                                                                                                                                                                                       
	                                                                                                                                                                                                                                                               
	                // i = the index of the selected row                                                                                                                                                                                                           
	                int i = table.getSelectedRow();                                                                                                                                                                                                                
	                if(i >= 0){                                                                                                                                                                                                                                    
	                    // remove a row from jtable                                                                                                                                                                                                                
	                  int selection=  JOptionPane.showConfirmDialog(null,"Do you want to delete this record","Confirm",JOptionPane.YES_NO_OPTION);                                                                                                                 
	                if(selection==JOptionPane.YES_OPTION) {                                                                                                                                                                                                        
	                    model.removeRow(i);                                                                                                                                                                                                                        
	                }                                                                                                                                                                                                                                              
	                }                                                                                                                                                                                                                                              
	                else{                                                                                                                                                                                                                                          
	                    JOptionPane.showMessageDialog(null,"Please select the record to be deleted","Error",JOptionPane.ERROR_MESSAGE);                                                                                                                            
	                    //System.out.println("Delete Error");                                                                                                                                                                                                      
	                }                                                                                                                                                                                                                                              
	            }                                                                                                                                                                                                                                                  
	        });                                                                                                                                                                                                                                                    
	                                                                                                                                                                                                                                                               
	        // get selected row data From table to textfields                                                                                                                                                                                                      
	        table.addMouseListener(new MouseAdapter(){                                                                                                                                                                                                             
	                                                                                                                                                                                                                                                               
	            @Override                                                                                                                                                                                                                                          
	            public void mouseClicked(MouseEvent e){                                                                                                                                                                                                            
	                                                                                                                                                                                                                                                               
	                // i = the index of the selected row                                                                                                                                                                                                           
	                int i = table.getSelectedRow();                                                                                                                                                                                                                
	                                                                                                                                                                                                                                                               
	                TITLE.setText(model.getValueAt(i, 0).toString());                                                                                                                                                                                              
	                CATEGORY.setText(model.getValueAt(i, 1).toString());                                                                                                                                                                                           
	                DATE.setText(model.getValueAt(i, 2).toString());                                                                                                                                                                                               
	                SENDER.setText(model.getValueAt(i, 3).toString());                                                                                                                                                                                             
	                DESCRIPTION.setText(model.getValueAt(i, 4).toString());                                                                                                                                                                                        
	            }                                                                                                                                                                                                                                                  
	        });                                                                                                                                                                                                                                                    
	                                                                                                                                                                                                                                                               
	        // button update row                                                                                                                                                                                                                                   
	        btnUpdate.addActionListener(new ActionListener(){                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                               
	            @Override                                                                                                                                                                                                                                          
	            public void actionPerformed(ActionEvent e) {   
	            	String title =TITLE.getText();
	            	String category = CATEGORY.getText();
	            	String date  = DATE.getText();
	            	String sender = SENDER.getText();
	            	String description = DESCRIPTION.getText();
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housesystem","root","PrasadSQL2022");
	    				Statement stmt = con.createStatement();
	    				System.out.println("Inserting Records");
	    				String sql = "insert into notice values('"+title+"','"+category+"','"+date+"','"+sender+"','"+description+"')";
	    				stmt.executeUpdate(sql);
	    				
	    			}catch(Exception p){
	    	System.out.println(p);}
	    	
	                                                                                                                                                                                                                                                               
	                // i = the index of the selected row                                                                                                                                                                                                           
	                int i = table.getSelectedRow();                                                                                                                                                                                                                
	                                                                                                                                                                                                                                                               
	                if(i >= 0)                                                                                                                                                                                                                                     
	                {                                                                                                                                                                                                                                              
	                    model.setValueAt(TITLE.getText(), i, 0);                                                                                                                                                                                                   
	                    model.setValueAt(CATEGORY.getText(), i, 1);                                                                                                                                                                                                
	                    model.setValueAt(DATE.getText(), i, 2);                                                                                                                                                                                                    
	                    model.setValueAt(SENDER.getText(), i, 3);                                                                                                                                                                                                  
	                    model.setValueAt(DESCRIPTION.getText(), i, 4);                                                                                                                                                                                             
	                }                                                                                                                                                                                                                                              
	                else{                                                                                                                                                                                                                                          
	                    System.out.println("Update Error");                                                                                                                                                                                                        
	                }                                                                                                                                                                                                                                              
	            }                                                                                                                                                                                                                                                  
	        });                                                                                                                                                                                                                                                    
	                                                                                                                                                                                                                                                               
	        frame.setSize(900,600);                                                                                                                                                                                                                                
	        frame.setLocationRelativeTo(null);                                                                                                                                                                                                                     
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                                                                                                                                                  
	        frame.setVisible(true);                                                                                                                                                                                                                                
	    }                                                                                                                                                                                                                                                          
}	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                                                          
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                                               

