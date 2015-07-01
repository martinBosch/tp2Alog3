package Unidades;

import java.awt.Rectangle;
import java.util.ArrayList;

import mapa.ObjetoMapa;
import Edificios.ArchivosTemplarios;
import Excepciones.ExcepcionEnergiaInsuficiente;
import constantes.Constantes;

public class AltoTemplario extends UnidadProtoss {

	private int energia;
	private int turnoTormenta;
	private int radioTormenta;
	private ArrayList<ObjetoMapa> objMapaAfectadoTormenta;

	public AltoTemplario(int x, int y) {
		super(x, y);

		transporte = 2;
		vision = 7;
		precioM = 50;
		precioG = 150;
		tiempoConstruccion = 7;
		danioA = 0;
		danioT = 0;
		suministro = 2;
		rangoA = 5;
		rangoT = 5;
		vida = 40;
		nombre = "Alto Templario";
		tipo = "Otro";
		edifNecesario.add(ArchivosTemplarios.class);
		escudo = 40;
		escudoMax = 40;

		energia = 50;
		radioTormenta = 5 * Constantes.ANCHO_UNIDAD;
		objMapaAfectadoTormenta = new ArrayList<ObjetoMapa>();
	}


	public boolean esUnidadMagica() {
		return true;
	}

	public void recibirDanioMagico() {
		this.energia = 0;
	}

	public int getEnergia() {
		return energia;
	}

	public void aumentarEnergia() {
		if (energia <= 185) {
			energia = energia + 15;
		}
	}

	public void atacarConMagia(ObjetoMapa atacado, Iterable<ObjetoMapa> objetosEnMapa) {
		if(energia >= 75) {
			tormentaPsionica(objetosEnMapa);
		}
	}


	public void tormentaPsionica (Iterable<ObjetoMapa> objetosEnMapa) {
		Rectangle areaTormenta = new Rectangle(x - radioTormenta/2, y - radioTormenta/2,
				radioTormenta, radioTormenta);

		for(ObjetoMapa objMapa : objetosEnMapa) {
			if( areaTormenta.contains(objMapa.obtenerX(), objMapa.obtenerY()) && objMapa != this) {
				objMapaAfectadoTormenta.add(objMapa);
			}
		}
		turnoTormenta = 2;
		objMapaAfectadoTormenta.clear();
		aplicarDanioTormenta();
		energia-=100;
	}

	public void aplicarDanioTormenta() {
		if(turnoTormenta>0) {
			for(ObjetoMapa objMapaAfectado : objMapaAfectadoTormenta) {
				objMapaAfectado.recibirDanio(10);
			}
			turnoTormenta-=1;
		}
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<Unidad> alucinacion(int posCopia1X, int posCopia1y,
			int posCopia2X, int posCopia2y, Iterable<Unidad> iterable,
			UnidadProtoss unidadAlucinante)throws ExcepcionEnergiaInsuficiente {
		if (energia >= 100) {
			UnidadCopia copiaUnidad;
			ArrayList<Unidad> listaAux = new ArrayList<Unidad>();
			Class auxiliar = unidadAlucinante.getClass();
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					copiaUnidad = new UnidadCopia(posCopia1X, posCopia1y,
							auxiliar, unidadAlucinante.getEscudoMax(),
							unidadAlucinante.getEscudo());
					listaAux.add(copiaUnidad);
				} else {
					copiaUnidad = new UnidadCopia(posCopia2X, posCopia2y,
							auxiliar, unidadAlucinante.getEscudoMax(),
							unidadAlucinante.getEscudo());
					listaAux.add(copiaUnidad);
				}
			}
			energia=energia-100;
			return listaAux;
		}
		else {
			throw new ExcepcionEnergiaInsuficiente();
			}
	}

	public void pasarTurno() {
		super.pasarTurno();
		aumentarEnergia();
		aplicarDanioTormenta();
	}

}
