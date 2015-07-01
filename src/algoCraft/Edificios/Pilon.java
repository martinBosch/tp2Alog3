package Edificios;

public class Pilon extends EdificioProtoss{ 

	private boolean yaAumentoPoblacion;

	public Pilon(int x, int y){
		super(x, y);

		precioM= 100;
		precioG= 0;
		tiempoConstruccion= 5;
		vida= 300;
		nombre= "Pilon";
		escudo=300;
		escudoMax=300;

		yaAumentoPoblacion = false;
	}

	public boolean poblador() {
		return true;
	}

	public void pasarTurno() {
		super.pasarTurno();
		if(!yaAumentoPoblacion) {
			jugador.aumentarPoblacionMax();
			yaAumentoPoblacion = true;
		}
	}

	public void realizarAccionMurio() {
		jugador.disminuirPoblacionMax();
	}

}
