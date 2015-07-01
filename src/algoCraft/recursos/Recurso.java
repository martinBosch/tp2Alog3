package recursos;

import mapa.ObjetoMapa;

public abstract class Recurso extends ObjetoMapa {

	public Recurso(int x, int y) {
		super(x, y);
	}

	public boolean tieneJugador() {
		return false;
	}

}
