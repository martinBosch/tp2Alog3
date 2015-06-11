package Unidades;

import Edificios.PuertoEstelarT;

public class NaveCiencia extends Unidad{ //Terran
	
	private int energia;
	
	public NaveCiencia(){		
		transporte= 0;
		vision= 10;
		precioM= 100;
		precioG= 225;
		tiempoConstruccion= 10;
		danioA= 0;
		danioT= 0;
		suministro= 2;
		rangoA= 0;
		rangoT= 0;
		vida= 200;
		energia=50;
		nombre= "Nave Ciencia";
		tipo="Aereo";
		edifNecesario.add(PuertoEstelarT.class);
	}
	public void AumentarEnergia(){
		if (energia<=185){
			energia=energia+15;
		}
	}
	public void EMP(){
		if (energia>=100){
			
		}
	}
	public void Radiación(){
		if (energia>=75){
			
		}
	}
	
	
	
}
