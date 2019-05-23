package Interfaces;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Panel;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JMenuBar;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import javax.swing.SwingConstants;

public class Principal extends JPanel{
	private Ventana ventana;
	private BufferedImage imagen;
	private JLabel lienzo;


	public Principal(Ventana v) {
		
		super();
		
		this.ventana=v;
		
		setBackground(new Color(204, 204, 255));
		
		
		lienzo=new JLabel();
		lienzo.setVerticalAlignment(SwingConstants.TOP);
		lienzo.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				
				/* lienzo.setText("X="+e.getX()+", Y="+e.getY());  
				    Graphics g=getGraphics();  
				    g.setColor(Color.RED);  
				    g.fillOval(e.getX(),e.getY(),10,10);  
				    System.out.println(e.getX()+" : "+e.getY());*/
				    imagen.setRGB(e.getX(), e.getY(), Color.red.getRGB());
				    
				    lienzo.repaint();
					repaint();
					ventana.repaint();
			}
			
			public void mouseMoved(MouseEvent e) {
				
				lienzo.setText("X="+e.getX()+", Y="+e.getY());  
			}
			
			
		});
		setLayout(new BorderLayout(0, 0));
		this.add(lienzo);
		
		
		
		this.setVisible(true);
	}
	
	 

	
	
	public JLabel getLabel() {
		return lienzo;
	}



	public void setLabel(JLabel label) {
		this.lienzo = label;
	}



	public BufferedImage getImagen() {
		return imagen;
	}
	
	
	
	public void setImagen(BufferedImage imagen,Color color) {
		this.imagen = imagen;
		
		//Aqui es donde cambiamos el color del lienzo cuando lo creamos.
	
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				imagen.setRGB(i, j, color.getRGB());
			}
		}
		this.lienzo.setIcon(new ImageIcon(imagen));
		this.lienzo.repaint();
		this.repaint();
		ventana.repaint();
	}
	
	public void abrirImagen(BufferedImage imagen) {
		this.imagen = imagen;
		
		//Aqui es donde cambiamos el color del lienzo cuando lo creamos.
	
		
		this.lienzo.setIcon(new ImageIcon(imagen));
		this.lienzo.repaint();
		this.repaint();
		ventana.repaint();
	}
	
	
	public void borrar() {
		lienzo.setIcon(null);
		this.lienzo.repaint();
		this.repaint();
		ventana.repaint();
	}
	
	
}
