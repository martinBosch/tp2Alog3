package mapa;

import java.util.ArrayList;

import recursos.Agua;
import recursos.GasVespeno;
import recursos.Minerales;
import vista.objetosMapaVista.BaseVista;
import vista.objetosMapaVista.ObjetoMapaVista;
import Jugador.Jugador;
import construcciones.Base;

public class EscenarioBuilder {

	private static EscenarioBuilder INSTANCE = null;

	private ArrayList<ObjetoMapa> objetosInicialesEnMapa;
	private ArrayList<ObjetoMapaVista> objetosVistaInicialesEnMapa;

	Escenario escenario;


	public EscenarioBuilder() {
		objetosInicialesEnMapa = new ArrayList<ObjetoMapa>();
		objetosVistaInicialesEnMapa = new ArrayList<ObjetoMapaVista>();
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

	public Escenario obtenerEscenario(Jugador jug1, Jugador jug2) {
		cargarTablero(jug1, jug2);
		escenario = new Escenario(objetosInicialesEnMapa);

		return escenario;
	}

	public static void reiniciarEscenario() {
		INSTANCE = null;
	}

	private void cargarTablero(Jugador jug1, Jugador jug2) {
		cargarBases(jug1, jug2);
		cargarRecursos();
		cargarAgua();
	}

	public void cargarBases(Jugador jug1, Jugador jug2) {
		Base base1 = new Base(175, 176);
		base1.setJugador(jug1);
		jug1.asignarBase(base1);
		Base base2 = new Base(2750, 2620);
		base2.setJugador(jug2);
		jug2.asignarBase(base2);

		objetosInicialesEnMapa.add(base1);
		objetosInicialesEnMapa.add(base2);

		BaseVista baseVista1 = new BaseVista(base1);
		objetosVistaInicialesEnMapa.add(baseVista1);
		BaseVista baseVista2 = new BaseVista(base2);
		objetosVistaInicialesEnMapa.add(baseVista2);
	}


	private void cargarRecursos() {
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
		Minerales mineral14 = new Minerales(1400,2940,64,64);
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
		
		objetosInicialesEnMapa.add(mineral1);
		objetosInicialesEnMapa.add(mineral2);
		objetosInicialesEnMapa.add(mineral3);
		objetosInicialesEnMapa.add(mineral4);
		objetosInicialesEnMapa.add(mineral5);
		objetosInicialesEnMapa.add(mineral6);
		objetosInicialesEnMapa.add(mineral7);
		objetosInicialesEnMapa.add(mineral8);
		objetosInicialesEnMapa.add(mineral9);
		objetosInicialesEnMapa.add(mineral10);
		objetosInicialesEnMapa.add(mineral11);
		objetosInicialesEnMapa.add(mineral12);
		objetosInicialesEnMapa.add(mineral13);
		objetosInicialesEnMapa.add(mineral14);
		objetosInicialesEnMapa.add(mineral15);
		objetosInicialesEnMapa.add(mineral16);
		objetosInicialesEnMapa.add(mineral17);
		objetosInicialesEnMapa.add(mineral18);

		objetosInicialesEnMapa.add(gas1);
		objetosInicialesEnMapa.add(gas2);
		objetosInicialesEnMapa.add(gas3);
		objetosInicialesEnMapa.add(gas4);
		objetosInicialesEnMapa.add(gas5);
		objetosInicialesEnMapa.add(gas6);
	}

	private void cargarAgua() {
		Agua agua1 = new Agua(1980,0,320,1215);
		Agua agua2 = new Agua(1470,900,830,320);
		Agua agua3 = new Agua(1470,900,320,1340);
		Agua agua4 = new Agua(1020,1985,770,258);
		Agua agua5 = new Agua(1020,1985,320,1175);

		objetosInicialesEnMapa.add(agua1);
		objetosInicialesEnMapa.add(agua2);
		objetosInicialesEnMapa.add(agua3);
		objetosInicialesEnMapa.add(agua4);
		objetosInicialesEnMapa.add(agua5);
	}

	public Iterable<ObjetoMapaVista> obtenerEscenarioVistasIniciales() {
		return objetosVistaInicialesEnMapa;
	}

}
