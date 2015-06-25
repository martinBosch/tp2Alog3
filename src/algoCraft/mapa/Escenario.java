package mapa;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;

import vista.Panel;
import constantes.Constantes;

public class Escenario extends ObjetoMapa{

	private static Escenario INSTANCE = null;

	private ArrayList<ObjetoMapa> objetosEnMapa;

	private boolean agregarVisionUnidades;

	private ArrayList<ObjetoMapa> objsEnMapaSeleccionados;
	private int primCoordXobjsEnMapaSeleccionar;
	private int primCoordYobjsEnMapaSeleccionar;
	private int segCoordXobjsEnMapaSeleccionar;
	private int segCoordYobjsEnMapaSeleccionar;
	private boolean moverObjsEnMapaSeleccionados;

	private Area areaNoVisible;
	private ArrayList<Rectangle> rectangulosVisibles;


	public Escenario(ArrayList<ObjetoMapa> objetosInicialesEnMapa){

		super(0, 0);

		dx = 0;
		dy = 0;

		ancho = Constantes.ANCHO_ESCENARIO;
		alto = Constantes.ALTO_ESCENARIO;

		agregarVisionUnidades = true;

		objetosEnMapa = objetosInicialesEnMapa;

		areaNoVisible = new Area(new Rectangle(0, 0, Constantes.ANCHO_VENTANA,
				Constantes.ALTO_VENTANA));
		rectangulosVisibles = new ArrayList<Rectangle>();

		objsEnMapaSeleccionados = new ArrayList<ObjetoMapa>();
	}

//	private synchronized static void createInstance() {
//		if (INSTANCE == null) {
//			INSTANCE = new MapaLista();
//		}
//	}
//
//	public static MapaLista getInstance() {
//		if (INSTANCE == null)
//			createInstance();
//		return INSTANCE;
//	}


	public boolean fueraLimites(int coordX, int coordY) {
	return ( coordX < 0 || coordX >= (this.ancho) )
			|| ( coordY < 0 || coordY >= (this.alto) );
}


