package Edificios;

public class ArchivosTemplarios extends Edificio { // Protoss

	public ArchivosTemplarios(int x, int y) {
		super(x, y);

		precioM = 150;
		precioG = 200;
		tiempoConstruccion = 9;
		vida = 500; // NO SE ENTIENDE
		nombre = "Archivos Templarios";
		edifNecesario.add(PuertoEstelarP.class);
	}

}
