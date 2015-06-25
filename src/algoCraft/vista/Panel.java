package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.objetosMapaVista.ObjetoMapaVista;
import Jugador.Jugador;
import algoCraft.AlgoCraft;
import constantes.Constantes;
import control.Boton;
import control.Raton;
import control.Teclado;

public class Panel extends JPanel implements PanelAgregable {

	private static final long serialVersionUID = 1L;

	private ArrayList<ObjetoMapaVista> objsMapaVista;
	
	private AlgoCraft juego;

	private Teclado teclado;// provisorio para dibujar limites.
	private Raton raton;
	private Boton botonOyente;

	public Panel(AlgoCraft juego) {

		objsMapaVista = new ArrayList<ObjetoMapaVista>();
		this.juego = juego;
		agregarBotones();

		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		// esta linea permite comenzar a mover el mouse o el teclado
		// sin hacer click en la ventana.
		setFocusable(true);
	}

	public void repintar() {
		paintImmediately(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}

	@Override
	public void paintComponent(Graphics grafica) {

		// limpia la grafica para que no se dibuje sobre
		// lo dibujado con la llamada anterior.
		super.paintComponent(grafica);
		Graphics2D g2 = (Graphics2D) grafica;

		for( ObjetoMapaVista objMapaVista : objsMapaVista ) {
			objMapaVista.dibujar(g2);
		}

		agregarBotones();
//		teclado.dibujarLimites(g2);
	}

	public void agregarObjMapaVista(ObjetoMapaVista objMapaVista) {
		objsMapaVista.add(objMapaVista);
	}

	public void agregarControladores(Teclado teclado, Raton raton, Boton botonOyente) {
		this.teclado = teclado;
		addKeyListener(teclado);

		this.raton = raton;
		addMouseListener(raton);
		addMouseMotionListener(raton);
		
		this.botonOyente = botonOyente;
	}

	public void agregarBotones() {

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());

		panelBotones.add( obtenerPanelUnidades(), BorderLayout.WEST );
		panelBotones.add( obtenerPanelEdificios(), BorderLayout.EAST );

		add( panelBotones, BorderLayout.SOUTH );


//		JButton boton = new JButton("Marine");
//		boton.setIcon(new ImageIcon(getClass().getResource("objetosMapaVista/imagenes/Marine.png")));
//		boton.setFocusable(false);
//		boton.addActionListener( botonOyente );
//		add(boton, BorderLayout.SOUTH);
	}


	public JPanel obtenerPanelUnidades() {
		JPanel panelUnidades = new JPanel();
		panelUnidades.setLayout(new GridLayout(3,2));

		Jugador jugTurno = juego.obtenerJugadorTurno();
		ArrayList<String> nombreUnidades = jugTurno.obtenerNombreUnidades();
		ArrayList<String> rutaImagenUnidades = jugTurno.obtenerRutaImagenUnidades();

		for( int i=0; i<Constantes.CANTIDAD_UNIDADES; i++ ) {
			System.out.println(i);
			System.out.println(	rutaImagenUnidades.get(i) );

			JButton boton = new JButton(nombreUnidades.get(i));
			boton.setIcon(new ImageIcon(getClass().getResource( rutaImagenUnidades.get(i) )));
			boton.setFocusable(false);
			boton.addActionListener( botonOyente );
			panelUnidades.add(boton);
		}
		return panelUnidades;
	}

	public JPanel obtenerPanelEdificios() {
		JPanel panelEdificios = new JPanel();
		panelEdificios.setLayout(new GridLayout(3,2));

		Jugador jugTurno = juego.obtenerJugadorTurno();
		ArrayList<String> nombreEdificios = jugTurno.obtenerNombreEdificios();
		ArrayList<String> rutaImagenEdificios = jugTurno.obtenerRutaImagenEdificios();

		for( int i=0; i<Constantes.CANTIDAD_UNIDADES; i++ ) {
			System.out.println(i);
			System.out.println(	rutaImagenEdificios.get(i) );

			JButton boton = new JButton(nombreEdificios.get(i));
			boton.setIcon(new ImageIcon(getClass().getResource( rutaImagenEdificios.get(i) )));
			boton.setFocusable(false);
			boton.addActionListener( botonOyente );
			panelEdificios.add(boton);
		}
		return panelEdificios;
	}

}