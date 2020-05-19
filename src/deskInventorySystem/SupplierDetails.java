package deskInventorySystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SupplierDetails extends JFrame {

	protected static final Object ID = null;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSadas;
	private JLabel lblSupplierId;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierDetails frame = new SupplierDetails();
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
	public SupplierDetails() {
		super("Supplier Details");
		new DbCon();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120, 135, 1200, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1184, 62);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSadas = new JLabel("Supplier Details");
		lblSadas.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 26));
		lblSadas.setForeground(Color.WHITE);
		lblSadas.setBounds(513, 0, 191, 62);
		panel.add(lblSadas);
		
		lblSupplierId = new JLabel("Supplier ID:-");
		lblSupplierId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSupplierId.setBounds(192, 96, 86, 17);
		contentPane.add(lblSupplierId);
		
		t1 = new JTextField();
		t1.setBounds(275, 93, 120, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblSupplerName = new JLabel("Supplier Name:-");
		lblSupplerName.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSupplerName.setBounds(153, 145, 112, 17);
		contentPane.add(lblSupplerName);
		
		t2 = new JTextField();
		t2.setBounds(275, 142, 120, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:-");
		lblMobileNumber.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblMobileNumber.setBounds(153, 198, 112, 17);
		contentPane.add(lblMobileNumber);
		
		t3 = new JTextField();
		t3.setBounds(275, 195, 120, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblAddressDetails = new JLabel("Address Details");
		lblAddressDetails.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblAddressDetails.setBounds(511, 73, 120, 37);
		contentPane.add(lblAddressDetails);
		
		JLabel lblHouseNo = new JLabel("House No.:-");
		lblHouseNo.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblHouseNo.setBounds(550, 112, 81, 28);
		contentPane.add(lblHouseNo);
		
		t4 = new JTextField();
		t4.setBounds(641, 118, 86, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JLabel lblStreaat = new JLabel("Street/Lane:-");
		lblStreaat.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblStreaat.setBounds(550, 157, 93, 17);
		contentPane.add(lblStreaat);
		
		t5 = new JTextField();
		t5.setBounds(641, 154, 127, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		JLabel lblCity = new JLabel("City:-");
		lblCity.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblCity.setBounds(596, 198, 35, 14);
		contentPane.add(lblCity);
		
		t6 = new JTextField();
		t6.setBounds(641, 195, 127, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblState = new JLabel("State:-");
		lblState.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblState.setBounds(590, 235, 41, 20);
		contentPane.add(lblState);
		
		JLabel lblPinCode = new JLabel("Pin Code:-");
		lblPinCode.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblPinCode.setBounds(560, 280, 71, 17);
		contentPane.add(lblPinCode);
		
		t7 = new JTextField();
		t7.setBounds(641, 280, 86, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "Delhi NCR", "UP", "Punjab", "Chhatisgarh", "Jaipur", "Utrakhand"}));
		comboBox.setBounds(641, 238, 112, 20);
		contentPane.add(comboBox);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(134, 73, 651, 244);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBounds(357, 11, 284, 222);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(contentPane, "ARE YOU SURE, Do you want to SAVE?");
				if(op==JOptionPane.YES_OPTION)
				{					
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
						PreparedStatement ps = con.prepareStatement("insert into supplier_details values(?,?,?,?,?,?,?,?)");
						
						ps.setString(1, t1.getText());
						ps.setString(2, t2.getText());
						
						int mob = Integer.parseInt(t3.getText());
						ps.setInt(3, mob);
						
						ps.setString(4, t4.getText());
						ps.setString(5, t5.getText());
						ps.setString(6, t6.getText());
						
						String sss = comboBox.getSelectedItem().toString();
						ps.setString(7, sss);
						
						int pin = Integer.parseInt(t7.getText());
						ps.setInt(8, pin);
						
						ps.executeUpdate();
						
						con.close();
						ps.close();
					
						JOptionPane.showMessageDialog(contentPane, "Record Saved in Database");
					}catch(Exception ex)
					{
						ex.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, ex);
					}
					
					
					
				}
				
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				t7.setText(null);
				
				//after save it will show in table immediate
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from supplier_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
				
			}
		});
		btnSave.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		btnSave.setBounds(795, 279, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from supplier_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		btnFetch.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		btnFetch.setBounds(1045, 236, 89, 23);
		contentPane.add(btnFetch);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog(contentPane,"Enter Supplier ID or Supplier Mobile Number to Delete");
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement(" delete from supplier_details where supplier_ID = '"+inp+"' OR mob_number = '"+inp+"' ");
				
					ps.executeUpdate();
				
					con.close();	
					
				}catch(Exception ar)
				{
					ar.printStackTrace();
					JOptionPane.showMessageDialog(contentPane,ar);
				}
				JOptionPane.showMessageDialog(contentPane,"Records Succefully Deleted");
				

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from supplier_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
			}
			
		});
		comboBox_1.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "ID", "Mob No."}));
		comboBox_1.setBounds(1045, 280, 89, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblClickFetchTo = new JLabel("Click Fetch to get Details");
		lblClickFetchTo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblClickFetchTo.setBounds(893, 235, 154, 23);
		contentPane.add(lblClickFetchTo);
		
		JLabel lblDeleteDataBy = new JLabel("Delete Data by");
		lblDeleteDataBy.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDeleteDataBy.setBounds(954, 280, 93, 20);
		contentPane.add(lblDeleteDataBy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 360, 1184, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDatabaseDetails = new JLabel("Database Details");
		lblDatabaseDetails.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDatabaseDetails.setBounds(10, 342, 112, 14);
		contentPane.add(lblDatabaseDetails);
	}
}
