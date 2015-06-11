package Edificios;

public class Barraca extends Edificio{ //Terran
	
	public Barraca(int x, int y){
		super(x,y);

		precioM= 150;
		precioG= 0;
		tiempoConstruccion= 12;
		vida= 1000;
		nombre= "Barraca";
	}
	
}
