package Interfaces;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import Conexiones.ConexionBD;
import Excepciones.ConexionException;

import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;



public class Ventana extends JFrame{
	private Principal principal;
	private File archivoCogido;
	private BufferedImage imagen;
	private ElegirTamaño et;
	
	
	public Ventana() {
		super();
		this.setTitle("Paint");
		setSize(750,450);
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
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
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
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				JFileChooser elGuardar= new JFileChooser();
				FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG file,GIF,PNG","jpg","gif","png");
				elGuardar.setFileFilter(filter);
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
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo.add(mntmSalir);
		
		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnOpciones);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				et=new ElegirTamaño(principal);
				et.setVisible(true);
			}
		});
		mnOpciones.add(mntmCrear);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
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

