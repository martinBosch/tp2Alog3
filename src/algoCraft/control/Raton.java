package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mapa.Escenario;
import vista.Panel;

public class Raton extends MouseAdapter{

	private Escenario escenario;
	private Panel panel;


	public Raton(Escenario escenario, Panel panel) {
		this.escenario = escenario;
		this.panel = panel;
	}

	public void mouseClicked(MouseEvent e) {
		int ratonX = e.getX();
		int ratonY = e.getY();

		escenario.moverNavesSeleccionadas(ratonX, ratonY, panel);
	}

	public void mousePressed(MouseEvent e) {
		int ratonX = e.getX();
		int ratonY = e.getY();

		escenario.guardarPrimerCoordUnidSeleccionar(ratonX, ratonY);
	}

	public void mouseReleased(MouseEvent e) {
		int ratonX = e.getX();
		int ratonY = e.getY();

		escenario.guardarSegCoordUnidSeleccionar(ratonX, ratonY);
		escenario.guardarUnidSeleccionadas();
	}

}
