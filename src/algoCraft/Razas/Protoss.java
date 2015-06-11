package Razas;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Protoss extends Raza {

	public Protoss(ArrayList<Class> listaEdificios, ArrayList<Class> listaUnidades) {
		this.listaEdificios = new ArrayList<Class>(listaEdificios);
		this.listaUnidades = new ArrayList<Class>(listaUnidades);
	};

	/*
	 * public Edificio crearEdificio(int minerales, int gases,
	 * ArrayList<Edificio> listaDeEdificios, int index) { Edificio edificio =
	 * null;// cambiar Edificio edificioAuxiliar;
	 * 
	 * switch (index) { case (1): edificioAuxiliar = new NexoMineral(); if
	 * ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (2): edificioAuxiliar = new Pilon(); if
	 * ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (3): edificioAuxiliar = new Asimilador();
	 * if ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (4): edificioAuxiliar = new Acceso(); if
	 * ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (5): edificioAuxiliar = new
	 * PuertoEstelarP(); if ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales) &&
	 * (verificarExistenciaDelEdificio(listaDeEdificios, "Acceso"))) { edificio
	 * = edificioAuxiliar; } break; case (6): edificioAuxiliar = new
	 * ArchivosTemplarios(); if ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales) &&
	 * (verificarExistenciaDelEdificio(listaDeEdificios, "Puerto Estelar"))) {
	 * edificio = edificioAuxiliar; } break; } return edificio; };
	 * 
	 * public Unidad crearUnidad(int minerales, int gases, ArrayList<Edificio>
	 * listaDeEdificios, int suministroDisponible, int index) { Unidad unidad =
	 * null; Unidad unidadAuxiliar; switch (index) { case (1): unidadAuxiliar =
	 * new Zealot(); if (verificarCreacionUnidad(unidadAuxiliar,"Acceso",
	 * listaDeEdificios, minerales, gases, suministroDisponible)) { unidad =
	 * unidadAuxiliar; } break; case (2): unidadAuxiliar = new Dragon(); if
	 * (verificarCreacionUnidad(unidadAuxiliar,"Acceso", listaDeEdificios,
	 * minerales, gases, suministroDisponible)) { unidad = unidadAuxiliar; }
	 * break; case (3): unidadAuxiliar = new Scout(); if
	 * (verificarCreacionUnidad(unidadAuxiliar,"Puerto Estelar",
	 * listaDeEdificios, minerales, gases, suministroDisponible)) { unidad =
	 * unidadAuxiliar; } break; case (4): unidadAuxiliar = new AltoTemplario();
	 * if (verificarCreacionUnidad(unidadAuxiliar, "Puerto Estelar",
	 * listaDeEdificios, minerales, gases, suministroDisponible)) { unidad =
	 * unidadAuxiliar; } break; case (5): unidadAuxiliar = new
	 * NaveTransportadorP(); if (verificarCreacionUnidad(unidadAuxiliar,
	 * "Archivos Templarios", listaDeEdificios, minerales, gases,
	 * suministroDisponible)) { unidad = unidadAuxiliar; } break; } return
	 * unidad; };
	 */

}
