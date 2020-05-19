package deskInventorySystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

public class PurchaseDetails extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPanel panel;
	private JLabel lblItem;
	private JLabel lblDiscription;
	private JLabel lblQuantity;
	private JLabel lblRate;
	private JLabel lblAmount;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JLabel lblRs;
	private JLabel lblSgst;
	private JLabel lblCgst;
	private JTextField t7;
	private JTextField t8;
	private JTextField t10;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField tfDate;
	private JLabel lblSaleDate;
	private JComboBox<Object> comboBox;
	private JLabel lblDatabaseRecords;
	private JLabel lblSupplierName;
	private JComboBox<String> comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseDetails frame = new PurchaseDetails();
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
	public PurchaseDetails() {
		super("Purchase Details");
		new DbCon();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120, 135, 1200, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalesDetails = new JLabel("Purchase Details");
		lblSalesDetails.setBounds(552, 0, 194, 62);
		lblSalesDetails.setForeground(Color.WHITE);
		lblSalesDetails.setBackground(Color.DARK_GRAY);
		lblSalesDetails.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(lblSalesDetails);
		
		JLabel lblSal = new JLabel("Purchase ID:-");
		lblSal.setBounds(10, 73, 89, 19);
		lblSal.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblSal);
		
		t1 = new JTextField();
		t1.setBounds(97, 73, 82, 20);
		t1.setFont(new Font("Century Gothic", Font.BOLD, 11));
		contentPane.add(t1);
		t1.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1184, 62);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		
		lblItem = new JLabel(" Item Code");
		lblItem.setBounds(81, 148, 78, 20);
		lblItem.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblItem);
		
		lblDiscription = new JLabel("Item Name");
		lblDiscription.setBounds(234, 148, 78, 20);
		lblDiscription.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblDiscription);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(381, 148, 67, 20);
		lblQuantity.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblQuantity);
		
		lblRate = new JLabel("Rate");
		lblRate.setBounds(521, 148, 49, 20);
		lblRate.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblRate);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setBounds(647, 148, 78, 20);
		lblAmount.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblAmount);
		
		t2 = new JTextField();
		t2.setBounds(81, 192, 86, 20);
		t2.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t2.setToolTipText("Write Item Code");
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(234, 192, 86, 20);
		t3.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t3.setToolTipText("Write Name");
		t3.setColumns(10);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(370, 192, 86, 20);
		t4.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t4.setToolTipText("per kg or piece");
		t4.setColumns(10);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(501, 192, 86, 20);
		t5.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t5.setToolTipText("per kg or piece");
		t5.setColumns(10);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setBounds(639, 192, 86, 20);
		t6.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float tf4 = Float.parseFloat(t4.getText());
				float tf5 = Float.parseFloat(t5.getText());
				
				float tf6 = tf4*tf5;				
				t6.setText(String.valueOf(tf6));
			}
		});		
		t6.setToolTipText("Click to get Amt.");
		t6.setColumns(10);
		contentPane.add(t6);
		
		lblRs = new JLabel("Rs.");
		lblRs.setBounds(616, 195, 23, 14);
		lblRs.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRs);
		
		lblSgst = new JLabel("SGST:-");
		lblSgst.setBounds(593, 224, 46, 14);
		lblSgst.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblSgst);
		
		lblCgst = new JLabel("CGST:-");
		lblCgst.setBounds(593, 249, 46, 14);
		lblCgst.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblCgst.setToolTipText("");
		contentPane.add(lblCgst);
		
		t7 = new JTextField();
		t7.setBounds(639, 223, 86, 20);
		t7.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				float tf6 = Float.parseFloat(t6.getText());
				float tf7 = (tf6/100)*8;
				t7.setText(String.valueOf(tf7));
			}
		});
		t7.setToolTipText("Click to get 8% of Amt");
		contentPane.add(t7);
		t7.setColumns(10);
		
		t8 = new JTextField();
		t8.setBounds(639, 249, 86, 20);
		t8.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				float tf6 = Float.parseFloat(t6.getText());
				float tf8 = (tf6/100)*8;
				t8.setText(String.valueOf(tf8));
			}
		});
		t8.setToolTipText("Click to get  8% of Amt");
		t8.setColumns(10);
		contentPane.add(t8);
		
		t10 = new JTextField();
		t10.setBounds(640, 280, 86, 20);
		t10.setFont(new Font("Century Gothic", Font.BOLD, 11));
		t10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				float tf6 = Float.parseFloat(t6.getText());
				float tf7 = Float.parseFloat(t7.getText());
				float tf8 = Float.parseFloat(t8.getText());
				float tf10 = tf6+tf7+tf8;
				t10.setText(String.valueOf(tf10));
			}
		});
		t10.setToolTipText("Click to get Total Amt");
		contentPane.add(t10);
		t10.setColumns(10);
		
		JLabel lblDeleteDataby = new JLabel("Delete Data by");
		lblDeleteDataby.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDeleteDataby.setBounds(917, 287, 86, 24);
		contentPane.add(lblDeleteDataby);						
		
		lblDatabaseRecords = new JLabel("Database Records");
		lblDatabaseRecords.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDatabaseRecords.setBounds(10, 333, 117, 14);
		contentPane.add(lblDatabaseRecords);
		
		JLabel lblSupplierId = new JLabel("Supplier ID:-");
		lblSupplierId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSupplierId.setBounds(399, 71, 89, 23);
		contentPane.add(lblSupplierId);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();		
		comboBox_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Select ID"}));
		comboBox_1.setBounds(485, 73, 102, 20);
		contentPane.add(comboBox_1);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
			PreparedStatement ps = con.prepareStatement("select supplier_id from supplier_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String supplier_id = rs.getString(1);				
				comboBox_1.addItem(supplier_id);
			}
			
		}catch(Exception exec)
		{
			exec.printStackTrace();
			JOptionPane.showMessageDialog(null, exec);
		}
		
		lblSupplierName = new JLabel("Supplier Name:-");
		lblSupplierName.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSupplierName.setBounds(593, 73, 111, 23);
		contentPane.add(lblSupplierName);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Name"}));
		comboBox_2.setFont(new Font("Century Gothic", Font.BOLD, 12));
		comboBox_2.setBounds(703, 73, 102, 20);
		contentPane.add(comboBox_2);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
			PreparedStatement ps = con.prepareStatement("select supplier_name from supplier_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String supplier_name = rs.getString(1);				
				comboBox_2.addItem(supplier_name);
			}
			
		}catch(Exception exec)
		{
			exec.printStackTrace();
			JOptionPane.showMessageDialog(null, exec);
		}
			
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("Choose Date");
		dateChooser.setBounds(291, 72, 91, 20);
		contentPane.add(dateChooser);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(736, 280, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int op = JOptionPane.showConfirmDialog(contentPane, "ARE YOU SURE, Do you want to SAVE?");
				if(op==JOptionPane.YES_OPTION)
				{					
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
						PreparedStatement ps = con.prepareStatement("insert into purchase_details values(?,?,?,?,?,?,?,?,?,?,?,?)");
						
						int purc_code = Integer.parseInt(t1.getText());
						ps.setInt(1,purc_code);
						
						String date = dateChooser.getDate().toString();
						ps.setString(2,date);
						
						String id = comboBox_1.getSelectedItem().toString();
						ps.setString(3, id);
						
						String name = comboBox_2.getSelectedItem().toString();
						ps.setString(4, name);
						
						ps.setString(5,t2.getText());
						
						ps.setString(6,t3.getText());
						
						float quant = Float.parseFloat(t4.getText());
						ps.setFloat(7,quant);
						
						float rate = Float.parseFloat(t5.getText());
						ps.setFloat(8,rate);
						
						float amt = Float.parseFloat(t6.getText());
						ps.setFloat(9,amt);
						
						float sgst = Float.parseFloat(t7.getText());
						ps.setFloat(10,sgst);
						
						float cgst = Float.parseFloat(t8.getText());
						ps.setFloat(11,cgst);
												
						float total_amt = Float.parseFloat(t10.getText());
						ps.setFloat(12,total_amt);
						
						ps.executeUpdate();
						
						con.close();
			
						JOptionPane.showMessageDialog(contentPane,"Records Successfully Saved");	
					}catch(Exception ee)
					{
						ee.printStackTrace();
						JOptionPane.showMessageDialog(null, ee);						
					}					
				}
				
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				t7.setText(null);
				t8.setText(null);
				t10.setText(null);
				tfDate.setText(null);
				
				// after save it will show in table immediate
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from purchase_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(btnSave);
		
		JLabel lblTotalAmt = new JLabel("Total Amt.");
		lblTotalAmt.setBounds(572, 282, 67, 14);
		lblTotalAmt.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblTotalAmt);
		
		JLabel lblFetchDetails = new JLabel("Click Fetch To Get Details:-");
		lblFetchDetails.setBounds(848, 245, 155, 24);
		lblFetchDetails.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(lblFetchDetails);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 351, 1184, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);		
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.setBounds(1013, 245, 89, 23);
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from purchase_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		btnFetch.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(btnFetch);
				
		lblSaleDate = new JLabel("Purchase Date:-");
		lblSaleDate.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSaleDate.setBounds(189, 73, 102, 19);
		contentPane.add(lblSaleDate);
				
		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Century Gothic", Font.BOLD, 12));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog(contentPane,"Enter Item Code or Item Name to Delete");
					
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
						PreparedStatement ps = con.prepareStatement(" delete from purchase_details where item_code = '"+inp+"' OR item_name = '"+inp+"' ");
					
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
						PreparedStatement ps = con.prepareStatement("select * from purchase_details");
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}catch(Exception eee)
					{
						eee.printStackTrace();
						JOptionPane.showMessageDialog(null, eee);
					}
				}
				
		});
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Select","Item Code", "Item Name"}));
		comboBox.setBounds(1013, 289, 102, 20);
		contentPane.add(comboBox);
		
		
	}
}