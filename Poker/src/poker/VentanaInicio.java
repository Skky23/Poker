package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame {

	private JPanel panel, panelBoton;
	private JButton jugar, salir;
	private Escuchas escucha;
	private JLabel imagenPoker;
	private ImageIcon imagen;
	private GUIPoker ventana;

	public VentanaInicio(){
		initGUI();
		this.setUndecorated(true);
		pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initGUI() {
		escucha = new Escuchas();
		
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		imagen = new ImageIcon("src/recursos/UPoker.png");
		imagenPoker = new JLabel();
		imagenPoker.setPreferredSize(new Dimension(700,500));
		imagenPoker.setIcon(imagen);
		
		panel = new JPanel();
		panel.add(imagenPoker);
		panel.setBackground(Color.white);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		add(panel,constraints);
		
		panelBoton = new JPanel();
		panelBoton.setBackground(new Color(116,0,19));
		panelBoton.setPreferredSize(new Dimension(700,35));
				
		jugar = new JButton("Jugar");
		jugar.addActionListener(escucha);
		panelBoton.add(jugar);
		
		salir = new JButton("Salir");
		salir.addActionListener(escucha);
		panelBoton.add(salir);
		
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=2;
		
		add(panelBoton,constraints);
		
	}
	
	public void cerrarVentana() {
		this.dispose();
	}
	
	private class Escuchas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==salir) {
				System.exit(0);
			}
			else {
				if(e.getSource()==jugar) {
					ventana = new GUIPoker();
					cerrarVentana();
				}
			}
		}
	}
}
