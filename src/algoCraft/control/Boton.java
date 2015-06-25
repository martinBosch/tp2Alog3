package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mapa.Escenario;
import vista.Panel;
import vista.objetosMapaVista.BarracaVista;
import vista.objetosMapaVista.MarineVista;
import Edificios.Barraca;
import Jugador.Jugador;
import Unidades.Marine;
import algoCraft.AlgoCraft;

public class Boton implements ActionListener {

	private Escenario escenario;
	private AlgoCraft juego;
	private Panel panel;

	public Boton(AlgoCraft juego, Panel panel) {
		this.juego = juego;
		this.escenario = juego.obtenerEscenario();
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {

		Jugador jugTurno = juego.obtenerJugadorTurno();
		String nombreBoton = (String) e.getActionCommand();

		switch(nombreBoton) {

			case("Marine"):
				Marine marine = new Marine(100, 100);
				if ( escenario.posOcupada(marine.obtenerAreaOcupa()) &&
						jugTurno.puedeCrearUnidad(marine)) {

					return;
				}
				boolean puedeCrearUnidad = jugTurno.crearUnidad(marine);
				if(puedeCrearUnidad) {
					escenario.agregar(marine);
					MarineVista marineVista = new MarineVista(marine);
					panel.agregarObjMapaVista(marineVista);
				}
				break;

			case("Barraca"):
				Barraca barraca = new Barraca(400, 400);
				if ( escenario.posOcupada(barraca.obtenerAreaOcupa()) &&
						jugTurno.puedeCrearEdificio(barraca)) {

					return;
				}
				boolean puedeCrearEdif = jugTurno.crearEdificio(200,200,barraca);
				System.out.println("puedeCrearEdif: " + puedeCrearEdif);
				if(puedeCrearEdif) {
					System.out.println("ESCENARIO1: " + escenario);
					escenario.agregar(barraca);
					BarracaVista barracaVista = new BarracaVista(barraca);
					panel.agregarObjMapaVista(barracaVista);
				}
				break;

			case("Pasar Turno"):
				juego.PasarTurno();
				panel.agregarBotones();


		}
		panel.repaint();

	}


}