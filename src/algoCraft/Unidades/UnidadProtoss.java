package Unidades;

public class UnidadProtoss extends Unidad {

	protected int escudo;
	protected int escudoMax;
	boolean escudoDestruido;

	public UnidadProtoss(int x, int y) {
		super(x, y);

		this.escudoDestruido = false;
	}

	public int getEscudo() {
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

	public void recibirDanioMagico() {
		this.escudo=0;
	}
	
	public void EstablecerValoresDeCopia() {
		vida=0;
		danioA=0;
		danioT=0;
	}

	public int getEscudoMax() {
		return escudo;
	}

	public void pasarTurno() {
		recargarEscudo();
	}

}
