package mapa;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import recursos.GasVespeno;
import recursos.Minerales;
import recursos.Recurso;
import construcciones.Base;

public class MapaListaBuilder {

	private static MapaListaBuilder INSTANCE = null;

	private int ancho = 6400;// ANCHO_MAPA
	private int alto = 6400;// ALTO_MAPA

	private ArrayList<ObjetoMapa> objetosEnMapa = new ArrayList<ObjetoMapa>();
	private ArrayList<Base> bases = new ArrayList<Base>();

	MapaLista mapaLista;

	
	public MapaListaBuilder() {
		objetosEnMapa = new ArrayList<ObjetoMapa>();
		bases = new ArrayList<Base>();

		this.cargarTablero();
		mapaLista = new MapaLista(objetosEnMapa, bases, ancho, alto);
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MapaListaBuilder();
		}
	}

	public static MapaListaBuilder getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	public MapaLista obtenerMapaLista() {
		return mapaLista;
	}
	
	public static void reiniciarMapaLista() {
		INSTANCE = null;
	}

	private void cargarTablero() {
		this.cargarBases();
		this.cargarRecursos();
	}

	private void cargarBases() {
		cargarBaseConCoordenadas(0, 0);
		cargarBaseConCoordenadas(this.ancho - 1, 0);
		cargarBaseConCoordenadas(0, this.alto - 1);
		cargarBaseConCoordenadas(this.ancho - 1, this.alto - 1);
	}

	private void cargarBaseConCoordenadas(int x, int y) {
		Base base = new Base(x, y, ancho / 4, alto / 4);
		this.bases.add(base);
		this.objetosEnMapa.add(base);
	}

	private void cargarRecursos() {
		this.cargarRecursosCercaBases();
	}

	private void cargarRecursosCercaBases() {
		Iterator<Base> i = this.bases.iterator();
		while (i.hasNext()) {
			Base base = i.next();
			this.cargarGasCercanoBase(base);
			this.cargarMineralCercanoBase(base);
			this.cargarMineralCercanoBase(base);
			this.cargarMineralCercanoBase(base);
		}
	}

	private void cargarRecursoCercanoBase(Base base, Recurso recurso) {
		boolean posOcupada = true;

		while (posOcupada) {
			int x = base.obtenerCoordXCercana(this.ancho);
			int y = base.obtenerCoordYCercana(this.alto);
			recurso.mover(x, y);
			posOcupada = this.posOcupada(recurso.obtenerAreaOcupa());
			if (!posOcupada) {
				objetosEnMapa.add(recurso);
			}
		}
	}

	private void cargarGasCercanoBase(Base base) {
		int x = base.obtenerCoordXCercana(this.ancho);
		int y = base.obtenerCoordYCercana(this.alto);

		this.cargarRecursoCercanoBase(base, new GasVespeno(x, y));
	}

	private void cargarMineralCercanoBase(Base base) {
		int x = base.obtenerCoordXCercana(this.ancho);
		int y = base.obtenerCoordYCercana(this.alto);

		this.cargarRecursoCercanoBase(base, new Minerales(x, y));
	}

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
		return (coordX < 0 || coordX >= (this.ancho))
				|| (coordY < 0 || coordY >= (this.alto));
	}

}
