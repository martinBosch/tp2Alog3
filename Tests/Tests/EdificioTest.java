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
import Razas.Terran;
import Razas.Protoss;
import mapa.Mapa;
import recursos.GasVespeno;
import recursos.Minerales;


public class TestsEdificio {

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
		jugador.elegirRaza(1);		
		assertTrue(jugador.getPoblacionMax() == 5);
		
	}

	@Test
	public void testCrearEdificioConJugadorResteMineral() {
		Jugador jugador = new Jugador();
		jugador.elegirRaza(2);
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		jugador.crearEdificio(2);
		jugador.crearEdificio(5);
		assertTrue(jugador.getGases() == 200);
	
	}
	
	@Test
	public void testCrearEdificioConJugadorResteMinerales() {
		Jugador jugador = new Jugador();
		jugador.elegirRaza(2);
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		jugador.crearEdificio(2);
		jugador.crearEdificio(5);
		assertTrue(jugador.getMinerales() == 150);
	
	}
	
	@Test
	public void testCrearEdificioYAgregarloALista() {
		Jugador jugador = new Jugador();
		jugador.elegirRaza(2);
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		jugador.crearEdificio(3);
		assertTrue(jugador.getCantidadEdificios() == 1);
	
	}
	
	@Test
	public void testCrearEdificioConJugadorResteGas() {
		Jugador jugador = new Jugador();
		jugador.elegirRaza(2);
		jugador.modificarMineral(300);
		jugador.modificarGas(300);
		jugador.crearEdificio(2);
		jugador.crearEdificio(5);
		assertTrue(jugador.getGases() == 200);
		
	}
	
	@Test
	public void testAumentarPoblacionMaxima() {
		Jugador jugador = new Jugador();
		jugador.elegirRaza(2);
		jugador.crearEdificio(3);
		assertTrue(jugador.getPoblacionMax() == 10);

	} 
	
	@Test
	public void testCrearEdificioRaza() {
		Terran raza = new Terran();
		Edificio edif = raza.crearEdificio(100, 0, null, 3);
		assertTrue(edif.getNombre() == "Deposito Suministro");
		
	}
	
	
	
}
