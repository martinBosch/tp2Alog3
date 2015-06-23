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

	public void EMP(Iterable<Unidad> listaUnidades,int posXEMP,int posYEMP) {
		if (energia >= 100) {
			int x;
			int y;
			Unidad unidadAux;
			int radio=3;
			while (listaUnidades.iterator().hasNext()) {
				unidadAux = listaUnidades.iterator().next();
				x = posXEMP - unidadAux.getPosX();
				y = posYEMP - unidadAux.getPosY();

				if (radio <= (int) Math.sqrt(x * x + y * y)) {

					if (unidadAux.getClass().getSuperclass() == UnidadProtoss.class) {
						((UnidadProtoss) unidadAux).eliminarEscudo();
					} else {
						if ((unidadAux.getClass() == AltoTemplario.class)
								|| (unidadAux.getClass() == NaveCiencia.class)) {
							((NaveCiencia) unidadAux).vaciarEnergia();
						} else {
							if ((unidadAux.getClass() == AltoTemplario.class)) {
								((AltoTemplario) unidadAux).vaciarEnergia();
							}
						}
					}
				}
				energia = energia - 100;
			}
		}
	}

	public void Radiacion(Unidad unidadAfectada) {
		if (energia >= 75) {
			unidadAfectada.serIrradiada();
			energia = energia - 75;
		}
	}
	public void vaciarEnergia(){
		this.energia=0;
	}
	
	
	
}
