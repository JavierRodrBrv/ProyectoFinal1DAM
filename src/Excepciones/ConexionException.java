package Excepciones;
/**
 * Esta clase modela una excepcion de conexión a la base de datos.
 * @author Javier Rodríguez
 *
 */
public class ConexionException extends Exception {
	/**
	 * @param msg Se le pasa un mensaje donde este implementada la excepción.
	 */
	public ConexionException(String msg) {
		super(msg);
		
	}
}
