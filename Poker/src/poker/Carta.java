package poker;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carta extends JLabel {
	
	private ImageIcon cara, reverso;
	private int valor;
	private String palo, nombre;
	
	public Carta(int valor, String palo, String nombre, ImageIcon cara, ImageIcon reverso) {
		this.cara=cara;
		this.reverso=reverso;
		this.valor=valor;
		this.palo=palo;
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getValor() {
		return valor;
	}

	public String getPalo() {
		return palo;
	}
	
	public void setCara(int i) {
		if(i==0) {
			this.setIcon(reverso);
		}
		else {
			if(i==1) {
				this.setIcon(cara);
			}
		}
	}
}
