package Razas;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Terran extends Raza {


	public Terran(ArrayList<Class> listaEdificios,
			ArrayList<Class> listaUnidades) {
		this.listaEdificios = new ArrayList<Class>(listaEdificios);
		this.listaUnidades = new ArrayList<Class>(listaUnidades);
	};


	public ArrayList<String> obtenerNombreUnidades() {
		ArrayList<String> nombreUnidades = new ArrayList<String>();

		nombreUnidades.add("Marine");
		nombreUnidades.add("Golliat");
		nombreUnidades.add("Espectro");
		nombreUnidades.add("NaveCiencia");
		nombreUnidades.add("NaveTransporte");
		
		return nombreUnidades;
	}

	public ArrayList<String> obtenerRutaImagenUnidades() {
		ArrayList<String> RutaImagenUnidades = new ArrayList<String>();

		RutaImagenUnidades.add("objetosMapaVista/imagenes/Marine.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/Golliat.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/Espectro.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/NaveCiencia.png");
		RutaImagenUnidades.add("objetosMapaVista/imagenes/NaveTransporteT.png");

		return RutaImagenUnidades;
	}

	public ArrayList<String> obtenerNombreEdificios() {
		ArrayList<String> nombreEdificios = new ArrayList<String>();

		nombreEdificios.add("CentroMineral");
		nombreEdificios.add("Barraca");
		nombreEdificios.add("DepositoSuministro");
		nombreEdificios.add("Refineria");
		nombreEdificios.add("Fabrica");
		nombreEdificios.add("PuertoEstelar");

		return nombreEdificios;
	}

	public ArrayList<String> obtenerRutaImagenEdificios() {
		ArrayList<String> RutaImagenEdificios = new ArrayList<String>();

		RutaImagenEdificios.add("objetosMapaVista/imagenes/CentroMineral.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/Barraca.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/DepositoSuministro.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/Refineria.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/Fabrica.png");
		RutaImagenEdificios.add("objetosMapaVista/imagenes/PuertoEstelarT.png");

		return RutaImagenEdificios;
	}


}
