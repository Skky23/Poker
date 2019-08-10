package poker;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Baraja {

	private ArrayList<Carta> baraja;
	private Random aleatorio;
	
	public Baraja() {
		baraja = new ArrayList<Carta>();
		aleatorio = new Random();
	}
	
	public void crearBaraja() {
		
		for(int i=0;i<4;i++) {
			for(int j=1;j<14;j++) {
				agregarCarta(new Carta(valorCarta(j), nombrePalo(i), nombreCarta(j), new ImageIcon(caminoArchivo(i,j)), new ImageIcon("src/Corazones/14.png")));
			}
		}
	}
	
	private int valorCarta(int i) {
		int valor=0;
		
		switch(i) {
		case 11:
			valor = 10;
			break;
		case 12:
			valor = 10;
			break;
		case 13:
			valor = 10;
			break;
		default:
			valor = i;
			break;
		}
		return valor;
	}
	
	private String nombreCarta(int i) {
		String nombreCarta="";
		
		switch(i) {
		case 1:
			nombreCarta ="As";
			break;
		case 2:
			nombreCarta ="2";
			break;
		case 3:
			nombreCarta ="3";
			break;
		case 4:
			nombreCarta ="4";
			break;
		case 5:
			nombreCarta ="5";
			break;
		case 6:
			nombreCarta ="6";
			break;
		case 7:
			nombreCarta ="7";
			break;
		case 8:
			nombreCarta ="8";
			break;
		case 9:
			nombreCarta ="9";
			break;
		case 10:
			nombreCarta ="10";
			break;
		case 11:
			nombreCarta ="J";
			break;
		case 12:
			nombreCarta ="Q";
			break;
		case 13:
			nombreCarta ="K";
			break;
		}
		return nombreCarta;
	}
	
	private String nombrePalo(int i) {
		String nombrePalo="";
		
		switch(i) {
		case 0:
			nombrePalo ="Corazones";
			break;
		case 1:
			nombrePalo ="Diamantes";
			break;
		case 2:
			nombrePalo ="Picas";
			break;
		case 3:
			nombrePalo ="Treboles";
			break;
		}
		return nombrePalo;
	}
	
	private String caminoArchivo(int palo, int carta) {
		String camino="";
		
		switch(palo) {
		case 0:
			camino ="src/Corazones/"+Integer.toString(carta)+".png";
			break;
		case 1:
			camino ="src/Diamantes/"+Integer.toString(carta)+".png";
			break;
		case 2:
			camino ="src/Picas/"+Integer.toString(carta)+".png";
			break;
		case 3:
			camino ="src/Treboles/"+Integer.toString(carta)+".png";
			break;
		}
		return camino;
	}
	
	
	public void agregarCarta(Carta carta) {
		baraja.add(carta);
	}
	
	public void eliminarCarta(int i) {
		baraja.remove(i);
	}
	
	public Carta obtenerCarta(int posicion) {
		return baraja.get(posicion);
	}
	
	public int numeroCartas() {
		return baraja.size();
	}
	
	public boolean  contieneLaCarta(Carta carta) {
		boolean contieneLaCarta = false;
		
		if(baraja.contains(carta)) {
			contieneLaCarta = true;
		}
		return contieneLaCarta;
	}
	
	public void revolverCartas() {
		for(int i=0;i<52*52*52;i++) {
			int numero = aleatorio.nextInt(52);
			Carta cartaAux = obtenerCarta(numero);
			eliminarCarta(numero);
			agregarCarta(cartaAux);
		}
	}
}
