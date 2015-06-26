package vista.objetosMapaVista;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import mapa.Escenario;

public class EscenarioVista extends ObjetoMapaVista {

	public EscenarioVista(Escenario escenario) {
		super(escenario, "imagenes/escenario.jpg");
	}

	private void dibujarAreaVisible(Graphics2D g) {
		g.setColor(Color.RED);
		Rectangle areaChoque = ((Escenario)objMapa).obtenerAreaVisible();
		g.drawRect((int) areaChoque.getX(), (int) areaChoque.getY(),
				(int) areaChoque.getWidth(), (int) areaChoque.getHeight());
		g.setColor(Color.BLACK);
	}

}
