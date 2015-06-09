package Razas;

import java.util.ArrayList;
import java.util.Collection;

import Unidades.Unidad;
import Edificios.Edificio;

public abstract class Raza {

	protected ArrayList<Class> listaEdificios;
	protected ArrayList<Class> listaUnidades;
	
	public Raza() {
		listaEdificios = new ArrayList();
		listaUnidades = new ArrayList();

	
	public boolean verificarExistenciaDelEdificio(ArrayList<Edificio> listaDeEdificios, String EdificioAVerrificar) {
		boolean existeElEdificio = false;
		if(EdificioAVerrificar == "Ninguno"){
			existeElEdificio = true;
		}
		if (!existeElEdificio){
			Iterator<Edificio> iterador = listaDeEdificios.iterator();
			while (iterador.hasNext()) {
				if(iterador.next().getNombre() == EdificioAVerrificar){
					existeElEdificio = true; 
				}
			}
		}
		return existeElEdificio;
	}
	
	private boolean verificarCreacionUnidad(Unidad unidadAuxiliar,
			String edificio, ArrayList<Edificio> listaDeEdificios,
			int minerales, int gases, int suministrosTotales) {
		boolean EsPosibleCrear;
		EsPosibleCrear = (unidadAuxiliar.getSuministros() <= suministrosTotales)
				&& (unidadAuxiliar.getPrecioG() <= gases)
				&& (unidadAuxiliar.getPrecioM() <= minerales)
		 && (verificarExistenciaDelEdificio(listaDeEdificios, edificio));
		return EsPosibleCrear;
	}
	
	public boolean crearEdificio(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, Edificio edificioAuxiliar) {
		boolean puede = false;
		
			if ((edificioAuxiliar.getPrecioG() <= gases)
					&& (edificioAuxiliar.getPrecioM() <= minerales)
					&& (verificarExistenciaDelEdificio(listaDeEdificios,
							edifAuxiliar.getEdifNecesario()))&&(verificarEdificioEnRaza(edificioAuxiliar))) {
				puede = true;
			}
		return puede;
	};
	
	private boolean verificarUnidadEnRaza(Unidad uni){
		boolean puede = false;
		Class c = uni.getClass();
		Iterator<Class> iterador = listaUnidades.iterator();
		while (iterador.hasNext()) {
			if(iterador.next().getClass() == c){
				puede = true; 
			}
		}
		return puede;
	}
	
	private boolean verificarEdificioEnRaza(Edificio edi){
		boolean puede = false;
		Class c = edi.getClass();
		Iterator<Class> iterador = listaEdificios.iterator();
		while (iterador.hasNext()) {
			if(iterador.next().getClass() == c){
				puede = true; 
			}
		}
		return puede;
	}
	
	public boolean crearUnidad(int minerales, int gases,
			ArrayList<Edificio> listaDeEdificios, int suministroDisponible, Unidad unidadACrear) {
		boolean puede = false;
		String edificioAuxiliar;
			if ((verificarCreacionUnidad(unidadACrear,unidadACrear.getEdifNecesario(), listaDeEdificios, minerales, gases, suministroDisponible))&&(verificarUnidadEnRaza(unidadACrear))) {
				puede = true;
			}
			
		return puede;
	};

	
/*	public Edificio crearEdificio(int minerales ,int gases,ArrayList<Edificio> ListaDeEdificios,int num);
	public Unidad crearUnidad(int minerales, int gases,
			ArrayList<Edificio> ListaDeEdificios,int suministroDisponible, int num);
	public boolean verificarExistenciaDelEdificio(
			ArrayList<Edificio> listaDeEdificios, String EdificioAVerrificar);

	*/
}
