package deskInventorySystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EmployeeAttendanceDetails extends JFrame {

	private JPanel contentPane;
	String attendance; 
	private JTextField t1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAttendanceDetails frame = new EmployeeAttendanceDetails();
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
	public EmployeeAttendanceDetails() 
	{
		super("Attendance Details");
		new DbCon();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 135, 850, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 0, 834, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAttendanceDetails = new JLabel("Attendance Details");
		lblAttendanceDetails.setForeground(Color.WHITE);
		lblAttendanceDetails.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 26));
		lblAttendanceDetails.setBounds(330, 11, 244, 46);
		panel_1.add(lblAttendanceDetails);
		
		JLabel lblSerialNo = new JLabel("Serial No.:-");
		lblSerialNo.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSerialNo.setBounds(80, 79, 72, 23);
		contentPane.add(lblSerialNo);
		
		JLabel lblEmployeeId = new JLabel("Select Employee ID:-");
		lblEmployeeId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblEmployeeId.setBounds(254, 110, 133, 23);
		contentPane.add(lblEmployeeId);
		
		JLabel lblTodaysDate = new JLabel("Today's Date:-");
		lblTodaysDate.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblTodaysDate.setBounds(290, 206, 97, 23);
		contentPane.add(lblTodaysDate);
		
		JLabel lblSelectEmployeeName = new JLabel("Select Employee Name:-");
		lblSelectEmployeeName.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblSelectEmployeeName.setBounds(228, 158, 159, 23);
		contentPane.add(lblSelectEmployeeName);
		
		JComboBox<String> cb1 = new JComboBox<String>();
		cb1.setModel(new DefaultComboBoxModel<String>(new String[] {"Select"}));
		cb1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		cb1.setBounds(397, 113, 115, 20);
		contentPane.add(cb1);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
			PreparedStatement ps = con.prepareStatement("select emp_ID from employee_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cb1.addItem(rs.getString(1));
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null,ee);
		}
		
		JComboBox<String> cb2 = new JComboBox<String>();
		cb2.setModel(new DefaultComboBoxModel<String>(new String[] {"Select"}));
		cb2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		cb2.setBounds(397, 161, 115, 20);
		contentPane.add(cb2);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
			PreparedStatement ps = con.prepareStatement("select First_name from employee_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cb2.addItem(rs.getString(1));
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null,ee);
		}
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(397, 206, 115, 20);
		contentPane.add(dateChooser);
		
		JLabel lblMarkAttendance = new JLabel("Mark Attendance");
		lblMarkAttendance.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblMarkAttendance.setBounds(272, 252, 115, 23);
		contentPane.add(lblMarkAttendance);
		
		JRadioButton rdbtnPresent = new JRadioButton("Present");
		rdbtnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attendance = "Present";
			}
		});
		rdbtnPresent.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnPresent.setBounds(397, 254, 79, 23);
		contentPane.add(rdbtnPresent);
		
		JRadioButton rdbtnAbsent = new JRadioButton("Absent");
		rdbtnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attendance = "Absent";
			}
		});
		rdbtnAbsent.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnAbsent.setBounds(511, 254, 79, 23);
		contentPane.add(rdbtnAbsent);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPresent);
		bg.add(rdbtnAbsent);
		
		t1 = new JTextField();
		t1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		t1.setBounds(156, 82, 72, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
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
						PreparedStatement ps = con.prepareStatement("insert into attendance_details values(?,?,?,?,?)");
						
						int sno = Integer.parseInt(t1.getText());
						ps.setInt(1, sno);
						
						String emp_id = cb1.getSelectedItem().toString();
						ps.setString(2, emp_id);
						
						String emp_name = cb2.getSelectedItem().toString();
						ps.setString(3, emp_name);
						
						ps.setString(4, dateChooser.getDate().toString());						
						ps.setString(5, attendance);
						
						ps.executeUpdate();
						con.close();
						
						JOptionPane.showMessageDialog(contentPane,"Attendance Successfully Saved");
				
					}catch(Exception exc)
					{
						exc.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, exc);
					}
					
					t1.setText(null);
				
					
					// after save it will show in table immediate
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
						PreparedStatement ps = con.prepareStatement("select * from attendance_details");
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}catch(Exception eee)
					{
						eee.printStackTrace();
						JOptionPane.showMessageDialog(null, eee);
					}
					
				}
			}
		});
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSave.setBounds(596, 254, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblClickFetchTo = new JLabel("Click Fetch to Fetch Details:-");
		lblClickFetchTo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblClickFetchTo.setBounds(537, 319, 163, 23);
		contentPane.add(lblClickFetchTo);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select * from attendance_details");
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception eee)
				{
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		btnFetch.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnFetch.setBounds(700, 319, 89, 23);
		contentPane.add(btnFetch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 376, 834, 125);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDatabaseDetails = new JLabel("Database Details");
		lblDatabaseDetails.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDatabaseDetails.setBounds(10, 348, 106, 23);
		contentPane.add(lblDatabaseDetails);
	}
}
		