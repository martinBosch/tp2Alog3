package Razas;

import java.util.ArrayList;

import Edificios.Acceso;
import Edificios.ArchivosTemplarios;
import Edificios.Asimilador;
import Edificios.Barraca;
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

@SuppressWarnings("rawtypes")
public class RazaBuilder {

	public Raza crearTerran() {

		ArrayList<Class> listaEdificios = new ArrayList<Class>();

		CentroMineral aux = new CentroMineral();
		listaEdificios.add(aux.getClass());
		Barraca aux1 = new Barraca();
		listaEdificios.add(aux1.getClass());
		DepositoSuministro aux2 = new DepositoSuministro();
		listaEdificios.add(aux2.getClass());
		Refineria aux3 = new Refineria();
		listaEdificios.add(aux3.getClass());
		Fabrica aux4 = new Fabrica();
		listaEdificios.add(aux4.getClass());
		PuertoEstelarT aux5 = new PuertoEstelarT();
		listaEdificios.add(aux5.getClass());

		ArrayList<Class> listaUnidades = new ArrayList<Class>();

		Marine uni1 = new Marine();
		listaUnidades.add(uni1.getClass());
		Golliat uni2 = new Golliat();
		listaUnidades.add(uni2.getClass());
		Espectro uni3 = new Espectro();
		listaUnidades.add(uni3.getClass());
		NaveCiencia uni4 = new NaveCiencia();
		listaUnidades.add(uni4.getClass());
		NaveTransportadorP uni5 = new NaveTransportadorP();
		listaUnidades.add(uni5.getClass());

		Raza raza = new Terran(listaEdificios, listaUnidades);

		return raza;
	}

	public Raza crearProtoss() {

		ArrayList<Class> listaEdificios = new ArrayList<Class>();

		NexoMineral aux = new NexoMineral();
		listaEdificios.add(aux.getClass());
		Pilon aux1 = new Pilon();
		listaEdificios.add(aux1.getClass());
		Asimilador aux2 = new Asimilador();
		listaEdificios.add(aux2.getClass());
		Acceso aux3 = new Acceso();
		listaEdificios.add(aux3.getClass());
		PuertoEstelarP aux4 = new PuertoEstelarP();
		listaEdificios.add(aux4.getClass());
		ArchivosTemplarios aux5 = new ArchivosTemplarios();
		listaEdificios.add(aux5.getClass());

		ArrayList<Class> listaUnidades = new ArrayList<Class>();

		Zealot uni1 = new Zealot();
		listaUnidades.add(uni1.getClass());
		Dragon uni2 = new Dragon();
		listaUnidades.add(uni2.getClass());
		Scout uni3 = new Scout();
		listaUnidades.add(uni3.getClass());
		AltoTemplario uni4 = new AltoTemplario();
		listaUnidades.add(uni4.getClass());
		NaveTransportadorT uni5 = new NaveTransportadorT();
		listaUnidades.add(uni5.getClass());

		Raza raza = new Protoss(listaEdificios, listaUnidades);

		return raza;
	}

}
