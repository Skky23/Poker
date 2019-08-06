package poker;

public class Jugador {
	
	private Baraja barajaJugador;
	private int dinero;
	
	
	public Jugador() {
		barajaJugador = new Baraja();
		dinero = 100000;
	}
	
	public int getDinero() {
		return dinero;
	}


	public void setDinero(int dinero) {
		this.dinero -= dinero;
	}


	public Baraja getBarajaJugador() {
		return barajaJugador;
	}

}
