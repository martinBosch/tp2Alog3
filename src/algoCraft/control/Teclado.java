package control;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import mapa.Escenario;
import vista.Panel;
import constantes.Constantes;

public class Teclado extends KeyAdapter implements KeyListener {

	private Escenario escenario;
	private JPanel panel;
	private VerificadorLimites limites;

	private long intervaloEjecucionEventos;


	public Teclado(Escenario escenario, Panel panel) {
		this.escenario = escenario;
		this.panel = panel;
		limites = new VerificadorLimites();

		intervaloEjecucionEventos = 0;
	}

	public void keyPressed(KeyEvent e) {
		// Controla que al mantener pulsada una tecla los
		// eventos que se llaman rapidamente se ejecuten todos.
		if(System.currentTimeMillis() - intervaloEjecucionEventos < 35) {
			return;
		}

		int idTecla = e.getKeyCode();

		int d = Constantes.DESPLAZAMIENTOESCENARIO;

		if (idTecla == KeyEvent.VK_LEFT) {

			if (! limites.tocaLimiteEscenarioIzquierda( limites.limiteVentanaIzquierda )) {

				escenario.desplazar(d, 0);
			}
			else {
				escenario.desplazar(0, 0);
			}
		}

		else if (idTecla == KeyEvent.VK_RIGHT) {

			if (! limites.tocaLimiteEscenarioDerecha( limites.limiteVentanaDerecho )) {

				escenario.desplazar(-d, 0);
			}
			else {
				escenario.desplazar(0, 0);
			}
		}

		else if (idTecla == KeyEvent.VK_UP) {

			if (! limites.tocaLimiteEscenarioArriba( limites.limiteVentanaArriba )) {

				escenario.desplazar(0, d);
			}
			else {
				escenario.desplazar(0, 0);
			}
		}

		else if (idTecla == KeyEvent.VK_DOWN) {

			if (! limites.tocaLimiteEscenarioAbajo( limites.limiteVentanaAbajo )) {

				escenario.desplazar(0, -d);
			}
			else {
				escenario.desplazar(0, 0);
			}
		}

		intervaloEjecucionEventos = System.currentTimeMillis();
		moverObjetosEscenario();
	}

	public void keyReleased(KeyEvent e) {
		escenario.desplazar(0, 0);
	}

	public void moverObjetosEscenario() {

		int dxEscenario = escenario.obtenerDesplazamientoX();
		int dyEscenario = escenario.obtenerDesplazamientoY();

		limites.actualizarLimitesEscenario(dxEscenario, dyEscenario);

		escenario.noAgregarVisionUnidades();
		escenario.mover();

		escenario.moverObjsEnMapa();

		panel.repaint();
	}

	public void dibujarLimites(Graphics2D g2) {
		limites.dibujar(g2);
	}

}
