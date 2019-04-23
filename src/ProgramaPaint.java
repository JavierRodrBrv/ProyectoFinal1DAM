import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ProgramaPaint {

		public static void main(String args[]) {
			
			new ProgramaPaint().leerYEscribirImagen();
			
			
		}
		
		public void leerYEscribirImagen() {
			
			try {
				//Leo la imagen que ya existe del niño
				BufferedImage ninioChucho=ImageIO.read(new File("./imagenes/niniochucho.jpg"));
				
				//Imagen en blanco para duplicar
				BufferedImage enBlanco=new BufferedImage(ninioChucho.getWidth()*2,ninioChucho.getHeight()*2,BufferedImage.TYPE_INT_RGB);

				for(int i=0;i<enBlanco.getWidth();i++) {
					for(int j=0;j<enBlanco.getHeight();j++) {
						enBlanco.setRGB(i,j,Integer.parseInt("111111111111111111111111",2));
						
					}
				}
				
				
				//Los bucles siguientes son para clonar en diferentes posiciones.
				
				for(int i=0;i<ninioChucho.getWidth();i++) {
					for(int j=0;j<ninioChucho.getHeight();j++) {
						//enBlanco.setRGB(i,j,Integer.parseInt("111111111111111111111111",2));
						enBlanco.setRGB(i, j, ninioChucho.getRGB(i, j));
					}
				}
				for(int i=0;i<ninioChucho.getWidth();i++) {
					for(int j=0;j<ninioChucho.getHeight();j++) {
						//enBlanco.setRGB(i,j,Integer.parseInt("111111111111111111111111",2));
						enBlanco.setRGB(i+ninioChucho.getWidth(), j, ninioChucho.getRGB(i, j));
					}
				}
				for(int i=0;i<ninioChucho.getWidth();i++) {
					for(int j=0;j<ninioChucho.getHeight();j++) {
						//enBlanco.setRGB(i,j,Integer.parseInt("111111111111111111111111",2));
						enBlanco.setRGB(i, j+ninioChucho.getHeight(), ninioChucho.getRGB(i, j));
					}
				}
				for(int i=0;i<ninioChucho.getWidth();i++) {
					for(int j=0;j<ninioChucho.getHeight();j++) {
						//enBlanco.setRGB(i,j,Integer.parseInt("111111111111111111111111",2));
						enBlanco.setRGB(i+ninioChucho.getWidth(), j+ninioChucho.getHeight(), ninioChucho.getRGB(i, j));
					}
				}
				
				
				
				
				ImageIO.write(enBlanco,"png",new File("./imagenes/enBlanco.png"));
				
				
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
		
}
