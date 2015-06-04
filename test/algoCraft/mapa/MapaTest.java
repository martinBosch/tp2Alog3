package algoCraft.mapa;

import org.junit.Assert;

import org.junit.Test;


public class MapaTest {

	@Test
	public void testCrearMapaNoVacio() {
		Mapa mapa = Mapa.getInstance();

		Assert.assertNotNull(mapa);
	}

	@Test
	public void testCrearUnicaInstanciaDeMapa() {
		Mapa mapa1 = Mapa.getInstance();
		Mapa mapa2 = Mapa.getInstance();

		Assert.assertEquals(mapa1, mapa2);
	}

	@Test
	public void testPosicionesFueraLimitesDeMapa() {
		Mapa mapa = Mapa.getInstance();
		Assert.assertEquals(true, mapa.fueraLimites(500, 500));
		Assert.assertEquals(true, mapa.fueraLimites(500, 0));
		Assert.assertEquals(true, mapa.fueraLimites(0, 500));
		Assert.assertEquals(true, mapa.fueraLimites(-1, 0));
	}

	@Test
	public void testPosicionesDentroLimitesDeMapa() {
		Mapa mapa = Mapa.getInstance();
		Assert.assertEquals(false, mapa.fueraLimites(0, 0));
		Assert.assertEquals(false, mapa.fueraLimites(499, 499));
		Assert.assertEquals(false, mapa.fueraLimites(300, 200));
	}





}
