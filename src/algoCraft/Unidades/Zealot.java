package Unidades;

import Edificios.Acceso;

public class Zealot extends UnidadProtoss { 

	public Zealot(int x, int y){
		super(x,y);

		transporte= 2;
		vision= 7;
		precioM= 100;
		precioG= 0;
		tiempoConstruccion= 4;
		danioA= 0;
		danioT= 8;
		suministro= 2;
		rangoA= 2;
		rangoT= 2;
		vida= 100; //No se entiendeuu
		nombre= "Zealot";
		tipo="Otro";
		edifNecesario.add(Acceso.class);
		escudo=60;
		escudoMax=60;
	}
	
}
