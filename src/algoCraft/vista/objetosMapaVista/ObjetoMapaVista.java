package vista.objetosMapaVista;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import mapa.ObjetoMapa;

public abstract class ObjetoMapaVista {

	protected ObjetoMapa objMapa;
	int tiempoConstruccion;

	protected String rutaImagen;

	protected Image imagen;


	public ObjetoMapaVista (ObjetoMapa objMapa, String rutaImagen){
		this.objMapa = objMapa;
		tiempoConstruccion = objMapa.getTiempoConstruccion();

		this.rutaImagen = rutaImagen;
		imagen = obtenerImagen();
	}

	private Image obtenerImagen() {
		ImageIcon img = new ImageIcon(this.getClass().getResource(rutaImagen));
		return img.getImage();
	}

	public void dibujar(Graphics2D g) {
		g.drawImage(imagen, objMapa.obtenerX(), objMapa.obtenerY(), null);
	}

	public void dibujarConTransparencia(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g.create();

		float num1 = (float)tiempoConstruccion - (float)objMapa.getTiempoConstruccion();
		float num2 = num1 / (float)tiempoConstruccion;
		float num3 = num2 * (0.5f);
		float num4 = num3 + 0.5f;
		float opacity = num4;

		g2d.setComposite(AlphaComposite.getInstance( AlphaComposite.SRC_OVER, opacity ));
		g2d.drawImage(imagen, objMapa.obtenerX(), objMapa.obtenerY(), null);
	}

	public void dibujarDatos(Graphics2D g, int ancho) {
		g.setColor(Color.GREEN);
		int alto = 20;

		g.drawString("NOMBRE: " + objMapa.getNombre(), ancho, alto);
		alto+=15;
		g.drawString("VIDA: " + objMapa.getVida(), ancho, 35);
		alto+=15;
		g.drawString("X: " + objMapa.obtenerX(), ancho, 50);
		alto+=15;
		g.drawString("Y: " + objMapa.obtenerY(), ancho, 65);
		alto+=15;

		int escudo = objMapa.getEscudo();
		if(escudo >= 0) {
			g.drawString("ESCUDO: " + escudo, ancho, alto);
			alto+=15;
		}

		int energia = objMapa.getEnergia();
		if(energia >= 0) {
			g.drawString("ENERGIA: " + energia, ancho, alto);
			alto+=15;
		}

		int tiempoConstruccion = objMapa.getTiempoConstruccion();
		if(tiempoConstruccion > 0) {
			g.drawString("TIEMPO", ancho, alto);
			alto+=15;
			g.drawString("CONSTRUCCION: " + tiempoConstruccion, ancho, alto);
			alto+=15;
		}

		g.setColor(Color.BLACK);
	}

	public boolean esDeObjMapa(ObjetoMapa objMapa) {
		return this.objMapa == objMapa;
	}

	public boolean seCreo() {
		return this.objMapa.vive();
	}

}
