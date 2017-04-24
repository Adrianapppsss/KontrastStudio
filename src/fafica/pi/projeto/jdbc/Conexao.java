package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public static Connection getConnection(){
		//Objeto para permitir a conex�o
		Connection con =null;
		try {
			Class.forName("org.postgresql.Driverxxx");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancokontraststudio","postgres","postgres");
			System.out.println("Conectado com sucesso!!!");
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println("N�o pode conectar : "+ e.getMessage());
		}
		return con; 
	}
	
	

}
