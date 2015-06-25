package mapa;

import java.awt.Rectangle;
import java.util.ArrayList;

import recursos.GasVespeno;
import recursos.Minerales;
import recursos.Recurso;
import vista.PanelAgregable;
import vista.objetosMapaVista.BaseVista;
import constantes.Constantes;
import construcciones.Base;

public class EscenarioBuilder {

	private static EscenarioBuilder INSTANCE = null;

	private int ancho;
	private int alto;

	private ArrayList<ObjetoMapa> objetosEnMapa;

	Escenario mapaLista;


	public EscenarioBuilder() {
		
		ancho = Constantes.ANCHO_ESCENARIO;
		alto = Constantes.ALTO_ESCENARIO;

		objetosEnMapa = new ArrayList<ObjetoMapa>();

		cargarTablero();
		mapaLista = new Escenario(objetosEnMapa);
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EscenarioBuilder();
		}
	}

	public static EscenarioBuilder getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	public Escenario obtenerEscenario() {
		return mapaLista;
	}

	public static void reiniciarEscenario() {
		INSTANCE = null;
	}

	private void cargarTablero() {
//		this.cargarRecursos();
	}

	public void cargarBases(PanelAgregable panel, Escenario escenario) {
		Base base1 = new Base(194, 208);
		Base base2 = new Base(2760, 2640);
		escenario.agregar(base1);
		escenario.agregar(base2);
		BaseVista base1Vista = new BaseVista(base1);
		BaseVista base2Vista = new BaseVista(base2);
		panel.agregarObjMapaVista(base1Vista);
		panel.agregarObjMapaVista(base2Vista);
	}

//	private void cargarRecursos() {
//		this.cargarRecursosCercaBases();
//	}

//	private void cargarRecursosCercaBases() {
//		for(Base base : bases) {
//			this.cargarGasCercanoBase(base);
//			this.cargarMineralCercanoBase(base);
//			this.cargarMineralCercanoBase(base);
//			this.cargarMineralCercanoBase(base);
//		}
//	}

	private void cargarRecursoCercanoBase(Base base, Recurso recurso) {
		boolean posOcupada = true;

		while (posOcupada) {
			int x = base.obtenerCoordXCercana(this.ancho);
			int y = base.obtenerCoordYCercana(this.alto);
			recurso.ubicar(x, y);
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

	private boolean posOcupada(Rectangle areaOcupaObjUbicar) {
		for(ObjetoMapa objetoEnMapa : objetosEnMapa) {
			Rectangle areaOcupaObjEnMapa = objetoEnMapa.obtenerAreaOcupa();
			if (areaOcupaObjUbicar.intersects(areaOcupaObjEnMapa)) {
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
