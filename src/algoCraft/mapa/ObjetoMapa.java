package mapa;

import java.awt.Rectangle;
import java.util.ArrayList;

import Jugador.Jugador;
import constantes.Constantes;
@SuppressWarnings("rawtypes")

public abstract class ObjetoMapa {

	protected String nombre;

	protected int x;
	protected int y;
	protected int dx;
	protected int dy;

	protected int ancho;
	protected int alto;

	protected Jugador jugador;

	protected Rectangle areaOcupa;
	protected int vida;
	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected ArrayList<Class> edifNecesario;


	public ObjetoMapa(int x, int y) {
		this.x = x;
		this.y = y;
		ancho = Constantes.ANCHO_UNIDAD;
		alto = Constantes.ALTO_UNIDAD;
		this.jugador= null;

		areaOcupa = crearAreaOcupa();

		edifNecesario = new ArrayList<Class>();
	}

	public Rectangle obtenerAreaOcupa() {
		actualizarAreaOcupa();
		return (Rectangle) areaOcupa.clone();
	}

	protected Rectangle crearAreaOcupa() {
		return new Rectangle(x, y, ancho, alto);
	}

	public void actualizarAreaOcupa() {
		areaOcupa.setLocation(x, y);
	}



	public boolean tieneVisibilidad() {
		return false;
	}
	
	public Rectangle obtenerAreaVisible() {
		return null;
	}

	public void actualizarAreaVisible() {
	}



	public void ubicar(int nuevoX, int nuevoY) {
	}

	public int obtenerX() {
		return x;
	}

	public int obtenerY() {
		return y;
	}

	public void mover() {
		x += dx;
		y += dy;
	}

	public void desplazar(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public int obtenerDesplazamientoX() {
		return dx;
	}

	public int obtenerDesplazamientoY() {
		return dy;
	}

	public boolean sePuedeDesplazarAlSelecionar() {
		return false;
	}

	public int obtenerAncho() {
		return ancho;
	}

	public int obtenerAlto() {
		return alto;
	}


	public int getSuministros() {
		return 0;
	}

	public int getVida() {
		return vida;
	}
	
	public int getEscudo() {
		return -1;
	}

	public int getEnergia() {
		return -1;
	}

	public boolean vive() {
		return tiempoConstruccion <= 0;
	}

	public boolean murio() {
		return vida <= 0;
	}

	public void realizarAccionMurio() {
	}

	public Iterable<Class> getEdifNecesario() {
		return edifNecesario;
	}
	
	public int getPrecioM() {
		return precioM;
	}

	public int getPrecioG() {
		return precioG;
	}

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void bajarTiempoConstruccion() {
		tiempoConstruccion-=1;
	}
		
	public void recibirDanio(int danio) {
		vida -= danio;
	}

	public void recibirDanioMagico() {
	}

	public int distancia(ObjetoMapa atacado) {
		int distX = x - atacado.obtenerX();
		int distY = y - atacado.obtenerY();

		return (int) Math.sqrt( distX*distX + distY*distY );
	}

	public void atacar(ObjetoMapa objMapa) {
	}

	public void atacarConMagia(ObjetoMapa atacado, Iterable<ObjetoMapa> objetosEnMapa) {
	}

	public boolean puedeAtacar() {
		return false;
	}

	public boolean esUnidadMagica() {
		return false;
	}


	public boolean dentroRangoAtaque(ObjetoMapa atacado) {
		return false;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public boolean esDeJugador(Jugador jugador) {
		return this.jugador == jugador;
	}

	public boolean tieneJugador() {
		return true;
	}

	public boolean estaEnPos(int posX, int posY) {
		return areaOcupa.contains(posX, posY);
	}

	public void pasarTurno() {
	}

}
