package Main;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Conexiones.Constantes;
import Interfaces.Ventana;

public class Main {

		public static void main(String args[]) {
			Constantes.init();
			Ventana ventana=new Ventana();
		}
}
