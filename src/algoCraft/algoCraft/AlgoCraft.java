package algoCraft;

import mapa.Escenario;
import mapa.EscenarioBuilder;
import Jugador.Jugador;
import Razas.Raza;
import Razas.RazaBuilder;

public class AlgoCraft {

	private Escenario escenario;

	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugTurno;

	public AlgoCraft() {
		jugador1 = new Jugador();
		jugador1.setNombre("Jugador 1");
		jugador1.referenciar(this);

		jugador2 = new Jugador();
		jugador2.setNombre("Jugador 2");
		jugador2.referenciar(this);

		RazaBuilder raza = new RazaBuilder();
		jugador1.asignarRaza(raza.crearTerran());
		jugador2.asignarRaza(raza.crearProtoss());

		escenario = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jugador1, jugador2);
		jugTurno = jugador1;
	}

	public Jugador getOponente(Jugador jugador){
		Jugador jugAux;
		if (jugador==jugador1){
			jugAux= jugador2;
		} else {
			jugAux= jugador1;
		}
		return jugAux;
	}

	public void InicializarJugadores(Raza raza1, Raza raza2) {
		jugador1.asignarRaza(raza1);
		jugador2.asignarRaza(raza2);
	}

	public void PasarTurno() {
		jugTurno.pasarTurno();

		if (jugTurno == jugador1) {
			jugTurno = jugador2;
		} else {
			jugTurno = jugador1;
		}
	}

	public Escenario obtenerEscenario() {
		return escenario;
	}

	public Jugador obtenerJugadorTurno() {
		return jugTurno;
	}

	public Jugador obtenerJugadorContrario() {
		if (jugTurno == jugador1) {
			return jugador2;
		}
		return jugador1;
	}

	public Jugador obtenerJugador1() {
		return jugador1;
	}

	public Jugador obtenerJugador2() {
		return jugador2;
	}

}
