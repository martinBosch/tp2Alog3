package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Edificios.Acceso;
import Edificios.ArchivosTemplarios;
import Edificios.Barraca;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.Fabrica;
import Edificios.Pilon;
import Edificios.PuertoEstelarP;
import Edificios.PuertoEstelarT;
import Jugador.Jugador;
import Razas.Raza;
import Razas.RazaBuilder;

public class EdificioTest {

	@Test
	public void testAcceso() {
		Acceso acceso = new Acceso();
		assertTrue(acceso.getPrecioG() == 0);
		assertTrue(acceso.getPrecioM() == 150);
		assertTrue(acceso.getNombre() == "Acceso");
		assertTrue(acceso.getVida() == 500);
	}

	@Test
	public void testPoblacionMaxima() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearTerran());
		assertTrue(jugador.getPoblacionMax() == 5);

	}

	@Test
	public void testCrearEdificioConJugadorResteMineral() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio acceso = new Acceso();
		Edificio puertoEstelar = new PuertoEstelarP();
		jugador.crearEdificio(acceso);
		jugador.crearEdificio(puertoEstelar);
		assertTrue(jugador.getMinerales() == 200);

	}

	@Test
	public void testCrearEdificiosYAgregarlosAListaProtoss() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(3000);
		jugador.modificarGas(3000);
		Edificio acceso = new Acceso();
		jugador.crearEdificio(acceso);
		Edificio puertoEstelar = new PuertoEstelarP();
		jugador.crearEdificio(puertoEstelar);
		Edificio archivosTemplarios = new ArchivosTemplarios();
		jugador.crearEdificio(archivosTemplarios);
		assertTrue(jugador.getCantidadEdificios() == 3);

	}

	@Test
	public void testCrearEdificiosYAgregarlosAListaTerran() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearTerran());
		jugador.modificarMineral(3000);
		jugador.modificarGas(3000);
		Edificio barraca = new Barraca();
		jugador.crearEdificio(barraca);
		Edificio fabrica = new Fabrica();
		jugador.crearEdificio(fabrica);
		Edificio puertoEstelar = new PuertoEstelarT();
		jugador.crearEdificio(puertoEstelar);
		assertTrue(jugador.getCantidadEdificios() == 3);

	}

	@Test
	public void testCrearEdificioConJugadorResteGas() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio acceso = new Acceso();
		jugador.crearEdificio(acceso);
		Edificio puertoEstelar = new PuertoEstelarP();
		jugador.crearEdificio(puertoEstelar);
		assertTrue(jugador.getGases() == 150);

	}

	@Test
	public void testAumentarPoblacionMaxima() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		Edificio pilon = new Pilon();
		jugador.crearEdificio(pilon);
		assertTrue(jugador.getPoblacionMax() == 10);

	}

	@Test
	public void testCrearEdificioRaza() {
		RazaBuilder razaBuilder = new RazaBuilder();
		Raza raza = razaBuilder.crearProtoss();
		Edificio deposito = new DepositoSuministro();
		boolean puedeCrear = (raza.crearEdificio(100, 0, null, deposito));
		assertFalse(puedeCrear);

	}

}
