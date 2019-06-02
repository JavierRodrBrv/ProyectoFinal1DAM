package Main;
import Conexiones.Constantes;
import Excepciones.ExcepcionHostDesconocido;
import Excepciones.ExcepcionMAC;
import Interfaces.Ventana;
/**
 * Este es el main del programa que inicia con el escaneo de direccion IP y MAC y despues entra en las interfaces.
 * @author Javier Rodriguez
 *
 */
public class Main {

		public static void main(String args[]) {
			
			try {
				Constantes.init();
			} catch (ExcepcionHostDesconocido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionMAC e) {
				e.printStackTrace();
			}
			
			Ventana ventana=new Ventana();
		}
}
