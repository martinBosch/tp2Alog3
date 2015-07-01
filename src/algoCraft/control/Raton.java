package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mapa.Escenario;
import mapa.ObjetoMapa;
import vista.Panel;
import Jugador.Jugador;
import algoCraft.AlgoCraft;

public class Raton extends MouseAdapter{

	private AlgoCraft juego;
	private Escenario escenario;
	private Panel panel;


	public Raton(AlgoCraft juego, Panel panel) {
		this.juego = juego;
		this.escenario = juego.obtenerEscenario();
		this.panel = panel;
	}

	public void mouseClicked(MouseEvent e) {
		int ratonX = e.getX();
		int ratonY = e.getY();

		escenario.realizarAccionClick(ratonX, ratonY, juego.obtenerJugadorTurno());
		realizarAccionAtaque();

		panel.repintar();

		realizarAccionCrearEdificio();
	}

	public void realizarAccionAtaque() {
		if( escenario.seRealizoAtaque() ) {
			ObjetoMapa atacado = escenario.obtenerObjMapaContrarioSelecionado();
			ObjetoMapa atacante = escenario.obtenerObjMapaPropioSeleccionado();

			if(atacante.esUnidadMagica()) {
				panel.agregarAtaqueMagico(atacado);
			}
			else {
				panel.agregarAtaque(atacado);
			}

			devolverAtaque(atacante, atacado);

			if (atacado.murio()) {
				panel.agregarAtaque(atacado);
				panel.borrar(atacado);
				escenario.borrar(atacado);
				escenario.reiniciarObjMapaContrarioSeleccionado();
				Jugador jugContrario = juego.obtenerJugadorContrario();
				jugContrario.murioObjMapa(atacado);
			}
			if (atacante.murio()) {
				panel.agregarAtaque(atacante);
				panel.borrar(atacante);
				escenario.borrar(atacante);
				escenario.reiniciarObjMapaPropioSeleccionado();
				Jugador jugTurno = juego.obtenerJugadorTurno();
				jugTurno.murioObjMapa(atacante);
			}

		}
	}

	public void devolverAtaque(ObjetoMapa atacante, ObjetoMapa atacado) {
		escenario.devolverAtaque();
		if(atacado.puedeAtacar() && atacado.dentroRangoAtaque(atacante)) {
			if(atacado.esUnidadMagica()) {
				panel.agregarAtaqueMagico(atacante);
			}
			else {
				panel.agregarAtaque(atacante);
			}
		}
	}

	public void realizarAccionCrearEdificio() {
		if(escenario.seGuardoUbicacionEdificioAconstruir()) {
			panel.crearEdificioAconstruir();
			escenario.reiniciarUbicacionEdificioAconstruir();
		}
	}



}
