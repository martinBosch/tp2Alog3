package Jugador;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Asimilador;
import Edificios.CentroMineral;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.EdificioProtoss;
import Edificios.NexoMineral;
import Edificios.Pilon;
import Edificios.Refineria;
import Razas.Raza;
import Unidades.Unidad;
import Unidades.UnidadProtoss;

public class Jugador {

	enum razas {
		Protoss, Terran
	};

	private Raza raza;
	private int gases;
	private int minerales;
	private int poblacion;
	private int poblacionMax;
	private ArrayList<Edificio> listaDeEdificios;
	private ArrayList<Edificio> listaDeEdificiosACrear;
	private ArrayList<Unidad> listaDeUnidades;
	private ArrayList<Unidad> listaDeUnidadesACrear;

	public Jugador() {
		this.listaDeEdificios = new ArrayList<Edificio>();
		this.listaDeUnidades = new ArrayList<Unidad>();
		this.listaDeEdificiosACrear = new ArrayList<Edificio>();
		this.listaDeUnidadesACrear = new ArrayList<Unidad>();
		gases = 0;
		minerales = 200;
		poblacionMax = 5;
		poblacion = 0;
	}

	public void elegirRaza(Raza razaSet) {
		this.raza = razaSet;
	};

	public void modificarMineral(int mineralModificado) {
		this.minerales = this.minerales + mineralModificado;
	};

	public void modificarGas(int gasesModificado) {
		this.gases = this.gases + gasesModificado;
	};

	public int getPoblacionMax() {
		return this.poblacionMax;
	};

	public void aumentarPoblacionMax() {
		this.poblacionMax = this.poblacionMax + 5;
	};

	public void disminuirPoblacionMax() {
		this.poblacionMax = this.poblacionMax - 5;
	};

	public int getPoblacion() {
		return this.poblacion;
	};

	public void modificarPoblacion(int poblacionModificada) {
		this.poblacion = this.poblacion + poblacionModificada;
	};

	public void crearEdificio(Edificio edificioACrear) {
		boolean puede = this.raza.crearEdificio(this.minerales, this.gases,
				this.listaDeEdificios, edificioACrear);
		// Edificio pilon = new Pilon();
		// Edificio deposito = new DepositoSuministro();
		if (puede) {
			modificarGas(-edificioACrear.getPrecioG());
			modificarMineral(-edificioACrear.getPrecioM());
			this.listaDeEdificiosACrear.add(edificioACrear);
		}
	};

	public int getCantidadEdificios() {
		return listaDeEdificios.size();
	}

	public int getMinerales() {
		return minerales;
	}

	public int getGases() {
		return gases;
	}

	public void crearUnidad(Unidad unidadACrear) {
		if (unidadACrear.getSuministros() <= (this.poblacionMax - this.poblacion)) {
			boolean puede = this.raza.crearUnidad(this.minerales, this.gases,
					this.listaDeEdificios, unidadACrear);
			if (puede) {
				modificarGas(-unidadACrear.getPrecioG());
				modificarMineral(-unidadACrear.getPrecioM());
				modificarPoblacion(unidadACrear.getSuministros());
				this.listaDeUnidadesACrear.add(unidadACrear);
			}
		}
	}

