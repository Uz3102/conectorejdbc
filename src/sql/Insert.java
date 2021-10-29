package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Insert {
	
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL codigo especifico: " + e.getErrorCode());
	  }

	  public static void main(String[] args) {

	    String basedatos = "pruebaS";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "7145";

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s = c.createStatement()) {

	      int nFil = s.executeUpdate("INSERT INTO COCHES (ID,MARCA,MODELO) VALUES "
	              + "('789012X','HONDA','CIVIC'),"
	              + "('890145E','FORD', 'FIESTA'),"
	              + "('589012B','CITROEN','C4'),"
	              + "('076543K','NISSAN', 'X-TRAIL');");

	      System.out.println(nFil + " Filas insertadas.");

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  }

	}