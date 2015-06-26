package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mapa.Escenario;
import vista.Panel;
import vista.objetosMapaVista.BarracaVista;
import vista.objetosMapaVista.MarineVista;
import vista.objetosMapaVista.ZealotVista;
import Edificios.Barraca;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionPoblacionInsuficiente;
import Jugador.Jugador;
import Unidades.Marine;
import Unidades.Zealot;
import algoCraft.AlgoCraft;

public class Boton implements ActionListener {

	private Escenario escenario;
	private AlgoCraft juego;
	private Panel panel;

	public Boton(AlgoCraft juego, Panel panel) {
		this.juego = juego;
		this.escenario = juego.obtenerEscenario();
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {

		Jugador jugTurno = juego.obtenerJugadorTurno();

		String nombreBoton = (String) e.getActionCommand();

		switch(nombreBoton) {

			case("Marine"):
				Marine marine = new Marine(100, 100);
				marine.setJugador(jugTurno);
			
				escenario.agregar(marine);
				MarineVista marineVista2 = new MarineVista(marine);
				panel.agregarObjMapaVista(marineVista2);

				try {
					if ( escenario.posOcupada(marine.obtenerAreaOcupa()) &&
							jugTurno.puedeCrearUnidad(marine)) {
	
						return;
					}
				} catch (ExcepcionGasesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcepcionMineralesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean puedeCrearUnidad = false;
				try {
					puedeCrearUnidad = jugTurno.crearUnidad(marine);
				} catch (ExcepcionPoblacionInsuficiente e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcepcionGasesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcepcionMineralesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(puedeCrearUnidad) {
					escenario.agregar(marine);
					MarineVista marineVista = new MarineVista(marine);
					panel.agregarObjMapaVista(marineVista);
				}
				break;

			case("Zealot"):
				System.out.println("ZEALOT");
				Zealot zealot = new Zealot(300, 300);
				zealot.setJugador(jugTurno);

				escenario.agregar(zealot);
				ZealotVista zealotVista = new ZealotVista(zealot);
				panel.agregarObjMapaVista(zealotVista);

				
				
			case("Barraca"):
					Barraca barraca = new Barraca(400, 400);
				try {
					if ( escenario.posOcupada(barraca.obtenerAreaOcupa()) &&
							jugTurno.puedeCrearEdificio(barraca)) {
	
						return;
					}
				} catch (ExcepcionGasesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcepcionMineralesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean puedeCrearEdif = false;
				try {
					puedeCrearEdif = jugTurno.crearEdificio(200,200,barraca);
				} catch (ExcepcionGasesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcepcionMineralesInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					if(puedeCrearEdif) {
						escenario.agregar(barraca);
						BarracaVista barracaVista = new BarracaVista(barraca);
						panel.agregarObjMapaVista(barracaVista);
					}
					break;

			case("Pasar Turno"):
				juego.PasarTurno();
				panel.cambiarBotones();


//		boolean puedeCrearUnidad;
//		try {
//			puedeCrearUnidad = jugTurno.crearUnidad(marine);
//			System.out.println("SE CREO" );
//			if(puedeCrearUnidad) {
//				escenario.agregar(marine);
//		
//				MarineVista marineVista = new MarineVista(marine);
//				panel.agregarObjMapaVista(marineVista);
//				
//				panel.repaint();
//
//			}
//		} catch (ExcepcionPoblacionInsuficiente | ExcepcionGasesInsuficientes
//				| ExcepcionMineralesInsuficientes e1) {
//			System.out.println("NO SE CREO: " + e1.getMessage());

		}
		panel.repaint();

	}


}