	public void destruirEdificios() {
		Iterator<Edificio> iterator = this.listaDeEdificios.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			if (iterator.next().getVida() < 0) {
				this.listaDeEdificios.remove(i);
			}
		}
	}

	public void destruirUnidades() {
		Iterator<Unidad> iterator = this.listaDeUnidades.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			if (iterator.next().getVida() < 0) {
				this.listaDeUnidades.remove(i);
			}
		}
	}

	public int getCantidadUnidades() {
		return listaDeUnidades.size();
	}

	public void aumentoGasYMineralPorEdificios(Iterator<Edificio> iterator) {
		int numeroDeEdificiosMinerales = 0;
		int numeroDeEdificiosGases = 0;
		Edificio edificioAuxiliar;
		if (listaDeEdificios.size() != 0) {
			while (iterator.hasNext()) {
				edificioAuxiliar = iterator.next();
				if ((edificioAuxiliar.getClass() == CentroMineral.class)
						|| (edificioAuxiliar.getClass() == NexoMineral.class)) {
					numeroDeEdificiosMinerales++;
				}
				if ((edificioAuxiliar.getClass() == Refineria.class)
						|| (edificioAuxiliar.getClass() == Asimilador.class)) {
					numeroDeEdificiosGases++;
				}

			}
			this.minerales = this.minerales + (numeroDeEdificiosMinerales * 10);
			this.gases = this.gases + (numeroDeEdificiosGases * 10);
		}
	}

	public void DisminuirTiempoDeConstruccion() {
		int i;
		Edificio edificioAuxiiliar;
		Unidad unidadAuxiliar;
		for (i = 0; i < listaDeEdificiosACrear.size(); i++) {
			edificioAuxiiliar = this.listaDeEdificiosACrear.get(i);
			edificioAuxiiliar.bajarTiempoConstruccion();
			if (edificioAuxiiliar.getTiempoConstruccion() == 0) {
				if ((edificioAuxiiliar.getClass() == Pilon.class)
						|| (edificioAuxiiliar.getClass() == DepositoSuministro.class)) {
					aumentarPoblacionMax();
				}
				this.listaDeEdificios.add(edificioAuxiiliar);
				this.listaDeEdificiosACrear.remove(i);
			}
		}
		for (i = 0; i < listaDeUnidadesACrear.size(); i++) {
			unidadAuxiliar = this.listaDeUnidadesACrear.get(i);
			unidadAuxiliar.bajarTiempoConstruccion();
			if (unidadAuxiliar.getTiempoConstruccion() == 0) {
				this.listaDeUnidades.add(unidadAuxiliar);
				this.listaDeUnidadesACrear.remove(unidadAuxiliar);
			}
		}
	}

	private void RegenerarEscudosProtoss(Iterator<Edificio> iteratorEdificios,
			Iterator<Unidad> iteratorUnidades) {
		Edificio edificioAuxiliar;
		Unidad unidadAuxiliar;
		if (listaDeEdificios.size() != 0) {
			while (iteratorEdificios.hasNext()) {
				edificioAuxiliar = iteratorEdificios.next();
				if ((edificioAuxiliar.getClass().getSuperclass() == EdificioProtoss.class)) {
					((EdificioProtoss) edificioAuxiliar).recargarEscudo();
					;
				}
			}
		}
		if (listaDeUnidades.size() != 0) {
			while (iteratorUnidades.hasNext()) {
				unidadAuxiliar = iteratorUnidades.next();
				if ((unidadAuxiliar.getClass().getSuperclass() == UnidadProtoss.class)) {
					((UnidadProtoss) unidadAuxiliar).recargarEscudo();
					;
				}
			}
		}

	}
	
	private void aplicarRadiacion(Iterator<Unidad> iteratorUnidades){
		Unidad unidadAuxiliar;
		ArrayList<Unidad> unidadesAledanias;
		while (iteratorUnidades.hasNext()) {
			unidadAuxiliar = iteratorUnidades.next();
			if(unidadAuxiliar.getEstadoIrradiacion()){
				unidadesAledanias=VerificarUnidadesAledanias(unidadAuxiliar);
				irradiar(unidadesAledanias.iterator());
			}
		}
	}

	private void irradiar(Iterator<Unidad> unidadesAledanias) {
		Unidad unidadAuxiliar;
		while (unidadesAledanias.hasNext()) {
			unidadAuxiliar = unidadesAledanias.next();
			unidadAuxiliar.recibirDanio(10);
		}
		
	}

	private ArrayList<Unidad> VerificarUnidadesAledanias(Unidad unidad) {
		ArrayList<Unidad> ListaUnidadesAux=new ArrayList<Unidad>();
		Unidad unidadAuxiliar;
		Iterator<Unidad> iterador = this.listaDeUnidades.iterator();
		while (iterador.hasNext()) {
			unidadAuxiliar = iterador.next();
			if(unidadAuxiliar.distancia(unidad)<=1){
				ListaUnidadesAux.add(unidadAuxiliar);
			}
		}
		return ListaUnidadesAux;
	}

	public void pasarTurno() {
		aplicarRadiacion(this.listaDeUnidades.iterator());
		destruirUnidades();
		destruirEdificios();
		aumentoGasYMineralPorEdificios(this.listaDeEdificios.iterator());
		DisminuirTiempoDeConstruccion();
		RegenerarEscudosProtoss(this.listaDeEdificios.iterator(),
				this.listaDeUnidades.iterator());
	}

	public ArrayList<Unidad> getListaUnidades() {
		return this.listaDeUnidades;
	}

}
