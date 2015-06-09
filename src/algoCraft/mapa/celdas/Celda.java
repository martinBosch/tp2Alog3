package mapa.celdas;

public abstract class Celda {

	protected Object contenido;

	protected Celda() {
		this.contenido = null;
	}
	
	public abstract boolean asignar(Object objectoJuego);
	
	public boolean estaOcupado() {
		return this.contenido != null;
	}

}
