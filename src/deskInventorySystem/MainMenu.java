package deskInventorySystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		super("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 75, 1200, 600);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Bradley Hand ITC", Font.BOLD, 40));
		lblWelcome.setBounds(534, 11, 197, 65);
		contentPane.add(lblWelcome);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Bradley Hand ITC", Font.BOLD, 35));
		lblTo.setBounds(596, 76, 46, 50);
		contentPane.add(lblTo);
		
		JLabel lblDeskInventorySystem = new JLabel("Desk Inventory System");
		lblDeskInventorySystem.setFont(new Font("Bradley Hand ITC", Font.BOLD, 40));
		lblDeskInventorySystem.setBounds(416, 122, 448, 76);
		contentPane.add(lblDeskInventorySystem);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSales = new JMenu("Sales");
		menuBar.add(mnSales);
		mnSales.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JMenuItem mntmSalesDetails = new JMenuItem("Sales Details");
		mntmSalesDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SalesDetails().setVisible(true);
			}
			
		});
		mntmSalesDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnSales.add(mntmSalesDetails);
		
		JMenuItem mntmReturnDetail = new JMenuItem("Return Detail");
		mntmReturnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalesReturnDetails().setVisible(true);
			}
		});
		mntmReturnDetail.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnSales.add(mntmReturnDetail);
		
		JMenu mnPurchase = new JMenu("Purchase");
		mnPurchase.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnPurchase);
		
		JMenuItem mntmPurchaseDetails = new JMenuItem("Purchase Details");
		mntmPurchaseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new PurchaseDetails().setVisible(true);
			}
		});
		mntmPurchaseDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnPurchase.add(mntmPurchaseDetails);
		
		JMenuItem mntmReturnDetails = new JMenuItem("Return Details");
		mntmReturnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PurchaseReturnDetails().setVisible(true);
			}
		});
		mntmReturnDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnPurchase.add(mntmReturnDetails);
		
		JMenu mnEmployee = new JMenu("Employee");
		mnEmployee.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnEmployee);
		
		JMenuItem mntmEmployeeDetails = new JMenuItem("Employee Details");
		mntmEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EmployeeDetails().setVisible(true);
			}
		});
		mntmEmployeeDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnEmployee.add(mntmEmployeeDetails);
		
		JMenuItem mntmAttendanceDetails = new JMenuItem("Attendance Details");
		mntmAttendanceDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeAttendanceDetails().setVisible(true);
			}
		});
		mntmAttendanceDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnEmployee.add(mntmAttendanceDetails);
		
		JMenuItem mntmSalaryDetails = new JMenuItem("Salary Details");
		mntmSalaryDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeSalaryDetails().setVisible(true);
			}
		});
		mntmSalaryDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnEmployee.add(mntmSalaryDetails);
		
		JMenu mnNewMenu = new JMenu("Supplier");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSupplierDetails = new JMenuItem("Supplier Details");
		mntmSupplierDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SupplierDetails().setVisible(true);
			}
		});
		mntmSupplierDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnNewMenu.add(mntmSupplierDetails);
		
		JMenu mnItem = new JMenu("Item");
		mnItem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnItem);
		
		JMenuItem mntmItemDetails = new JMenuItem("Item Details");
		mntmItemDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ItemsDetails().setVisible(true);
			}
		});
		mntmItemDetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnItem.add(mntmItemDetails);
	}
}
