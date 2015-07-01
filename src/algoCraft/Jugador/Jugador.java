package Jugador;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import mapa.ObjetoMapa;
import recursos.GasVespeno;
import recursos.Minerales;
import Edificios.Edificio;
import Excepciones.ExcepcionEnergiaInsuficiente;
import Excepciones.ExcepcionGasVespenoNecesario;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralNecesario;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionNoPoseeEdifNecesario;
import Excepciones.ExcepcionPoblacionMaxSuperada;
import Excepciones.ExcepcionPosicionOcupada;
import Excepciones.ExcepcionRazaEquivocada;
import Magias.TormentaPsionica;
import Razas.Protoss;
import Razas.Raza;
import Unidades.AltoTemplario;
import Unidades.Unidad;
import Unidades.UnidadProtoss;
import algoCraft.AlgoCraft;
import constantes.Constantes;
import construcciones.Base;

public class Jugador {

	private Raza raza;
	private int gases;
	private int minerales;
	private int poblacion;
	private int poblacionMax;

	private String nombre;

	private ArrayList<Edificio> listaDeEdificios;
	private ArrayList<Unidad> listaDeUnidades;

	private ArrayList<Edificio> listaDeEdificiosACrear;
	private ArrayList<Unidad> listaDeUnidadesACrear;

	private ArrayList<TormentaPsionica> listaDeTormentas;

	private AlgoCraft juego;
	private Base base;


	public Jugador() {
		this.listaDeEdificios = new ArrayList<Edificio>();
		this.listaDeUnidades = new ArrayList<Unidad>();

		this.listaDeEdificiosACrear = new ArrayList<Edificio>();
		this.listaDeUnidadesACrear = new ArrayList<Unidad>();

		this.listaDeTormentas = new ArrayList<TormentaPsionica>();
		gases = 0;
		minerales = 200;
		poblacionMax = 5;
		poblacion = 0;
	}



	public void asignarRaza(Raza raza) {
		this.raza = raza;
	}

	public void referenciar(AlgoCraft juegoActual) {
		this.juego = juegoActual;
	}

	public void modificarMineral(int mineralModificado) {
		this.minerales += mineralModificado;
	}

	public void modificarGas(int gasesModificado) {
		this.gases += gasesModificado;
	}

	public int getPoblacionMax() {
		return this.poblacionMax;
	}

	public void aumentarPoblacionMax() {
		if(poblacionMax<200) {
			this.poblacionMax += 5;
		}
	}

	public void disminuirPoblacionMax() {
		if(poblacionMax>=5) {
			this.poblacionMax -= 5;
		}
	}

	public int getPoblacion() {
		return this.poblacion;
	}

	public void modificarPoblacion(int poblacionModificada) {
		this.poblacion = this.poblacion + poblacionModificada;
	}

	public void asignarBase(Base base) {
		this.base = base;
	}

	public int obtenerPosXbase() {
		return base.obtenerX();
	}

