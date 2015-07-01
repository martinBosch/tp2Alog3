package control;

import java.awt.event.ActionEvent;

import mapa.Escenario;
import vista.Panel;
import vista.objetosMapaVista.AccesoVista;
import vista.objetosMapaVista.ArchivosTemplariosVista;
import vista.objetosMapaVista.AsimiladorVista;
import vista.objetosMapaVista.BarracaVista;
import vista.objetosMapaVista.CentroMineralVista;
import vista.objetosMapaVista.DepositoSuministroVista;
import vista.objetosMapaVista.FabricaVista;
import vista.objetosMapaVista.NexoMineralVista;
import vista.objetosMapaVista.ObjetoMapaVista;
import vista.objetosMapaVista.PilonVista;
import vista.objetosMapaVista.PuertoEstelarPVista;
import vista.objetosMapaVista.PuertoEstelarTVista;
import vista.objetosMapaVista.RefineriaVista;
import Edificios.Acceso;
import Edificios.ArchivosTemplarios;
import Edificios.Asimilador;
import Edificios.Barraca;
import Edificios.CentroMineral;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.Fabrica;
import Edificios.NexoMineral;
import Edificios.Pilon;
import Edificios.PuertoEstelarP;
import Edificios.PuertoEstelarT;
import Edificios.Refineria;
import Excepciones.ExcepcionGasVespenoNecesario;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralNecesario;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionNoPoseeEdifNecesario;
import Excepciones.ExcepcionPoblacionMaxSuperada;
import Excepciones.ExcepcionPosicionOcupada;
import Jugador.Jugador;
import algoCraft.AlgoCraft;
import constantes.Constantes;

public class BotonEdificios extends Boton {

	private String nombreEdifAcrear;
	public BotonEdificios(AlgoCraft juego, Panel panel) {
		super(juego, panel);
	}

	public void actionPerformed(ActionEvent e) {

		nombreEdifAcrear = (String) e.getActionCommand();

		Escenario escenario = juego.obtenerEscenario();
		escenario.guardarUbicacionEdificioAconstruir();
	}


	public void crearEdificio() {

		Jugador jugTurno = juego.obtenerJugadorTurno();

		int x = escenario.obtenerUbicacionXedificioAconstruir();
		int y = escenario.obtenerUbicacionYedificioAconstruir();
		x -= (Constantes.ANCHO_EDIFICIO / 2);
		y -= (Constantes.ALTO_EDIFICIO / 2);

		Edificio edificio = null;
		ObjetoMapaVista edificioVista = null;
		String advertencia = "";

		switch(nombreEdifAcrear)
		{
		case("CentroMineral"):
			edificio = new CentroMineral(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new CentroMineralVista( (CentroMineral) edificio);
			break;

		case("Barraca"):
			edificio = new Barraca(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new BarracaVista( (Barraca) edificio);
			break;

		case("DepositoSuministro"):
			edificio = new DepositoSuministro(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new DepositoSuministroVista( (DepositoSuministro) edificio);
			break;

		case("Refineria"):
			edificio = new Refineria(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new RefineriaVista( (Refineria) edificio);
			break;

		case("Fabrica"):
			edificio = new Fabrica(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new FabricaVista( (Fabrica) edificio);
			break;

		case("PuertoEstelarT"):
			edificio = new PuertoEstelarT(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new PuertoEstelarTVista( (PuertoEstelarT) edificio);
			break;

		case("NexoMineral"):
			edificio = new NexoMineral(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new NexoMineralVista( (NexoMineral) edificio);
			break;

		case("Pilon"):
			edificio = new Pilon(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new PilonVista( (Pilon) edificio);
			break;

		case("Asimilador"):
			edificio = new Asimilador(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new AsimiladorVista( (Asimilador) edificio);
			break;

		case("Acceso"):
			edificio = new Acceso(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new AccesoVista( (Acceso) edificio);
			break;

		case("PuertoEstelarP"):
			edificio = new PuertoEstelarP(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new PuertoEstelarPVista( (PuertoEstelarP) edificio);
			break;

		case("ArchivosTemplarios"):
			edificio = new ArchivosTemplarios(x, y);
			edificio.setJugador(jugTurno);
			edificioVista = new ArchivosTemplariosVista( (ArchivosTemplarios) edificio);
			break;
		}

		try {
			jugTurno.puedeCrearEdificio(edificio);

			escenario.agregar(edificio);
			jugTurno.agregarEdificioACrear(edificio);
			panel.agregarVistaACrear(edificioVista);
		}
		catch (ExcepcionGasesInsuficientes e1) {
			advertencia = "PARA CONSTRUIR EDIFICIO SE NECESITA: " + edificio.getPrecioG() + " GASES.";
		}
		catch (ExcepcionMineralesInsuficientes e2) {
			advertencia = "PARA CONSTRUIR EDIFICIO SE NECESITA: " + edificio.getPrecioM() + " MINERALES.";
		}
		catch (ExcepcionPoblacionMaxSuperada e3) {
			advertencia = "PARA CONSTRUIR EDIFICIO SE NECESITA: " + edificio.getSuministros() + " CUPOS DE POBLACION.";
		}
		catch (ExcepcionNoPoseeEdifNecesario e4) {
			advertencia = "PARA CREAR UNIDAD SE NECESITA EDIFICIO.";
		}
		catch (ExcepcionGasVespenoNecesario e5) {
			advertencia = "PARA CONSTRUIR EDIFICIO ES NECESARIO UBICARLO SOBRE UN VOLCAN DE GAS VESPENO.";
		}
		catch (ExcepcionMineralNecesario e6) {
			advertencia = "PARA CONSTRUIR EDIFICIO ES NECESARIO UBICARLO SOBRE UN NODO DE MINERAL.";
		}
		catch (	ExcepcionPosicionOcupada e7) {
			advertencia = "PARA CONSTRUIR EDIFICIO ES NECESARIO UBICARLO EN UNA POSICION NO OCUPADA.";
		}

		panel.agregarAdvertencia(advertencia);
		panel.repaint();
	}
}

