package Interfaces;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ElegirTamaño extends JDialog {
	private JTextField alto;
	private ElegirTamaño thisRef;
	private JTextField ancho;
	private Principal principal;
	
	public ElegirTamaño(Principal p) {
		this.principal=p;
		thisRef=this;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 56, 86, 99, 89, 0};
		gridBagLayout.rowHeights = new int[]{60, 20, 75, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		JLabel lblAlto = new JLabel("Alto");
		GridBagConstraints gbc_lblAlto = new GridBagConstraints();
		gbc_lblAlto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlto.gridx = 1;
		gbc_lblAlto.gridy = 1;
		getContentPane().add(lblAlto, gbc_lblAlto);
		this.setSize(500,300);
		alto = new JTextField();
		alto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				switch(arg0.getKeyChar()) {
				case KeyEvent.VK_ENTER:
					System.out.println("Intro presionado");
					
					p.setImagen(new BufferedImage(Integer.parseInt
							(ancho.getText()),Integer.parseInt
							(alto.getText()),BufferedImage.TYPE_INT_RGB));
					
					thisRef.dispose();
					break;
				}
			}
		});
		GridBagConstraints gbc_alto = new GridBagConstraints();
		gbc_alto.anchor = GridBagConstraints.WEST;
		gbc_alto.insets = new Insets(0, 0, 5, 5);
		gbc_alto.gridx = 2;
		gbc_alto.gridy = 1;
		getContentPane().add(alto, gbc_alto);
		alto.setColumns(10);
		
		JLabel lblAncho = new JLabel("Ancho");
		GridBagConstraints gbc_lblAncho = new GridBagConstraints();
		gbc_lblAncho.insets = new Insets(0, 0, 5, 5);
		gbc_lblAncho.gridx = 1;
		gbc_lblAncho.gridy = 2;
		getContentPane().add(lblAncho, gbc_lblAncho);
		
		ancho = new JTextField();
		ancho.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				switch(arg0.getKeyChar()) {
				case KeyEvent.VK_ENTER:
					System.out.println("Intro presionado");
					
					p.setImagen(new BufferedImage(Integer.parseInt
							(ancho.getText()),Integer.parseInt
							(alto.getText()),BufferedImage.TYPE_INT_RGB));
					
					thisRef.dispose();
					break;
				}
			}
		});
		GridBagConstraints gbc_ancho = new GridBagConstraints();
		gbc_ancho.anchor = GridBagConstraints.WEST;
		gbc_ancho.insets = new Insets(0, 0, 5, 5);
		gbc_ancho.gridx = 2;
		gbc_ancho.gridy = 2;
		getContentPane().add(ancho, gbc_ancho);
		ancho.setColumns(10);
		
		JButton okButton = new JButton("Confirmar");
		okButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				switch(arg0.getKeyChar()) {
				case KeyEvent.VK_ENTER:
					System.out.println("Intro presionado");
					
					p.setImagen(new BufferedImage(Integer.parseInt
							(ancho.getText()),Integer.parseInt
							(alto.getText()),BufferedImage.TYPE_INT_RGB));
					
					thisRef.dispose();
					break;
				}
				
			}
		});
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				p.setImagen(new BufferedImage(Integer.parseInt
						(ancho.getText()),Integer.parseInt
						(alto.getText()),BufferedImage.TYPE_INT_RGB));
				
				thisRef.dispose();
			}
		});
		
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.gridx = 2;
		gbc_okButton.gridy = 3;
		getContentPane().add(okButton, gbc_okButton);
	}
}
