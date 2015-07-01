package mapa;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;

import Jugador.Jugador;
import constantes.Constantes;

public class Escenario extends ObjetoMapa {

	private ArrayList<ObjetoMapa> objetosEnMapa;

	private boolean agregarVisionUnidades;

	private boolean guardarUbicacionEdificioAconstruir;
	private int ubicacionXedificioAcostruir;
	private int ubicacionYedificioAcostruir;

	private ObjetoMapa objMapaPropioSeleccionado;
	private ObjetoMapa objMapaContrarioSelecionado;

	private Area areaNoVisible;
	private ArrayList<Rectangle> rectangulosVisibles;


	public Escenario(Iterable<ObjetoMapa> objetosInicialesEnMapa){

		super(0, 0);

		dx = 0;
		dy = 0;

		ancho = Constantes.ANCHO_ESCENARIO;
		alto = Constantes.ALTO_ESCENARIO;

		agregarVisionUnidades = true;

		cargarObjMapaIniciales(objetosInicialesEnMapa);

		areaNoVisible = new Area(new Rectangle(0, 0,
				Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA));
		rectangulosVisibles = new ArrayList<Rectangle>();

		guardarUbicacionEdificioAconstruir = false;
		ubicacionXedificioAcostruir = -1;
		ubicacionYedificioAcostruir = -1;

		objMapaPropioSeleccionado = null;
		objMapaContrarioSelecionado = null;
	}


	public void cargarObjMapaIniciales(Iterable<ObjetoMapa> objetosInicialesEnMapa) {
		objetosEnMapa = new ArrayList<ObjetoMapa>();

		for(ObjetoMapa objMapaInicial : objetosInicialesEnMapa) {
			objetosEnMapa.add(objMapaInicial);
		}
	}

	public boolean fueraLimites(int coordX, int coordY) {
		return ( coordX < 0 || coordX >= (this.ancho) )
			|| ( coordY < 0 || coordY >= (this.alto) );
	}

	public boolean agregar(ObjetoMapa objetoAgregar) {
		objetosEnMapa.add(objetoAgregar);
		return true;		
	}

	public void borrar(ObjetoMapa objetoBorrar) {
		objetosEnMapa.remove(objetoBorrar);
	}

	public boolean posOcupada(Rectangle areaOcupaObjUbicar) {
		for(ObjetoMapa objetoEnMapa : objetosEnMapa) {
			Rectangle areaOcupaObjEnMapa = objetoEnMapa.obtenerAreaOcupa();
			if (areaOcupaObjUbicar.intersects(areaOcupaObjEnMapa)) {
				return true;
			}
		}
		return false;
	}

	public boolean posOcupada(int x, int y) {
		Rectangle areaOcupa = new Rectangle(x, y,
				Constantes.ANCHO_UNIDAD, Constantes.ALTO_UNIDAD);
		return posOcupada(areaOcupa);
	}


	public void moverObjsEnMapa() {
		for( ObjetoMapa objEnMapa : objetosEnMapa ) {
			objEnMapa.desplazar(dx, dy);
			objEnMapa.mover();
			objEnMapa.desplazar(0, 0);
		}
	}





	public void guardarUbicacionEdificioAconstruir() {
		guardarUbicacionEdificioAconstruir = true;
	}

	public void reiniciarUbicacionEdificioAconstruir() {
		guardarUbicacionEdificioAconstruir = false;
	}

	public boolean seGuardoUbicacionEdificioAconstruir() {
		return guardarUbicacionEdificioAconstruir == true;
	}

	public void asignarUbicacionEdificioAconstruir(int ratonX, int ratonY) {
		ubicacionXedificioAcostruir = ratonX;
		ubicacionYedificioAcostruir = ratonY;
	}

	public int obtenerUbicacionXedificioAconstruir() {
		return ubicacionXedificioAcostruir;
	}

	public int obtenerUbicacionYedificioAconstruir() {
		return ubicacionYedificioAcostruir;
	}



	public void realizarAccionClick(int ratonX, int ratonY, Jugador jugTurno) {

		if(guardarUbicacionEdificioAconstruir == true) {
			asignarUbicacionEdificioAconstruir(ratonX, ratonY);
			return;
		}

		asignarObjMapaSeleccionado(ratonX, ratonY, jugTurno);
		asignarObjMapaJugContrario(ratonX, ratonY, jugTurno);

		if(objMapaContrarioSelecionado == null) {
			moverObjMapaPropioSeleccionado(ratonX, ratonY);
		}
		else {
			atacarObjMapaContrarioSeleccionado();
		}
	}

