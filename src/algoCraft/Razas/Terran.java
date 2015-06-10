package Razas;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Terran extends Raza {
	public Terran(ArrayList<Class> listaEdificios,
			ArrayList<Class> listaUnidades) {
		this.listaEdificios = new ArrayList<Class>(listaEdificios);
		this.listaUnidades = new ArrayList<Class>(listaUnidades);
	};

	/*
	 * public Edificio crearEdificio(int minerales, int gases,
	 * ArrayList<Edificio> listaDeEdificios, int index) { Edificio edificio =
	 * null;// cambiar Edificio edificioAuxiliar;
	 * 
	 * switch (index) { case (1): edificioAuxiliar = new CentroMineral(); if
	 * ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (2): edificioAuxiliar = new Barraca(); if
	 * ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (3): edificioAuxiliar = new
	 * DepositoSuministro(); if ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (4): edificioAuxiliar = new Refineria();
	 * if ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales)) { edificio =
	 * edificioAuxiliar; } break; case (5): edificioAuxiliar = new Fabrica(); if
	 * ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales) &&
	 * (verificarExistenciaDelEdificio(listaDeEdificios, "Barraca"))) { edificio
	 * = edificioAuxiliar; } break; case (6): edificioAuxiliar = new
	 * PuertoEstelarT(); if ((edificioAuxiliar.getPrecioG() <= gases) &&
	 * (edificioAuxiliar.getPrecioM() <= minerales) &&
	 * (verificarExistenciaDelEdificio(listaDeEdificios, "Fabrica"))) { edificio
	 * = edificioAuxiliar; } break; } return edificio; };
	 */

}
