package Edificios;

import mapa.ObjetoMapa;

public abstract class Edificio extends ObjetoMapa {

	public Edificio(int x, int y) {
		super(x,y);
		ancho = 64;// Constantes.ANCHO_EDIF
		alto = 32;// Constantes.ALTO_EDIF
	}

}
