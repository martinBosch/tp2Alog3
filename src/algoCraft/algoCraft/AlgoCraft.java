package algoCraft;

import mapa.Escenario;
import mapa.EscenarioBuilder;
import mapa.ObjetoMapa;
import Jugador.Jugador;
import Razas.Raza;
import Razas.RazaBuilder;

public class AlgoCraft {

	private Jugador jugador1;
	private Jugador jugador2;
	private Escenario escenario;
	private Jugador jugTurno;

	public AlgoCraft() {
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		jugador1.referenciar(this);
		jugador2.referenciar(this);

		RazaBuilder raza = new RazaBuilder();
		jugador2.asignarRaza(raza.crearTerran());
		jugador1.asignarRaza(raza.crearProtoss());

		escenario = ( EscenarioBuilder.getInstance() ).obtenerEscenario();
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
	
	public Iterable<ObjetoMapa> obtenerListaObjetos() {
		return escenario.obtenerListaObjetos();
	}

	public Jugador obtenerJugadorTurno() {
		return jugTurno;
	}
	

}
