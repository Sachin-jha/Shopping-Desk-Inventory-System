package deskInventorySystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class EmployeeDetails extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTable table;
	private String gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDetails frame = new EmployeeDetails();
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
	public EmployeeDetails() {
		super("Employee Details");
		new DbCon();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120, 135, 1200, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EmpDetails = new JLabel("Employee Details");
		EmpDetails.setBounds(538, 0, 241, 45);
		EmpDetails.setForeground(Color.WHITE);
		EmpDetails.setBackground(Color.DARK_GRAY);
		EmpDetails.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(EmpDetails);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:-");
		lblEmployeeId.setBounds(193, 49, 100, 24);
		lblEmployeeId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(lblEmployeeId);
		
		JLabel lblFirstName = new JLabel("First Name:-");
		lblFirstName.setBounds(193, 95, 74, 24);
		lblFirstName.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name:-");
		lblMiddleName.setBounds(372, 95, 94, 24);
		lblMiddleName.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name:-");
		lblLastName.setBounds(583, 95, 74, 24);
		lblLastName.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(lblLastName);
		
		JLabel lblGender = new JLabel("Gender:-");
		lblGender.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblGender.setBounds(194, 146, 73, 24);
		contentPane.add(lblGender);
		
		JRadioButton g1 = new JRadioButton("Male");
		g1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Male";
			}
		});
		g1.setFont(new Font("Century Gothic", Font.BOLD, 11));
		g1.setBounds(262, 147, 67, 23);
		contentPane.add(g1);	
				
		JRadioButton g2 = new JRadioButton("Female");
		g2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Female";
			}
		});
		g2.setFont(new Font("Century Gothic", Font.BOLD, 11));
		g2.setBounds(331, 147, 74, 23);
		contentPane.add(g2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(g1);
		bg.add(g2);
				
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:-");
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDateOfBirth.setBounds(431, 146, 83, 24);
		contentPane.add(lblDateOfBirth);
		
		JDateChooser d1 = new JDateChooser();
		d1.setBounds(513, 146, 109, 20);
		contentPane.add(d1);
		
		JLabel lblEmployeeAddress = new JLabel("Full Address:-");
		lblEmployeeAddress.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmployeeAddress.setBounds(193, 202, 83, 24);
		contentPane.add(lblEmployeeAddress);
		
		JTextArea ta = new JTextArea();
		ta.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		ta.setBounds(272, 204, 202, 45);
		contentPane.add(ta);
		
		JLabel lblDateOfJoining = new JLabel("Date Of Joining:-");
		lblDateOfJoining.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDateOfJoining.setBounds(651, 146, 100, 24);
		contentPane.add(lblDateOfJoining);
		
		JDateChooser d2 = new JDateChooser();
		d2.setBounds(761, 150, 108, 20);
		contentPane.add(d2);
		
		JLabel lblContactNo = new JLabel("Contact No.:-");
		lblContactNo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblContactNo.setBounds(484, 208, 83, 24);
		contentPane.add(lblContactNo);
		
		JLabel lblEmailAddress = new JLabel("Email Address:-");
		lblEmailAddress.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmailAddress.setBounds(696, 208, 94, 24);
		contentPane.add(lblEmailAddress);
		
		JLabel lblPerMonthBasic = new JLabel("Per Month Basic Salary:-");
		lblPerMonthBasic.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblPerMonthBasic.setBounds(484, 269, 147, 24);
		contentPane.add(lblPerMonthBasic);
		
		t1 = new JTextField();
		t1.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t1.setBounds(291, 53, 100, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t2.setColumns(10);
		t2.setBounds(262, 98, 100, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t3.setColumns(10);
		t3.setBounds(461, 98, 100, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t4.setColumns(10);
		t4.setBounds(651, 98, 100, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t5.setColumns(10);
		t5.setBounds(561, 211, 125, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t6.setColumns(10);
		t6.setBounds(786, 211, 180, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		t7.setColumns(10);
		t7.setBounds(626, 271, 74, 20);
		contentPane.add(t7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 352, 1184, 149);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDatabaseRecords = new JLabel("Database Records");
		lblDatabaseRecords.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDatabaseRecords.setBounds(10, 328, 109, 24);
		contentPane.add(lblDatabaseRecords);
		
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
						PreparedStatement ps = con.prepareStatement("insert into employee_details values(?,?,?,?,?,?,?,?,?,?,?)");
						
						ps.setString(1, t1.getText());
						ps.setString(2, t2.getText());
						ps.setString(3, t3.getText());
						ps.setString(4, t4.getText());
						ps.setString(5, gender);
						
						String dob = d1.getDate().toString();
						ps.setString(6, dob);
						
						String doj = d2.getDate().toString();
						ps.setString(7, doj);
						
						ps.setString(8, ta.getText());
						ps.setString(9, t5.getText());
						ps.setString(10, t6.getText());
						
						Double sal = Double.parseDouble(t7.getText());
						ps.setDouble(11, sal);
						
						ps.executeUpdate();
						con.close();
						
						JOptionPane.showMessageDialog(contentPane,"Records Successfully Saved");
					}catch(Exception exc)
					{
						exc.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, exc);
					}
				}
				
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				ta.setText(null);
				t7.setText(null);
				
				//after save it will show in table immediate
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from employee_details");
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
		btnSave.setBounds(742, 271, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblClickFetchTo = new JLabel("Click Fetch to Fetch Data:-");
		lblClickFetchTo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblClickFetchTo.setBounds(880, 269, 161, 24);
		contentPane.add(lblClickFetchTo);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from employee_details");
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
		btnFetch.setBounds(1036, 271, 89, 23);
		contentPane.add(btnFetch);
		
		JLabel lblDeleteDataBy = new JLabel("Delete Data By");
		lblDeleteDataBy.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDeleteDataBy.setBounds(937, 304, 94, 24);
		contentPane.add(lblDeleteDataBy);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inp = JOptionPane.showInputDialog(contentPane,"Enter Employee ID or Email to Delete");
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement(" delete from employee_details where emp_ID = '"+inp+"' OR Email = '"+inp+"' ");
				
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
					PreparedStatement ps = con.prepareStatement("select * from employee_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
			}
			
		});
		comboBox.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "Employee ID", "Email"}));
		comboBox.setBounds(1036, 305, 89, 20);
		contentPane.add(comboBox);
				
	}
}
