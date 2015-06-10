package Unidades;

import Edificios.Acceso;
import Edificios.Fabrica;

public class Golliat extends Unidad{ //Terran

	public Golliat(){		
		transporte= 2;
		vision= 8;
		precioM= 100;
		precioG= 50;
		tiempoConstruccion= 6;
		danioA= 10;
		danioT= 12;
		suministro= 2;
		rangoA= 5;
		rangoT= 6;
		vida= 125;
		nombre= "Golliat";
		edifNecesario.add(Fabrica.class);
	}
	
	
}

	
