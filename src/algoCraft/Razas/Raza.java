package Razas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Unidades.Unidad;
import Edificios.Edificio;

public abstract class Raza {

	protected ArrayList<Class> listaEdificios;
	protected ArrayList<Class> listaUnidades;

	public Raza() {
		listaEdificios = new ArrayList();
		listaUnidades = new ArrayList();
	}

	public boolean verificarExistenciaDelEdificio(
			ArrayList<Edificio> listaDeEdificios,
			ArrayList<Class> edificiosAVerificar) {
		boolean existeElEdificio = false;
		if (edificiosAVerificar.size() == 0) {
			existeElEdificio = true;
		}
		if (!existeElEdificio) {
			Iterator<Edificio> iterador1 = listaDeEdificios.iterator();
			Iterator<Class> iterador2 = edificiosAVerificar.iterator();
			Class edificioAVerificar;
			while (iterador2.hasNext()) {
				existeElEdificio = false;
				edificioAVerificar = iterador2.next();
				while (iterador1.hasNext()) {
					if (iterador1.next().getClass() == edificioAVerificar) {
						existeElEdificio = true;
						break;
					}
				}
			}
		}
		return existeElEdificio;
	}

	public boolean crearEdificio(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, Edificio edificioAuxiliar) {
		boolean puede = false;

		if ((edificioAuxiliar.getPrecioG() <= gases)
				&& (edificioAuxiliar.getPrecioM() <= minerales)
				&& (verificarExistenciaDelEdificio(listaDeEdificios,
						edificioAuxiliar.getEdifNecesario()))
				&& (verificarEdificioEnRaza(edificioAuxiliar))) {
			puede = true;
		}
		return puede;
	};

	private boolean verificarUnidadEnRaza(Unidad uni) {
		boolean puede = false;
		Class c = uni.getClass();
		Iterator<Class> iterador = listaUnidades.iterator();
		while (iterador.hasNext()) {
			if (iterador.next() == c) {
				puede = true;
				break;
			}
		}
		return puede;
	}

	private boolean verificarEdificioEnRaza(Edificio edificio) {
		boolean puede = false;
		Class c = edificio.getClass();
		Iterator<Class> iterador = listaEdificios.iterator();
		while (iterador.hasNext()) {
			if (iterador.next() == c) {
				puede = true;
				break;
			}
		}
		return puede;
	}

	public boolean crearUnidad(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, Unidad unidadACrear) {
		boolean puede = false;
		
		if ((verificarCreacionUnidad(unidadACrear,
				listaDeEdificios, minerales,gases))
				&& (verificarUnidadEnRaza(unidadACrear))){
			puede = true;
		}

		return puede;
	};
	
	private boolean verificarCreacionUnidad(Unidad unidadAuxiliar,
			ArrayList<Edificio> listaDeEdificios, int minerales, int gases) {
		boolean EsPosibleCrear= (unidadAuxiliar.getPrecioG() <= gases)
				&& (unidadAuxiliar.getPrecioM() <= minerales)
				&& (verificarExistenciaDelEdificio(listaDeEdificios,
						unidadAuxiliar.getEdifNecesario()));
		return EsPosibleCrear;
	}

	/*
	 * public Edificio crearEdificio(int minerales ,int
	 * gases,ArrayList<Edificio> ListaDeEdificios,int num); public Unidad
	 * crearUnidad(int minerales, int gases, ArrayList<Edificio>
	 * ListaDeEdificios,int suministroDisponible, int num); public boolean
	 * verificarExistenciaDelEdificio( ArrayList<Edificio> listaDeEdificios,
	 * String EdificioAVerrificar);
	 */
}
