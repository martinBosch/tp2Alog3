package Unidades;

import java.util.ArrayList;

import Edificios.PuertoEstelarT;

public class NaveTransportadorT extends Unidad { //Terran
	private ArrayList<Unidad> unidadesTransportadas;
	int numeroAbordado;
	
	public NaveTransportadorT(int x, int y){
		super(x,y);
		this.numeroAbordado=0;
		unidadesTransportadas = new ArrayList<Unidad>();
		transporte= 8; //Dice Capacidad. Imagino que debe ser esto
		vision= 8;
		precioM= 100;
		precioG= 100;
		tiempoConstruccion= 7;
		danioA= 0;
		danioT= 0;
		suministro= 2;
		rangoA= 0;
		rangoT= 0;
		vida= 150;
		nombre= "Nave Transportador";
		tipo="Aereo";
		edifNecesario.add(PuertoEstelarT.class);
	}
	
	public void abordar(Unidad unidadAAbordar){
		if(unidadAAbordar.getSuministros()+this.numeroAbordado <= this.transporte){
			this.unidadesTransportadas.add(unidadAAbordar);
			this.numeroAbordado = this.numeroAbordado + unidadAAbordar.getSuministros();
		}
	}
	
	public Iterable<Unidad> desabordar(Unidad unidadAAbordar){
		this.numeroAbordado= 0;
		Iterable<Unidad> listaAux = (Iterable<Unidad>) unidadesTransportadas.clone();
			this.unidadesTransportadas =  new ArrayList<Unidad>();
		return listaAux;
	}
	
	public Iterable<Unidad> getListaAbordados(){
		Iterable<Unidad> listaAux = (Iterable<Unidad>) unidadesTransportadas;
		return listaAux;
	}
}
