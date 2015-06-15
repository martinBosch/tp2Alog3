package Unidades;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.PuertoEstelarT;

public class NaveCiencia extends Unidad{ //Terran
	
	private int energia;
	
	public NaveCiencia(int x, int y){
		super(x,y);

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
		if (energia<=190){
			energia=energia+10;
		}
	}

	public void EMP(ArrayList<Unidad> unidadesAfectadas) {
		Iterator<Unidad> iterator = unidadesAfectadas.iterator();
		Unidad unidadAModificar;
		while(iterator.hasNext()){
			unidadAModificar = iterator.next();
			if(unidadAModificar.getClass().getSuperclass()== UnidadProtoss.class){
				((UnidadProtoss) unidadAModificar).eliminarEscudo();
			}else{
				if((unidadAModificar.getClass()==AltoTemplario.class)||(unidadAModificar.getClass()==NaveCiencia.class)){
					((NaveCiencia) unidadAModificar).vaciarEnergia();
				}else{
					if((unidadAModificar.getClass()==AltoTemplario.class)){
						((AltoTemplario) unidadAModificar).vaciarEnergia();
					}
				}
			}
		}
		energia=energia-100;
	}

	public void Radiacion(Unidad unidadAfectada) {
		unidadAfectada.serIrradiada();
		energia=energia-75;
	}
	public void vaciarEnergia(){
		this.energia=0;
	}
	
	
	
}
