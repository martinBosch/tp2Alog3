package recursos;

import mapa.ObjetoMapa;

public abstract class Recurso extends ObjetoMapa {

	public Recurso(int x, int y) {
		super(x, y);
		ancho = 64;// Constantes.ANCHO_RECURSO
		alto = 32;// Constantes.ALTO_RECURSO
	}

}
