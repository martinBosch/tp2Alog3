package Jugador;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import Edificios.Asimilador;
import Edificios.CentroMineral;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.NexoMineral;
import Edificios.Pilon;
import Edificios.Refineria;
import Razas.Raza;
import Unidades.Unidad;

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
	private ArrayList<Unidad> listaDeUnidades;

	public Jugador() {
		this.listaDeEdificios = new ArrayList<Edificio>();
		this.listaDeUnidades = new ArrayList<Unidad>();
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
		Edificio pilon = new Pilon();
		Edificio deposito = new DepositoSuministro();
		if (puede) {
			if ((edificioACrear.getClass() == pilon.getClass())
					|| (edificioACrear.getClass() == deposito.getClass())) {
				aumentarPoblacionMax();
			}
			modificarGas(-edificioACrear.getPrecioG());
			modificarMineral(-edificioACrear.getPrecioM());
			this.listaDeEdificios.add(edificioACrear);
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
				this.listaDeUnidades.add(unidadACrear);
			}
		}
	}

	public void destruirEdificios(){
		Iterator<Edificio> iterator = this.listaDeEdificios.iterator();
		int i=0;
		while (iterator.hasNext()) {
			i++;
			if (iterator.next().getVida()<0){
				this.listaDeEdificios.remove(i);
			}
		}
	}
	
	public void destruirUnidades(){
		Iterator<Unidad> iterator = this.listaDeUnidades.iterator();
		int i=0;
		while (iterator.hasNext()) {
			i++;
			if (iterator.next().getVida()<0){
				this.listaDeUnidades.remove(i);
			}
		}
	}

	public int getCantidadUnidades() {
		return listaDeUnidades.size();
	}

	public void pasarTurno() {
		Iterator<Edificio> iterator = this.listaDeEdificios.iterator();
		int numeroDeEdificiosMinerales = 0;
		int numeroDeEdificiosGases = 0;
		destruirUnidades();
		destruirEdificios();
		while (iterator.hasNext()) {
			if ((iterator.next().getClass() == CentroMineral.class)
					|| (iterator.next().getClass() == NexoMineral.class)) {
				numeroDeEdificiosMinerales++;
			}
			if ((iterator.next().getClass() == Refineria.class)
					|| ((iterator.next()).getClass() == Asimilador.class)) {
				numeroDeEdificiosGases++;
			}
		this.minerales=this.minerales+(numeroDeEdificiosMinerales*10);
		this.gases=this.gases+(numeroDeEdificiosGases*10);
		}
	}

}
