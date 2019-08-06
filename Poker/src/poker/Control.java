package poker;

import java.util.ArrayList;

public class Control {
	private Jugador jugador;
	private Jugador computador;
	private Baraja baraja, mesa;
	private int apuestaMesa;
	private int fase;
	
	public Control() {
		jugador = new Jugador();
		computador = new Jugador();
		baraja = new Baraja();
		mesa = new Baraja();
	}
	
	//Funcion que toma el valor de la mesa a partir del valor que haga el jugador
	public void apostar(int apuesta) {
		apuestaMesa = 2*apuesta;
		jugador.setDinero(apuesta);
		computador.setDinero(apuesta);
	}

	public int getApuestaMesa() {
		return apuestaMesa;
	}
	
	//Funcion que reparte dos cartas a cada jugador en la fase inicial de reparto
	public void faseReparto() {
		baraja.crearBaraja();
		baraja.revolverCartas();
		
		for(int i=50;i<52;i++) {
			jugador.getBarajaJugador().adicionarCarta(baraja.getCarta(i));
			baraja.eliminarCarta(i);
		}
		
		for(int i=48;i<50;i++) {
			computador.getBarajaJugador().adicionarCarta(baraja.getCarta(i));
			baraja.eliminarCarta(i);
		}
	}
	
	//Funcion que reparte 3 cartas a la mesa en la fase flop
	public void faseFlop() {
		for(int i=45;i<48;i++) {
			mesa.adicionarCarta(baraja.getCarta(i));
			baraja.eliminarCarta(i);
		}
	}
	
	//Funcion que reparte la 4ta y 5ta carta en su respectiva fase
	public void faseTurnRiver(int fase) {
		if(fase==4) {
			mesa.adicionarCarta(baraja.getCarta(44));
			baraja.eliminarCarta(44);
		}
		else {
			if(fase==5) {
				mesa.adicionarCarta(baraja.getCarta(43));
				baraja.eliminarCarta(43);
			}
		}
	}
	
	//Validacion Escalera Real de Color
	public boolean hayEscaleraRealDeColor(Baraja barajaEnJuego) {
		ArrayList<String> nombresCartas = new ArrayList<String>();
		ArrayList<String> palosCartas= new ArrayList<String>();
		boolean hayEscaleraRealDeColor = false;
		
		for(int i=0;i<7;i++) {
			nombresCartas.add(barajaEnJuego.getCarta(i).getNombre());
		}
		
		for(int i=0;i<7;i++) {
			palosCartas.add(barajaEnJuego.getCarta(i).getPalo());
		}
		
		if(nombresCartas.contains("10") && nombresCartas.contains("J") && nombresCartas.contains("Q") && nombresCartas.contains("K") && nombresCartas.contains("AS")) {
			if(palosCartas.get(0)==palosCartas.get(1) && palosCartas.get(0)==palosCartas.get(2) && palosCartas.get(0)==palosCartas.get(3)
					&& palosCartas.get(0)==palosCartas.get(4) && palosCartas.get(0)==palosCartas.get(5) && palosCartas.get(0)==palosCartas.get(6)  ) {
				hayEscaleraRealDeColor = true;
			}	
		}
		else {
			hayEscaleraRealDeColor = false;
		}
		return hayEscaleraRealDeColor;
	}
	
	
}



