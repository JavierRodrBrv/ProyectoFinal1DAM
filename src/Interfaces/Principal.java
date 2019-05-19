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

public class Principal extends JPanel{
	private Ventana ventana;
	private BufferedImage imagen;
	private JLabel lienzo;


	public Principal(Ventana v) {
		
		super();
		
		this.ventana=v;
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		setBackground(new Color(204, 204, 255));
		
		
		lienzo=new JLabel();
		lienzo.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				
				 lienzo.setText("X="+e.getX()+", Y="+e.getY());  
				    Graphics g=getGraphics();  
				    g.setColor(Color.RED);  
				    g.fillOval(e.getX(),e.getY(),10,10);  
				
			}
			
			public void mouseMoved(MouseEvent e) {
				
				lienzo.setText("X="+e.getX()+", Y="+e.getY());  
			}
			
			
		});
		
		GridBagConstraints gbc_lienzo = new GridBagConstraints();
		gbc_lienzo.fill = GridBagConstraints.BOTH;
		gbc_lienzo.gridx = 0;
		gbc_lienzo.gridy = 0;
		this.add(lienzo, gbc_lienzo);
		
		
		
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
	
		Graphics2D    graphics = imagen.createGraphics();
		graphics.setPaint ( color );
		graphics.fillRect ( 0, 0, imagen.getWidth(), imagen.getHeight() );
		this.lienzo.setIcon(new ImageIcon(imagen));
	}
	
	
}
