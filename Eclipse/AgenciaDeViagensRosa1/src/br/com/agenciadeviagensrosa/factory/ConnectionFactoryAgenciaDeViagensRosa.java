package br.com.agenciadeviagensrosa.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryAgenciaDeViagensRosa{
	
	public static Connection createConnectionSQLServer() throws Exception {
		Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=AgenciaDeViagensRosa;integratedSecurity=true;"); 
			return connection;
	}
	

	public static void main (String[] args) throws Exception {
		Connection con = createConnectionSQLServer();
		
		if (con != null) {
			System.out.println("Conexão estabelecida com sucesso!! " + con);
			con.close();
		}
		
	}
	
	
}