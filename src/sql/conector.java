package sql;

import java.sql.*;

public class conector {
	
	public static void main(String[]args) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "7145");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from personas ");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
			con.close();
		}catch (SQLException e) {
			System.out.println("hola");
		}
	}
}

