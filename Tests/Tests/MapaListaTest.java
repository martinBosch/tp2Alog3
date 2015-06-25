package Tests;

import mapa.Escenario;
import mapa.EscenarioBuilder;

import org.junit.Assert;
import org.junit.Test;

import Unidades.Golliat;
import Unidades.Marine;

public class MapaListaTest {


	@Test
	public void testCrearMapaNoVacio() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();
		Assert.assertNotNull(mapa);
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testCrearUnicaInstanciaDeMapa() {
		Escenario mapa1 = ( EscenarioBuilder.getInstance() ).obtenerEscenario();
		Escenario mapa2 = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

		Assert.assertEquals(mapa1, mapa2);
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testPosicionesFueraLimitesDeMapa() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();
		Assert.assertEquals(true, mapa.fueraLimites(6400, 6400));
		Assert.assertEquals(true, mapa.fueraLimites(6400, 0));
		Assert.assertEquals(true, mapa.fueraLimites(0, 6400));
		Assert.assertEquals(true, mapa.fueraLimites(-1, 0));
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testPosicionesDentroLimitesDeMapa() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();
		Assert.assertEquals(false, mapa.fueraLimites(0, 0));
		Assert.assertEquals(false, mapa.fueraLimites(6399, 6399));
		Assert.assertEquals(false, mapa.fueraLimites(300, 200));
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testAgregarObjetoAlMapaEnPosicionNoOcupada() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

		Marine marine = new Marine(6400/2, 6400/2); // (ANCHO_MAPA/2, ALTO_MAPA/2)
		
		Assert.assertEquals(true, mapa.agregar(marine));
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testAgregarObjetoAlMapaEnPosicionOcupada() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

		Marine marine = new Marine(6400/2, 6400/2); // (ANCHO_MAPA/2, ALTO_MAPA/2)
		Golliat golliat = new Golliat(6400/2, 6400/2); // (ANCHO_MAPA/2, ALTO_MAPA/2)

		Assert.assertEquals(true, mapa.agregar(marine));
		Assert.assertEquals(false, mapa.agregar(golliat));
		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testPosicionesDeBasesOcupadasEnElMapa() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

		Marine marine = new Marine(0, 0);
		Assert.assertEquals(false, mapa.agregar(marine));

		marine.ubicar(6400-1, 6400-1); //  (ANCHO_MAPA-1, ALTO_MAPA-1)
		Assert.assertEquals(false, mapa.agregar(marine));

		marine.ubicar(0, 6400-1); //  (0, ALTO_MAPA-1)
		Assert.assertEquals(false, mapa.agregar(marine));

		marine.ubicar(6400-1, 0); //  (ANCHO_MAPA-1, 0)
		Assert.assertEquals(false, mapa.agregar(marine));

		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testUnidadAtacantePuedeAtacarDentroRangoAtaque() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

		Marine marineAtacante = new Marine(33, 33);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(133, 133);
		mapa.agregar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());

		marineAtacante.atacar(marineAtacado);

		Assert.assertEquals(34, marineAtacado.getVida());

		EscenarioBuilder.reiniciarEscenario();
	}

	@Test
	public void testUnidadAtacanteAlAtacarNoPierdeVida() {
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

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
		Escenario mapa = ( EscenarioBuilder.getInstance() ).obtenerEscenario();

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
