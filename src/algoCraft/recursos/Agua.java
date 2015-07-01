package recursos;


public class Agua extends Recurso {

	public Agua(int x, int y, int anchoAgua, int altoAgua) {
		super(x, y);
		ancho = anchoAgua;
		alto = altoAgua;

		areaOcupa = crearAreaOcupa();
	}
}
