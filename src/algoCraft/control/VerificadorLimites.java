package control;

import java.awt.Rectangle;

import constantes.Constantes;

public class VerificadorLimites {

	public final Rectangle limiteVentanaDerecho = new Rectangle(
			Constantes.ANCHO_VENTANA - Constantes.LIMITE_BORDE_VENTANA, 0,
			Constantes.LIMITE_BORDE_VENTANA, Constantes.ALTO_VENTANA);

	public final Rectangle limiteVentanaAbajo = new Rectangle(
			0, Constantes.ALTO_VENTANA - Constantes.LIMITE_BORDE_VENTANA*4,
			Constantes.ANCHO_VENTANA, Constantes.LIMITE_BORDE_VENTANA);

	public final Rectangle limiteVentanaIzquierda = new Rectangle(
			0, 0, Constantes.LIMITE_BORDE_VENTANA, Constantes.ALTO_VENTANA);

	public final Rectangle limiteVentanaArriba = new Rectangle(
			0, 0, Constantes.ANCHO_VENTANA, Constantes.LIMITE_BORDE_VENTANA);

	private Rectangle limiteEscenarioDerecho;
	private Rectangle limiteEscenarioAbajo;
	private Rectangle limiteEscenarioIzquierdo;
	private Rectangle limiteEscenarioArriba;


	public VerificadorLimites() {

		limiteEscenarioDerecho = new Rectangle(
				Constantes.ANCHO_ESCENARIO - Constantes.LIMITE_BORDE_VENTANA, 0,
				Constantes.LIMITE_BORDE_ESCENARIO,
				Constantes.ALTO_ESCENARIO );

		limiteEscenarioAbajo = new Rectangle(
				0, Constantes.ALTO_ESCENARIO  - Constantes.LIMITE_BORDE_VENTANA,
				Constantes.ANCHO_ESCENARIO,
				Constantes.LIMITE_BORDE_ESCENARIO);

		limiteEscenarioIzquierdo = new Rectangle(
				0, 0, Constantes.LIMITE_BORDE_VENTANA,
				Constantes.ALTO_ESCENARIO);

		limiteEscenarioArriba = new Rectangle(
				0, 0,
				Constantes.ANCHO_ESCENARIO,
				Constantes.LIMITE_BORDE_VENTANA);
	}

	public void actualizarLimitesEscenario(int dxEscenario, int dyEscenario) {
		limiteEscenarioDerecho.translate(dxEscenario, dyEscenario);
		limiteEscenarioAbajo.translate(dxEscenario, dyEscenario);
		limiteEscenarioIzquierdo.translate(dxEscenario, dyEscenario);
		limiteEscenarioArriba.translate(dxEscenario, dyEscenario);
	}

	public boolean tocaLimiteVentanaDerecha(Rectangle limiteDeChoque) {
		return limiteVentanaDerecho.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteVentanaIzquierda(Rectangle limiteDeChoque) {
		return limiteVentanaIzquierda.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteVentanaArriba(Rectangle limiteDeChoque) {
		return limiteVentanaArriba.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteVentanaAbajo(Rectangle limiteDeChoque) {
		return limiteVentanaAbajo.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteEscenarioDerecha(Rectangle limiteDeChoque) {
		return limiteEscenarioDerecho.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteEscenarioIzquierda(Rectangle limiteDeChoque) {
		return limiteEscenarioIzquierdo.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteEscenarioArriba(Rectangle limiteDeChoque) {
		return limiteEscenarioArriba.intersects(limiteDeChoque);
	}

	public boolean tocaLimiteEscenarioAbajo(Rectangle limiteDeChoque) {
		return limiteEscenarioAbajo.intersects(limiteDeChoque);
	}
}
