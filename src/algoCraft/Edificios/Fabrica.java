package Edificios;

public class Fabrica extends Edificio{ //Terran
	
	public Fabrica(){
		precioM= 200;
		precioG= 100;
		tiempoConstruccion= 12;
		vida= 1250;
		nombre= "Fabrica";
		edifNecesario.add(Barraca.class);
	}
	
}
