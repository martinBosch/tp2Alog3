package construcciones;

import java.util.Random;

import Edificios.Edificio;

public class Base extends Edificio {

	private int perimetroCercanoX;
	private int perimetroCercanoY;

	public Base(int x, int y, int perimetroCercanoX, int perimetroCercanoY) {
		super(x,y);
		this.perimetroCercanoX = perimetroCercanoX;
		this.perimetroCercanoY = perimetroCercanoY;
	}
	
	public Base(int x, int y) {
		super(x,y);
	}

	private int obtenerCoordCercana(int limiteCoordMapa,
			int perimetroCercanoCoord, int coord) {
		int coordMin;
		int coordMax;
		coordMin = coord - perimetroCercanoCoord;
		if (coordMin < 0) {
			coordMin = 0;
		}
		coordMax = coord + perimetroCercanoCoord;
		if (coordMax > limiteCoordMapa) {
			coordMax = limiteCoordMapa - 1;
		}
		return this.obtenerNumRandom(coordMin, coordMax);
	}

	public int obtenerCoordXCercana(int anchoMapa) {
		return this.obtenerCoordCercana(anchoMapa, this.perimetroCercanoX,
				this.x);
	}

	public int obtenerCoordYCercana(int altoMapa) {
		return this.obtenerCoordCercana(altoMapa, this.perimetroCercanoY,
				this.y);
	}

	private int obtenerNumRandom(int inicio, int fin) {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * (fin - inicio) + inicio);
	}
}
