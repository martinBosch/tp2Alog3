package Edificios;

public class CentroMineral extends Edificio { // Terran

	public CentroMineral(int x, int y) {
		super(x, y);
		precioM = 50;
		precioG = 0;
		tiempoConstruccion = 4;
		vida = 500;
		nombre = "Centro de Mineral";
	}
	public boolean minador() {
		return true;
	}
}
