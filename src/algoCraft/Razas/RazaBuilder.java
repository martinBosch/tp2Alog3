package Razas;

import java.util.ArrayList;

import Unidades.*;
import Edificios.*;
import Razas.*;

public class RazaBuilder {

	public Raza crearTerran(){
		ArrayList<Class> listaEdificios = new ArrayList();
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
		PuertoEstelarP aux5 = new PuertoEstelarP();
		listaEdificios.add(aux5.getClass());
		
		ArrayList<Class> listaUnidades = new ArrayList();
		
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
		
		Raza raza = new Protoss(listaEdificios,listaUnidades);
		
		return raza;
	}
	
	public Raza crearProtoss(){
		ArrayList<Class> listaEdificios = new ArrayList();
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
		PuertoEstelarP aux5 = new PuertoEstelarP();
		listaEdificios.add(aux5.getClass());
		
		ArrayList<Class> listaUnidades = new ArrayList();
		
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
		
		Raza raza = new Protoss(listaEdificios,listaUnidades);
		
		return raza;
	}

}
