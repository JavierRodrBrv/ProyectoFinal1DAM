package Interfaces;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import Conexiones.ConexionBD;
import Excepciones.ConexionException;

import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Esta clase modela lo que es una ventana del programa
 * @author Javier Rodriguez
 *
 */

public class Ventana extends JFrame{
	private Principal principal;//Este es el lienzo principal (PANEL)
	private File archivoCogido;//Tipo file para abrir alguna imagen
	private ElegirTamaño et;//Es el JDialog de la clase ElegirTamaño
	
	
	public Ventana() {
		super();
		this.setTitle("Paint");
		setSize(750,490);
		this.setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/icono2.jpg"));
		
		//Hacemos conexion a la base de datos
		
		try {
			ConexionBD.crearStatement();
		} catch (ConexionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		principal=new Principal(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");//Es el menu que contiene varias opciones
		mnArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");//Esta opción nos permite abrir una imagen
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser elegir=new JFileChooser();
				FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG file,GIF,PNG","jpg","gif","png");
				elegir.setFileFilter(filter);
				
				
				int opcionElegida=elegir.showOpenDialog(principal);
				if(opcionElegida==JFileChooser.APPROVE_OPTION) {
					archivoCogido=elegir.getSelectedFile();
					System.out.println(archivoCogido.getAbsolutePath());
					
					
					
				try {
					principal.abrirImagen(ImageIO.read(new FileInputStream(archivoCogido)));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				}
				
			}
		});
		mntmAbrir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");//Esta opción nos permite guardar una imagen
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				JFileChooser elGuardar= new JFileChooser();
				
				int eleccionValor=elGuardar.showSaveDialog(null);
				if(eleccionValor==JFileChooser.APPROVE_OPTION) {
					File f=elGuardar.getSelectedFile();
					String ruta= f.getAbsolutePath();
					
					try {
						ImageIO.write(principal.getImagen(),"jpg",new File(ruta));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		mntmGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");//Esta opcion nos permite salirnos del programa y cortar su ejecución.
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo.add(mntmSalir);
		
		JMenu mnOpciones = new JMenu("Opciones");//Este menu que contiene las opciones del lienzo.
		mnOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnOpciones);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");//Esta opcion permite crear un lienzo.
		mntmCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				et=new ElegirTamaño(principal);
				et.setVisible(true);
			}
		});
		mnOpciones.add(mntmCrear);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");//Esta opcion permite borrar el lienzo.
		mntmBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.borrar();
				principal.repaint();
			}
		});
		mnOpciones.add(mntmBorrar);
		
		this.setContentPane(principal);
		this.setVisible(true);
		
		
		}
	}

