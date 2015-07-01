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
		nombreUnidades.add("NaveTransporteP");

		return nombreUnidades;
	}

	public ArrayList<String> obtenerRutaImagenUnidades() {
		ArrayList<String> RutaImagenUnidades = new ArrayList<String>();

		RutaImagenUnidades.add("objetosMapaVista/imagenes/ZealotBoton.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/DragonBoton.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/ScoutBoton.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/AltoTemplarioBoton.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/NaveTransportePBoton.png");

		return RutaImagenUnidades;
	}

	public ArrayList<String> obtenerNombreEdificios() {
		ArrayList<String> nombreEdificios = new ArrayList<String>();

		nombreEdificios.add("NexoMineral");
		nombreEdificios.add("Pilon");
		nombreEdificios.add("Asimilador");
		nombreEdificios.add("Acceso");
		nombreEdificios.add("PuertoEstelarP");
		nombreEdificios.add("ArchivosTemplarios");

		return nombreEdificios;
	}

	public ArrayList<String> obtenerRutaImagenEdificios() {
		ArrayList<String> RutaImagenEdificios = new ArrayList<String>();

		RutaImagenEdificios.add("objetosMapaVista/imagenes/NexoMineralBoton.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/PilonBoton.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/AsimiladorBoton.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/AccesoBoton.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/PuertoEstelarPBoton.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/ArchivosTemplariosBoton.png");

		return RutaImagenEdificios;
	}

}
