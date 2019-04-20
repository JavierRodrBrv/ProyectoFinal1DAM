import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ProgramaPaint {

		public static void main(String args[]) {
			
			new ProgramaPaint().leerYEscribirImagen();
			
			
		}
		
		public void leerYEscribirImagen() {
			
			try {
				
				File archivoImagen=new File("./fondo.png");
				BufferedImage imagen = ImageIO.read(archivoImagen);
				System.out.println("SE HA LEÍDO CORRECTAMENTE LA IMAGEN");
				ImageIO.write(imagen, "png", new File("./fondoCopia.png"));
				System.out.println("SE HA ESCRITO LA IMAGEN");
				
				
			}catch(Exception e) {
				
				
			}
		}
		
}
