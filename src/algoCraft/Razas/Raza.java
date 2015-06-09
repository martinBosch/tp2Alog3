package Razas;

import java.util.ArrayList;
import java.util.Collection;

import Unidades.Unidad;
import Edificios.Edificio;

public abstract class Raza {

	protected ArrayList<Class> listaEdificios;
	protected ArrayList<Class> listaUnidades;
	
	public Raza() {
		listaEdificios = new ArrayList();
		listaUnidades = new ArrayList();
	};
	public void agregarEdificio(Class c){
		listaEdificios.add(c);
	};
	public void agregarUnidad(Class c){
		listaUnidades.add(c);
	};
	
/*	public Edificio crearEdificio(int minerales ,int gases,ArrayList<Edificio> ListaDeEdificios,int num);
	public Unidad crearUnidad(int minerales, int gases,
			ArrayList<Edificio> ListaDeEdificios,int suministroDisponible, int num);
	public boolean verificarExistenciaDelEdificio(
			ArrayList<Edificio> listaDeEdificios, String EdificioAVerrificar);

	*/
}
