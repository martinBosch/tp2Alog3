package principal;
import mapa.Escenario;
import mapa.EscenarioBuilder;
import vista.Panel;
import vista.Ventana;
import vista.objetosMapaVista.EscenarioVista;
import algoCraft.AlgoCraft;
import control.Boton;
import control.Raton;
import control.Teclado;

public class Principal {

	AlgoCraft juego;
	Escenario escenario;

	Teclado teclado;
	Raton raton;

	Panel panel;
	Ventana ventana;

	public Principal() {
		juego = new AlgoCraft();
		panel = new Panel(juego);

//		escenario = ( EscenarioBuilder.getInstance() ).obtenerEscenario();
		escenario = juego.obtenerEscenario();
		EscenarioVista escenarioVista = new EscenarioVista(escenario);
		panel.agregarObjMapaVista(escenarioVista);

		( EscenarioBuilder.getInstance() ).cargarBases(panel, escenario);

		teclado = new Teclado(escenario, panel);
		raton = new Raton(juego, panel);
		Boton botonOyente = new Boton(juego, panel);
		panel.agregarControladores(teclado, raton, botonOyente);

		ventana = new Ventana(panel);
	}

	public static void main(String[] args) throws InterruptedException {
		Principal p = new Principal();
	}

}
