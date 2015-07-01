package Unidades;

import java.awt.Rectangle;

import mapa.ObjetoMapa;
import constantes.Constantes;

public abstract class Unidad extends ObjetoMapa {

	protected int vision;
	private Rectangle areaVisible;

	protected int transporte;
	protected int suministro;
	protected String tipo;
	protected int danioA;
	protected int danioT;
	protected int rangoA;
	protected int rangoT;
	protected boolean tieneRadiacion;
	protected boolean yaJugo;

	public Unidad(int x, int y) {
		super(x, y);

		areaVisible = crearAreaVisible();

		tieneRadiacion = false;
		yaJugo= false;
	}


	public Rectangle obtenerAreaVisible() {
		actualizarAreaVisible();
		return (Rectangle) areaVisible.clone();
	}

	private int obtenerXareaVision() {
		int anchoVision = vision * (Constantes.ANCHO_UNIDAD/2);
		int centro_nave_X = x + Constantes.ANCHO_UNIDAD / 2;
		int xVision = centro_nave_X - anchoVision / 2;
		return xVision;
	}

	private int obtenerYareaVision() {
		int anchoVision = vision * (Constantes.ALTO_UNIDAD/2);
		int centro_nave_Y = y + Constantes.ALTO_UNIDAD / 2;
		int yVision = centro_nave_Y - anchoVision / 2;
		return yVision;
	}

	private Rectangle crearAreaVisible() {
		int anchoVision = vision * (Constantes.ANCHO_UNIDAD);
		int altoVision = vision * (Constantes.ALTO_UNIDAD);
		
		int xVision = obtenerXareaVision();
		int yVision = obtenerYareaVision();

		return new Rectangle(xVision, yVision, anchoVision, altoVision);
	}

	public void actualizarAreaVisible() {
		int xVision = obtenerXareaVision();
		int yVision = obtenerYareaVision();

		areaVisible.setLocation(xVision, yVision);
	}

	public boolean tieneVisibilidad() {
		return true;
	}


	public boolean sePuedeDesplazarAlSelecionar() {
		return true;
	}

	public void ubicar(int nuevoX, int nuevoY) {
			x = nuevoX;
			y = nuevoY;

			actualizarAreaOcupa();
	}


	public int getDanioA() {
		return danioA;
	}
	
	public boolean getYaJugo() {
		return yaJugo;
	}

	public void YaJugo() {
		yaJugo=true;
	}
	
	public void reiniciarYaJugo() {
		yaJugo=false;
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
	}

	public int getSuministros() {
		return suministro;
	}

	public String getTipo() {
		return this.tipo;
	}

	public boolean dentroRangoAtaque(ObjetoMapa atacado) {
		return (distancia(atacado) < rangoT * Constantes.ANCHO_UNIDAD &&
				!this.esDeJugador( atacado.getJugador() ) );
	}

	public void atacar(ObjetoMapa atacado) {
		if (distancia(atacado) < rangoT * Constantes.ANCHO_UNIDAD &&
				!this.esDeJugador( atacado.getJugador() ) )
		{
			atacado.recibirDanio(danioT);
			this.YaJugo();
		}
	}

	public boolean puedeAtacar() {
		return true;
	}

	public boolean getEstadoIrradiacion(){
		return tieneRadiacion;
	}

	public void serIrradiada() {
		this.tieneRadiacion = true;

	}
}