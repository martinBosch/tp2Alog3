package mapa;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import construcciones.Base;

public class MapaLista {

	private static MapaLista INSTANCE = null;

	private int ancho;
	private int alto;

	private ArrayList<ObjetoMapa> objetosEnMapa;
	private ArrayList<Base> bases;

	public MapaLista(ArrayList<ObjetoMapa> objetosInicialesEnMapa,
			ArrayList<Base> basesInicialesEnMapa, int ancho, int alto){
		objetosEnMapa = objetosInicialesEnMapa;
		bases = basesInicialesEnMapa;
		this.ancho = ancho;
		this.alto = alto;
	}

//	private synchronized static void createInstance() {
//		if (INSTANCE == null) {
//			INSTANCE = new MapaLista();
//		}
//	}
//
//	public static MapaLista getInstance() {
//		if (INSTANCE == null)
//			createInstance();
//		return INSTANCE;
//	}

	private boolean posOcupada(Rectangle area1) {
		Iterator<ObjetoMapa> i = this.objetosEnMapa.iterator();
		while (i.hasNext()) {
			ObjetoMapa objeto2 = i.next();
			Rectangle area2 = objeto2.obtenerAreaOcupa();
			if (area1.intersects(area2)) {
				return true;
			}
		}
		return false;
	}

	public boolean fueraLimites(int coordX, int coordY) {
		return ( coordX < 0 || coordX >= (this.ancho) )
				|| ( coordY < 0 || coordY >= (this.alto) );
	}


}
