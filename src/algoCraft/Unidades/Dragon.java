package Unidades;

import Edificios.Acceso;

public class Dragon extends UnidadProtoss {

	public Dragon(int x, int y){
		super(x,y);

		transporte= 4;
		vision= 8;
		precioM= 125;
		precioG= 50;
		tiempoConstruccion= 6;
		danioA= 20;
		danioT= 20;
		suministro= 2;
		rangoA= 4;
		rangoT= 4;
		vida= 150; //No se entiende
		nombre= "Dragon";
		tipo="Otro";
		edifNecesario.add(Acceso.class);
		escudo=80;
		escudoMax=80;
	}
	
	
}
