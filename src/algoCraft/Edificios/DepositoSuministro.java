package Edificios;

public class DepositoSuministro extends Edificio{ //Terran
	
	public DepositoSuministro(int x, int y){
		super(x, y);

		precioM= 100;
		precioG= 0;
		tiempoConstruccion= 6;
		vida= 500;
		nombre= "Deposito Suministro";
	}

}
