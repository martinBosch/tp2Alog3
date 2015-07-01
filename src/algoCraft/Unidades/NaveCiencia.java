package Unidades;

import java.awt.Rectangle;

import mapa.ObjetoMapa;
import Edificios.PuertoEstelarT;
import constantes.Constantes;

public class NaveCiencia extends Unidad{ //Terran

	private int energia;
	private int radioEMP;
	private ObjetoMapa atacadoRadiacion;

	public NaveCiencia(int x, int y){
		super(x,y);

		transporte= 0;
		vision= 10;
		precioM= 100;
		precioG= 225;
		tiempoConstruccion= 10;
		danioA= 0;
		danioT= 0;
		suministro= 2;
		rangoA= 5;
		rangoT= 5;
		vida= 200;
		nombre= "Nave Ciencia";
		tipo="Aereo";
		edifNecesario.add(PuertoEstelarT.class);

		energia = 50;
		radioEMP = 5 * Constantes.ANCHO_UNIDAD;
		atacadoRadiacion = null;
	}

	public boolean esUnidadMagica() {
		return true;
	}

	public int getEnergia() {
		return energia;
	}

	public void recibirDanioMagico() {
		this.energia = 0;
	}

	public void aumentarEnergia(){
		if (energia<=190){
			energia+=10;
		}
	}

	public void atacarConMagia(ObjetoMapa atacado, Iterable<ObjetoMapa> objetosEnMapa) {

		if(energia >= 100) {
			EMP(objetosEnMapa);
		}
		if(energia >= 75) {
			radiacion(atacado);
		}
	}


	public void EMP(Iterable<ObjetoMapa> objetosEnMapa) {
		Rectangle areaEMP = new Rectangle(x - radioEMP/2, y - radioEMP/2, radioEMP, radioEMP);

		for(ObjetoMapa objMapa : objetosEnMapa) {
			if( areaEMP.contains(objMapa.obtenerX(), objMapa.obtenerY()) && objMapa != this ) {
				objMapa.recibirDanioMagico();
			}
		}
		energia -= 100;
	}

	public void radiacion(ObjetoMapa atacado) {
		atacadoRadiacion = atacado;
		irradiar();
		energia -= 75;
	}

	public void irradiar() {
		if(atacadoRadiacion != null && !atacadoRadiacion.murio())
		{
			atacadoRadiacion.recibirDanio(10);
		}
	}

	public void pasarTurno() {
		super.pasarTurno();
		aumentarEnergia();
		irradiar();
	}

}
