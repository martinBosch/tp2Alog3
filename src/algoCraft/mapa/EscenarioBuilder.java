package mapa;

import java.awt.Rectangle;
import java.util.ArrayList;

import recursos.Agua;
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

	private void cargarRecursos(Escenario escenario) {
		Minerales mineral1 = new Minerales(376,348,64,64);
		Minerales mineral2 = new Minerales(578,64,64,64);
		Minerales mineral3 = new Minerales(700,190,64,64);
		Minerales mineral4 = new Minerales(1276,410,64,64);
		Minerales mineral5 = new Minerales(1534,246,64,64);
		Minerales mineral6 = new Minerales(1788,632,64,64);
		Minerales mineral7 = new Minerales(2428,380,64,64);
		Minerales mineral8 = new Minerales(2694,252,64,64);
		Minerales mineral9 = new Minerales(3008,412,64,64);
		Minerales mineral10 = new Minerales(2492,2462,64,64);
		Minerales mineral11 = new Minerales(2296,2588,64,64);
		Minerales mineral12 = new Minerales(2430,2882,64,64);
		Minerales mineral13 = new Minerales(1528,2682,64,64);
		Minerales mineral14 = new Minerales(1400,1662,64,64);
		Minerales mineral15 = new Minerales(1662,2972,64,64);
		Minerales mineral16 = new Minerales(758,2492,64,64);
		Minerales mineral17 = new Minerales(758,2976,64,64);
		Minerales mineral18 = new Minerales(60,2880,64,64);
		GasVespeno gas1 = new GasVespeno(150,640,64,64);
		GasVespeno gas2 = new GasVespeno(1746,96,64,64);
		GasVespeno gas3 = new GasVespeno(2704,826,64,64);
		GasVespeno gas4 = new GasVespeno(2798,2332,64,64);
		GasVespeno gas5 = new GasVespeno(1488,2398,64,64);
		GasVespeno gas6 = new GasVespeno(396,2718,64,64);
	}
	
	private void cargarAgua(Escenario escenario) {
		Agua agua1 = new Agua(1985,0,1220,318);
		Agua agua2 = new Agua(1985,0,317,515);
		Agua agua3 = new Agua(1985,0,1013,311);
		Agua agua4 = new Agua(1985,0,253,157);
		Agua agua5 = new Agua(1985,0,1175,296);
	
		escenario.agregar(agua1);
		escenario.agregar(agua2);
		escenario.agregar(agua3);
		escenario.agregar(agua4);
		escenario.agregar(agua5);
	}
	
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

		this.cargarRecursoCercanoBase(base, new GasVespeno(x, y,64,64));
	}

	private void cargarMineralCercanoBase(Base base) {
		int x = base.obtenerCoordXCercana(this.ancho);
		int y = base.obtenerCoordYCercana(this.alto);

		this.cargarRecursoCercanoBase(base, new Minerales(x, y,64,64));
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
