package principal;
import mapa.Escenario;
import vista.Panel;
import vista.Ventana;
import algoCraft.AlgoCraft;
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
		ventana = new Ventana(panel);
	}

	public static void main(String[] args) throws InterruptedException {
		Principal p = new Principal();
	}

}
