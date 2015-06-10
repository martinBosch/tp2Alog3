package Unidades;

import java.util.ArrayList;

import Edificios.Edificio;

@SuppressWarnings("rawtypes")
public abstract class Unidad {

	protected int posX;
	protected int posY;
	protected int transporte;
	protected int vision;
	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected int danioA;
	protected int danioT;
	protected int suministro;
	protected int rangoA;
	protected int rangoT;
	protected int vida;
	protected String nombre;
	protected ArrayList<Class> edifNecesario;
	protected String tipo;

	public Unidad() {
		edifNecesario = new ArrayList<Class>();
	}

	public String getNombre() {
		return nombre;
	}

	public void construir() {
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public int getPrecioM() {
		return precioM;
	}

	public int getVision() {
		return vision;
	};

	public int getPrecioG() {
		return precioG;
	}

	public int getSuministros() {
		return suministro;
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

	public int getVida() {
		return vida;
	}

	public ArrayList<Class> getEdifNecesario() {
		return edifNecesario;
	}

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void bajarVida(int vidaABajar) {
		if (this.vida > vidaABajar) {
			this.vida = this.vida - vidaABajar;
		} else {
			this.vida = 0;
		}
	}

	public void atacarEdificio(Edificio edificioAAtacar) {
		double DiferenciaPosicionX = Math.pow(
				this.getPosX() - edificioAAtacar.getPosX(), 2);
		double DiferenciaPosicionY = Math.pow(
				this.getPosY() - edificioAAtacar.getPosY(), 2);
		if (DiferenciaPosicionX + DiferenciaPosicionY <= Math.pow(
				this.getRangoT(), 2)) {
			edificioAAtacar.bajarVida(this.getDanioT());
		}
	}

	public void atacarUnidad(Unidad unidadAAtacar) {
		double DiferenciaPosicionX = Math.pow(
				this.getPosX() - unidadAAtacar.getPosX(), 2);
		double DiferenciaPosicionY = Math.pow(
				this.getPosY() - unidadAAtacar.getPosY(), 2);
		if (unidadAAtacar.getTipo() == "Aereo") {
			if (DiferenciaPosicionX + DiferenciaPosicionY <= Math.pow(
					this.getRangoA(), 2)) {
				unidadAAtacar.bajarVida(this.getDanioA());
			}
		} else {
			if (DiferenciaPosicionX + DiferenciaPosicionY <= Math.pow(
					this.getRangoT(), 2)) {
				unidadAAtacar.bajarVida(this.getDanioT());
			}
		}
	}
}
