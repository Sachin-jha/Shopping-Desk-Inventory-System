package deskInventorySystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeSalaryDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JTextField t10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSalaryDetails frame = new EmployeeSalaryDetails();
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
	public EmployeeSalaryDetails() 
	{
		super("Salary Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120, 135, 1200, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1184, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSalaryDetails = new JLabel("Salary Details");
		lblSalaryDetails.setForeground(Color.WHITE);
		lblSalaryDetails.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 26));
		lblSalaryDetails.setBounds(529, 11, 167, 38);
		panel.add(lblSalaryDetails);
		
		JLabel lblSalarySlipNo = new JLabel("Salary Slip No:-");
		lblSalarySlipNo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSalarySlipNo.setBounds(83, 84, 87, 23);
		contentPane.add(lblSalarySlipNo);
		
		JLabel lblEmpId = new JLabel("Employee ID:-");
		lblEmpId.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmpId.setBounds(253, 84, 87, 23);
		contentPane.add(lblEmpId);
		
		JLabel lblMonth = new JLabel("Month:-");
		lblMonth.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblMonth.setBounds(170, 130, 54, 23);
		contentPane.add(lblMonth);
		
		JLabel lblAttendingDays = new JLabel("Attending Days:-");
		lblAttendingDays.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblAttendingDays.setBounds(122, 164, 102, 23);
		contentPane.add(lblAttendingDays);
		
		JLabel lblAbsentDays = new JLabel("Absent Days:-");
		lblAbsentDays.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblAbsentDays.setBounds(137, 198, 87, 23);
		contentPane.add(lblAbsentDays);
		
		JLabel lblPerDaySalary = new JLabel("Per Day Salary:-");
		lblPerDaySalary.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblPerDaySalary.setBounds(132, 232, 92, 23);
		contentPane.add(lblPerDaySalary);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_1.setBounds(170, 266, 229, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPaymentMode = new JLabel("Payment Mode");
		lblPaymentMode.setBounds(10, 0, 89, 16);
		panel_1.add(lblPaymentMode);
		lblPaymentMode.setFont(new Font("Century Gothic", Font.BOLD, 12));
				
		JRadioButton rdbtnCheque = new JRadioButton("Cheque");
		rdbtnCheque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String chque = JOptionPane.showInputDialog("Enter Cheque Number");
				textField.setText(chque);
			}
		});
		rdbtnCheque.setBounds(128, 23, 71, 23);
		panel_1.add(rdbtnCheque);
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(null);
			}
		});
		rdbtnCash.setBounds(63, 23, 63, 23);
		panel_1.add(rdbtnCash);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCheque);
		bg.add(rdbtnCash);
		
		JLabel lblEmployeeName = new JLabel("Employee name:-");
		lblEmployeeName.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmployeeName.setBounds(457, 84, 111, 23);
		contentPane.add(lblEmployeeName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBounds(402, 266, 195, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCheckNumber = new JLabel("Cheque Number");
		lblCheckNumber.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblCheckNumber.setBounds(0, 0, 104, 16);
		panel_2.add(lblCheckNumber);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(41, 16, 144, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary:-");
		lblBasicSalary.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBasicSalary.setBounds(769, 89, 78, 23);
		contentPane.add(lblBasicSalary);
		
		JLabel lblSalaryDeduct = new JLabel("Salary Deduct:-");
		lblSalaryDeduct.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSalaryDeduct.setBounds(769, 117, 92, 23);
		contentPane.add(lblSalaryDeduct);
		
		JLabel lblTotalSalary = new JLabel("Total Salary:-");
		lblTotalSalary.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTotalSalary.setBounds(769, 151, 78, 23);
		contentPane.add(lblTotalSalary);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_3.setBounds(769, 185, 303, 99);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAllowe = new JLabel("Allowances");
		lblAllowe.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblAllowe.setBounds(0, 0, 78, 23);
		panel_3.add(lblAllowe);
		
		JLabel lblTravelAllowances = new JLabel("TA");
		lblTravelAllowances.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTravelAllowances.setBounds(90, 23, 27, 23);
		panel_3.add(lblTravelAllowances);
		
		JLabel lblDa = new JLabel("DA");
		lblDa.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDa.setBounds(90, 45, 27, 23);
		panel_3.add(lblDa);
		
		JLabel lblHra = new JLabel("HRA");
		lblHra.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblHra.setBounds(90, 68, 27, 23);
		panel_3.add(lblHra);
		
		t7 = new JTextField();
		t7.setBounds(136, 25, 86, 20);
		panel_3.add(t7);
		t7.setColumns(10);
		
		t8 = new JTextField();
		t8.setBounds(136, 47, 86, 20);
		panel_3.add(t8);
		t8.setColumns(10);
		
		t9 = new JTextField();
		t9.setBounds(136, 70, 86, 20);
		panel_3.add(t9);
		t9.setColumns(10);
		
		JLabel lblGrossSalary = new JLabel("GROSS SALARY:-");
		lblGrossSalary.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblGrossSalary.setBounds(855, 295, 102, 23);
		contentPane.add(lblGrossSalary);
		
		t1 = new JTextField();
		t1.setBounds(172, 87, 63, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
					PreparedStatement ps = con.prepareStatement("select count(*) from attendance_details where Emp_Name = 'Sachin' and Present_or_Absent='Present'");
					ResultSet rs = ps.executeQuery();
										
					while(rs.next())
					{
						t2.setText(rs.getString(1));
					}
								
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null,ee);
				}
			}
		});
		t2.setBounds(219, 166, 86, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(219, 200, 86, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(219, 133, 98, 20);
		contentPane.add(monthChooser);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select"}));
		comboBox.setBounds(339, 86, 102, 20);
		contentPane.add(comboBox);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
			PreparedStatement ps = con.prepareStatement("select emp_ID from employee_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString(1));
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null,ee);
		}
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Select"}));
		comboBox_1.setBounds(566, 86, 92, 20);
		contentPane.add(comboBox_1);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary", "root", "root");
			PreparedStatement ps = con.prepareStatement("select First_name from employee_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				comboBox_1.addItem(rs.getString(1));
			}
						
		}catch(Exception ee)
		{
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null,ee);
		}
		
		t4 = new JTextField();
		t4.setBounds(871, 86, 86, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(871, 119, 86, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(873, 153, 86, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		t10 = new JTextField();
		t10.setBounds(957, 293, 102, 20);
		contentPane.add(t10);
		t10.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSave.setBounds(1085, 295, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnFetch.setBounds(1085, 329, 89, 23);
		contentPane.add(btnFetch);
		
		JLabel lblClickFetchTo = new JLabel("Click Fetch to get details");
		lblClickFetchTo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblClickFetchTo.setBounds(927, 329, 154, 23);
		contentPane.add(lblClickFetchTo);
		
		
	}
}
