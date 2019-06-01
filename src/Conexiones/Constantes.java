package Conexiones;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import Excepciones.ExcepcionHostDesconocido;
import Excepciones.ExcepcionMAC;
/**
 * Esta clase trata de crear constantes( variables que no cambian sus datos) para la conexi�n a la base de datos.
 * @author Javier Rodr�guez
 *
 */
public class Constantes {
	/**
	 * Conexion:  se establece la direcci�n de la base de datos a la que se conecta nuestro programa.
	 * Usuario y contrase�a: en este caso la base de datos tiene usuario y contrase�a asi que nos conectamos con la que tengamos creada.
	 */
		public final static String conexion="jdbc:mysql://127.0.0.1/bdPaint";
		public final static String usuario="root";
		public static String contrase�a="root";
		
		/**
		 * Esta funci�n devuelve un valor en este caso una cadena vacia de String si en el ordenador en el que el programa se esta ejecutando tiene una MAC distinta a la acordada
		 * en la funci�n.
		 * @throws ExcepcionHostDesconocido Excepcion que devuelve un fallo en el caso que la IP no este identificada.
		 * @throws ExcepcionMAC Excepcion que devuelve un mensaje si la MAC no es la correcta.
		 */
		public static void init() throws ExcepcionHostDesconocido, ExcepcionMAC {
			
			InetAddress ip;
			try {
					
				ip = InetAddress.getLocalHost();
				
				NetworkInterface network = NetworkInterface.getByInetAddress(ip);
					
				byte[] mac = network.getHardwareAddress();
				
					
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
				}
				if(sb.toString().equals("2C-27-D7-27-28-D8")) {
					contrase�a="";
				}
					
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
				throw new ExcepcionHostDesconocido("La direcci�n de la IP esta mal puesta. Por favor revisela");
			} catch (SocketException e){
					
				e.printStackTrace();
				throw new ExcepcionMAC("La MAC es incorrecta");	
			}
		}
		
		
}

