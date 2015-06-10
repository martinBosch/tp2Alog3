package Edificios;

import java.util.ArrayList;
public abstract class Edificio {
	
	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected int vida;
	protected String nombre;
	protected ArrayList<Class> edifNecesario;
	protected int posX;
	protected int posY;

	public Edificio() {
		edifNecesario = new ArrayList<Class>();
	}

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
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

	public void bajarTiempoConstruccion() {
		tiempoConstruccion--;
	}
}
