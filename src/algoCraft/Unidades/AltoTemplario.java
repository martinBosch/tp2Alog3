package Unidades;

import java.util.ArrayList;

import Edificios.ArchivosTemplarios;
import Excepciones.ExcepcionEnergiaInsuficiente;
import Magias.TormentaPsionica;

public class AltoTemplario extends UnidadProtoss {

	private int energia;

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
		rangoA = 0;
		rangoT = 0;
		vida = 40;
		energia = 50;
		nombre = "Alto Templario";
		tipo = "Otro";
		edifNecesario.add(ArchivosTemplarios.class);
		escudo = 40;
		escudoMax = 40;
	}

	public int GetEnergia() {
		return energia;
	}

	public void AumentarEnergia() {
		if (energia <= 185) {
			energia = energia + 15;
		}
	}

	public TormentaPsionica tormentaPsionica(int x, int y,
			Iterable<Unidad> iterable)throws ExcepcionEnergiaInsuficiente {
		TormentaPsionica tormentaAux = null;
		if (energia >= 75) {
			tormentaAux = new TormentaPsionica(x, y, iterable);
			energia = energia - 75;
			return tormentaAux;
		}else{
			throw new ExcepcionEnergiaInsuficiente();
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

	public void vaciarEnergia(){
		this.energia=0;
	}

}
