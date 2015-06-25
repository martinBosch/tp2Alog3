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
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionPoblacionInsuficiente;
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
		jugador.asignarRaza(raza.crearTerran());
		assertTrue(jugador.getPoblacionMax() == 5);

	}

	@Test
	public void testCrearEdificioConJugadorResteMineral() throws  ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio acceso = new Acceso(x,y);
		Edificio puertoEstelar = new PuertoEstelarP(x,y);
		jugador.crearEdificio(0, 0, acceso);
		for(int i=1;i<=8;i++){
			jugador.pasarTurno();
		}
		jugador.crearEdificio(0, 0, puertoEstelar);
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		assertTrue(jugador.getMinerales() == 200);

	}

	@Test
	public void testCrearEdificiosYAgregarlosAListaProtoss() throws  ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearProtoss());
		jugador.modificarMineral(3000);
		jugador.modificarGas(3000);
		
		Edificio acceso = new Acceso(x,y);
		jugador.crearEdificio(0, 0, acceso);
		
		for(int i=1;i<=8;i++){
			jugador.pasarTurno();
		}
		
		Edificio puertoEstelar = new PuertoEstelarP(x,y);
		jugador.crearEdificio(0, 0, puertoEstelar);
		
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		
		Edificio archivosTemplarios = new ArchivosTemplarios(x,y);
		jugador.crearEdificio(0, 0, archivosTemplarios);
		
		for(int i=1;i<=9;i++){
			jugador.pasarTurno();
		}
		
		assertTrue(jugador.getCantidadEdificios() == 3);

	}

	@Test
	public void testCrearEdificiosYAgregarlosAListaTerran() throws  ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());
		jugador.modificarMineral(3000);
		jugador.modificarGas(3000);
		
		Edificio barraca = new Barraca(x,y);
		jugador.crearEdificio(0, 0, barraca);
		
		for(int i=1;i<=12;i++){
			jugador.pasarTurno();
		}
		
		Edificio fabrica = new Fabrica(x,y);
		jugador.crearEdificio(0, 0, fabrica);
		
		for(int i=1;i<=12;i++){
			jugador.pasarTurno();
		}
		
		Edificio puertoEstelar = new PuertoEstelarT(x,y);
		jugador.crearEdificio(0, 0, puertoEstelar);
		
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		
		assertTrue(jugador.getCantidadEdificios() == 3);

	}

	@Test
	public void testCrearEdificioConJugadorResteGas() throws  ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio acceso = new Acceso(x,y);
		Edificio puertoEstelar = new PuertoEstelarP(x,y);
		jugador.crearEdificio(0, 0, acceso);
		for(int i=1;i<=8;i++){
			jugador.pasarTurno();
		}
		jugador.crearEdificio(0, 0, puertoEstelar);
		for(int i=1;i<=10;i++){
			jugador.pasarTurno();
		}
		assertTrue(jugador.getGases() == 150);

	}

	@Test
	public void testAumentarPoblacionMaxima() throws  ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearProtoss());
		Edificio pilon = new Pilon(x,y);
		jugador.crearEdificio(0, 0, pilon);
		assertFalse(jugador.getPoblacionMax() == 10);
		for(int i=1;i<=5;i++){
			jugador.pasarTurno();
		}
		assertTrue(jugador.getPoblacionMax() == 10);
	}

	@Test
	public void testCrearEdificioRaza() throws ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		RazaBuilder razaBuilder = new RazaBuilder();
		Raza raza = razaBuilder.crearProtoss();
		Edificio deposito = new DepositoSuministro(x,y);
		boolean puedeCrear = (raza.crearEdificio(100, 0, null, deposito, null));
		assertFalse(puedeCrear);

	}

}
