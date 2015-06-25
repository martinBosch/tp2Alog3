package Razas;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Protoss extends Raza {


	public Protoss(ArrayList<Class> listaEdificios, ArrayList<Class> listaUnidades) {
		this.listaEdificios = new ArrayList<Class>(listaEdificios);
		this.listaUnidades = new ArrayList<Class>(listaUnidades);
	};


	public ArrayList<String> obtenerNombreUnidades() {
		ArrayList<String> nombreUnidades = new ArrayList<String>();

		nombreUnidades.add("Zealot");
		nombreUnidades.add("Dragon");
		nombreUnidades.add("Scout");
		nombreUnidades.add("AltoTemplario");
		nombreUnidades.add("NaveTransporte");

		return nombreUnidades;
	}

	public ArrayList<String> obtenerRutaImagenUnidades() {
		ArrayList<String> RutaImagenUnidades = new ArrayList<String>();

		RutaImagenUnidades.add("objetosMapaVista/imagenes/Zealot.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/Dragon.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/Scout.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/AltoTemplario.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/NaveTransporteP.png");

		return RutaImagenUnidades;
	}

	public ArrayList<String> obtenerNombreEdificios() {
		ArrayList<String> nombreEdificios = new ArrayList<String>();

		nombreEdificios.add("NexoMineral");
		nombreEdificios.add("Pilon");
		nombreEdificios.add("Asimilador");
		nombreEdificios.add("Acceso");
		nombreEdificios.add("PuertoEstelar");
		nombreEdificios.add("ArchivosTemplarios");

		return nombreEdificios;
	}

	public ArrayList<String> obtenerRutaImagenEdificios() {
		ArrayList<String> RutaImagenEdificios = new ArrayList<String>();

		RutaImagenEdificios.add("objetosMapaVista/imagenes/NexoMineral.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/Pilon.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/Asimilador.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/Acceso.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/PuertoEstelarP.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/ArchivosTemplarios.png");

		return RutaImagenEdificios;
	}





}
