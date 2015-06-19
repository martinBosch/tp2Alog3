package Edificios;

import mapa.ObjetoMapa;

public abstract class Edificio extends ObjetoMapa {

	public Edificio(int x, int y) {
		super(x,y);
		ancho = 64;// Constantes.ANCHO_EDIF
		alto = 32;// Constantes.ALTO_EDIF
	}

	public boolean minador() {
		return false;
	}
	public boolean gaseador() {
		return false;
	}
	public boolean poblador() {
		return false;
	}
}
