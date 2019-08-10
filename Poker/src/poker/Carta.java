package poker;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carta extends JLabel {
	
	private int valorCarta;
	private String palo;
	private String nombre;
	private ImageIcon imagenArriba;
	private ImageIcon imagenAbajo;
	
	
	public Carta(int valor, String paloCarta, String nombreCarta, ImageIcon arriba, ImageIcon abajo ) {
		this.valorCarta = valor;
		this.palo = paloCarta;
		this.nombre = nombreCarta;
		this.imagenArriba = arriba;
		this.imagenAbajo = abajo;
		
		setIcon(imagenArriba);
	}

	public int getValorCarta() {
		return valorCarta;
	}


	public String getPalo() {
		return palo;
	}


	public String getNombre() {
		return nombre;
	}
	
	
	public void voltearCartaArriba() {
		this.setIcon(imagenArriba);
	}
	
	
	public void voltearCartaAbajo() {
		this.setIcon(imagenAbajo);
	}
}
