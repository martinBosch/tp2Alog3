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
	Iterable<Unidad> listaDeUnidadesOtroJugador;
	
	public TormentaPsionica(int x,int y,Iterable<Unidad> iterable){
		posX=x;
		posY=y;
		radio=3;
		turnosDeVida=2;
		danio=100;
		this.listaDeUnidadesOtroJugador= iterable;
	}
	
	public void PasarTurno(){
		turnosDeVida--;
		InflingirDanio(this.listaDeUnidadesOtroJugador);
	}
	
	public Iterable<Unidad> InflingirDanio(Iterable<Unidad> listaDeUnidadesOtroJugador2){
		Iterator<Unidad> iterador = listaDeUnidadesOtroJugador2.iterator();
		Unidad UnidadAux;
		int y;
		int x;
		while(iterador.hasNext()){
			UnidadAux = iterador.next();
			x = posX - UnidadAux.getPosX();
			y = posY - UnidadAux.getPosY();

			if(radio<=(int) Math.sqrt( x*x + y*y )){
				UnidadAux.recibirDanio(danio);
			}
		}
		return listaDeUnidadesOtroJugador2;
	}
}
