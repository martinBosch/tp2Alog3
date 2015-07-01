package Unidades;

import java.util.ArrayList;

import Edificios.PuertoEstelarP;

public class NaveTransporteP extends UnidadProtoss{
		private ArrayList<Unidad> unidadesTransportadas;
		int numeroAbordado;
	
	public NaveTransporteP(int x, int y){
		super(x,y);
		this.numeroAbordado=0;
		unidadesTransportadas = new ArrayList<Unidad>();
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