package Edificios;

public class NexoMineral extends EdificioProtoss{ //Protoss

	public NexoMineral(int x, int y){
		super(x, y);

		precioM= 50;
		precioG= 0;
		tiempoConstruccion= 4;
		vida= 250; //NO SE ENTIENDE
		nombre= "Nexo Mineral";
		escudo=250;
		escudoMax=250;
	}

	public boolean minador() {
		return true;
	}

	public void pasarTurno() {
		super.pasarTurno();
		jugador.modificarMineral(10);
	}

}
