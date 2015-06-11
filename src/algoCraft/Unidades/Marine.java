package Unidades;

import Edificios.Barraca;

public class Marine extends Unidad{ //Terran

	public Marine(int x, int y){
		super(x,y);

		vida= 40;
		transporte= 1;
		vision= 7;
		precioM= 50;
		precioG= 0;
		tiempoConstruccion= 3;
		danioA= 6;
		danioT= 6;
		suministro= 1;
		rangoA= 4;
		rangoT= 4;
		nombre= "Marine";
		tipo="Otro";
		edifNecesario.add(Barraca.class);
	}
	
	
}
