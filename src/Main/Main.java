package Main;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Conexiones.Constantes;
import Excepciones.ExcepcionHostDesconocido;
import Excepciones.ExcepcionMAC;
import Interfaces.Ventana;

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
