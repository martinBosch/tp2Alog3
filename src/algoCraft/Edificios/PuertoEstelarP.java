package Edificios;

public class PuertoEstelarP extends EdificioProtoss{ //Protoss

	public PuertoEstelarP(int x, int y){
		super(x, y);

		precioM= 150;
		precioG= 150;
		tiempoConstruccion= 10;
		vida= 600;//no se entiende
		nombre= "Puerto Estelar";
		edifNecesario.add(Acceso.class);
		escudo=600;
		escudoMax=600;
	}
	
	
}
