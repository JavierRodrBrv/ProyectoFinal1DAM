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
import javax.swing.JSlider;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Principal extends JPanel{
	private Ventana ventana;
	private BufferedImage imagen;
	private JLabel lienzo;
	private JSlider sliderRojo;
	private JSlider sliderVerde;
	private JSlider sliderAzul;
	
	public Principal(Ventana v) {
		
		super();
		
		this.ventana=v;
		
		setBackground(new Color(204, 204, 255));
		
		
		
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{144, 0};
		gbl_panel.rowHeights = new int[]{47, 43, 40, 43, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton botonHerramienta = new JButton("");
		botonHerramienta.setMinimumSize(new Dimension(27, 9));
		botonHerramienta.setMaximumSize(new Dimension(20, 9));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.VERTICAL;
		gbc_button.gridx = 0;
		gbc_button.gridy = 3;
		panel.add(botonHerramienta, gbc_button);
		
		
		
		sliderRojo = new JSlider();
		
		GridBagConstraints gbc_sliderRojo = new GridBagConstraints();
		gbc_sliderRojo.fill = GridBagConstraints.BOTH;
		gbc_sliderRojo.insets = new Insets(0, 0, 5, 0);
		gbc_sliderRojo.gridx = 0;
		gbc_sliderRojo.gridy = 0;
		panel.add(sliderRojo, gbc_sliderRojo);
		sliderRojo.setValue(0);
		sliderRojo.setMaximum(255);
		
		sliderVerde = new JSlider();
		
		GridBagConstraints gbc_sliderVerde = new GridBagConstraints();
		gbc_sliderVerde.fill = GridBagConstraints.BOTH;
		gbc_sliderVerde.insets = new Insets(0, 0, 5, 0);
		gbc_sliderVerde.gridx = 0;
		gbc_sliderVerde.gridy = 1;
		panel.add(sliderVerde, gbc_sliderVerde);
		sliderVerde.setValue(0);
		sliderVerde.setMaximum(255);
		
		sliderAzul = new JSlider();
		
		GridBagConstraints gbc_sliderAzul = new GridBagConstraints();
		gbc_sliderAzul.fill = GridBagConstraints.BOTH;
		gbc_sliderAzul.insets = new Insets(0, 0, 5, 0);
		gbc_sliderAzul.gridx = 0;
		gbc_sliderAzul.gridy = 2;
		panel.add(sliderAzul, gbc_sliderAzul);
		sliderAzul.setValue(0);
		sliderAzul.setMaximum(255);
		
		
		
		
		
		this.setVisible(true);
		
		lienzo=new JLabel();
		lienzo.setVerticalAlignment(SwingConstants.TOP);
		lienzo.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				
				
				int [] colores= new int[255];
				colores[0]=sliderRojo.getValue();
				colores[1]=sliderVerde.getValue();
				colores[2]=sliderAzul.getValue();
				
				System.out.println(colores[0]+ "" + colores[1] +""+colores[2]);
				
				    imagen.setRGB(e.getX(), e.getY(), 10, 10,colores , 0, 0);
				 
				    lienzo.repaint();
					repaint();
					ventana.repaint();
					
			}
			
			public void mouseMoved(MouseEvent e) {
				
				lienzo.setText("X="+e.getX()+", Y="+e.getY());  
			}
			
			
			
		});
		
		sliderRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				botonHerramienta.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			}
		});
		
		sliderVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				botonHerramienta.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			}
		});
		
		sliderAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				botonHerramienta.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			}
		});
		
		this.add(lienzo);
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
