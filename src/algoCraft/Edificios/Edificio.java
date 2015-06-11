package Edificios;

import java.util.ArrayList;

import mapa.ObjetoMapa;

@SuppressWarnings("rawtypes")
public abstract class Edificio extends ObjetoMapa {

	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected int vida;
	protected String nombre;
	protected ArrayList<Class> edifNecesario;
	protected int posX;
	protected int posY;

	public Edificio(int x, int y) {
		super(x,y);
		ancho = 64;// Constantes.ANCHO_EDIF
		alto = 32;// Constantes.ALTO_EDIF
		edifNecesario = new ArrayList<Class>();
	}

	public int getPrecioM() {
		return precioM;
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public int getPrecioG() {
		return precioG;
	}

	public int getVida() {
		return vida;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Class> getEdifNecesario() {
		return edifNecesario;
	}

	public void bajarVida(int vidaABajar) {
		if (this.vida > vidaABajar) {
			this.vida = this.vida - vidaABajar;
		} else {
			this.vida = 0;
		}
	}
}
