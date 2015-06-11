package Tests;

import mapa.MapaLista;
import mapa.MapaListaBuilder;

import org.junit.Assert;
import org.junit.Test;

public class MapaListaTest {


	@Test
	public void testCrearMapaNoVacio() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		Assert.assertNotNull(mapa);
	}

	@Test
	public void testCrearUnicaInstanciaDeMapa() {
		MapaLista mapa1 = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		MapaLista mapa2 = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();

		Assert.assertEquals(mapa1, mapa2);
	}

	@Test
	public void testPosicionesFueraLimitesDeMapa() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		Assert.assertEquals(true, mapa.fueraLimites(6400, 6400));
		Assert.assertEquals(true, mapa.fueraLimites(6400, 0));
		Assert.assertEquals(true, mapa.fueraLimites(0, 6400));
		Assert.assertEquals(true, mapa.fueraLimites(-1, 0));
	}

	@Test
	public void testPosicionesDentroLimitesDeMapa() {
		MapaLista mapa = ( MapaListaBuilder.getInstance() ).obtenerMapaLista();
		Assert.assertEquals(false, mapa.fueraLimites(0, 0));
		Assert.assertEquals(false, mapa.fueraLimites(6399, 6399));
		Assert.assertEquals(false, mapa.fueraLimites(300, 200));
	}

}
