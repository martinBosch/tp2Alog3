package Razas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Edificios.Acceso;
import Edificios.ArchivosTemplarios;
import Edificios.Asimilador;
import Edificios.Barraca;
import Edificios.CentroMineral;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.Fabrica;
import Edificios.NexoMineral;
import Edificios.Pilon;
import Edificios.PuertoEstelarP;
import Edificios.PuertoEstelarT;
import Edificios.Refineria;
import Unidades.AltoTemplario;
import Unidades.Dragon;
import Unidades.Espectro;
import Unidades.Golliat;
import Unidades.Marine;
import Unidades.NaveCiencia;
import Unidades.NaveTransportadorP;
import Unidades.NaveTransportadorT;
import Unidades.Scout;
import Unidades.Unidad;
import Unidades.Zealot;

public class Protoss extends Raza{
	private ArrayList<Class> listaDeUnidades;
	private ArrayList<Class> listaDeEdificios;
	
	public Protoss(ArrayList<Class> listaEdificios,ArrayList<Class> listaUnidades){
		listaDeEdificios = listaEdificios;
		listaDeUnidades = listaUnidades;
	};
	

	
/*	public Edificio crearEdificio(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, int index) {
		Edificio edificio = null;// cambiar
		Edificio edificioAuxiliar;

		switch (index) {
		case (1):
			edificioAuxiliar = new NexoMineral();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (2):
			edificioAuxiliar = new Pilon();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (3):
			edificioAuxiliar = new Asimilador();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (4):
			edificioAuxiliar = new Acceso();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)) {
				edificio = edificioAuxiliar;
			}
			break;
		case (5):
			edificioAuxiliar = new PuertoEstelarP();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)
					&& (verificarExistenciaDelEdificio(listaDeEdificios,
							"Acceso"))) {
				edificio = edificioAuxiliar;
			}
			break;
		case (6):
			edificioAuxiliar = new ArchivosTemplarios();
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)
					&& (verificarExistenciaDelEdificio(listaDeEdificios,
							"Puerto Estelar"))) {
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
		switch (index) {
		case (1):
			unidadAuxiliar = new Zealot();
			if (verificarCreacionUnidad(unidadAuxiliar,"Acceso", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (2):
			unidadAuxiliar = new Dragon();
			if (verificarCreacionUnidad(unidadAuxiliar,"Acceso", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (3):
			unidadAuxiliar = new Scout();
			if (verificarCreacionUnidad(unidadAuxiliar,"Puerto Estelar", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (4):
			unidadAuxiliar = new AltoTemplario();
			if (verificarCreacionUnidad(unidadAuxiliar, "Puerto Estelar", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		case (5):
			unidadAuxiliar = new NaveTransportadorP();
			if (verificarCreacionUnidad(unidadAuxiliar, "Archivos Templarios", listaDeEdificios, minerales, gases, suministroDisponible)) {
				unidad = unidadAuxiliar;
			}
			break;
		}
		return unidad;
	}; */
	
}

