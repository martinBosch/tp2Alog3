package construcciones;

import java.util.Random;

public class Base {
	
	private int posX;
	private int posY;
	private int perimetroCercanoX;
	private int perimetroCercanoY;


	public Base (int posicionX, int posicionY) {
		this.posX = posicionX;
		this.posY = posicionY;
		this.perimetroCercanoX = 35;
		this.perimetroCercanoY = 35;
	}

	private int obtenerCoordCercana(int limiteCoordMapa, int perimetroCercanoCoord, int coord) {
		int coordMin;
		int coordMax;
		coordMin = coord - perimetroCercanoCoord;
		if(coordMin  < 0) {
			coordMin = 0;
		}
		coordMax = coord + perimetroCercanoCoord;
		if(coordMax  > limiteCoordMapa) {
			coordMax = limiteCoordMapa-1;
		}
		return this.obtenerNumRandom(coordMin, coordMax);
	}

	public int obtenerCoordXCercana(int anchoMapa) {
		return this.obtenerCoordCercana(anchoMapa, this.perimetroCercanoX, this.posX);
	}

	public int obtenerCoordYCercana(int altoMapa) {
		return this.obtenerCoordCercana(altoMapa, this.perimetroCercanoY, this.posY);
	}

	private int obtenerNumRandom(int inicio, int fin) {
		 Random rnd = new Random();
		 return (int) (rnd.nextDouble() * (fin-inicio) + inicio);
	}
}


