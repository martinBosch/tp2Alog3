package algoCraft;

import mapa.Mapa;
import Jugador.Jugador;
import Razas.Raza;

public class AlgoCraft {

	Jugador Jugador1;
	Jugador Jugador2;
	Mapa mapa;
	int turnos;

	AlgoCraft() {
		Jugador1 = new Jugador();
		Jugador2 = new Jugador();
		Jugador1.referenciar(this);
		Jugador2.referenciar(this);
		Mapa.getInstance();
		turnos = 0;
	}
	
	public Jugador getOponente(Jugador jug){
		Jugador jugAux;
		if (jug==Jugador1){
			jugAux= Jugador2;
		} else {
			jugAux= Jugador1;
		}
		return jugAux;
	}
	
	void InicializarJugadores(Raza raza1, Raza raza2) {
		Jugador1.elegirRaza(raza1);
		Jugador2.elegirRaza(raza2);
	}

	void PasarTurnos() {
		if ((turnos % 2) == 0) {
			Jugador1.pasarTurno();
		} else {
			Jugador2.pasarTurno();
		}
	}
	

}
