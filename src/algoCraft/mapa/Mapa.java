package mapa;

import java.util.ArrayList;
import java.util.Iterator;

import mapa.celdas.Celda;
import mapa.celdas.Espacio;
import mapa.celdas.Tierra;
import recursos.GasVespeno;
import recursos.Minerales;
import recursos.Recurso;
import construcciones.Base;

public class Mapa {

	private static Mapa INSTANCE = null;

	private int ancho = 500;
	private int alto = 500;
	private Celda[][] tablero;
	private ArrayList<Base> bases;

	private Mapa() {
		this.bases = new ArrayList<Base>();
		this.tablero = new Celda[this.alto][this.ancho];
		this.cargarTablero();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Mapa();
		}
	}

	public static Mapa getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	private void cargarTablero() {
		this.cargarTableroTierrayEspacio();
		this.cargarBases();
		this.cargarRecursos();
	}

	private void cargarTableroTierrayEspacio() {
		this.cargarTableroEspacio();
		this.cargarTableroTierra();
	}

	private void cargarTableroEspacio() {
		for (int i = 0; i < this.ancho; i++) {
			for (int j = ((this.alto / 2) - 50); j < ((this.alto / 2) + 50); j++) {
				this.tablero[i][j] = new Espacio();
			}
		}
	}

	private void cargarTableroTierra() {
		for (int i = 0; i < this.ancho; i++) {
			for (int j = 0; j < this.alto; j++) {
				if (this.tablero[i][j] == null) {
					this.tablero[i][j] = new Tierra();
				}
			}
		}
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
		boolean celdaOcupada = true;
		while (celdaOcupada) {
			int x = base.obtenerCoordXCercana(this.ancho);
			int y = base.obtenerCoordYCercana(this.alto);
			Celda celda = this.tablero[x][y];
			celdaOcupada = celda.estaOcupado();
			if (!celdaOcupada) {
				celda.asignar(recurso);
			}
		}
	}

	private void cargarGasCercanoBase(Base base) {
		int x = base.obtenerCoordXCercana(this.ancho);
		int y = base.obtenerCoordYCercana(this.alto);

		this.cargarRecursoCercanoBase(base, new GasVespeno(x,y));
	}

	private void cargarMineralCercanoBase(Base base) {
		int x = base.obtenerCoordXCercana(this.ancho);
		int y = base.obtenerCoordYCercana(this.alto);

		this.cargarRecursoCercanoBase(base, new Minerales(x,y));
	}

	private void cargarBases() {
		// Se agrega una base en cada extremo del mapa.
		this.bases.add(new Base(0, 0, ancho / 4, alto / 4));
		this.bases.add(new Base(this.ancho - 1, this.alto - 1, ancho / 4,
				alto / 4));
		this.bases.add(new Base(0, this.alto - 1, ancho / 4, alto / 4));
		this.bases.add(new Base(this.ancho - 1, ancho / 4, alto / 4, 0));
	}

	public boolean fueraLimites(int coordX, int coordY) {
		return (coordX < 0 || coordX >= (this.ancho))
				|| (coordY < 0 || coordY >= (this.alto));
	}

}
