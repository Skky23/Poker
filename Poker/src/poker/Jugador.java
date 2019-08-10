package poker;

public class Jugador {
	
	private Baraja cartasJugador;
	private int dinero;
	private int apuesta;
	private boolean subioApuesta;
	
	public Jugador() {
		cartasJugador = new Baraja();
		dinero = 200;
		apuesta=0;
		subioApuesta=false;
	}

	public int getDinero() {
		return dinero;
	}

	public Baraja getCartasJugador() {
		return cartasJugador;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
}
