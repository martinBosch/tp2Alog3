package Unidades;

import mapa.ObjetoMapa;

public abstract class Unidad extends ObjetoMapa {

	protected int transporte;
	protected int vision;
	protected int suministro;
	protected String tipo;
	
	protected int danioA;
	protected int danioT;
	protected int rangoA;
	protected int rangoT;


	public Unidad(int x, int y) {
		super(x,y);
		ancho = 32;// Constantes.ANCHO_UNIDAD
		alto = 32;// Constantes.ALTO_UNIDAD
	}

	public int getDanioA() {
		return danioA;
	}

	public int getDanioT() {
		return danioT;
	}

	public int getRangoA() {
		return rangoA;
	}

	public int getRangoT() {
		return rangoT;
	}

	public void construir() {
	}

	public int getVision() {
		return vision;
	};

	public int getSuministros() {
		return suministro;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void atacar(ObjetoMapa atacado) {
		//  1 rango de ataque equivale a dos celdas.
		if ( distancia(atacado) < rangoT * (32*2) ) {
			atacado.recibirDanio(danioT);
		}
	}

}
