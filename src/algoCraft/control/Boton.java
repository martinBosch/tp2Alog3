package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mapa.Escenario;
import vista.Panel;
import vista.objetosMapaVista.MarineVista;
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

		Marine marine = new Marine(100, 100);
		Jugador jugTurno = juego.obtenerJugadorTurno();
		boolean puedeCrearUnidad = jugTurno.crearUnidad(marine);
		
		System.out.println("SE CREO: " + puedeCrearUnidad );

		if(puedeCrearUnidad) {
			escenario.agregar(marine);
	
			MarineVista marineVista = new MarineVista(marine);
			panel.agregarObjMapaVista(marineVista);
			
			panel.repaint();

		}
	}


}