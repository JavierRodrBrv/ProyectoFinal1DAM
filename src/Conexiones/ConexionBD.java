package Conexiones;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Excepciones.ConexionException;
/**
 * Esta clase esta dedicada ha hacer conexi�n directa a la base de datos creada con mysqlWorkBench
 * @author Javier Rodr�guez
 *
 */

public class ConexionBD {
	/**
	 * El Statement creado realiza la conexi�n a la base de datos.
	 * @return devuelve las constantes(los datos para hacer conexi�n).
	 * @throws ConexionException Lanzamos la excepci�n de la conexi�n de la base de datos.
	 */
	public static Statement crearStatement() throws ConexionException{
		
		try {
			return DriverManager.getConnection(Constantes.conexion,Constantes.usuario,Constantes.contrase�a).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("La conexion ha bd fallado");
		}
	}
	
}
