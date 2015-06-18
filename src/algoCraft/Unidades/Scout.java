package Unidades;

import Edificios.PuertoEstelarP;

public class Scout extends UnidadProtoss{

	public Scout(int x, int y){	
		super(x,y);

		transporte= 0;
		vision= 7;
		precioM= 300;
		precioG= 150;
		tiempoConstruccion= 9;
		danioA= 14;
		danioT= 8;
		suministro= 3;
		rangoA= 4;
		rangoT= 4;
		vida= 150; //No se entiende
		nombre= "Scout";
		tipo="Aereo";
		edifNecesario.add(PuertoEstelarP.class);
		escudo=100;
		escudoMax=100;
	}
	
}
