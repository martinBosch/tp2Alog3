package Unidades;

import Edificios.PuertoEstelarT;

public class Espectro extends Unidad { // Terran

	public Espectro(int x, int y) {
		super(x,y);

		transporte = 0;
		vision = 7;
		precioM = 150;
		precioG = 100;
		tiempoConstruccion = 8;
		danioA = 20;
		danioT = 8;
		suministro = 2;
		rangoA = 5;
		rangoT = 5;
		vida = 120;
		nombre = "Espectro";
		tipo = "Aereo";
		edifNecesario.add(PuertoEstelarT.class);
	}

}
