package control;

import java.awt.event.ActionEvent;

import vista.Panel;
import algoCraft.AlgoCraft;

public class BotonPasarTurno extends Boton {

	public BotonPasarTurno(AlgoCraft juego, Panel panel) {
		super(juego, panel);
	}


	public void actionPerformed(ActionEvent e) {
		juego.PasarTurno();
		escenario.pasarTurno(juego.obtenerJugadorTurno());
		panel.pasarTurno();

		panel.repaint();
	}
}

