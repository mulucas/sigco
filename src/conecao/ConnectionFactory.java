package conecao;

import java.sql.*;
import java.util.logging.*;

public class ConnectionFactory {
		public static Connection con;
	    public PreparedStatement stmt;
	    public ResultSet rs;
	    
	    String drive = "com.mysql.jdbc.Driver";
	    public Connection getConnection() {
			try {
		        Class.forName(drive);
		        con = DriverManager.getConnection("jdbc:mysql://localhost/sigco","root","280697");
		          
			}         
			catch(SQLException excecao) {
		        throw new RuntimeException(excecao);
			} catch (ClassNotFoundException ex) {
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return con;
	    }
}
