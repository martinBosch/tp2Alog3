package Unidades;

import Edificios.PuertoEstelarP;

public class NaveTransportadorP extends UnidadProtoss{
	
	public NaveTransportadorP(int x, int y){
		super(x,y);

		transporte= 8; //Dice Capacidad. Imagino que debe ser esto
		vision= 8;
		precioM= 200;
		precioG= 0;
		tiempoConstruccion= 8;
		danioA= 0;
		danioT= 0;
		suministro= 2;
		rangoA= 0;
		rangoT= 0;
		vida= 80;
		nombre= "Nave Transportador";
		tipo="Aereo";
		edifNecesario.add(PuertoEstelarP.class);
		escudo=60;
		escudoMax=60;
	}
}
