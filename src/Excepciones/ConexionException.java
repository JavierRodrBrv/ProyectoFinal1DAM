package Excepciones;
/**
 * Esta clase modela una excepcion de conexi�n a la base de datos.
 * @author Javier Rodr�guez
 *
 */
public class ConexionException extends Exception {
	/**
	 * @param msg Se le pasa un mensaje donde este implementada la excepci�n.
	 */
	public ConexionException(String msg) {
		super(msg);
		
	}
}
