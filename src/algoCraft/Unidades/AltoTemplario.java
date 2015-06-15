package Unidades;

import Edificios.ArchivosTemplarios;

public class AltoTemplario extends UnidadProtoss {

	private int energia;
	
	public AltoTemplario(int x, int y){	
		super(x,y);

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
		escudo=40;
		escudoMax=40;
	}
	public void AumentarEnergia(){
		if (energia<=185){
			energia=energia+15;
		}
	}
	public void TormentaPsionica(){
		if (energia>=75){
			
		}
	}
	public void Radiacion(){
		if (energia>=100){
			
		}
	}

}
