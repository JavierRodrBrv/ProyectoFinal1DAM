package Conexiones;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Excepciones.ConexionException;
/**
 * Esta clase esta dedicada ha hacer conexión directa a la base de datos creada con mysqlWorkBench
 * @author Javier Rodríguez
 *
 */

public class ConexionBD {
	/**
	 * El Statement creado realiza la conexión a la base de datos.
	 * @return devuelve las constantes(los datos para hacer conexión).
	 * @throws ConexionException Lanzamos la excepción de la conexión de la base de datos.
	 */
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
