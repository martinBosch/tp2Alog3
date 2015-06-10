package algoCraft;

import java.util.ArrayList;

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
		mapa.getInstance();
		turnos = 0;
	}

	void InicializarJugadores(Raza raza1,Raza raza2) {
		Jugador1.elegirRaza(raza1);
		Jugador2.elegirRaza(raza2);
	}

	void PasarTurnos(){
		if((turnos % 2)==0){
			Jugador1.pasarTurno();
		}else{
			Jugador2.pasarTurno();
		}
	}
}
