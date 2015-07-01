package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Edificios.Acceso;
import Edificios.Barraca;
import Edificios.DepositoSuministro;
import Edificios.Edificio;
import Edificios.Fabrica;
import Edificios.PuertoEstelarT;
import Excepciones.ExcepcionGasesInsuficientes;
import Excepciones.ExcepcionMineralesInsuficientes;
import Excepciones.ExcepcionNoPoseeEdifNecesario;
import Excepciones.ExcepcionPoblacionMaxSuperada;
import Jugador.Jugador;
import Razas.RazaBuilder;
import Unidades.AltoTemplario;
import Unidades.Dragon;
import Unidades.Espectro;
import Unidades.Golliat;
import Unidades.Marine;
import Unidades.NaveCiencia;
import Unidades.Unidad;
import Unidades.UnidadProtoss;
import Unidades.Zealot;

public class UnidadesTest {

	private static int x = 0;
	private static int y = 0;

	@Test
	public void testCreacionAltosTemplarios() {
		AltoTemplario templario = new AltoTemplario(x, y);
		assertTrue(templario.getPrecioG() == 150);
		assertTrue(templario.getPrecioM() == 50);
		assertTrue(templario.getNombre() == "Alto Templario");
		assertTrue(templario.getSuministros() == 2);
		assertTrue(templario.getVision() == 7);
		assertTrue(templario.getDanioA() == 0);
		assertTrue(templario.getDanioT() == 0);
		assertTrue(templario.getRangoA() == 5);
		assertTrue(templario.getRangoT() == 5);
		assertTrue(templario.getVida() == 40);
		assertTrue(templario.getTiempoConstruccion() == 7);
	}

	@Test
	public void testCreacionDragones() {
		Dragon dragon = new Dragon(x, y);
		assertTrue(dragon.getPrecioM() == 125);
		assertTrue(dragon.getPrecioG() == 50);
		assertTrue(dragon.getNombre() == "Dragon");
		assertTrue(dragon.getSuministros() == 2);
		assertTrue(dragon.getVision() == 8);
		assertTrue(dragon.getDanioA() == 20);
		assertTrue(dragon.getDanioT() == 20);
		assertTrue(dragon.getRangoA() == 4);
		assertTrue(dragon.getRangoT() == 4);
		assertTrue(dragon.getVida() == 150);
		assertTrue(dragon.getTiempoConstruccion() == 6);
	}

	@Test
	public void testCreacionEspectro() {
		Espectro espectro = new Espectro(x, y);
		assertTrue(espectro.getPrecioG() == 100);
		assertTrue(espectro.getPrecioM() == 150);
		assertTrue(espectro.getNombre() == "Espectro");
		assertTrue(espectro.getSuministros() == 2);
		assertTrue(espectro.getVision() == 7);
		assertTrue(espectro.getDanioA() == 20);
		assertTrue(espectro.getDanioT() == 8);
		assertTrue(espectro.getRangoA() == 5);
		assertTrue(espectro.getRangoT() == 5);
		assertTrue(espectro.getVida() == 120);
		assertTrue(espectro.getTiempoConstruccion() == 8);
	}

	@Test
	public void testCreacionGolliat() {
		Golliat golliat = new Golliat(x, y);
		assertTrue(golliat.getPrecioG() == 50);
		assertTrue(golliat.getPrecioM() == 100);
		assertTrue(golliat.getNombre() == "Golliat");
		assertTrue(golliat.getSuministros() == 2);
		assertTrue(golliat.getVision() == 8);
		assertTrue(golliat.getDanioA() == 10);
		assertTrue(golliat.getDanioT() == 12);
		assertTrue(golliat.getRangoA() == 5);
		assertTrue(golliat.getRangoT() == 6);
		assertTrue(golliat.getVida() == 125);
		assertTrue(golliat.getTiempoConstruccion() == 6);
	}

