package Razas;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public abstract class Raza {

	protected ArrayList<Class> listaEdificios;
	protected ArrayList<Class> listaUnidades;

	public Raza() {
		listaEdificios = new ArrayList<Class>();
		listaUnidades = new ArrayList<Class>();
	}

	public abstract ArrayList<String> obtenerNombreUnidades();

	public abstract ArrayList<String> obtenerNombreEdificios();

	public abstract ArrayList<String> obtenerRutaImagenUnidades();

	public abstract ArrayList<String> obtenerRutaImagenEdificios();

}
