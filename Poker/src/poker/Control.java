package poker;

import java.util.ArrayList;
import java.util.Random;

public class Control {
	private Jugador jugador, computador;
	private Baraja baraja, cartasMesa;
	private int apuestaMesa, fase;
	private Random aleatorio;
	
	public Control() {
		jugador = new Jugador();
		computador = new Jugador();
		baraja = new Baraja();
		cartasMesa = new Baraja();
		apuestaMesa = 0;
		fase = 0;
	}
	
	public int generarAleatorio(int rango) {
		aleatorio = new Random();
		int numero = aleatorio.nextInt(rango);
		return numero;
	}
	
	public boolean usada(int posicion) {
		boolean usada = false;
		
		if(jugador.getCartasJugador().contieneLaCarta(baraja.obtenerCarta(posicion)) || 
		   computador.getCartasJugador().contieneLaCarta(baraja.obtenerCarta(posicion)) ||
		   cartasMesa.contieneLaCarta(baraja.obtenerCarta(posicion))) {
			usada = true;
		}
		else {
			usada = false;
		}
		return usada;
	}
	
	public void apuestaMesa(int apuesta) {
		apuestaMesa = apuestaMesa + 2*apuesta;
		jugador.setApuesta(apuesta);
		jugador.setDinero(jugador.getDinero()-apuesta);
		computador.setApuesta(apuesta);
		computador.setDinero(computador.getDinero()-apuesta);
	}
	
	public void faseReparto() {
		baraja.crearBaraja();
		baraja.revolverCartas();
		
		for(int i=0;i<2;i++) {
			jugador.getCartasJugador().agregarCarta(baraja.obtenerCarta(i));
			computador.getCartasJugador().agregarCarta(baraja.obtenerCarta(i+2));
		}
		fase = 1;
	}
	
	public void faseFlop() {
		for(int i=4;i<9;i++) {
			cartasMesa.agregarCarta(baraja.obtenerCarta(i));
		}
		fase = 2;
	}
	
	public void faseTurn() {
		cartasMesa.agregarCarta(baraja.obtenerCarta(9));
		fase = 3;
	}
	
	public void faseRiver() {
		cartasMesa.agregarCarta(baraja.obtenerCarta(10));
		fase = 4;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public Jugador getComputador() {
		return computador;
	}

	public int getApuestaMesa() {
		return apuestaMesa;
	}
	
	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	public Baraja getCartasMesa() {
		return cartasMesa;
	}
	
/*
	public boolean hayEscalera(Baraja baraja) {
		boolean hayEscalera=false;
		ArrayList<String> nombresCartas = new ArrayList<String>();
		
		for(int i=0;i<7;i++) {
			nombresCartas.add(baraja.obtenerCarta(i).getNombre()); 
		}
		
		if(baraja.contieneLaCarta(carta)) {}else {}
		return hayEscalera;
	}
	
	public int hayEscaleraRealDeColor(Baraja barajaEnJuego) {
		
		
		int hayEscaleraRealDeColor=0;
		
		
		
		for(int i=0;i<7;i++) {
			palosCartas.add(barajaEnJuego.obtenerCarta(i).getPalo());
		}
		
		if(nombresCartas.contains("10") && nombresCartas.contains("J") && nombresCartas.contains("Q") && nombresCartas.contains("K") &&
			 nombresCartas.contains("AS")) { 
			  
			  if(palosCartas.get(0)==palosCartas.get(1) && palosCartas.get(0)==palosCartas.get(2) && palosCartas.get(0)==palosCartas.get(3) && 
			     palosCartas.get(0)==palosCartas.get(4) && palosCartas.get(0)==palosCartas.get(5) && palosCartas.get(0)==palosCartas.get(6) ) { 
				  hayEscaleraRealDeColor=10; 
			  }
		  }
		  else { 
			  hayEscaleraRealDeColor=0;
		  } 
		  return hayEscaleraRealDeColor; 
	  }
	  */
}



