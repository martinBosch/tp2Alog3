package Jugador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Edificios.Edificio;
import Razas.Raza;
import Razas.Protoss;
import Razas.Terran;
import Unidades.Unidad;

import java.lang.System.*;

public class Jugador {

	enum razas {Protoss,Terran}; 
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

	public void elegirRaza(Raza razaSet){
		this.raza = razaSet;
	};
	
	public void modificarMineral(int mineralModificado){
		this.minerales= this.minerales + mineralModificado;
	};
	
	public void modificarGas(int gasesModificado){
		this.gases= this.gases + gasesModificado;
	};
	
	public int getPoblacionMax(){
		return this.poblacionMax;
	};
	
	
	public void aumentarPoblacionMax(){
		this.poblacionMax= this.poblacionMax + 5;
	};

	public void disminuirPoblacionMax(){
		this.poblacionMax= this.poblacionMax - 5;
	};
	
	public int getPoblacion(){
		return this.poblacion;
	};
	
	public void modificarPoblacion(int poblacionModificada){
		this.poblacion = this.poblacion + poblacionModificada;
	};

	
	public void crearEdificio(Edificio edificioACrear) {
		boolean puede = this.raza.crearEdificio(this.minerales, this.gases, this.listaDeEdificios, edificioACrear);
		if (puede) {
			if (((edificioACrear.getNombre() == "Pilon") || (edificioACrear
					.getNombre() == "Deposito Suministro"))) {
				aumentarPoblacionMax();
			}
			modificarGas(-edificioACrear.getPrecioG());
			modificarMineral(-edificioACrear.getPrecioM());
			this.listaDeEdificios.add(edificioACrear);
		}
	};
	
	public int getCantidadEdificios(){
		return listaDeEdificios.size();
	}
	
	public int getMinerales(){
		return minerales;
	}
	
	public int getGases(){
		return gases;	
	}
	
	public void crearUnidad(Unidad unidadACrear) {
		boolean puede = this.raza.crearUnidad(this.minerales, this.gases,
				this.listaDeEdificios, this.poblacionMax - this.poblacion, unidadACrear);
		if (puede) {
			modificarGas(-unidadACrear.getPrecioG());
			modificarMineral(-unidadACrear.getPrecioM());
			modificarPoblacion(unidadACrear.getSuministros());
			this.listaDeUnidades.add(unidadACrear);
			
		}
	};

	public void destruirEdificio(Edificio edificioAux){
		
	};
	
	public void destruirUnidad(Unidad unidadAux){
		
	};

}
