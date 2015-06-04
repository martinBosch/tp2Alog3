package Unidades;
public abstract class Unidad {

	protected int transporte;
	protected int vision;
	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected int danioA;
	protected int danioT;
	protected int suministro;
	protected int rangoA;
	protected int rangoT;
	protected int vida;
	protected String nombre;
	
	public String getNombre(){
		return nombre;
	}
	public void construir(){};
	public int getPrecioM(){
		return precioM;
	}
	public int getVision() {
		return vision;
	};
	public int getPrecioG(){
		return precioG;
	}
	public int getSuministros(){
		return suministro;
	}
	public int getDanioA(){
		return danioA;
	}
	public int getDanioT(){
		return danioT;
	}
	public int getRangoA(){
		return rangoA;
	}
	public int getRangoT(){
		return rangoT;
	}
	public int getVida(){
		return vida;
	}
	public int getTiempoConstruccion(){
		return tiempoConstruccion;
	}
	public void bajarVida (int vidaABajar){
		if(this.vida>vidaABajar){
			this.vida=this.vida-vidaABajar;
		}else{
			this.vida=0;
		}
	}
}
