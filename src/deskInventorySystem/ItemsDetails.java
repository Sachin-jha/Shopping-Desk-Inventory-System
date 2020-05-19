package deskInventorySystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

public class ItemsDetails extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSadas;
	private JTextField t1;
	private JTextField t2;
	private JTextField t5;
	private JTextField t6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemsDetails frame = new ItemsDetails();
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
	public ItemsDetails() {
		super("Item Details");
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
		
		JLabel label = new JLabel("Items Details");
		label.setBounds(0, 0, 0, 0);
		lblSadas = label;
		lblSadas.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 26));
		lblSadas.setForeground(Color.WHITE);
		lblSadas.setBounds(513, 0, 191, 62);
		panel.setLayout(null);
		panel.add(lblSadas);
		
		JLabel lblItemCode = new JLabel("Item Code:-");
		lblItemCode.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblItemCode.setBounds(208, 135, 77, 26);
		contentPane.add(lblItemCode);
		
		JLabel lblItemName = new JLabel("Item Name:-");
		lblItemName.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblItemName.setBounds(208, 180, 77, 26);
		contentPane.add(lblItemName);
		
		JLabel lblNewLabel = new JLabel("Manufactured Date:-");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(163, 230, 120, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblExpiredDate = new JLabel("Expired Date:-");
		lblExpiredDate.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblExpiredDate.setBounds(179, 282, 86, 26);
		contentPane.add(lblExpiredDate);
		
		t1 = new JTextField();
		t1.setBounds(281, 139, 128, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(281, 184, 128, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblPurchaseRate = new JLabel("Purchase Rate:-");
		lblPurchaseRate.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblPurchaseRate.setBounds(496, 135, 97, 26);
		contentPane.add(lblPurchaseRate);
		
		JLabel lblSaleRate = new JLabel("Sale Rate:-");
		lblSaleRate.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSaleRate.setBounds(518, 180, 68, 26);
		contentPane.add(lblSaleRate);
		
		t5 = new JTextField();
		t5.setBounds(589, 139, 86, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(589, 184, 86, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblDiscriptionOfItem = new JLabel("Discription Of Item:-");
		lblDiscriptionOfItem.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblDiscriptionOfItem.setBounds(468, 230, 110, 26);
		contentPane.add(lblDiscriptionOfItem);
		
		JTextArea t7 = new JTextArea();
		t7.setBounds(589, 232, 191, 44);
		contentPane.add(t7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(288, 236, 110, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(288, 288, 110, 20);
		contentPane.add(dateChooser_1);
		
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
						PreparedStatement ps = con.prepareStatement("insert into items_details values(?,?,?,?,?,?,?)");
						
						ps.setString(1, t1.getText());
						ps.setString(2, t2.getText());
						
						String manu_date = dateChooser.getDate().toString();
						ps.setString(3, manu_date);
						
						String exp_date = dateChooser_1.getDate().toString();
						ps.setString(4, exp_date);						
						float tf5 = Float.parseFloat(t5.getText());
						ps.setFloat(5, tf5);						
						float tf6 = Float.parseFloat(t6.getText());
						ps.setFloat(6, tf6);						
						ps.setString(7, t7.getText());
						
						ps.executeUpdate();
						
						con.close();
						ps.close();
						
						JOptionPane.showMessageDialog(contentPane, "Record Saved In Database");
					}catch(Exception exc)
					{
						exc.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, exc);
					}
					
					t1.setText(null);
					t2.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					
					//after save it will show item immediate
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
						PreparedStatement ps = con.prepareStatement("select * from items_details");
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}catch(Exception ep)
					{
						ep.printStackTrace();
						JOptionPane.showMessageDialog(null, ep);
					}
				}
			}
		});
		btnSave.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		btnSave.setBounds(692, 284, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from items_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception ep)
				{
					ep.printStackTrace();
					JOptionPane.showMessageDialog(null, ep);
				}
			}
		});
		btnFetch.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		btnFetch.setBounds(971, 232, 89, 23);
		contentPane.add(btnFetch);
		
		JLabel lblClcikFetchTo = new JLabel("Clcik Fetch to Fetch Details");
		lblClcikFetchTo.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblClcikFetchTo.setBounds(822, 230, 149, 26);
		contentPane.add(lblClcikFetchTo);
		
		JLabel lblChooseOptionTo = new JLabel("Choose option To Delete Item");
		lblChooseOptionTo.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblChooseOptionTo.setBounds(812, 282, 165, 26);
		contentPane.add(lblChooseOptionTo);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inp = JOptionPane.showInputDialog(contentPane,"Enter Item Code or Item Name to Delete");
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement(" delete from items_details where item_code = '"+inp+"' OR item_name = '"+inp+"' ");
				
					ps.executeUpdate();
				
					con.close();	
					
					JOptionPane.showMessageDialog(contentPane,"Records Succefully Deleted");
				}catch(Exception ar)
				{
					ar.printStackTrace();
					JOptionPane.showMessageDialog(contentPane,ar);
				}
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from items_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception ep)
				{
					ep.printStackTrace();
					JOptionPane.showMessageDialog(null, ep);
				}
				
			}
		});
		comboBox.setFont(new Font("Century Schoolbook", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select ", "Item Code", "Item Name"}));
		comboBox.setBounds(971, 282, 97, 26);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 357, 1184, 144);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDatabaseDetails = new JLabel("Database Details");
		lblDatabaseDetails.setFont(new Font("Century Schoolbook", Font.BOLD, 11));
		lblDatabaseDetails.setBounds(10, 332, 110, 20);
		contentPane.add(lblDatabaseDetails);
		
		
	}
}
