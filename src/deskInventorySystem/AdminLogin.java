package deskInventorySystem;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JPasswordField pf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		super("Administrator Login");
		new DbCon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminLogin.setBounds(117, 11, 107, 29);
		contentPane.add(lblAdminLogin);
		
		JLabel lblAdminId = new JLabel("Admin ID:-");
		lblAdminId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdminId.setBounds(43, 85, 75, 22);
		contentPane.add(lblAdminId);
		
		tf = new JTextField();
		tf.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
		tf.setBounds(128, 85, 107, 22);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:-");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(43, 131, 75, 22);
		contentPane.add(lblPassword);
		
		pf = new JPasswordField();
		pf.setBounds(128, 133, 107, 20);
		contentPane.add(pf);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{		
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary","root","root");
					PreparedStatement ps = con.prepareStatement("select * from admin where AID=? and Apassword=?");
					
					String name = tf.getText();
					String pass = new String(pf.getPassword());
					
					ps.setString(1,name);
					ps.setString(2,pass);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next())
					{		
						int a = JOptionPane.showConfirmDialog(contentPane,"Are You Sure?");
						if(a==JOptionPane.YES_OPTION)
						{
							dispose();
							new MainMenu().setVisible(true);
							//JOptionPane.showMessageDialog(contentPane,"You are Logged in ");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane,"name and password are incorrect, please re-enter");
						tf.setText(null);
						pf.setText(null);
					}
					
					con.close();
					
					
				}catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnLogin.setBounds(117, 199, 89, 29);
		contentPane.add(btnLogin);
		
	}
	
}
