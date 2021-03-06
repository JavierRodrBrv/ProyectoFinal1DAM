package Interfaces;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Toolkit;
/**
 * Clase que modela una interfaz que crea un lienzo de las medidas que quieres.
 * @author Javier Rodriguez
 *
 */
public class ElegirTamaņo extends JDialog {
	
	private JTextField alto,ancho,valorHexa;//Son campos de texto que tanto en alto y ancho introducimos valores naturales y en el campo valorHexadecimal se va generando automaticamente por los sliders.
	private ElegirTamaņo thisRef;//Si se devuelve un true la ventana a la que ha sido implementada desaparece.
	private JSlider sliderRojo,sliderVerde,sliderAzul;//Los sliders dan color al lienzo
	
	public ElegirTamaņo(Principal p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1DAM\\Documents\\GitHub\\ProyectoFinal1DAM\\imagenes\\icono2.jpg"));
		
		thisRef=this;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 79, 86, 257, 68, 146, 0};
		gridBagLayout.rowHeights = new int[]{60, 49, 54, 43, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		this.setSize(850,350);
		
		valorHexa = new JTextField();
		GridBagConstraints gbc_valorHexa = new GridBagConstraints();
		gbc_valorHexa.anchor = GridBagConstraints.WEST;
		gbc_valorHexa.insets = new Insets(0, 0, 5, 0);
		gbc_valorHexa.gridx = 5;
		gbc_valorHexa.gridy = 2;
		getContentPane().add(valorHexa, gbc_valorHexa);
		valorHexa.setColumns(10);
		
		alto = new JTextField();
		JLabel lblAlto = new JLabel("Alto");
		GridBagConstraints gbc_lblAlto = new GridBagConstraints();
		gbc_lblAlto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlto.gridx = 1;
		gbc_lblAlto.gridy = 1;
		getContentPane().add(lblAlto, gbc_lblAlto);
		GridBagConstraints gbc_alto = new GridBagConstraints();
		gbc_alto.insets = new Insets(0, 0, 5, 5);
		gbc_alto.gridx = 2;
		gbc_alto.gridy = 1;
		getContentPane().add(alto, gbc_alto);
		alto.setColumns(10);
		
		
		
		ancho = new JTextField();
		JLabel lblAncho = new JLabel("Ancho");
		GridBagConstraints gbc_lblAncho = new GridBagConstraints();
		gbc_lblAncho.insets = new Insets(0, 0, 5, 5);
		gbc_lblAncho.gridx = 1;
		gbc_lblAncho.gridy = 2;
		getContentPane().add(lblAncho, gbc_lblAncho);
		GridBagConstraints gbc_ancho = new GridBagConstraints();
		gbc_ancho.insets = new Insets(0, 0, 5, 5);
		gbc_ancho.gridx = 2;
		gbc_ancho.gridy = 2;
		getContentPane().add(ancho, gbc_ancho);
		ancho.setColumns(10);
		
		
			JButton botonColor = new JButton("");//La funcionalidad de este boton es mostrar el color que se recoge de los sliders
		
				GridBagConstraints gbc_botonColor = new GridBagConstraints();
				gbc_botonColor.fill = GridBagConstraints.VERTICAL;
				gbc_botonColor.insets = new Insets(0, 0, 0, 5);
				gbc_botonColor.gridx = 3;
				gbc_botonColor.gridy = 4;
				getContentPane().add(botonColor, gbc_botonColor);
				
				
				botonColor.setBackground(Color.BLACK);
		
		
		
		
				JButton botonConfirmar = new JButton("Confirmar");//Boton cuya funcionalidad es enviar una orden en este caso aceptar todo lo que le estas poniendo.
				botonConfirmar.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
						switch(arg0.getKeyChar()) {
						case KeyEvent.VK_ENTER:
							System.out.println("Intro presionado");
							
							p.setImagen(new BufferedImage(Integer.parseInt
									(ancho.getText()),Integer.parseInt
									(alto.getText()),BufferedImage.TYPE_INT_RGB),new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));


					
					
					
					thisRef.dispose();
					break;
				}
				
			}
		});
				
				botonConfirmar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						
						
						p.setImagen(new BufferedImage(Integer.parseInt
								(ancho.getText()),Integer.parseInt
								(alto.getText()),BufferedImage.TYPE_INT_RGB),new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
						
						thisRef.dispose();
				
			}
		});
		
		JButton btnPredeterminado = new JButton("Predeterminado");//Este boton hace que envie un lienzo ya creado, que el usuario no se moleste en rellenar nada
				btnPredeterminado.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						p.setImagen(new BufferedImage(450,300,BufferedImage.TYPE_INT_RGB),new Color(255,255,255));
					
						thisRef.dispose();
					}
				});
				GridBagConstraints gbc_btnPredeterminado = new GridBagConstraints();
				gbc_btnPredeterminado.insets = new Insets(0, 0, 5, 5);
				gbc_btnPredeterminado.gridx = 1;
				gbc_btnPredeterminado.gridy = 3;
				getContentPane().add(btnPredeterminado, gbc_btnPredeterminado);
		
		
		
				GridBagConstraints gbc_botonConfirmar = new GridBagConstraints();
				gbc_botonConfirmar.insets = new Insets(0, 0, 5, 5);
				gbc_botonConfirmar.gridx = 2;
				gbc_botonConfirmar.gridy = 3;
				getContentPane().add(botonConfirmar, gbc_botonConfirmar);
				
				JLabel labelRojo = new JLabel("0");//Label que recoge el valor del slider rojo
				GridBagConstraints gbc_labelRojo = new GridBagConstraints();
				gbc_labelRojo.insets = new Insets(0, 0, 5, 5);
				gbc_labelRojo.gridx = 4;
				gbc_labelRojo.gridy = 1;
				getContentPane().add(labelRojo, gbc_labelRojo);
				
				
				JLabel labelVerde = new JLabel("0");//Label que recoge el valor del slider verde
				GridBagConstraints gbc_labelVerde = new GridBagConstraints();
				gbc_labelVerde.insets = new Insets(0, 0, 5, 5);
				gbc_labelVerde.gridx = 4;
				gbc_labelVerde.gridy = 2;
				getContentPane().add(labelVerde, gbc_labelVerde);
				
				JLabel labelAzul = new JLabel("0");//Label que recoge el valor del slider azul
				GridBagConstraints gbc_labelAzul = new GridBagConstraints();
				gbc_labelAzul.insets = new Insets(0, 0, 5, 5);
				gbc_labelAzul.gridx = 4;
				gbc_labelAzul.gridy = 3;
				getContentPane().add(labelAzul, gbc_labelAzul);
		
		
		sliderRojo = new JSlider();//Slider que recoge y da el color rojo al lienzo
		GridBagConstraints gbc_sliderRojo = new GridBagConstraints();
		gbc_sliderRojo.insets = new Insets(0, 0, 5, 5);
		gbc_sliderRojo.gridx = 3;
		gbc_sliderRojo.gridy = 1;
		getContentPane().add(sliderRojo, gbc_sliderRojo);
		sliderRojo.setMaximum(255);
		sliderRojo.setValue(0);
		
		sliderRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
			botonColor.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			labelRojo.setText(sliderRojo.getValue()+"");
			labelRojo.setForeground(new Color(sliderRojo.getValue(),0,0));
			cambiaValorHex();
		}
			
	});
		
		
		
		sliderVerde = new JSlider();//Slider que recoge y da el color verde al lienzo
		GridBagConstraints gbc_sliderVerde = new GridBagConstraints();
		gbc_sliderVerde.insets = new Insets(0, 0, 5, 5);
		gbc_sliderVerde.gridx = 3;
		gbc_sliderVerde.gridy = 2;
		getContentPane().add(sliderVerde, gbc_sliderVerde);
		sliderVerde.setMaximum(255);
		sliderVerde.setValue(0);
		
		sliderVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				botonColor.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
				labelVerde.setText(sliderVerde.getValue()+"");
				labelVerde.setForeground(new Color(0,sliderVerde.getValue(),0));
				cambiaValorHex();
			}
		});
		
		
		sliderAzul = new JSlider();//Slider que recoge y da el color azul al lienzo
		GridBagConstraints gbc_sliderAzul = new GridBagConstraints();
		gbc_sliderAzul.insets = new Insets(0, 0, 5, 5);
		gbc_sliderAzul.gridx = 3;
		gbc_sliderAzul.gridy = 3;
		getContentPane().add(sliderAzul, gbc_sliderAzul);
		sliderAzul.setMaximum(255);
		sliderAzul.setValue(0);
		
		
		
		
		sliderAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			
			botonColor.setBackground(new Color(sliderRojo.getValue(),sliderVerde.getValue(),sliderAzul.getValue()));
			labelAzul.setText(sliderAzul.getValue()+"");
			labelAzul.setForeground(new Color(0,0,sliderAzul.getValue()));
			cambiaValorHex();
		}
	});
		
	}
	
		public void cambiaValorHex() {//Esta funcion crea un codigo hexadecimal a partir de los sliders.
		
			//Campo de texto hexadecimal.
			String hexRojo=Integer.toHexString(sliderRojo.getValue());
			String hexVerde=Integer.toHexString(sliderVerde.getValue());
			String hexAzul=Integer.toHexString(sliderAzul.getValue());
			valorHexa.setText("#"+hexRojo+hexVerde+hexAzul);
		
	}
		
		
}
