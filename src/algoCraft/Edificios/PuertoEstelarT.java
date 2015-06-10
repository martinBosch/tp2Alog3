package Edificios;

public class PuertoEstelarT extends Edificio { //Terran

	public PuertoEstelarT(){
		precioM= 150;
		precioG= 100;
		tiempoConstruccion= 10;
		vida= 1300;
		nombre= "Puerto Estelar";
		edifNecesario.add(Fabrica.class);
	}
	
	
}
