package Unidades;

import Edificios.ArchivosTemplarios;


public class AltoTemplario extends Unidad {
	
	private int energia;
	
	public AltoTemplario(){		
		transporte= 2;
		vision= 7;
		precioM= 50;
		precioG= 150;
		tiempoConstruccion= 7;
		danioA= 0;
		danioT= 0;
		suministro= 2;
		rangoA= 0;
		rangoT= 0;
		vida= 40;
		energia=50;
		nombre= "Alto Templario";
		tipo="Otro";
		edifNecesario.add(ArchivosTemplarios.class);
	}
	public void AumentarEnergia(){
		if (energia<=185){
			energia=energia+15;
		}
	}
	public void TormentaPsiónica(){
		if (energia>=75){
			
		}
	}
	public void Radiación(){
		if (energia>=100){
			
		}
	}
	
}
