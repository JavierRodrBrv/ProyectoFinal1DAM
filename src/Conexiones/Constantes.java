package Conexiones;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Constantes {
	
		public final static String conexion="jdbc:mysql://127.0.0.1/bdPaint";
		public final static String usuario="root";
		public static String contraseña="root";
		
		public static void init() {
			
			InetAddress ip;
			try {
					
				ip = InetAddress.getLocalHost();
				//System.out.println("Current IP address : " + ip.getHostAddress());
				
				NetworkInterface network = NetworkInterface.getByInetAddress(ip);
					
				byte[] mac = network.getHardwareAddress();
					
				//System.out.print("Current MAC address : ");
					
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
				}
				if(sb.toString().equals("2C-27-D7-27-28-D8")) {
					contraseña="";
				}
					
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
				
			} catch (SocketException e){
					
				e.printStackTrace();
					
			}
		}
		
		
}

