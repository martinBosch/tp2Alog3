package Unidades;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
	public int GetEnergia(){
		return energia;
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
	@SuppressWarnings("unchecked")
	public void Alucinacion(ArrayList<UnidadProtoss> listaUnidades,UnidadProtoss unidadAlucinante){
		UnidadProtoss copiaUnidad;
		Class <UnidadProtoss> auxiliar = (Class<UnidadProtoss>) unidadAlucinante.getClass();
		int posicionX = unidadAlucinante.getPosX();
		int posicionY = unidadAlucinante.getPosY();
		@SuppressWarnings("rawtypes")
		Class [] paramTypesSub = {int.class,int.class};
		for(int i=0;i<2;i++){
			int [] paramValuesSub ={posicionX+i+1,posicionY+i+1};
			try {
				copiaUnidad= (auxiliar.getConstructor(paramTypesSub).newInstance(paramValuesSub));
				copiaUnidad.EstablecerValoresDeCopia();
				listaUnidades.add(copiaUnidad);
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				
				e.printStackTrace();
			}

		}
	}
	public void vaciarEnergia(){
		this.energia=0;
	}

}
