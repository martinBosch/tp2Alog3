package vista.objetosMapaVista;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import mapa.ObjetoMapa;

public abstract class ObjetoMapaVista {

	protected ObjetoMapa objMapa;

	protected String rutaImagen;

	protected Image imagen;


	public ObjetoMapaVista (ObjetoMapa objMapa, String rutaImagen){
		this.objMapa = objMapa;
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


}
