package Excepciones;
/**
 * Esta clase modela una excepcion de Host IP incorrecto.
 * @author Javier Rodríguez
 *
 */
public class ExcepcionHostDesconocido extends Exception{
	/**
	 * @param msg Se le pasa un mensaje donde este implementada la excepción.
	 */
	 public ExcepcionHostDesconocido(String msg) {
		 super(msg);
	 }
}