	@Test
	public void testCreacionMarine() {
		Marine marine = new Marine(x, y);
		assertTrue(marine.getPrecioG() == 0);
		assertTrue(marine.getPrecioM() == 50);
		assertTrue(marine.getNombre() == "Marine");
		assertTrue(marine.getSuministros() == 1);
		assertTrue(marine.getVision() == 7);
		assertTrue(marine.getDanioA() == 6);
		assertTrue(marine.getDanioT() == 6);
		assertTrue(marine.getRangoA() == 4);
		assertTrue(marine.getRangoT() == 4);
		assertTrue(marine.getVida() == 40);
		assertTrue(marine.getTiempoConstruccion() == 3);
	}

	@Test
	public void testPoblacionMaxima() {
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());
		assertTrue(jugador.getPoblacionMax() == 5);
	}

	@Test(expected=ExcepcionNoPoseeEdifNecesario.class)
	public void testCreacionUnidadSinEdificio() throws ExcepcionPoblacionMaxSuperada, 
	ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes,
	ExcepcionNoPoseeEdifNecesario 
	{
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());

		Unidad marine = new Marine(x, y);
		marine.setJugador(jugador);

		jugador.puedeCrearUnidad(marine);
	}

	@Test
	public void testCreacionUnidadConEdificio() throws ExcepcionPoblacionMaxSuperada,
	ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes 
	{
		Jugador jugador = new Jugador();

		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());

		jugador.modificarMineral(10000);

		Edificio barraca = new Barraca(x, y);
		barraca.setJugador(jugador);
		jugador.agregarEdificioACrear(barraca);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		Marine marine = new Marine(x, y);
		marine.setJugador(jugador);
		jugador.agregarUnidadACrear(marine);

		for (int i = 1; i <= 3; i++) {
			jugador.pasarTurno();
		}

		assertTrue(jugador.getPoblacion() == 1);
	}

	@Test(expected=ExcepcionGasesInsuficientes.class)
	public void testUnidadConMineralYsinGas() throws ExcepcionPoblacionMaxSuperada,
	ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes, ExcepcionNoPoseeEdifNecesario
	{
		Jugador jugador = new Jugador();
		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());
		jugador.modificarMineral(300);
		jugador.modificarMineral(10000);

		Edificio edificioACrear = new Barraca(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new Fabrica(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new PuertoEstelarT(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 10; i++) {
			jugador.pasarTurno();
		}
		Unidad espectro = new Espectro(x, y);
		espectro.setJugador(jugador);

		jugador.puedeCrearUnidad(espectro);
	}

	@Test
	public void testUnidadConMineralYConGas() throws ExcepcionPoblacionMaxSuperada,
	ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes 
	{
		Jugador jugador = new Jugador();

		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());

		jugador.modificarMineral(450);
		jugador.modificarGas(300);

		Edificio edificioACrear = new Barraca(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new Fabrica(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new PuertoEstelarT(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 10; i++) {
			jugador.pasarTurno();
		}

		Unidad espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		for (int i = 1; i <= 8; i++) {
			jugador.pasarTurno();
		}

		assertTrue(jugador.getPoblacion() == 2);
	}

	@Test(expected=ExcepcionMineralesInsuficientes.class)
	public void testUnidadSinMineralYConGas() throws ExcepcionPoblacionMaxSuperada,
	ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes,
	ExcepcionNoPoseeEdifNecesario
	{
		Jugador jugador = new Jugador();

		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());

		jugador.modificarMineral(300);
		jugador.modificarGas(500);

		Edificio edificioACrear = new Barraca(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new Fabrica(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new PuertoEstelarT(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 10; i++) {
			jugador.pasarTurno();
		}

		Unidad espectro = new Espectro(x, y);
		espectro.setJugador(jugador);

		jugador.puedeCrearUnidad(espectro);
	}

	@Test(expected=ExcepcionPoblacionMaxSuperada.class)
	public void testUnidadSinSuministros() throws ExcepcionPoblacionMaxSuperada,
	ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes,
	ExcepcionNoPoseeEdifNecesario 
	{
		Jugador jugador = new Jugador();

		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());

		jugador.modificarMineral(1000);
		jugador.modificarGas(1000);

		Edificio edificioACrear = new Barraca(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}
		edificioACrear = new Fabrica(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new PuertoEstelarT(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 10; i++) {
			jugador.pasarTurno();
		}

		Unidad espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		espectro = new Espectro(x, y);
		espectro.setJugador(jugador);

		jugador.puedeCrearUnidad(espectro);
	}

	@Test
	public void testUnidadConSuministrosAumentoDeSuministros()
			throws ExcepcionPoblacionMaxSuperada, ExcepcionGasesInsuficientes,
			ExcepcionMineralesInsuficientes 
	{
		Jugador jugador = new Jugador();

		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearTerran());

		jugador.modificarMineral(1500);
		jugador.modificarGas(1000);

		Edificio edificioACrear = new Barraca(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new Fabrica(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		edificioACrear = new PuertoEstelarT(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);
		edificioACrear = new DepositoSuministro(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 10; i++) {
			jugador.pasarTurno();
		}

		Unidad marine = new Marine(x, y);
		marine.setJugador(jugador);
		jugador.agregarUnidadACrear(marine);

		Unidad espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		espectro = new Espectro(x, y);
		espectro.setJugador(jugador);
		jugador.agregarUnidadACrear(espectro);

		for (int i = 1; i <= 8; i++) {
			jugador.pasarTurno();
		}

		assertTrue(jugador.getPoblacion() == 9);
	}

	@Test
	public void testEscudoProtoss() throws ExcepcionPoblacionMaxSuperada, ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugador = new Jugador();

		RazaBuilder raza = new RazaBuilder();
		jugador.asignarRaza(raza.crearProtoss());

		jugador.modificarMineral(1500);
		jugador.modificarGas(1000);

		Edificio edificioACrear = new Acceso(x, y);
		edificioACrear.setJugador(jugador);
		jugador.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		UnidadProtoss zealot = new Zealot(x, y);
		zealot.setJugador(jugador);
		jugador.agregarUnidadACrear(zealot);

		for (int i = 1; i <= 12; i++) {
			jugador.pasarTurno();
		}

		zealot.recibirDanio(50);

		assertEquals(zealot.getEscudo(), 10);

		jugador.pasarTurno();

		assertEquals(zealot.getEscudo(), 60);

		zealot.recibirDanio(100);

		jugador.pasarTurno();
		jugador.pasarTurno();

		assertEquals(zealot.getEscudo(), 0);
		assertEquals(zealot.getVida(), 60);

	}

	@Test
	public void testRadiacion() throws ExcepcionPoblacionMaxSuperada, ExcepcionGasesInsuficientes, ExcepcionMineralesInsuficientes {
		Jugador jugadorUno = new Jugador();
		jugadorUno.modificarMineral(1000);
		RazaBuilder raza = new RazaBuilder();
		jugadorUno.asignarRaza(raza.crearTerran());

		Edificio edificioACrear = new Barraca(x, y);
		edificioACrear.setJugador(jugadorUno);
		jugadorUno.agregarEdificioACrear(edificioACrear);

		for (int i = 1; i <= 12; i++) {
			jugadorUno.pasarTurno();
		}

		Unidad naveCiencia = new NaveCiencia(50, 50);
		naveCiencia.setJugador(jugadorUno);

		Unidad marine = new Marine(80, 80);
		marine.setJugador(jugadorUno);
		jugadorUno.agregarUnidadACrear(marine);

		for (int i = 1; i <= 10; i++) {
			jugadorUno.pasarTurno();
			((NaveCiencia) naveCiencia).aumentarEnergia();
		}
		Iterable<Unidad> listaAux = jugadorUno.getListaUnidades();
		Unidad unidad = listaAux.iterator().next();
		((NaveCiencia) naveCiencia).radiacion(unidad);
		jugadorUno.pasarTurno();
		assertEquals(unidad.getVida(), 30);
	}
}