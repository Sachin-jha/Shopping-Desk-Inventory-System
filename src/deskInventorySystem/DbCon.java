package deskInventorySystem;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbCon 
{
	DbCon()
	{
		try
		{		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/desk_inventary","root","root");
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e);
			
		}
	}

}
