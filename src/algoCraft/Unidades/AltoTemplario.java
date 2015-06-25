package Unidades;

import java.util.ArrayList;

import Edificios.ArchivosTemplarios;
import Magias.TormentaPsionica;

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
	public int GetEnergia(){
		return energia;
	}
	public void AumentarEnergia(){
		if (energia<=185){
			energia=energia+15;
		}
	}
	public TormentaPsionica tormentaPsionica(int x ,int y,ArrayList<Unidad> listaDeUnidades){
		TormentaPsionica tormentaAux = null;
		if (energia>=75){
			tormentaAux = new TormentaPsionica(x, y,listaDeUnidades);
		}
		return tormentaAux;
	}
	@SuppressWarnings("rawtypes")
	public void Alucinacion(ArrayList<UnidadProtoss> listaUnidades,UnidadProtoss unidadAlucinante){
		UnidadCopia copiaUnidad;
		Class auxiliar = unidadAlucinante.getClass();
		int posicionX = unidadAlucinante.obtenerX();
		int posicionY = unidadAlucinante.obtenerY();
		for(int i=0;i<2;i++){
				copiaUnidad= new UnidadCopia(posicionX+10+i*10,posicionY,auxiliar,unidadAlucinante.getEscudoMax(),unidadAlucinante.getEscudo());
				listaUnidades.add(copiaUnidad);

		}
	}
	public void vaciarEnergia(){
		this.energia=0;
	}

}
