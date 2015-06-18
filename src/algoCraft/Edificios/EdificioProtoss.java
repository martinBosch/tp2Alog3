package Edificios;

public class EdificioProtoss extends Edificio {

	protected int escudo;
	protected int escudoMax;
	boolean escudoDestruido;

	public EdificioProtoss(int x, int y) {
		super(x, y);
		this.escudoDestruido=false;
		ancho = 32;// Constantes.ANCHO_UNIDAD
		alto = 32;// Constantes.ALTO_UNIDAD
	}

	int getEscudo() {
		return this.escudo;
	}

	public void recibirDanio(int danio) {
		if (this.escudo < danio) {
			super.recibirDanio(danio - this.escudo);
			this.escudo = 0;
			this.escudoDestruido = true;
		} else {
			this.escudo = (this.escudo - danio);
		}
	}

	public void recargarEscudo() {
		if (!this.escudoDestruido) {
			this.escudo = this.escudoMax;
		}
	}
}
