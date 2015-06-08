package Razas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Edificios.Barraca;
import Edificios.CentroMineral;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.Fabrica;
import Edificios.PuertoEstelarT;
import Edificios.Refineria;
import Unidades.Espectro;
import Unidades.Golliat;
import Unidades.Marine;
import Unidades.NaveCiencia;
import Unidades.NaveTransportadorT;
import Unidades.Unidad;

public class Terran extends Raza {
	private ArrayList<Class> listaDeUnidades;
	private ArrayList<Class> listaDeEdificios;

	public Terran(ArrayList<Class> listaEdificios,ArrayList<Class> listaUnidades){
		listaDeEdificios = listaEdificios;
		listaDeUnidades = listaUnidades;
	};
	
	public Edificio crearEdificio(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, int index) {
		Edificio edificio = null;// cambiar
		Edificio edificioAuxiliar;

		switch (index) {
		case (1):
			edificioAuxiliar = new CentroMineral();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (2):
			edificioAuxiliar = new Barraca();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (3):
			edificioAuxiliar = new DepositoSuministro();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (4):
			edificioAuxiliar = new Refineria();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (5):
			edificioAuxiliar = new Fabrica();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)
					&& (verificarExistenciaDelEdificio(listaDeEdificios,
							"Barraca"))) {
				edificio = edificioAuxiliar;
			}
			break;
		case (6):
			edificioAuxiliar = new PuertoEstelarT();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)
					&& (verificarExistenciaDelEdificio(listaDeEdificios,
							"Fabrica"))) {
				edificio = edificioAuxiliar;
			}
			break;
		}
		return edificio;
	};

	public Unidad crearUnidad(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, int suministroDisponible, int index) {
		Unidad unidad = null;
		Unidad unidadAuxiliar;
		String edificioAuxiliar;
		switch (index) {
		case (1):
			unidadAuxiliar = new Marine();
			if (verificarCreacionUnidad(unidadAuxiliar,"Barraca", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (2):
			unidadAuxiliar = new Golliat();
			if (verificarCreacionUnidad(unidadAuxiliar,"Fabrica", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (3):
			unidadAuxiliar = new Espectro();
			if (verificarCreacionUnidad(unidadAuxiliar,"Puerto Estelar", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (4):
			unidadAuxiliar = new NaveCiencia();
			if (verificarCreacionUnidad(unidadAuxiliar, "Puerto Estelar", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (5):
			unidadAuxiliar = new NaveTransportadorT();
			if (verificarCreacionUnidad(unidadAuxiliar, "Puerto Estelar", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		}
		return unidad;
	};

	public boolean verificarExistenciaDelEdificio(
			ArrayList<Edificio> listaDeEdificios, String EdificioAVerrificar) {
		boolean existeElEdificio = false;
		Iterator<Edificio> iterador = listaDeEdificios.iterator();
		while (iterador.hasNext()) {
			if (iterador.next().getNombre() == EdificioAVerrificar) {
				existeElEdificio = true;
			}
		}
		return existeElEdificio;
	}

	private boolean verificarCreacionUnidad(Unidad unidadAuxiliar,
			String edificio, ArrayList<Edificio> listaDeEdificios,
			int minerales, int gases, int suministrosTotales) {
		boolean EsPosibleCrear;
		EsPosibleCrear = (unidadAuxiliar.getSuministros() <= suministrosTotales)
				&& (unidadAuxiliar.getPrecioG() <= gases)
				&& (unidadAuxiliar.getPrecioM() <= minerales)
		 && (verificarExistenciaDelEdificio(listaDeEdificios, edificio));
		return EsPosibleCrear;
	}
}
