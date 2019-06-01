package Excepciones;
/**
 * Esta clase modela una excepcion de Host IP incorrecto.
 * @author Javier Rodr�guez
 *
 */
public class ExcepcionHostDesconocido extends Exception{
	/**
	 * @param msg Se le pasa un mensaje donde este implementada la excepci�n.
	 */
	 public ExcepcionHostDesconocido(String msg) {
		 super(msg);
	 }
}
