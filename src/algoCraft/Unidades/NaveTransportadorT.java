package Unidades;

import Edificios.PuertoEstelarT;

public class NaveTransportadorT extends Unidad { //Terran
	
	public NaveTransportadorT(){		
		transporte= 8; //Dice Capacidad. Imagino que debe ser esto
		vision= 8;
		precioM= 100;
		precioG= 100;
		tiempoConstruccion= 7;
		danioA= 0;
		danioT= 0;
		suministro= 2;
		rangoA= 0;
		rangoT= 0;
		vida= 150;
		nombre= "Nave Transportador";
		tipo="Aereo";
		edifNecesario.add(PuertoEstelarT.class);
	}
	
	
}
