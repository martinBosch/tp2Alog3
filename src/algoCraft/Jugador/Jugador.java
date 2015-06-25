package Jugador;

import java.util.ArrayList;
import java.util.Iterator;

import Edificios.Edificio;
import Edificios.EdificioProtoss;
import Excepciones.ExcepcionEnergiaInsuficiente;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionPoblacionInsuficiente;
import Excepciones.ExcepcionRazaEquivocada;
import Magias.TormentaPsionica;
import Razas.Protoss;
import Razas.Raza;
import Razas.Terran;
import Unidades.AltoTemplario;
import Unidades.NaveCiencia;
import Unidades.Unidad;
import Unidades.UnidadProtoss;
import algoCraft.AlgoCraft;

public class Jugador {

	enum razas {
		Protoss, Terran
	};

	private Raza raza;
	private int gases;
	private int minerales;
	private int poblacion;
	private int poblacionMax;

	private ArrayList<Edificio> listaDeEdificios;
	private ArrayList<Edificio> listaDeEdificiosACrear;
	private ArrayList<Unidad> listaDeUnidades;
	private ArrayList<Unidad> listaDeUnidadesACrear;
	private ArrayList<TormentaPsionica> listaDeTormentas;

	private AlgoCraft juego;

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
	};

	public void referenciar(AlgoCraft juegoActual) {
		this.juego = juegoActual;
	};

	public void crearTormenta(int x, int y) throws ExcepcionEnergiaInsuficiente {
		Iterator<Unidad> iterador = this.listaDeUnidades.iterator();
		TormentaPsionica tormenta = null;
		while (iterador.hasNext()) {
			Unidad unidadAux = iterador.next();
			if ((unidadAux.getClass() == AltoTemplario.class)
					&& (unidadAux.obtenerX() == x)
					&& (unidadAux.obtenerY() == y)) {
				tormenta = ((AltoTemplario) unidadAux).tormentaPsionica(x, y,
						juego.getOponente(this).getListaUnidades());
				if (tormenta != null) {
					this.listaDeTormentas.add(tormenta);
					unidadAux.YaJugo();
				}
			}
		}
	};

	public void modificarMineral(int mineralModificado) {
		this.minerales = this.minerales + mineralModificado;
	};

	public void modificarGas(int gasesModificado) {
		this.gases = this.gases + gasesModificado;
	};

	public int getPoblacionMax() {
		return this.poblacionMax;
	};

	public void aumentarPoblacionMax() {
		this.poblacionMax = this.poblacionMax + 5;
	};

	public void disminuirPoblacionMax() {
		this.poblacionMax = this.poblacionMax - 5;
	};

	public int getPoblacion() {
		return this.poblacion;
	};

	public void modificarPoblacion(int poblacionModificada) {
		this.poblacion = this.poblacion + poblacionModificada;
	};

	public boolean puedeCrearEdificio(Edificio edificioACrear)
			throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		
		return this.raza.crearEdificio(this.minerales, this.gases,
				this.listaDeEdificios, edificioACrear,juego);
	}


	public boolean crearEdificio(int x, int y, Edificio edificioACrear)
			throws  ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {

		boolean puede = this.raza.crearEdificio(this.minerales, this.gases,
				this.listaDeEdificios, edificioACrear, juego);

		if (puede) {
			modificarGas(-edificioACrear.getPrecioG());
			modificarMineral(-edificioACrear.getPrecioM());
			this.listaDeEdificiosACrear.add(edificioACrear);
		}
		return puede;
	}

	public boolean puedeCrearUnidad(Unidad unidadACrear)
			throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {

		boolean puede = false;

		if (unidadACrear.getSuministros() <= (this.poblacionMax - this.poblacion)) {
			puede = this.raza.crearUnidad(this.minerales, this.gases,
					this.listaDeEdificios, unidadACrear);
		}
		return puede;
	}


	public boolean crearUnidad(Unidad unidadACrear)
			throws ExcepcionPoblacionInsuficiente, ExcepcionGasesInsuficientes,
			ExcepcionMineralesInsuficientes {

		boolean puede = false;
		if (unidadACrear.getSuministros() <= (this.poblacionMax - this.poblacion)) {
			puede = this.raza.crearUnidad(this.minerales, this.gases,
					this.listaDeEdificios, unidadACrear);

			if (puede) {
				modificarGas(-unidadACrear.getPrecioG());
				modificarMineral(-unidadACrear.getPrecioM());
				modificarPoblacion(unidadACrear.getSuministros());
				this.listaDeUnidadesACrear.add(unidadACrear);
			} 
		
		}else {
			throw new ExcepcionPoblacionInsuficiente();
		}
		return puede;
	}

	public void destruirEdificios() {
		Iterator<Edificio> iterator = this.listaDeEdificios.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			if (iterator.next().getVida() < 0) {
				this.listaDeEdificios.remove(i);
			}
		}
	}

	public void destruirUnidades() {
		Iterator<Unidad> iterator = this.listaDeUnidades.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i++;
			if (iterator.next().getVida() < 0) {
				this.listaDeUnidades.remove(i);
			}
		}
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

	public void aumentoGasYMineralPorEdificios(Iterable<Edificio> iterable) {
		int numeroDeEdificiosMinerales = 0;
		int numeroDeEdificiosGases = 0;
		Edificio edificioAuxiliar;
		Iterator<Edificio> i = iterable.iterator();
		if (listaDeEdificios.size() != 0) {
			while (i.hasNext()) {
				edificioAuxiliar = i.next();
				if ((edificioAuxiliar.minador())) {
					numeroDeEdificiosMinerales++;
				}
				if ((edificioAuxiliar.gaseador())) {
					numeroDeEdificiosGases++;
				}

			}
			this.minerales = this.minerales + (numeroDeEdificiosMinerales * 10);
			this.gases = this.gases + (numeroDeEdificiosGases * 10);
		}
	}

	public void disminuirTiempoDeConstruccion() {
		ArrayList<Edificio> edifTerminoTiempoConstruc = new ArrayList<Edificio>();
		ArrayList<Unidad> unidTerminoTiempoConstruc = new ArrayList<Unidad>();

		for (Edificio edificio : listaDeEdificiosACrear) {
			edificio.bajarTiempoConstruccion();
			if (edificio.getTiempoConstruccion() == 0) {
				if ((edificio.poblador())) {
					aumentarPoblacionMax();
				}
				edifTerminoTiempoConstruc.add(edificio);
			}
		}

		for (Unidad unidad : listaDeUnidadesACrear) {
			unidad.bajarTiempoConstruccion();
			if (unidad.getTiempoConstruccion() == 0) {
				unidTerminoTiempoConstruc.add(unidad);
			}
		}
		actualizarObjMapaTerminoTiempoConstruc(edifTerminoTiempoConstruc,
				unidTerminoTiempoConstruc);
	}

	public void actualizarObjMapaTerminoTiempoConstruc(ArrayList<Edificio> edifTerminoTiempoConstruc,
			ArrayList<Unidad> unidTerminoTiempoConstruc) {

		for (Edificio edificio : edifTerminoTiempoConstruc) {
			this.listaDeEdificios.add(edificio);
			this.listaDeEdificiosACrear.remove(edificio);
		}

		for (Unidad unidad : unidTerminoTiempoConstruc) {
			this.listaDeUnidades.add(unidad);
			this.listaDeUnidadesACrear.remove(unidad);
		}

	}

	private void regenerarEscudosProtoss(Iterable<Edificio> iteratorEdificios,
			Iterator<Unidad> iteratorUnidades) {
		Edificio edificioAuxiliar;
		Unidad unidadAuxiliar;

		if (listaDeEdificios.size() != 0) {
			Iterator<Edificio> i = iteratorEdificios.iterator();
			while (i.hasNext()) {
				edificioAuxiliar = i.next();
				if ((edificioAuxiliar.getClass().getSuperclass() == EdificioProtoss.class)) {
					((EdificioProtoss) edificioAuxiliar).recargarEscudo();
				}
			}
		}
		if (listaDeUnidades.size() != 0) {
			while (iteratorUnidades.hasNext()) {
				unidadAuxiliar = iteratorUnidades.next();
				if ((unidadAuxiliar.getClass().getSuperclass() == UnidadProtoss.class)) {
					((UnidadProtoss) unidadAuxiliar).recargarEscudo();
				}
			}
		}

	}

	private void aplicarRadiacion(Iterable<Unidad> iteratorUnidades) {
		Unidad unidadAuxiliar;
		ArrayList<Unidad> unidadesAledanias;
		Iterator<Unidad> i = iteratorUnidades.iterator();
		while (i.hasNext()) {
			unidadAuxiliar = i.next();
			if (unidadAuxiliar.getEstadoIrradiacion()) {
				unidadesAledanias = VerificarUnidadesAledanias(unidadAuxiliar);
				irradiar(unidadesAledanias);
			}
		}
	}

	private void irradiar(Iterable<Unidad> unidadesAledanias) {
		Unidad unidadAuxiliar;
		Iterator<Unidad> i = unidadesAledanias.iterator();
		while (i.hasNext()) {
			unidadAuxiliar = i.next();
			unidadAuxiliar.recibirDanio(10);
		}

	}

	private ArrayList<Unidad> VerificarUnidadesAledanias(Unidad unidad) {
		ArrayList<Unidad> ListaUnidadesAux = new ArrayList<Unidad>();
		Unidad unidadAuxiliar;
		Iterator<Unidad> iterador = this.listaDeUnidades.iterator();
		while (iterador.hasNext()) {
			unidadAuxiliar = iterador.next();
			if (unidadAuxiliar.distancia(unidad) <= 1) {
				ListaUnidadesAux.add(unidadAuxiliar);
			}
		}
		return ListaUnidadesAux;
	}

	private void reiniciarYaJugoUnidades() {
		Iterable<Unidad> lista = this.listaDeUnidades;
		for (Unidad unidadAux : lista) {
			unidadAux.reiniciarYaJugo();
		}
	}

	public void crearEMP(int posXEMP, int posYEMP, int x, int y)
			throws ExcepcionRazaEquivocada, ExcepcionEnergiaInsuficiente {
		if (this.raza.getClass() == Terran.class) {
			Iterator<Unidad> iterador = this.listaDeUnidades.iterator();
			while (iterador.hasNext()) {
				Unidad unidadAux = iterador.next();

				if ((unidadAux.getClass() == NaveCiencia.class)
						&& (unidadAux.obtenerX() == x)
						&& (unidadAux.obtenerY() == y)) {
					((NaveCiencia) unidadAux).EMP(listaDeUnidades, posXEMP,
							posYEMP);
				}
			}
		} else {
			throw new ExcepcionRazaEquivocada();
		}
	}

	public void CrearAlucinaciones(Unidad unidadACopiar, int posCopia1X,
			int posCopia1y, int posCopia2X, int posCopia2y, int x, int y)
			throws ExcepcionEnergiaInsuficiente {
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
		}
	}

	public void pasarTurno() {
		aplicarRadiacion(this.listaDeUnidades);
		destruirUnidades();
		destruirEdificios();
		aumentoGasYMineralPorEdificios(this.listaDeEdificios);
		disminuirTiempoDeConstruccion();
		regenerarEscudosProtoss(this.listaDeEdificios,
				this.listaDeUnidades.iterator());
		tormentarTurnos();
		reiniciarYaJugoUnidades();
	}

	public void tormentarTurnos() {
		Iterator<TormentaPsionica> iterador = this.listaDeTormentas.iterator();
		while (iterador.hasNext()) {
			TormentaPsionica tormentaAux = iterador.next();
			tormentaAux.PasarTurno();
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
