package Edificios;

public class Asimilador extends EdificioProtoss { // Protoss

	public Asimilador(int x, int y) {
		super(x,y);

		precioM = 100;
		precioG = 0;
		tiempoConstruccion = 6;
		vida = 450; // NO SE ENTIENDE
		nombre = "Asimilador";
		escudo=450;
		escudoMax=450;

	}
	public boolean gaseador() {
		return true;
	}
}