	public void moverObjMapaPropioSeleccionado(int x, int y) {
		if( !posOcupada(x, y) && objMapaPropioSeleccionado!=null
				&& objMapaPropioSeleccionado.vive() )
		{
			x-= (objMapaPropioSeleccionado.obtenerAncho() / 2);
			y-= (objMapaPropioSeleccionado.obtenerAlto() / 2);
			objMapaPropioSeleccionado.ubicar(x, y);
		}
	}

	public void atacarObjMapaContrarioSeleccionado() {
		if(objMapaPropioSeleccionado!=null 
				&& objMapaContrarioSelecionado.vive()
				&& objMapaPropioSeleccionado.vive())
		{
			if(objMapaPropioSeleccionado.esUnidadMagica()) {
				objMapaPropioSeleccionado.atacarConMagia(objMapaContrarioSelecionado, objetosEnMapa);
			}
			else {
				objMapaPropioSeleccionado.atacar(objMapaContrarioSelecionado);
			}
		}
	}

	public void devolverAtaque() {
		if(objMapaContrarioSelecionado.puedeAtacar() 
				&& objMapaContrarioSelecionado.vive() ) 
		{
			objMapaContrarioSelecionado.atacar(objMapaPropioSeleccionado);
		}
	}

	public boolean seRealizoAtaque() {
		if(objMapaContrarioSelecionado != null && objMapaPropioSeleccionado != null)
		{
			return objMapaPropioSeleccionado.puedeAtacar()
					&& objMapaPropioSeleccionado.vive()
					&& objMapaContrarioSelecionado.vive()
					&& objMapaPropioSeleccionado.dentroRangoAtaque(objMapaContrarioSelecionado);
		}
		return false;
	}

	public void asignarObjMapaSeleccionado(int ratonX, int ratonY, Jugador jugTurno) {
		ObjetoMapa objMapaSeleccionado = obtenerObjMapaPropioEnPos(ratonX, ratonY, jugTurno);

		if (this.objMapaPropioSeleccionado != objMapaSeleccionado &&
				objMapaSeleccionado != null)
		{
			this.objMapaPropioSeleccionado = objMapaSeleccionado;
		}

	}

	public void asignarObjMapaJugContrario(int ratonX, int ratonY, Jugador jugTurno) {
		this.objMapaContrarioSelecionado = obtenerObjMapaJugContrarioEnPos(ratonX, ratonY, jugTurno);
	}

	public ObjetoMapa obtenerObjMapaPropioEnPos(int x, int y, Jugador jugTurno) {
		for(ObjetoMapa objMapa : objetosEnMapa) {
			if( objMapa.estaEnPos(x, y) && objMapa.esDeJugador(jugTurno)  && objMapa.tieneJugador()) {
				return objMapa;
			}
		}
		return null;
	}

	public ObjetoMapa obtenerObjMapaJugContrarioEnPos(int x, int y, Jugador jugTurno) {
		for(ObjetoMapa objMapa : objetosEnMapa) {
			if( objMapa.estaEnPos(x, y) && !objMapa.esDeJugador(jugTurno) && objMapa.tieneJugador()) {
				return objMapa;
			}
		}
		return null;
	}

	public ObjetoMapa obtenerObjMapaContrarioSelecionado() {
		return objMapaContrarioSelecionado;
	}

	public ObjetoMapa obtenerObjMapaPropioSeleccionado() {
		return objMapaPropioSeleccionado;
	}

	public void reiniciarObjMapaContrarioSeleccionado() {
		objMapaContrarioSelecionado = null;
	}

	public void reiniciarObjMapaPropioSeleccionado() {
		objMapaPropioSeleccionado = null;
	}

	public void pasarTurno(Jugador jugTurno) {
		objMapaPropioSeleccionado = null;
		objMapaContrarioSelecionado = null;
	}

	public ObjetoMapa obtenerObjMapaEnPos(int x, int y) {
		for(ObjetoMapa objMapa : objetosEnMapa) {
			if( objMapa.estaEnPos(x, y)) {
				return objMapa;
			}
		}
		return null;
	}

	public Iterable<ObjetoMapa> obtenerObjetosEnMapa(){
		return this.objetosEnMapa;
	}
}