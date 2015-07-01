package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import mapa.Escenario;
import vista.Panel;
import algoCraft.AlgoCraft;
import constantes.Constantes;

public abstract class Boton implements ActionListener {

	protected Escenario escenario;
	protected AlgoCraft juego;
	protected Panel panel;
	
	private int posXobjMapaAubicar;
	private int posYobjMapaAubicar;


	public Boton(AlgoCraft juego, Panel panel) {
		this.juego = juego;
		this.escenario = juego.obtenerEscenario();
		this.panel = panel;

		posXobjMapaAubicar = obtenerCoordXCercanaBase(5);
		posYobjMapaAubicar = obtenerCoordYCercanaBase(5);
	}

	public void actionPerformed(ActionEvent e) {
	}

	private void actualizarPosObjMapa() {
		int aumentoX = 0;
		int aumentoY = 0;
		while( escenario.posOcupada(posXobjMapaAubicar, posYobjMapaAubicar) ) {
			posXobjMapaAubicar = obtenerCoordXCercanaBase(aumentoX);
			posYobjMapaAubicar = obtenerCoordYCercanaBase(aumentoY);
			
			aumentoX+=1;
			aumentoY+=1;
		}
	}

	public int obtenerPosXobjMapaAubicar() {
		actualizarPosObjMapa();
		return posXobjMapaAubicar;
	}

	public int obtenerPosYobjMapaAubicar() {
		actualizarPosObjMapa();
		return posYobjMapaAubicar;
	}

	public int obtenerCoordXCercanaBase(int aumentoX) {
		int baseX = juego.obtenerJugadorTurno().obtenerPosXbase();
		return obtenerNumRandom(baseX, Constantes.ANCHO_UNIDAD*aumentoX);
	}

	public int obtenerCoordYCercanaBase(int aumentoY) {
		int baseY = juego.obtenerJugadorTurno().obtenerPosYbase();
		return obtenerNumRandom(baseY, Constantes.ALTO_UNIDAD*aumentoY);
	}

	private int obtenerNumRandom(int inicio, int fin) {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * (fin - inicio) + inicio);
	}

}

