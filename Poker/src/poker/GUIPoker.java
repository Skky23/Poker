package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GUIPoker extends JFrame {

	private JPanel panelComputador, panelJugador, zonaJuego, panelBotones, panelTextos, aux1, aux2, aux3, aux4;
	private JLabel titulo, computador, jugador, dinero, apuesta;
	private JButton iniciar, pasar, igualar, subir, retirarse, salir;
	private JTextArea dineroA, apuestaA;
	private Control control;
	private Escuchas escucha;
	private int apuesta1;
	
	public GUIPoker() {
		
		initGUI();
		this.setUndecorated(true);
		pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	public void initGUI() {
		
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		escucha = new Escuchas();
		
		//Parte norte de la ventana
		Font font = new Font(Font.SERIF,Font.BOLD+Font.ITALIC,25);
			
		titulo = new JLabel("POKER");
		titulo.setBackground(new Color(233,62,12));
		titulo.setOpaque(true);
		titulo.setFont(font);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=5;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		add(titulo,constraints);
		
		computador = new JLabel("Crupier");
		computador.setBackground(Color.LIGHT_GRAY);
		computador.setOpaque(true);
		computador.setFont(font);
		computador.setHorizontalAlignment(SwingConstants.CENTER);
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=5;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		add(computador,constraints);
		
		aux1 = new JPanel();
		aux1.setPreferredSize(new Dimension(1000,130));
		aux1.setBackground(new Color(102,51,0));
		aux1.setOpaque(true);
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridheight=1;
		constraints.gridwidth=3;
		add(aux1,constraints);
		
		panelComputador = new JPanel();
		panelComputador.setPreferredSize(new Dimension(400,130));
		panelComputador.setBackground(Color.WHITE);
		aux1.add(panelComputador);
		
		//Parte central de la ventana
		aux2 = new JPanel();
		aux2.setPreferredSize(new Dimension(150,200));
		aux2.setBackground(new Color(102,51,0));
		aux2.setOpaque(true);
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.gridheight=1;
		constraints.gridwidth=1;
		add(aux2,constraints);
		
		zonaJuego = new JPanel();
		zonaJuego.setPreferredSize(new Dimension(700,200));
		zonaJuego.setBackground(new Color(0,153,0));
		zonaJuego.setOpaque(true);
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(zonaJuego,constraints);
		
		aux3 = new JPanel();
		aux3.setPreferredSize(new Dimension(150,200));
		aux3.setBackground(new Color(102,51,0));
		aux3.setOpaque(true);
		constraints.gridx=2;
		constraints.gridy=3;
		constraints.gridheight=1;
		constraints.gridwidth=1;
		add(aux3,constraints);
		
		//Parte sur de la ventana 
		aux4 = new JPanel();
		aux4.setPreferredSize(new Dimension(1000,130));
		aux4.setBackground(new Color(102,51,0));
		aux4.setOpaque(true);
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.gridheight=1;
		constraints.gridwidth=3;
		add(aux4,constraints);
		
		panelJugador = new JPanel();
		panelJugador.setPreferredSize(new Dimension(400,130));
		panelComputador.setBackground(Color.WHITE);
		aux4.add(panelJugador);
		
		jugador = new JLabel("Jugador");
		jugador.setBackground(Color.LIGHT_GRAY);
		jugador.setOpaque(true);
		jugador.setFont(font);
		jugador.setHorizontalAlignment(SwingConstants.CENTER);
		constraints.gridx=0;
		constraints.gridy=5;
		constraints.gridwidth=5;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		add(jugador,constraints);		
		
		panelTextos = new JPanel();
		panelTextos.setPreferredSize(new Dimension(1000,35));
		
		dinero = new JLabel("Dinero:");
		panelTextos.add(dinero);
		
		dineroA = new JTextArea(1,9);
		dineroA.setPreferredSize(new Dimension(30,19));
		dineroA.setEditable(false);
		panelTextos.add(dineroA);
		
		apuesta = new JLabel("Apuesta de la mesa:");
		panelTextos.add(apuesta);
		
		apuestaA = new JTextArea(1,9);
		apuestaA.setPreferredSize(new Dimension(30,19));
		apuestaA.setEditable(false);
		panelTextos.add(apuestaA);
		
		constraints.gridx=0;
		constraints.gridy=6;
		constraints.gridwidth=3;
		add(panelTextos,constraints);
		
		panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(1000,35));
		
		iniciar = new JButton("Iniciar");
		iniciar.addActionListener(escucha);
		panelBotones.add(iniciar);
		
		pasar = new JButton("Pasar");
		pasar.addActionListener(escucha);
		pasar.setEnabled(false);
		panelBotones.add(pasar);
		/*
		igualar = new JButton("Igualar");
		igualar.addActionListener(escucha);
		igualar.setEnabled(false);
		panelBotones.add(igualar);
		*/
		subir = new JButton("Subir");
		subir.addActionListener(escucha);
		subir.setEnabled(false);
		panelBotones.add(subir);
		
		retirarse = new JButton("Retirarse");
		//retirarse.addActionListener(escucha);
		retirarse.setEnabled(false);
		panelBotones.add(retirarse);
		
		salir = new JButton("Salir");
		salir.addActionListener(escucha);
		panelBotones.add(salir);
	
		constraints.gridx=0;
		constraints.gridy=7;
		constraints.gridwidth=3;
		
		add(panelBotones,constraints);
		control = new Control();
	}
	
	public void setApuestaMesa() {
		control.apuestaMesa(apuesta1);
		dineroA.setText(Integer.toString(control.getJugador().getDinero()));
		apuestaA.setText(Integer.toString(control.getApuestaMesa()));
	}
	
	public void jugar() {
		if(control.getFase()==0) {
			control.faseReparto();
			for(int i=0;i<2;i++) {
				panelComputador.add(control.getComputador().getCartasJugador().obtenerCarta(i));
				panelJugador.add(control.getJugador().getCartasJugador().obtenerCarta(i));
			}
			setApuestaMesa();
			revalidate();
		}
		else {
			if(control.getFase()==1) {
				control.faseFlop();
				for(int i=0;i<3;i++) {
					zonaJuego.add(control.getCartasMesa().obtenerCarta(i));
				}
				setApuestaMesa();
				revalidate();
			}
			else {
				if(control.getFase()==2) {
					control.faseTurn();
					zonaJuego.add(control.getCartasMesa().obtenerCarta(3));
					setApuestaMesa();
					revalidate();
				}
				else {
					if(control.getFase()==3) {
						control.faseRiver();
						zonaJuego.add(control.getCartasMesa().obtenerCarta(4));
						setApuestaMesa();
						revalidate();
					}
				}
			}
		}
	}
	
	private class Escuchas implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==salir) {
				System.exit(0);
			}
			else {
				if(e.getSource()==iniciar) {
					apuesta1=Integer.parseInt(JOptionPane.showInputDialog("Tiene 200 dólares, introduzca el valor de su apuesta"));
					jugar();
					iniciar.setEnabled(false);
					pasar.setEnabled(true);
					subir.setEnabled(true);
				}
				else {
					if(e.getSource()==pasar) {
						jugar();						
					}
					else {
						if(e.getSource()==subir) {
							apuesta1=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el valor que desea agregar a su apuesta"));
							jugar();
						}
					}
				}
			}
		}
	}
}
