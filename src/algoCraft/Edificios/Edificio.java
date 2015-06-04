package Edificios;
public abstract class Edificio {
	
	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected int vida;
	protected String nombre;
	
	public int getPrecioM(){
		return precioM;
	}
	public int getPrecioG(){
		return precioG;
	}
	public int getVida(){
		return vida;
	}
	public String getNombre(){
		return nombre;
	}
}
