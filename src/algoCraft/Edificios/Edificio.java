package Edificios;
public abstract class Edificio {
	
	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected int vida;
	protected String nombre;
	protected int posX;
	protected int posY;
	
	public int getPrecioM(){
		return precioM;
	}
	public int getPosX(){
		return this.posX;
	}	
	public int getPosY(){
		return this.posY;
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
