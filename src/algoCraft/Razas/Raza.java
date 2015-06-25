package Razas;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Edificio;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralesInsuficientes;
import Unidades.Unidad;
import algoCraft.AlgoCraft;

@SuppressWarnings("rawtypes")
public abstract class Raza {

	protected ArrayList<Class> listaEdificios;
	protected ArrayList<Class> listaUnidades;

	public Raza() {
		listaEdificios = new ArrayList<Class>();
		listaUnidades = new ArrayList<Class>();
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
			ArrayList<Edificio> listaDeEdificios, Edificio edificioAuxiliar,AlgoCraft juego) throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		boolean puede = false;

		if ((edificioAuxiliar.getPrecioG() <= gases)
				&& (edificioAuxiliar.getPrecioM() <= minerales)
				&& (verificarExistenciaDelEdificio(listaDeEdificios,
						edificioAuxiliar.getEdifNecesario()))
				&& (verificarEdificioEnRaza(edificioAuxiliar))) {
			puede = true;
		}
		if (edificioAuxiliar.getPrecioG() > gases){
			throw new ExcepcionGasesInsuficientes();
		}
		if (edificioAuxiliar.getPrecioM() > minerales){
			throw new ExcepcionMineralesInsuficientes();
		}
		if(edificioAuxiliar.gaseador()){
			//CHEQUEUAR QUE SE ESTE CREANDO ARRIBA DE UN VOLCAN
		}
		if(edificioAuxiliar.minador()){
			//CHEQUEUAR QUE SE ESTE CREANDO ARRIBA DE UNA MINA
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
			ArrayList<Edificio> listaDeEdificios, Unidad unidadACrear)
					throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {

		boolean puede = false;

		if ((verificarCreacionUnidad(unidadACrear, listaDeEdificios, minerales,
				gases)) && (verificarUnidadEnRaza(unidadACrear))) {
			puede = true;
		}

		return puede;
	};

	private boolean verificarCreacionUnidad(Unidad unidadAuxiliar,
			ArrayList<Edificio> listaDeEdificios, int minerales, int gases)
					throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {

		boolean EsPosibleCrear = (unidadAuxiliar.getPrecioG() <= gases)
				&& (unidadAuxiliar.getPrecioM() <= minerales)
				&& (verificarExistenciaDelEdificio(listaDeEdificios,
						unidadAuxiliar.getEdifNecesario()));
		if(unidadAuxiliar.getPrecioG() > gases){
			throw new ExcepcionGasesInsuficientes();
		}
		if(unidadAuxiliar.getPrecioM() > minerales){
			throw new ExcepcionMineralesInsuficientes();
		}
		return EsPosibleCrear;
	}

	public abstract ArrayList<String> obtenerNombreUnidades();

	public abstract ArrayList<String> obtenerNombreEdificios();

	public abstract ArrayList<String> obtenerRutaImagenUnidades();

	public abstract ArrayList<String> obtenerRutaImagenEdificios();




}
