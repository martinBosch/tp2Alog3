package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mapa.Escenario;
import vista.Panel;
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

		panel.repintar();
//		escenario.moverNavesSeleccionadas(ratonX, ratonY, panel);
	}

	public void mousePressed(MouseEvent e) {
		int ratonX = e.getX();
		int ratonY = e.getY();

//		escenario.guardarPrimerCoordUnidSeleccionar(ratonX, ratonY);
	}

	public void mouseReleased(MouseEvent e) {
		int ratonX = e.getX();
		int ratonY = e.getY();

//		escenario.guardarSegCoordUnidSeleccionar(ratonX, ratonY);
//		escenario.guardarUnidSeleccionadas();
	}

}
