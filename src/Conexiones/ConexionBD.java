package Conexiones;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.ConexionException;

public class ConexionBD {
	public static Statement crearStatement() throws ConexionException{
		
		try {
			return DriverManager.getConnection(Constantes.conexion,Constantes.usuario,Constantes.contraseña).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("La conexion ha bd fallado");
		}
	}
	
}