	public int obtenerPosYbase() {
		return base.obtenerY();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public int getCantidadUnidades() {
		return listaDeUnidades.size();
	}

	public int getCantidadEdificios() {
		return listaDeEdificios.size();
	}

	public int getMinerales() {
		return minerales;
	}

	public int getGases() {
		return gases;
	}

	public void murioObjMapa(ObjetoMapa objMapa) {
		modificarPoblacion(-objMapa.getSuministros());
		objMapa.realizarAccionMurio();
		listaDeEdificios.remove(objMapa);
		listaDeUnidades.remove(objMapa);
	}



	public boolean puedeCrear(ObjetoMapa objMapa)
			throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes,
			ExcepcionPoblacionMaxSuperada, ExcepcionNoPoseeEdifNecesario
	{
		if( gases < objMapa.getPrecioG() ) {
			throw new ExcepcionGasesInsuficientes();
		}
		else if( minerales < objMapa.getPrecioM() ) {
			throw new ExcepcionMineralesInsuficientes();
		}
		else if( poblacion + objMapa.getSuministros() > poblacionMax ) {
			throw new ExcepcionPoblacionMaxSuperada();
		}
		else if( !poseeEdifNecesario(objMapa) ) {
			throw new ExcepcionNoPoseeEdifNecesario();
		}
		return true;
	}


	public boolean puedeCrearUnidad(Unidad unidadACrear)
			throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes,
			ExcepcionPoblacionMaxSuperada, ExcepcionNoPoseeEdifNecesario
	{
		return puedeCrear(unidadACrear);
	}


	public boolean puedeCrearEdificio(Edificio edificioACrear)
			throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes,
			ExcepcionPoblacionMaxSuperada, ExcepcionNoPoseeEdifNecesario,
			ExcepcionGasVespenoNecesario, ExcepcionMineralNecesario,
			ExcepcionPosicionOcupada
	{
		if( puedeCrear(edificioACrear) ) {

			if( edificioACrear.gaseador() ) {
				return poseeGasVespenoEnPosEdifACrear(edificioACrear);
			}
			else if( edificioACrear.minador() ) {
				return poseeMineralEnPosEdifACrear(edificioACrear);
			}
			else {
				return verificarPosicionOcupada(edificioACrear);
			}
		}
		return true;
	}


	public boolean poseeEdifNecesario(ObjetoMapa unidadACrear) {
		int cantidad = 0;
		for( Class edifNecesario : unidadACrear.getEdifNecesario() ) {
			for(Edificio edificio : listaDeEdificios) {
				if( edificio.getClass() == edifNecesario ){
					return true;
				}
			}
			cantidad+=1;
		}
		return cantidad==0;
	}

	public boolean poseeGasVespenoEnPosEdifACrear(Edificio edificioACrear)
			throws ExcepcionGasVespenoNecesario
	{
		int edifX = edificioACrear.obtenerX();
		int edifY = edificioACrear.obtenerY();
		Rectangle areaOcupaEdifAcrear = new Rectangle(edifX, edifY, 
				Constantes.ANCHO_UNIDAD, Constantes.ALTO_UNIDAD);
		boolean puedeConstruirEdif = false;

		for( ObjetoMapa objMapa : juego.obtenerEscenario().obtenerObjetosEnMapa() ) {
			boolean esGasVespeno = objMapa.getClass() == GasVespeno.class;
			boolean ocupaPosEdifAcrear = objMapa.obtenerAreaOcupa().intersects(areaOcupaEdifAcrear);

			if(esGasVespeno && ocupaPosEdifAcrear) {
				puedeConstruirEdif = true;
			}
			else if(!esGasVespeno && ocupaPosEdifAcrear) {
				throw new ExcepcionGasVespenoNecesario();
			}
		}
		if(!puedeConstruirEdif) {
			throw new ExcepcionGasVespenoNecesario();
		}
		return puedeConstruirEdif;
	}

	public boolean poseeMineralEnPosEdifACrear(Edificio edificioACrear)
			throws ExcepcionMineralNecesario
	{
		int edifX = edificioACrear.obtenerX();
		int edifY = edificioACrear.obtenerY();
		Rectangle areaOcupaEdifAcrear = new Rectangle(edifX, edifY, 
				Constantes.ANCHO_UNIDAD, Constantes.ALTO_UNIDAD);
		boolean puedeConstruirEdif = false;

		for( ObjetoMapa objMapa : juego.obtenerEscenario().obtenerObjetosEnMapa() ) {
			boolean esMineral = objMapa.getClass() == Minerales.class;
			boolean ocupaPosEdifAcrear = objMapa.obtenerAreaOcupa().intersects(areaOcupaEdifAcrear);

			if(esMineral && ocupaPosEdifAcrear) {
				puedeConstruirEdif = true;
			}
			else if(!esMineral && ocupaPosEdifAcrear) {
				throw new ExcepcionMineralNecesario();
			}
		}
		if(!puedeConstruirEdif) {
			throw new ExcepcionMineralNecesario();
		}
		return puedeConstruirEdif;
	}

	public boolean verificarPosicionOcupada(Edificio edificioACrear)
		throws ExcepcionPosicionOcupada
	{
		boolean estaPosOcupada = juego.obtenerEscenario().posOcupada(edificioACrear.obtenerAreaOcupa());
		if(estaPosOcupada){
			throw new ExcepcionPosicionOcupada();
		}
		return false;
	}



	public void agregarUnidadACrear(Unidad unidadACrear) {
		modificarGas(-unidadACrear.getPrecioG());
		modificarMineral(-unidadACrear.getPrecioM());
		modificarPoblacion(unidadACrear.getSuministros());

		listaDeUnidadesACrear.add(unidadACrear);
	}

	public void agregarEdificioACrear(Edificio edificioACrear) {
		modificarGas(-edificioACrear.getPrecioG());
		modificarMineral(-edificioACrear.getPrecioM());

		listaDeEdificiosACrear.add(edificioACrear);
	}

	public void agregarUnidad(Unidad unidad) {
		listaDeUnidades.add(unidad);
	}

	public void agregarEdificio(Edificio edificio) {
		listaDeEdificios.add(edificio);
	}




	public void actualizarTiempoDeConstruccion() {
		ArrayList<Edificio> edifTerminoTiempoConstruc = new ArrayList<Edificio>();
		ArrayList<Unidad> unidTerminoTiempoConstruc = new ArrayList<Unidad>();

		for (Edificio edificio : listaDeEdificiosACrear) {
			edificio.bajarTiempoConstruccion();
			if (edificio.getTiempoConstruccion() == 0) {
				edifTerminoTiempoConstruc.add(edificio);
			}
		}

		for (Unidad unidad : listaDeUnidadesACrear) {
			unidad.bajarTiempoConstruccion();
			if (unidad.getTiempoConstruccion() == 0) {
				unidTerminoTiempoConstruc.add(unidad);
			}
		}
		actualizarObjMapaTerminoTiempoConstruc(
				edifTerminoTiempoConstruc, 
				unidTerminoTiempoConstruc);
	}


	private void actualizarObjMapaTerminoTiempoConstruc(
			ArrayList<Edificio> edifTerminoTiempoConstruc,
			ArrayList<Unidad> unidTerminoTiempoConstruc )
	{
		for (Edificio edificio : edifTerminoTiempoConstruc) {
			agregarEdificio(edificio);
			this.listaDeEdificiosACrear.remove(edificio);
		}
		for (Unidad unidad : unidTerminoTiempoConstruc) {
			agregarUnidad(unidad);
			this.listaDeUnidadesACrear.remove(unidad);
		}
	}



	public void pasarTurno() {
		actualizarTiempoDeConstruccion();
		pasarTurnoEdificios();
		pasarTurnoUnidades();
	}

	public void pasarTurnoEdificios() {
		for(Edificio edificio : listaDeEdificios) {
			edificio.pasarTurno();
		}
	}

	public void pasarTurnoUnidades() {
		for(Unidad unidad : listaDeUnidades) {
			unidad.pasarTurno();
		}
	}


	public void CrearAlucinaciones(Unidad unidadACopiar, int posCopia1X,
			int posCopia1y, int posCopia2X, int posCopia2y, int x, int y)
			throws ExcepcionEnergiaInsuficiente, ExcepcionRazaEquivocada {
		ArrayList<Unidad> listaAux = null;
		if (this.raza.getClass() == Protoss.class) {
			Iterator<Unidad> iterador = this.listaDeUnidades.iterator();
			while (iterador.hasNext()) {
				Unidad unidadAux = iterador.next();
				if ((unidadAux.getClass() == AltoTemplario.class)
						&& (unidadAux.obtenerX() == x)
						&& (unidadAux.obtenerY() == y)) {
					listaAux = ((AltoTemplario) unidadAux).alucinacion(
							posCopia1X, posCopia1y, posCopia2X, posCopia2y,
							this.getListaUnidades(),
							(UnidadProtoss) unidadACopiar);
				}
			}
			if (listaAux.size() != 0) {
				iterador = listaAux.iterator();
				while (iterador.hasNext()) {
					this.listaDeUnidades.add(iterador.next());
				}
			}
		}else {
			throw new ExcepcionRazaEquivocada();
		}
	}


	public Iterable<Unidad> getListaUnidades() {
		return this.listaDeUnidades;
	}

	public ArrayList<String> obtenerNombreUnidades() {
		return raza.obtenerNombreUnidades();
	}

	public ArrayList<String> obtenerNombreEdificios() {
		return raza.obtenerNombreEdificios();
	}

	public ArrayList<String> obtenerRutaImagenUnidades() {
		return raza.obtenerRutaImagenUnidades();
	}

	public ArrayList<String> obtenerRutaImagenEdificios() {
		return raza.obtenerRutaImagenEdificios();
	}

}
