package Interfaces;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Ventana extends JFrame{
	private Principal principal;
	private File archivoCogido;
	private BufferedImage imagen;
	
	
	public Ventana() {
		super();
	
		this.setTitle("Paint");
		setSize(500,500);
		principal=new Principal(this);
		
		this.setLocationRelativeTo(null);
		
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
				
				archivoCogido=elegir.getSelectedFile();
				int opcionElegida=elegir.showOpenDialog(principal);
				
				try {
					imagen=ImageIO.read(archivoCogido);
					principal.setImagen(imagen);
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		mntmAbrir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
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
				ElegirTamaño et=new ElegirTamaño(principal);
				et.setVisible(true);
			}
		});
		mnOpciones.add(mntmCrear);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnOpciones.add(mntmBorrar);
		
		this.setContentPane(principal);
		this.setVisible(true);
	}

}
