package Edificios;

public class Refineria extends Edificio{ //Terran

	public Refineria(int x, int y){
		super(x, y);

		precioM= 50;
		precioG= 0;
		tiempoConstruccion= 6;
		vida= 750;
		nombre= "Refineria";
	}
	public boolean gaseador() {
		return true;
	}

	public void pasarTurno() {
		jugador.modificarGas(10);
	}

}
