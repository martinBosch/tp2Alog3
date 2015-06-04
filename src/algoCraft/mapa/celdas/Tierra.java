package algoCraft.mapa.celdas;

public class Tierra extends Celda {

	public Tierra(){
		super();
	}

	public boolean asignar(Object objectoJuego) {
		if (!this.estaOcupado()) {
			this.contenido = objectoJuego;
			return true;
		}
		return false;
	}
}
