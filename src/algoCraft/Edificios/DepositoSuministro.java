package Edificios;

public class DepositoSuministro extends Edificio{ //Terran

	private boolean yaAumentoPoblacion;

	public DepositoSuministro(int x, int y){
		super(x, y);

		precioM= 100;
		precioG= 0;
		tiempoConstruccion= 6;
		vida= 500;
		nombre= "Deposito Suministro";
		
		yaAumentoPoblacion = false;
	}

	public boolean poblador() {
		return true;
	}

	public void pasarTurno() {
		if(!yaAumentoPoblacion) {
			jugador.aumentarPoblacionMax();
			yaAumentoPoblacion = true;
		}
	}

	public void realizarAccionMurio() {
		jugador.disminuirPoblacionMax();
	}

}
