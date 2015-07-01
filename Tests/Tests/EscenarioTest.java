package Tests;

import mapa.Escenario;
import mapa.EscenarioBuilder;

import org.junit.Assert;
import org.junit.Test;

import Jugador.Jugador;
import Unidades.Marine;
import algoCraft.AlgoCraft;

public class EscenarioTest {


	@Test
	public void testCrearMapaNoVacio() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);
		Assert.assertNotNull(mapa);
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testCrearUnicaInstanciaDeMapa() {
		AlgoCraft juego = new AlgoCraft();
		Escenario mapa1 = juego.obtenerEscenario();
		Escenario mapa2 = juego.obtenerEscenario();

		Assert.assertEquals(mapa1, mapa2);
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testPosicionesFueraLimitesDeMapa() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);
		Assert.assertEquals(true, mapa.fueraLimites(3164, 3164));
		Assert.assertEquals(true, mapa.fueraLimites(3164, 0));
		Assert.assertEquals(true, mapa.fueraLimites(0, 3164));
		Assert.assertEquals(true, mapa.fueraLimites(-1, 0));
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testPosicionesDentroLimitesDeMapa() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);
		Assert.assertEquals(false, mapa.fueraLimites(0, 0));
		Assert.assertEquals(false, mapa.fueraLimites(3163, 3163));
		Assert.assertEquals(false, mapa.fueraLimites(300, 200));
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testAgregarObjetoAlMapaEnPosicionNoOcupada() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);

		Marine marine = new Marine(3164/2, 3164/2);
		
		Assert.assertEquals(true, mapa.agregar(marine));
		EscenarioBuilder.reiniciarEscenario();
	}


	@Test
	public void testUnidadAtacantePuedeAtacarDentroRangoAtaque() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);

		Marine marineAtacante = new Marine(10, 10);
		marineAtacante.setJugador(jug1);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(100, 100);
		marineAtacado.setJugador(jug2);
		mapa.agregar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());
		Assert.assertEquals(true, marineAtacante.dentroRangoAtaque(marineAtacado));

		marineAtacante.atacar(marineAtacado);

		Assert.assertEquals(34, marineAtacado.getVida());

		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testUnidadAtacanteAlAtacarNoPierdeVida() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);

		Marine marineAtacante = new Marine(33, 33);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(133, 133);
		mapa.agregar(marineAtacado);
		
		Assert.assertEquals(40, marineAtacante.getVida());

		marineAtacante.atacar(marineAtacado);

		Assert.assertEquals(40, marineAtacante.getVida());
		
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testUnidadAtacanteNoPuedeAtacarFueraRangoAtaque() {
		Jugador jug1 = new Jugador();
		Jugador jug2 = new Jugador();

		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario(jug1, jug2);

		Marine marineAtacante = new Marine(33, 33);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(500, 500);
		mapa.agregar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());

		marineAtacante.atacar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());

		EscenarioBuilder.reiniciarEscenario();
	}


}
