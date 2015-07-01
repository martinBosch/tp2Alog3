package Edificios;

import mapa.ObjetoMapa;
import constantes.Constantes;

public abstract class Edificio extends ObjetoMapa {

	public Edificio(int x, int y) {
		super(x,y);
		
		ancho = Constantes.ANCHO_EDIFICIO;
		alto = Constantes.ALTO_EDIFICIO;

		areaOcupa = crearAreaOcupa();
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
