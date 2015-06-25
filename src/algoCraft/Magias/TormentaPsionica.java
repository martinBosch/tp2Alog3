package Magias;

import java.util.ArrayList;
import java.util.Iterator;

import Unidades.Unidad;

public class TormentaPsionica {
	
	int posX;
	int posY;
	
	int radio;
	int turnosDeVida;
	int danio;
	ArrayList<Unidad> listaDeUnidadesOtroJugador;
	
	public TormentaPsionica(int x,int y,ArrayList<Unidad> listaDeUnidades){
		posX=x;
		posY=y;
		radio=3;
		turnosDeVida=2;
		danio=100;
		this.listaDeUnidadesOtroJugador= listaDeUnidades;
	}
	
	public void PasarTurno(){
		turnosDeVida--;
		InflingirDanio(this.listaDeUnidadesOtroJugador);
	}
	
	public ArrayList<Unidad> InflingirDanio(ArrayList<Unidad> ListaUnidades){
		Iterator<Unidad> iterador = ListaUnidades.iterator();
		Unidad UnidadAux;
		int y;
		int x;
		while(iterador.hasNext()){
			UnidadAux = iterador.next();
			x = posX - UnidadAux.obtenerX();
			y = posY - UnidadAux.obtenerY();

			if(radio<=(int) Math.sqrt( x*x + y*y )){
				UnidadAux.recibirDanio(danio);
			}
		}
		return ListaUnidades;
	}
}
