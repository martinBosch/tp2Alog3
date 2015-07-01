package control;

import java.awt.event.ActionEvent;

import vista.Panel;
import vista.objetosMapaVista.AltoTemplarioVista;
import vista.objetosMapaVista.DragonVista;
import vista.objetosMapaVista.EspectroVista;
import vista.objetosMapaVista.GolliatVista;
import vista.objetosMapaVista.MarineVista;
import vista.objetosMapaVista.NaveCienciaVista;
import vista.objetosMapaVista.NaveTransportePVista;
import vista.objetosMapaVista.NaveTransporteTVista;
import vista.objetosMapaVista.ObjetoMapaVista;
import vista.objetosMapaVista.ScoutVista;
import vista.objetosMapaVista.ZealotVista;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionNoPoseeEdifNecesario;
import Excepciones.ExcepcionPoblacionMaxSuperada;
import Jugador.Jugador;
import Unidades.AltoTemplario;
import Unidades.Dragon;
import Unidades.Espectro;
import Unidades.Golliat;
import Unidades.Marine;
import Unidades.NaveCiencia;
import Unidades.NaveTransporteP;
import Unidades.NaveTransporteT;
import Unidades.Scout;
import Unidades.Unidad;
import Unidades.Zealot;
import algoCraft.AlgoCraft;
import constantes.Constantes;

public class BotonUnidades extends Boton {

	public BotonUnidades(AlgoCraft juego, Panel panel) {
		super(juego, panel);
	}


	public void actionPerformed(ActionEvent e) {
		Jugador jugTurno = juego.obtenerJugadorTurno();

		int x = obtenerPosXobjMapaAubicar();
		int y = obtenerPosYobjMapaAubicar();
		x -= (Constantes.ANCHO_UNIDAD / 2);
		y -= (Constantes.ALTO_UNIDAD / 2);

		Unidad unidad = null;
		ObjetoMapaVista unidadVista = null;
		String advertencia = "";

		String nombreBoton = (String) e.getActionCommand();

		switch(nombreBoton)
		{
		case("Marine"):
			unidad = new Marine(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new MarineVista( (Marine) unidad);
			break;

		case("Golliat"):
			unidad = new Golliat(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new GolliatVista( (Golliat) unidad);
			break;

		case("Espectro"):
			unidad = new Espectro(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new EspectroVista( (Espectro) unidad);
			break;

		case("NaveCiencia"):
			unidad = new NaveCiencia(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new NaveCienciaVista( (NaveCiencia) unidad);
			break;

		case("NaveTransporteT"):
			unidad = new NaveTransporteT(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new NaveTransporteTVista( (NaveTransporteT) unidad);
			break;

		case("Zealot"):
			unidad = new Zealot(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new ZealotVista( (Zealot) unidad);
			break;

		case("Dragon"):
			unidad = new Dragon(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new DragonVista( (Dragon) unidad);
			break;

		case("Scout"):
			unidad = new Scout(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new ScoutVista( (Scout) unidad);
			break;

		case("AltoTemplario"):
			unidad = new AltoTemplario(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new AltoTemplarioVista( (AltoTemplario) unidad);
			break;

		case("NaveTransporteP"):
			unidad = new NaveTransporteP(x, y);
			unidad.setJugador(jugTurno);
			unidadVista = new NaveTransportePVista( (NaveTransporteP) unidad);
			break;
		}

		try {
			jugTurno.puedeCrearUnidad(unidad);

			escenario.agregar(unidad);
			jugTurno.agregarUnidadACrear(unidad);
			panel.agregarVistaACrear(unidadVista);
		}
		catch (ExcepcionGasesInsuficientes e1) {
			advertencia = "PARA CREAR UNIDAD SE NECESITA: " + unidad.getPrecioG() + " GASES.";
		}
		catch (ExcepcionMineralesInsuficientes e2) {
			advertencia = "PARA CREAR UNIDAD SE NECESITA: " + unidad.getPrecioM() + " MINERALES.";
		}
		catch (ExcepcionPoblacionMaxSuperada e3) {
			advertencia = "PARA CREAR UNIDAD SE NECESITA: " + unidad.getSuministros() + " CUPOS DE POBLACION.";
		}
		catch (ExcepcionNoPoseeEdifNecesario e4) {
			advertencia = "PARA CREAR UNIDAD SE NECESITA EDIFICIO.";
		}

		panel.agregarAdvertencia(advertencia);
		panel.repaint();
	}
}

