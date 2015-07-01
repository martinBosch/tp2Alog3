package Edificios;

public class ArchivosTemplarios extends EdificioProtoss { // Protoss

	public ArchivosTemplarios(int x, int y) {
		super(x, y);

		precioM = 150;
		precioG = 200;
		tiempoConstruccion = 9;
		vida = 500;
		nombre = "Archivos Templarios";
		edifNecesario.add(PuertoEstelarP.class);
		escudo=600;
		escudoMax=600;
	}

}
