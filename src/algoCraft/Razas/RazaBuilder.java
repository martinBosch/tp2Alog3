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
import Unidades.NaveTransporteP;
import Unidades.NaveTransporteT;
import Unidades.Scout;
import Unidades.Zealot;

@SuppressWarnings("rawtypes")
public class RazaBuilder {

	public Raza crearTerran() {
		// Se utiliza una posicion cualquiera.
		// Solo se quiere saber la clase del onjeto.
		int x = 0;
		int y = 0;

		ArrayList<Class> listaEdificios = new ArrayList<Class>();

		CentroMineral aux = new CentroMineral(x,y);
		listaEdificios.add(aux.getClass());
		Barraca aux1 = new Barraca(x,y);
		listaEdificios.add(aux1.getClass());
		DepositoSuministro aux2 = new DepositoSuministro(x,y);
		listaEdificios.add(aux2.getClass());
		Refineria aux3 = new Refineria(x,y);
		listaEdificios.add(aux3.getClass());
		Fabrica aux4 = new Fabrica(x,y);
		listaEdificios.add(aux4.getClass());
		PuertoEstelarT aux5 = new PuertoEstelarT(x,y);
		listaEdificios.add(aux5.getClass());

		ArrayList<Class> listaUnidades = new ArrayList<Class>();

		Marine uni1 = new Marine(x,y);
		listaUnidades.add(uni1.getClass());
		Golliat uni2 = new Golliat(x,y);
		listaUnidades.add(uni2.getClass());
		Espectro uni3 = new Espectro(x,y);
		listaUnidades.add(uni3.getClass());
		NaveCiencia uni4 = new NaveCiencia(x,y);
		listaUnidades.add(uni4.getClass());
		NaveTransporteP uni5 = new NaveTransporteP(x,y);
		listaUnidades.add(uni5.getClass());

		Raza raza = new Terran(listaEdificios, listaUnidades);

		return raza;
	}

	public Raza crearProtoss() {
		// Se utiliza una posicion cualquiera.
		// Solo se quiere saber la clase del onjeto.
		int x = 0;
		int y = 0;

		ArrayList<Class> listaEdificios = new ArrayList<Class>();

		NexoMineral aux = new NexoMineral(x,y);
		listaEdificios.add(aux.getClass());
		Pilon aux1 = new Pilon(x,y);
		listaEdificios.add(aux1.getClass());
		Asimilador aux2 = new Asimilador(x,y);
		listaEdificios.add(aux2.getClass());
		Acceso aux3 = new Acceso(x,y);
		listaEdificios.add(aux3.getClass());
		PuertoEstelarP aux4 = new PuertoEstelarP(x,y);
		listaEdificios.add(aux4.getClass());
		ArchivosTemplarios aux5 = new ArchivosTemplarios(x,y);
		listaEdificios.add(aux5.getClass());

		ArrayList<Class> listaUnidades = new ArrayList<Class>();

		Zealot uni1 = new Zealot(x,y);
		listaUnidades.add(uni1.getClass());
		Dragon uni2 = new Dragon(x,y);
		listaUnidades.add(uni2.getClass());
		Scout uni3 = new Scout(x,y);
		listaUnidades.add(uni3.getClass());
		AltoTemplario uni4 = new AltoTemplario(x,y);
		listaUnidades.add(uni4.getClass());
		NaveTransporteT uni5 = new NaveTransporteT(x,y);
		listaUnidades.add(uni5.getClass());

		Raza raza = new Protoss(listaEdificios, listaUnidades);

		return raza;
	}

}
