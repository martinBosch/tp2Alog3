package vista.objetosMapaVista;

import java.awt.Color;
import java.awt.Graphics2D;

import Jugador.Jugador;

public class JugadorVista {

	private Jugador jugador;

	public JugadorVista(Jugador jugador) {
		this.jugador = jugador;
	}

	public void dibujarDatos(Graphics2D g, int altura) {
		g.setColor(Color.GREEN);
		g.drawString("NOMBRE: " + jugador.obtenerNombre(), altura, 20);
		g.drawString("GASES: " + jugador.getGases(), altura, 35);
		g.drawString("MINERALES: " + jugador.getMinerales(), altura, 50);
		g.drawString("POBLACION: " + jugador.getPoblacion(), altura, 65);
		g.drawString("LIMITE POBLACION: " + jugador.getPoblacionMax(), altura, 80);
		g.setColor(Color.BLACK);
	}

}
