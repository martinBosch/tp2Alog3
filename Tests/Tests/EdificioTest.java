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

	private static int x = 0;
	private static int y = 0;

	@Test
	public void testAcceso() {
		Acceso acceso = new Acceso(x,y);
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
		Edificio acceso = new Acceso(x,y);
		Edificio puertoEstelar = new PuertoEstelarP(x,y);
		jugador.crearEdificio(acceso);
		for(int i=1;i<=8;i++){
			jugador.pasarTurno();
		}
		jugador.crearEdificio(puertoEstelar);
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		assertTrue(jugador.getMinerales() == 200);

	}

	@Test
	public void testCrearEdificiosYAgregarlosAListaProtoss() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(3000);
		jugador.modificarGas(3000);
		
		Edificio acceso = new Acceso(x,y);
		jugador.crearEdificio(acceso);
		
		for(int i=1;i<=8;i++){
			jugador.pasarTurno();
		}
		
		Edificio puertoEstelar = new PuertoEstelarP(x,y);
		jugador.crearEdificio(puertoEstelar);
		
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		
		Edificio archivosTemplarios = new ArchivosTemplarios(x,y);
		jugador.crearEdificio(archivosTemplarios);
		
		for(int i=1;i<=9;i++){
			jugador.pasarTurno();
		}
		
		assertTrue(jugador.getCantidadEdificios() == 3);

	}

	@Test
	public void testCrearEdificiosYAgregarlosAListaTerran() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearTerran());
		jugador.modificarMineral(3000);
		jugador.modificarGas(3000);
		
		Edificio barraca = new Barraca(x,y);
		jugador.crearEdificio(barraca);
		
		for(int i=1;i<=12;i++){
			jugador.pasarTurno();
		}
		
		Edificio fabrica = new Fabrica(x,y);
		jugador.crearEdificio(fabrica);
		
		for(int i=1;i<=12;i++){
			jugador.pasarTurno();
		}
		
		Edificio puertoEstelar = new PuertoEstelarT(x,y);
		jugador.crearEdificio(puertoEstelar);
		
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		
		assertTrue(jugador.getCantidadEdificios() == 3);

	}

	@Test
	public void testCrearEdificioConJugadorResteGas() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio acceso = new Acceso(x,y);
		Edificio puertoEstelar = new PuertoEstelarP(x,y);
		jugador.crearEdificio(acceso);
		for(int i=1;i<=8;i++){
			jugador.pasarTurno();
		}
		jugador.crearEdificio(puertoEstelar);
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		assertTrue(jugador.getGases() == 150);

	}

	@Test
	public void testAumentarPoblacionMaxima() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		Edificio pilon = new Pilon(x,y);
		jugador.crearEdificio(pilon);
		assertFalse(jugador.getPoblacionMax() == 10);
		for(int i=1;i<=5;i++){
			jugador.pasarTurno();
		}
		assertTrue(jugador.getPoblacionMax() == 10);

	}

	@Test
	public void testCrearEdificioRaza() {
		RazaBuilder razaBuilder = new RazaBuilder();
		Raza raza = razaBuilder.crearProtoss();
		Edificio deposito = new DepositoSuministro(x,y);
		boolean puedeCrear = (raza.crearEdificio(100, 0, null, deposito));
		assertFalse(puedeCrear);

	}

}