	public boolean agregar(ObjetoMapa objetoAgregar) {
		if ( posOcupada(objetoAgregar.obtenerAreaOcupa()) ) {
			return false;
		}
		objetosEnMapa.add(objetoAgregar);
		return true;		
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



	public void moverObjsEnMapa() {
		for( ObjetoMapa objEnMapa : objetosEnMapa ) {
			System.out.println("objMapa: " + objEnMapa);

			objEnMapa.desplazar(dx, dy);
			objEnMapa.mover();
		}
	}




	public void agregarVisionUnidades() {
		this.agregarVisionUnidades = true;
	}

	public void noAgregarVisionUnidades() {
		// solo se actualizara la vision de las
		// unidades al moverse el escenario.
		this.agregarVisionUnidades = false;
	}

	public Area obtenerAreaNoVisible() {
		actualizarAreaVisible();
		return areaNoVisible;
	}

	public void actualizarAreaVisible() {

		actualizarVisibilidadUnidades();

		areaNoVisible = new Area(new Rectangle(0, 0, Constantes.ANCHO_VENTANA,
				Constantes.ALTO_VENTANA));

		for (Rectangle rectanguloVisible : rectangulosVisibles) {
			rectanguloVisible.translate(dx, dy);
			areaNoVisible.subtract(new Area(rectanguloVisible));
		}
	}

	public void actualizarVisibilidadUnidades() {
		for (ObjetoMapa objEnMapa : objetosEnMapa) {
			if ( objEnMapa.tieneVisibilidad() ) {
				actualizarVisibilidadUnidad(objEnMapa);
			}
		}
	}

	public void actualizarVisibilidadUnidad(ObjetoMapa objEnMapa) {
		if( agregarVisionUnidades ) {
			Rectangle areaVisible = objEnMapa.obtenerAreaVisible();
			rectangulosVisibles.add(areaVisible);
		}
		else {
			objEnMapa.actualizarAreaVisible();
		}
	}





	public void guardarPrimerCoordUnidSeleccionar(int ratonX, int ratonY) {
		if (moverObjsEnMapaSeleccionados){
			return;
		}
		primCoordXobjsEnMapaSeleccionar = ratonX;
		primCoordYobjsEnMapaSeleccionar = ratonY;
	}

	public void guardarSegCoordUnidSeleccionar(int ratonX, int ratonY) {
		if (moverObjsEnMapaSeleccionados){
			return;
		}
		segCoordXobjsEnMapaSeleccionar = ratonX;
		segCoordYobjsEnMapaSeleccionar = ratonY;
	}

	public void guardarUnidSeleccionadas() {
		if (moverObjsEnMapaSeleccionados){
			return;
		}
		
		Rectangle areaSeleccionada = obtenerAreaSeleccionada();
		guardarUnidAdesplazar(areaSeleccionada);
		moverObjsEnMapaSeleccionados = true;
	}

	public Rectangle obtenerAreaSeleccionada() {
		int coordXareaSelccionada = primCoordXobjsEnMapaSeleccionar;
		int coordYareaSelccionada = primCoordYobjsEnMapaSeleccionar;
		int anchoAreaSeleccionada = 
				Math.abs( segCoordXobjsEnMapaSeleccionar - primCoordXobjsEnMapaSeleccionar );
		int altoAreaSeleccionada = 
				Math.abs( segCoordYobjsEnMapaSeleccionar - primCoordYobjsEnMapaSeleccionar );

		Rectangle areaSeleccionada = new Rectangle(
				coordXareaSelccionada, coordYareaSelccionada,
				anchoAreaSeleccionada, altoAreaSeleccionada);

		return areaSeleccionada;
	}

	private void guardarUnidAdesplazar(Rectangle areaSeleccionada) {
		for( ObjetoMapa objEnMapa : objetosEnMapa ) {
			Rectangle areaOcupaObj = objEnMapa.obtenerAreaOcupa();
			if( objEnMapa.sePuedeDesplazarAlSelecionar() &&
					areaSeleccionada.contains(areaOcupaObj) ) {
				objsEnMapaSeleccionados.add(objEnMapa);
			}
		}
	}

	public void moverNavesSeleccionadas(int ratonX, int ratonY, Panel panel) {
		if (!moverObjsEnMapaSeleccionados) {
			return;
		}

		agregarVisionUnidades();
		for( ObjetoMapa objEnMapaSelecionado : objsEnMapaSeleccionados ) {
			moverNaveSeleccionada(objEnMapaSelecionado, ratonX, ratonY, panel);
		}

		objsEnMapaSeleccionados.clear();
		moverObjsEnMapaSeleccionados = false;
	}

	public void moverNaveSeleccionada(ObjetoMapa objEnMapaSelecionado,
			int ratonX, int ratonY, Panel panel) {

		int desplazamientoTotalX = ratonX - objEnMapaSelecionado.obtenerX();
		int desplazamientoTotalY = ratonY - objEnMapaSelecionado.obtenerY();

		int desplazamientoParcialX = ratonX - objEnMapaSelecionado.obtenerX();
		int desplazamientoParcialY = ratonY - objEnMapaSelecionado.obtenerY();

		boolean seguirX  = true;
		boolean seguirY  = true;

		int desplazamientoX = obtenerDesplazamiento(desplazamientoTotalX);
		int desplazamientoY = obtenerDesplazamiento(desplazamientoTotalY);

		while( seguirX || seguirY ) {

			seguirX = seguirDesplazamiento(desplazamientoTotalX, desplazamientoParcialX);
			seguirY = seguirDesplazamiento(desplazamientoTotalY, desplazamientoParcialY);

			if(seguirX) {
				desplazamientoParcialX -= desplazamientoX;
			}
			else {
				desplazamientoX = 0;
			}

			if(seguirY) {
				desplazamientoParcialY -= desplazamientoY;
			}
			else {
				desplazamientoY = 0;
			}

			objEnMapaSelecionado.desplazar(desplazamientoX, desplazamientoY);
			objEnMapaSelecionado.mover();
			panel.repintar();
		}
	}

	public boolean seguirDesplazamiento(int desplazamientoTotal, int desplazamientoParcial) {
		
		if(desplazamientoTotal>0){
			return desplazamientoParcial > 0;
		}
		else{
			return desplazamientoParcial < 0;
		}
	}


	public int obtenerDesplazamiento(int desplazamientoTotal) {
		int d = Constantes.DESPLAZAMIENTOUNIDAD;

		if(desplazamientoTotal>0){
			return d;
		}
		else{
			return -d;
		}
	}

	public Iterable<ObjetoMapa> obtenerListaObjetos(){
		return this.objetosEnMapa;
	}




}