package Interfaces;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Dimension;

import javax.swing.event.ChangeListener;

import Conexiones.ConexionBD;
import Excepciones.ConexionException;

import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.ButtonGroup;

import java.awt.Rectangle;
import javax.swing.border.LineBorder;

public class Principal extends JPanel{
	private Ventana ventana;
	private BufferedImage imagen;
	private JLabel lienzo,lblColoresGuardados;
	private JSlider sliderRojo,sliderVerde,sliderAzul; //Aqui estan los slider de colores que he creado
	private JButton botonGuardaColores,btnLimpiarColores; //Botones donde guarda colores y lo limpia tanto en base de datos como en el programa.
	private JRadioButton opPincel2px,opPincel4px,opPincel8px; //La seleccion de la anchura de los pixeles
	private final ButtonGroup conjuntoOpciones;
	private ArrayList<JButton> botonesColores; //Este es el ArrayList que he utilizado para ingresarle los valores a los botones.
	private JPanel coloresGuardados; 
	
	public Principal(Ventana v) {
		
		super();
		this.ventana=v;
		setBackground(new Color(204, 204, 255));
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelHerramientas = new JPanel();//Este panel contiene las herramientas para pintar 
		add(panelHerramientas, BorderLayout.EAST);
		GridBagLayout gbl_panelHerramientas = new GridBagLayout();
		gbl_panelHerramientas.columnWidths = new int[]{174, 32, 0};
		gbl_panelHerramientas.rowHeights = new int[]{47, 43, 40, 24, 60, 0, 0, 0, 39, 45, 42, 0};
		gbl_panelHerramientas.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelHerramientas.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelHerramientas.setLayout(gbl_panelHerramientas);
		
		sliderRojo = new JSlider();//Este slider trata de dar valor/color rojo al pincel
		GridBagConstraints gbc_sliderRojo = new GridBagConstraints();
		gbc_sliderRojo.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderRojo.insets = new Insets(0, 0, 5, 5);
		gbc_sliderRojo.gridx = 0;
		gbc_sliderRojo.gridy = 0;
		panelHerramientas.add(sliderRojo, gbc_sliderRojo);
		sliderRojo.setValue(0);
		sliderRojo.setMaximum(255);
		
		sliderVerde = new JSlider();//Este slider trata de dar valor/color verde al pincel
		GridBagConstraints gbc_sliderVerde = new GridBagConstraints();
		gbc_sliderVerde.fill = GridBagConstraints.BOTH;
		gbc_sliderVerde.insets = new Insets(0, 0, 5, 5);
		gbc_sliderVerde.gridx = 0;
		gbc_sliderVerde.gridy = 1;
		panelHerramientas.add(sliderVerde, gbc_sliderVerde);
		sliderVerde.setValue(0);
		sliderVerde.setMaximum(255);
		
		sliderAzul = new JSlider();//Este slider trata de dar valor/color azul al pincel
		GridBagConstraints gbc_sliderAzul = new GridBagConstraints();
		gbc_sliderAzul.fill = GridBagConstraints.BOTH;
		gbc_sliderAzul.insets = new Insets(0, 0, 5, 5);
		gbc_sliderAzul.gridx = 0;
		gbc_sliderAzul.gridy = 2;
		panelHerramientas.add(sliderAzul, gbc_sliderAzul);
		sliderAzul.setValue(0);
		sliderAzul.setMaximum(255);
		
		JButton botonColor = new JButton("");//La funcionalidad de este boton es mostrar en que color esta el pincel actualmente
		botonColor.setBackground(Color.BLACK);
		botonColor.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		botonColor.setMinimumSize(new Dimension(27, 9));
		botonColor.setMaximumSize(new Dimension(20, 9));
		GridBagConstraints gbc_botonColor = new GridBagConstraints();
		gbc_botonColor.insets = new Insets(0, 0, 5, 0);
		gbc_botonColor.fill = GridBagConstraints.VERTICAL;
		gbc_botonColor.gridx = 1;
		gbc_botonColor.gridy = 1;
		panelHerramientas.add(botonColor, gbc_botonColor);
		
		
		

		
		lblColoresGuardados = new JLabel("COLORES GUARDADOS");//Este label muestra el titulo del panel
		GridBagConstraints gbc_lblColoresGuardados = new GridBagConstraints();
		gbc_lblColoresGuardados.insets = new Insets(0, 0, 5, 5);
		gbc_lblColoresGuardados.gridx = 0;
		gbc_lblColoresGuardados.gridy = 3;
		panelHerramientas.add(lblColoresGuardados, gbc_lblColoresGuardados);
		
		
		coloresGuardados = new JPanel();//Este panel muestra los colores almacenados
		coloresGuardados.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		
		botonesColores=new ArrayList<JButton>();
        try {

    		Statement selectColor=ConexionBD.crearStatement();
			ResultSet setColor=selectColor.executeQuery("select * from colores;");
			while(setColor.next()){
				coloresPredefinidosBD(setColor);
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
        catch (ConexionException e1) {
        	
			e1.printStackTrace();
		}
		
		
		coloresGuardados.setBounds(new Rectangle(0, 0, 15, 15));
		GridBagConstraints gbc_coloresGuardados = new GridBagConstraints();
		gbc_coloresGuardados.gridwidth = 2;
		gbc_coloresGuardados.insets = new Insets(0, 0, 5, 5);
		gbc_coloresGuardados.fill = GridBagConstraints.BOTH;
		gbc_coloresGuardados.gridx = 0;
		gbc_coloresGuardados.gridy = 4;
		panelHerramientas.add(coloresGuardados, gbc_coloresGuardados);
		coloresGuardados.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		coloresGuardados.setSize(25,25);
		coloresGuardados.setMinimumSize(coloresGuardados.getSize());
		coloresGuardados.setMaximumSize(coloresGuardados.getSize());
		
		
		botonGuardaColores = new JButton("Guardar color");//Este boton guarda los colores tanto en la base de datos como en el programa
		botonGuardaColores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_botonGuardaColores1 = new GridBagConstraints();
		gbc_botonGuardaColores1.insets = new Insets(0, 0, 5, 5);
		gbc_botonGuardaColores1.anchor = GridBagConstraints.SOUTH;
		gbc_botonGuardaColores1.gridx = 0;
		gbc_botonGuardaColores1.gridy = 5;
		panelHerramientas.add(botonGuardaColores, gbc_botonGuardaColores1);
		
		botonGuardaColores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					Statement registrarColores=ConexionBD.crearStatement();
					registrarColores.execute("insert into colores(red,green,blue) values('"+sliderRojo.getValue()+"','"+sliderVerde.getValue()+"','"+sliderAzul.getValue()+"')");
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				} catch (ConexionException e) {
					
					e.printStackTrace();
				
				}
				
				JButton boton=new JButton();
				boton.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
				coloresGuardados.add(boton);
				botonesColores.add(boton);
				seleccionarColores(boton);
				
				coloresGuardados.setVisible(false);
				coloresGuardados.setVisible(true);
				
			}
			
		});
		
		btnLimpiarColores = new JButton("Limpiar colores");
		btnLimpiarColores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					Statement limpiarColores=ConexionBD.crearStatement();
					
					 // Usamos TRUNCATE
				    String borrar = "TRUNCATE colores";
				    // Ejecutamos el TRUNCATE
				    limpiarColores.executeUpdate(borrar);
				    coloresGuardados.removeAll();
				    coloresGuardados.setVisible(false);
					coloresGuardados.setVisible(true);
				    coloresGuardados.repaint();
					limpiarColores.close();
				} catch (ConexionException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnLimpiarColores = new GridBagConstraints();
		gbc_btnLimpiarColores.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiarColores.gridx = 0;
		gbc_btnLimpiarColores.gridy = 6;
		panelHerramientas.add(btnLimpiarColores, gbc_btnLimpiarColores);
		
	
		conjuntoOpciones= new ButtonGroup();//Grupo donde recoge los RadioButtons
		
		opPincel2px = new JRadioButton("Pincel 2px");//En este RadioButton seleccionamos de que el pincel tenga una anchura de 2px
		conjuntoOpciones.add(opPincel2px);
		GridBagConstraints gbc_opPincel2px = new GridBagConstraints();
		gbc_opPincel2px.insets = new Insets(0, 0, 5, 5);
		gbc_opPincel2px.gridx = 0;
		gbc_opPincel2px.gridy = 7;
		panelHerramientas.add(opPincel2px, gbc_opPincel2px);
		
		opPincel4px = new JRadioButton("Pincel 4px");//En este RadioButton seleccionamos de que el pincel tenga una anchura de 4px
		opPincel4px.setSelected(true);
		conjuntoOpciones.add(opPincel4px);
		GridBagConstraints gbc_opPincel4px = new GridBagConstraints();
		gbc_opPincel4px.insets = new Insets(0, 0, 5, 5);
		gbc_opPincel4px.gridx = 0;
		gbc_opPincel4px.gridy = 8;
		panelHerramientas.add(opPincel4px, gbc_opPincel4px);
		
		opPincel8px = new JRadioButton("Pincel 8px");//En este RadioButton seleccionamos de que el pincel tenga una anchura de 8px
		conjuntoOpciones.add(opPincel8px);
		GridBagConstraints gbc_opPincel6px = new GridBagConstraints();
		gbc_opPincel6px.insets = new Insets(0, 0, 5, 5);
		gbc_opPincel6px.gridx = 0;
		gbc_opPincel6px.gridy = 9;
		panelHerramientas.add(opPincel8px, gbc_opPincel6px);
		
		this.setVisible(true);
		
		lienzo=new JLabel();//Este es el lienzo en el que se va a pintar
		lienzo.setVerticalAlignment(SwingConstants.TOP);
		lienzo.addMouseMotionListener(new MouseMotionAdapter() {
			
			
			
			public void mouseDragged(MouseEvent e) {//Con este evento podemos dibujar lineas libres por el lienzo
				
				int ancho=0;
				if(opPincel2px.isSelected()==true) {
					ancho=2;
				}else  if(opPincel4px.isSelected()==true) {
					ancho=4;
				}else if(opPincel8px.isSelected()==true) {
					ancho=8;
				}
				//La formula para que un pincel reciba el color prometido es la siguiente:
				
				int [] colores= new int[ancho*ancho];//El array tiene que estar ocupado por el maximo de pixeles que pueda rellenarse
				for (int i = 0; i <ancho*ancho; i++) {
					colores[i]=sliderRojo.getValue()<<16 | sliderVerde.getValue()<<8 |sliderAzul.getValue();//Hace falta desplazar los valores de los sliders rojo 
																											//y verde ya que sería asi: 255(ROJO) 255(Verde 255 Azul. 
																											//Al azul no hace falta desplazarlo ya que esta en la ultima posicion.
				}	
				lienzo.setText("X="+e.getX()+", Y="+e.getY());  
			    imagen.setRGB(e.getX(), e.getY(), ancho,ancho,colores , 0, 0);
			    lienzo.repaint();
				repaint();
				ventana.repaint();
					
			}
			
			public void mouseMoved(MouseEvent e) {//En este evento marca en que coordenadas esta situado el puntero.
				
				lienzo.setText("X="+e.getX()+", Y="+e.getY());  
			}
			
			
			
		});
		
		sliderRojo.addChangeListener(new ChangeListener() {//Este slider rojo recoge los valores para aplicarselos al boton.
			public void stateChanged(ChangeEvent arg0) {

				botonColor.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			}
		});
		
		sliderVerde.addChangeListener(new ChangeListener() {//Este slider verde recoge los valores para aplicarselos al boton.
			public void stateChanged(ChangeEvent e) {

				botonColor.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			}
		});
		
		sliderAzul.addChangeListener(new ChangeListener() {//Este slider azul recoge los valores para aplicarselos al boton.
			public void stateChanged(ChangeEvent e) {

				botonColor.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			}
		});
		
		this.add(lienzo);
		
		
		
	
	}
	/**
	 * Esta funcion trata de agregar los valores a los botones que se crean dinamicamente.
	 * @param color lo envia por parametro para agregarlo al boton
	 * @throws SQLException la excepcion de la base de datos.
	 */
	public void coloresPredefinidosBD(ResultSet color) throws SQLException {
		
		JButton boton=new JButton();
		boton.setBackground(new Color(color.getInt("red"),color.getInt("green"),color.getInt("blue")));
		coloresGuardados.add(boton);
		botonesColores.add(boton);
		seleccionarColores(boton);
		
		
		
	}
	
	/**
	 * Esta funcion trata de que clickando un boton se seleccione el color.
	 * @param boton  se le pasa por parametros los botones creados dinamicamente.
	 */
	public void seleccionarColores(JButton boton) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			int valorColorRojo=boton.getBackground().getRed();
			int valorColorVerde=boton.getBackground().getGreen();
			int valorColorAzul=boton.getBackground().getBlue();
			
			sliderRojo.setValue(valorColorRojo);
			sliderVerde.setValue(valorColorVerde);
			sliderAzul.setValue(valorColorAzul);
			}
		});
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
	
	/**
	 * En esta funcion es donde creamos nuestro lienzo predeterminado para que el usuario no tenga que introducir nada.
	 * @param imagen Es donde pasamos la imagen por parametros para crear el lienzo
	 * @param color Es donde le pasamos el color anteriormente introducido.
	 */
	public void setImagenPreseterminada(BufferedImage imagen,Color color) {
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
	
	/**
	 * En esta funcion es donde creamos nuestro lienzo personalizado.
	 * @param imagen Es donde pasamos la imagen por parametros para crear el lienzo
	 * @param color Es donde le pasamos el color anteriormente introducido.
	 */
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
	
	/**
	 * En esta funcion trata de que se pueda abrir una imagen de nuestro PC
	 * @param imagen	Le pasamos por parametros la imagen.
	 */
	public void abrirImagen(BufferedImage imagen) {
		this.imagen = imagen;
		this.lienzo.setIcon(new ImageIcon(imagen));
		this.lienzo.repaint();
		this.repaint();
		ventana.repaint();
	}
	
	/**
	 * Esta funcion borra el lienzo entero.
	 */
	public void borrar() {
		lienzo.setIcon(null);
		this.lienzo.repaint();
		this.repaint();
		ventana.repaint();
	}
}
