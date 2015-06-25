package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constantes.Constantes;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	public Ventana(Panel panel) {

		setSize(Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
		setTitle("Mover imagen con java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());

		add(panel, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}


}