package poker;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Baraja {
	private ArrayList<Carta> cartas;
	private Random aleatorio;
	public static final int numCartas = 52;
	public static final String [] palos = {"Corazones","Diamantes","Picas","Treboles"};
	
	public Baraja() {
		cartas = new ArrayList<Carta>();
		aleatorio = new Random();
	}

	public void adicionarCarta(Carta carta) {
		cartas.add(carta);
	}
	
	public Carta getCarta(int i) {
		return cartas.get(i);
	}
	
	public void eliminarCarta(int posicion) {
		cartas.remove(posicion);
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
	
	private String asignarRuta(int palo, int numero) {
		String ruta="";
		
		switch(palo) {
		case 0: ruta = "src/Corazones/"+Integer.toString(numero)+".png";
				break;
		
		case 1: ruta = "src/Diamantes/"+Integer.toString(numero)+".png";
				break;
				
		case 2: ruta = "src/Picas/"+Integer.toString(numero)+".png";
				break;
				
		case 3: ruta = "src/Treboles/"+Integer.toString(numero)+".png";
				break;
		}
		return ruta;
	}
	
	public void crearBaraja() {
		for(int i=0;i<4;i++) {
			for(int j=1;j<14;j++) {
				adicionarCarta(new Carta(j, palos[i], nombreCarta(j), new ImageIcon(asignarRuta(i,j)), new ImageIcon("src/Corazones/14.png")));
			}
		}
	}
	
	public void revolverCartas() {
		for(int i=0;i<numCartas*numCartas*numCartas;i++) {
			int numero = aleatorio.nextInt(numCartas)+1;
			Carta cartaAux = getCarta(numero);
			eliminarCarta(numero);
			adicionarCarta(cartaAux);
		}
	}
}
