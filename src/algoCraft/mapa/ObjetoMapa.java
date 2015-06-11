package mapa;

import java.awt.Rectangle;

public abstract class ObjetoMapa {

	protected int posX;
	protected int posY;
	protected int ancho;
	protected int alto;

	public ObjetoMapa(int x, int y) {
		posX = x;
		posY = y;
	}

	public Rectangle obtenerAreaOcupa() {
		return new Rectangle(posX, posY, ancho, alto);
	}

	public void mover(int x, int y) {
		posX = x;
		posY = y;
	}
}
