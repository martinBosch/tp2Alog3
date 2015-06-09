package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Edificios.Acceso;
import Edificios.ArchivosTemplarios;
import Edificios.Asimilador;
import Edificios.Barraca;
import Edificios.Edificio;
import Edificios.CentroMineral;
import Edificios.DepositoSuministro;
import Edificios.Fabrica;
import Edificios.NexoMineral;
import Edificios.Pilon;
import Edificios.PuertoEstelarP;
import Edificios.PuertoEstelarT;
import Edificios.Refineria;
import Unidades.AltoTemplario;
import Unidades.Dragon;
import Unidades.Espectro;
import Unidades.Golliat;
import Unidades.Marine;
import Unidades.NaveCiencia;
import Unidades.NaveTransportadorP;
import Unidades.NaveTransportadorT;
import Unidades.Scout;
import Unidades.Zealot;
import Jugador.Jugador;
import Razas.Raza;
import Razas.RazaBuilder;
import Razas.Terran;
import Razas.Protoss;
import mapa.Mapa;
import recursos.GasVespeno;
import recursos.Minerales;


public class EdificioTest {

	@Test
	public void testAcceso() {
		Acceso acceso =new Acceso();
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
		Edificio pilon = new Pilon();
		Edificio puertoEstelar = new PuertoEstelarP();
		jugador.crearEdificio(pilon);
		jugador.crearEdificio(puertoEstelar);
		assertTrue(jugador.getGases() == 150);
	
	}
	
	@Test
	public void testCrearEdificioConJugadorResteMinerales() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio pilon = new Pilon();
		jugador.crearEdificio(pilon);
		Edificio puertoEstelar = new PuertoEstelarP();
		jugador.crearEdificio(puertoEstelar);
		assertTrue(jugador.getMinerales() == 250);
	
	}
	
	@Test
	public void testCrearEdificioYAgregarloALista() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio asimilador = new Asimilador();
		jugador.crearEdificio(asimilador);
		assertTrue(jugador.getCantidadEdificios() == 1);
	
	}
	
	@Test
	public void testCrearEdificioConJugadorResteGas() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.elegirRaza(raza.crearProtoss());
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		Edificio pilon = new Pilon();
		jugador.crearEdificio(pilon);
		Edificio puertoEstelar = new PuertoEstelarP();
		jugador.crearEdificio(puertoEstelar);
		System.out.println(jugador.getGases());
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
		boolean puedeCrear =(raza.crearEdificio(100, 0, null, deposito));
		assertFalse(puedeCrear);
		
	}
	
	
	
}
