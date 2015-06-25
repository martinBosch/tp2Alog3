package Edificios;

import mapa.ObjetoMapa;

public abstract class Edificio extends ObjetoMapa {

	public Edificio(int x, int y) {
		super(x,y);
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
