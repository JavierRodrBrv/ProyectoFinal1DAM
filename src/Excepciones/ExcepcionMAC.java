package Excepciones;
/**
 * Esta clase modela una excepcion de MAC incorrecta.
 * @author Javier Rodríguez
 */
public class ExcepcionMAC extends Exception{
	/**
	 * @param msg Se le pasa un mensaje donde este implementada la excepción.
	 */
	public ExcepcionMAC(String msg) {
		super(msg);
	}
}
