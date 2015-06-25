package vista.objetosMapaVista;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

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

//		dibujarAreaVisible(g);
	}

	public void dibujarCoord(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.drawString("X UNID: " + objMapa.obtenerX(), 40, 50);
		g.drawString("Y UNID: " + objMapa.obtenerY(), 40, 60);
		g.setColor(Color.BLACK);
	}

	private void dibujarAreaVisible(Graphics2D g) {
		g.setColor(Color.RED);
		Rectangle areaChoque = objMapa.obtenerAreaVisible();
		g.drawRect((int) areaChoque.getX(), (int) areaChoque.getY(),
				(int) areaChoque.getWidth(), (int) areaChoque.getHeight());
		g.setColor(Color.BLACK);
	}

//	public void cargarRutaImagen(String rutaImagen) {
//		this.rutaImagen = rutaImagen;
//	}



}
