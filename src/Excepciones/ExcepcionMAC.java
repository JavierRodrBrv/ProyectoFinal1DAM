package Excepciones;
/**
 * Esta clase modela una excepcion de MAC incorrecta.
 * @author Javier Rodr�guez
 */
public class ExcepcionMAC extends Exception{
	/**
	 * @param msg Se le pasa un mensaje donde este implementada la excepci�n.
	 */
	public ExcepcionMAC(String msg) {
		super(msg);
	}
}
