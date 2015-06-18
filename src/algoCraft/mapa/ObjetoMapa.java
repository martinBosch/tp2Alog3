package mapa;

import java.awt.Rectangle;
import java.util.ArrayList;
@SuppressWarnings("rawtypes")

public abstract class ObjetoMapa {

	protected String nombre;

	protected int posX;
	protected int posY;
	protected int ancho;
	protected int alto;

	protected int vida;

	protected int precioM;
	protected int precioG;
	protected int tiempoConstruccion;
	protected ArrayList<Class> edifNecesario;



	public ObjetoMapa(int x, int y) {
		posX = x;
		posY = y;
		edifNecesario = new ArrayList<Class>();
	}

	public Rectangle obtenerAreaOcupa() {
		return new Rectangle(posX, posY, ancho, alto);
	}

	public void mover(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getVida() {
		return vida;
	}

	public ArrayList<Class> getEdifNecesario() {
		return edifNecesario;
	}
	
	public int getPrecioM() {
		return precioM;
	}

	public int getPrecioG() {
		return precioG;
	}

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void bajarTiempoConstruccion() {
		tiempoConstruccion--;
	}
		
	public void recibirDanio(int danio) {
		vida -= danio;

//		if (this.vida > vidaABajar) {
//			this.vida = this.vida - vidaABajar;
//		} else {
//			this.vida = 0;
//		}
	} 
 
//	public void atacarEdificio(Edificio edificioAAtacar) {
//		double DiferenciaPosicionX = Math.pow(
//				this.getPosX() - edificioAAtacar.getPosX(), 2);
//		double DiferenciaPosicionY = Math.pow(
//				this.getPosY() - edificioAAtacar.getPosY(), 2);
//		if (DiferenciaPosicionX + DiferenciaPosicionY <= Math.pow(
//				this.getRangoT(), 2)) {
//			edificioAAtacar.bajarVida(this.getDanioT());
//		}
//	}

	public int distancia(ObjetoMapa atacado) {
		int x = posX - atacado.getPosX();
		int y = posY - atacado.getPosY();

		return (int) Math.sqrt( x*x + y*y );
	}

}
