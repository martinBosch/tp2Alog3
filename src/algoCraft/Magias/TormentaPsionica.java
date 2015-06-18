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
	
	TormentaPsionica(int x,int y){
		posX=x;
		posY=y;
		radio=3;
		turnosDeVida=2;
		danio=100;
	}
	
	public void PasarTurno(){
		turnosDeVida--;
	}
	
	public ArrayList<Unidad> InflingirDanio(ArrayList<Unidad> ListaUnidades){
		Iterator<Unidad> iterador = ListaUnidades.iterator();
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
		return ListaUnidades;
	}
}
