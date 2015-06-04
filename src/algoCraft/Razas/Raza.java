package Razas;

import java.util.ArrayList;
import java.util.Collection;

import Unidades.Unidad;
import Edificios.Edificio;

public interface Raza {
	public Edificio crearEdificio(int minerales ,int gases,ArrayList<Edificio> ListaDeEdificios,int num);
	public Unidad crearUnidad(int minerales, int gases,
			ArrayList<Edificio> ListaDeEdificios,int suministroDisponible, int num);
	
}
