package Tests;

import mapa.MapaLista;
import mapa.MapaListaBuilder;

import org.junit.Assert;
import org.junit.Test;

import Unidades.Golliat;
import Unidades.Marine;

public class MapaListaTest {


	@Test
	public void testCrearMapaNoVacio() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		Assert.assertNotNull(mapa);
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testCrearUnicaInstanciaDeMapa() {
		MapaLista mapa1 = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		MapaLista mapa2 = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Assert.assertEquals(mapa1, mapa2);
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testPosicionesFueraLimitesDeMapa() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		Assert.assertEquals(true, mapa.fueraLimites(6400, 6400));
		Assert.assertEquals(true, mapa.fueraLimites(6400, 0));
		Assert.assertEquals(true, mapa.fueraLimites(0, 6400));
		Assert.assertEquals(true, mapa.fueraLimites(-1, 0));
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testPosicionesDentroLimitesDeMapa() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		Assert.assertEquals(false, mapa.fueraLimites(0, 0));
		Assert.assertEquals(false, mapa.fueraLimites(6399, 6399));
		Assert.assertEquals(false, mapa.fueraLimites(300, 200));
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testAgregarObjetoAlMapaEnPosicionNoOcupada() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Marine marine = new Marine(6400/2, 6400/2); // (ANCHO_MAPA/2, ALTO_MAPA/2)
		
		Assert.assertEquals(true, mapa.agregar(marine));
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testAgregarObjetoAlMapaEnPosicionOcupada() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Marine marine = new Marine(6400/2, 6400/2); // (ANCHO_MAPA/2, ALTO_MAPA/2)
		Golliat golliat = new Golliat(6400/2, 6400/2); // (ANCHO_MAPA/2, ALTO_MAPA/2)

		Assert.assertEquals(true, mapa.agregar(marine));
		Assert.assertEquals(false, mapa.agregar(golliat));
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testPosicionesDeBasesOcupadasEnElMapa() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Marine marine = new Marine(0, 0);
		Assert.assertEquals(false, mapa.agregar(marine));

		marine.mover(6400-1, 6400-1); //  (ANCHO_MAPA-1, ALTO_MAPA-1)
		Assert.assertEquals(false, mapa.agregar(marine));

		marine.mover(0, 6400-1); //  (0, ALTO_MAPA-1)
		Assert.assertEquals(false, mapa.agregar(marine));

		marine.mover(6400-1, 0); //  (ANCHO_MAPA-1, 0)
		Assert.assertEquals(false, mapa.agregar(marine));
		
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testUnidadAtacantePuedeAtacarDentroRangoAtaque() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Marine marineAtacante = new Marine(33, 33);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(133, 133);
		mapa.agregar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());

		marineAtacante.atacar(marineAtacado);

		Assert.assertEquals(34, marineAtacado.getVida());

		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testUnidadAtacanteAlAtacarNoPierdeVida() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Marine marineAtacante = new Marine(33, 33);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(133, 133);
		mapa.agregar(marineAtacado);
		
		Assert.assertEquals(40, marineAtacante.getVida());

		marineAtacante.atacar(marineAtacado);
		
		Assert.assertEquals(40, marineAtacante.getVida());
		
		MapaListaBuilder.reiniciarMapaLista();
	}

	@Test
	public void testUnidadAtacanteNoPuedeAtacarFueraRangoAtaque() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Marine marineAtacante = new Marine(33, 33);
		mapa.agregar(marineAtacante);

		Marine marineAtacado = new Marine(500, 500);
		mapa.agregar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());

		marineAtacante.atacar(marineAtacado);

		Assert.assertEquals(40, marineAtacado.getVida());

		MapaListaBuilder.reiniciarMapaLista();
	}


}
