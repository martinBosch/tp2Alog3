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

import mapa.Escenario;
import mapa.EscenarioBuilder;
import mapa.ObjetoMapa;
import vista.objetosMapaVista.EscenarioVista;
import vista.objetosMapaVista.ExplosionVista;
import vista.objetosMapaVista.JugadorVista;
import vista.objetosMapaVista.ObjetoMapaVista;
import Jugador.Jugador;
import algoCraft.AlgoCraft;
import constantes.Constantes;
import control.BotonEdificios;
import control.BotonPasarTurno;
import control.BotonUnidades;
import control.Raton;
import control.Teclado;
import efectos.Explosion;

public class Panel extends JPanel implements PanelAgregable,Repintable {

	private static final long serialVersionUID = 1L;

	private ArrayList<ObjetoMapaVista> objsMapaVista;
	private ArrayList<ObjetoMapaVista> objsMapaACrearVista;

	private AlgoCraft juego;
	private Escenario escenario;

	private String advertencia;
	private Teclado teclado;
	private BotonEdificios botonEdificios;
	private boolean cambiarBotones;


	public Panel(AlgoCraft juego) {

		objsMapaVista = new ArrayList<ObjetoMapaVista>();
		objsMapaACrearVista = new ArrayList<ObjetoMapaVista>();

		this.juego = juego;
		this.escenario = juego.obtenerEscenario();

		agregarControladores();
		cargarVistasIniciales();

		advertencia = "";
		cambiarBotones = true;

		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setFocusable(true);
	}



	public void cargarVistasIniciales() {
		EscenarioVista escenarioVista = new EscenarioVista(escenario);
		agregar(escenarioVista);

		Iterable<ObjetoMapaVista> vistasIniciales =
				( EscenarioBuilder.getInstance() ).obtenerEscenarioVistasIniciales();
		for(ObjetoMapaVista vista : vistasIniciales) {
			agregar(vista);
		}
	}


	public void repintar() {
		paintImmediately(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}


	@Override
	public void paintComponent(Graphics grafica) {

		super.paintComponent(grafica);
		Graphics2D g2 = (Graphics2D) grafica;

		for( ObjetoMapaVista objMapaVista : objsMapaVista ) {
			objMapaVista.dibujar(g2);
		}
		for( ObjetoMapaVista objMapaACrearVista : objsMapaACrearVista ) {
			objMapaACrearVista.dibujarConTransparencia(g2);
		}

		dibujarDatos(g2);
		dibujarAdvertencia(g2);

		if (cambiarBotones) {
			agregarBotones();
			cambiarBotones = false;
		}
	}

	public void agregarControladores() {

		Teclado teclado = new Teclado(escenario, this);
		this.teclado = teclado;
		addKeyListener(teclado);

		Raton raton = new Raton(juego, this);
		addMouseListener(raton);
		addMouseMotionListener(raton);
	}

	public void pasarTurno() {
		cambiarBotones();
		actualizarObjMapaACrearVista();
		teclado.moverObjetosEscenario();
	}

	private void actualizarObjMapaACrearVista() {
		ArrayList<ObjetoMapaVista> objsMapaVistaCreado = new ArrayList<ObjetoMapaVista>();

		for( ObjetoMapaVista objMapaACrearVista : objsMapaACrearVista ) {
			if( objMapaACrearVista.seCreo() ) {
				objsMapaVistaCreado.add(objMapaACrearVista);
			}
		}
		actualizarObjMapaVistaCreado(objsMapaVistaCreado);
	}

	private void actualizarObjMapaVistaCreado(ArrayList<ObjetoMapaVista> objsMapaVistaCreado) {
		for( ObjetoMapaVista objMapaVistaCreado : objsMapaVistaCreado ) {
			agregar(objMapaVistaCreado);
			objsMapaACrearVista.remove(objMapaVistaCreado);
		}
	}

	private void cambiarBotones() {
		cambiarBotones = true;
	}

	public void agregarBotones() {
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());

		panelBotones.add( obtenerPanelUnidades(), BorderLayout.WEST );
		panelBotones.add( obtenerPanelEdificios(), BorderLayout.EAST );

		JButton boton = new JButton("Pasar Turno");
		boton.setFocusable(false);
		boton.addActionListener( new BotonPasarTurno(juego, this) );
		panelBotones.add(boton, BorderLayout.CENTER);

		removeAll();
		add( panelBotones, BorderLayout.SOUTH );
		revalidate();
	}


	public JPanel obtenerPanelUnidades() {
		JPanel panelUnidades = new JPanel();
		panelUnidades.setLayout(new GridLayout(3,2));

		Jugador jugTurno = juego.obtenerJugadorTurno();
		BotonUnidades botonUnidades = new BotonUnidades(juego, this);

		ArrayList<String> nombreUnidades = jugTurno.obtenerNombreUnidades();

		ArrayList<String> rutaImagenUnidades = jugTurno.obtenerRutaImagenUnidades();

		for( int i=0; i<Constantes.CANTIDAD_UNIDADES; i++ ) {
			JButton boton = new JButton(nombreUnidades.get(i));
			boton.setIcon(new ImageIcon(getClass().getResource( rutaImagenUnidades.get(i) )));
			boton.setFocusable(false);
			boton.addActionListener( botonUnidades );
			panelUnidades.add(boton);
		}
		return panelUnidades;
	}

	public JPanel obtenerPanelEdificios() {
		JPanel panelEdificios = new JPanel();
		panelEdificios.setLayout(new GridLayout(3,2));

		Jugador jugTurno = juego.obtenerJugadorTurno();
		botonEdificios = new BotonEdificios(juego, this);

		ArrayList<String> nombreEdificios = jugTurno.obtenerNombreEdificios();
		ArrayList<String> rutaImagenEdificios = jugTurno.obtenerRutaImagenEdificios();

		for( int i=0; i<Constantes.CANTIDAD_EDIFICIOS; i++ ) {
			JButton boton = new JButton(nombreEdificios.get(i));
			boton.setIcon(new ImageIcon(getClass().getResource( rutaImagenEdificios.get(i) )));
			boton.setFocusable(false);
			boton.addActionListener( botonEdificios );
			panelEdificios.add(boton);
		}
		return panelEdificios;
	}

	public void crearEdificioAconstruir() {
		botonEdificios.crearEdificio();
	}

	public void agregarAtaque(ObjetoMapa atacado) {
		Iterable<ExplosionVista> explosionesVista = 
				obtenerExplosionesVista(atacado, obtenerRutasImagenes() );
		agregarExplosionesVista(explosionesVista);
	}

	public void agregarAtaqueMagico(ObjetoMapa atacado) {
		Iterable<ExplosionVista> explosionesVista = 
				obtenerExplosionesMagicasVista(atacado, obtenerRutasImagenesMagicas() );
		agregarExplosionesVista(explosionesVista);
	}

	private Iterable<String> obtenerRutasImagenesMagicas() {
		ArrayList<String> rutaImagenes = new ArrayList<String>();

		rutaImagenes.add("imagenes/magia1.png");
		rutaImagenes.add("imagenes/magia2.png");
		rutaImagenes.add("imagenes/magia3.png");
		rutaImagenes.add("imagenes/magia4.png");
		rutaImagenes.add("imagenes/magia5.png");
		rutaImagenes.add("imagenes/magia6.png");

		return rutaImagenes;
	}

	private Iterable<String> obtenerRutasImagenes() {
		ArrayList<String> rutaImagenes = new ArrayList<String>();

		rutaImagenes.add("imagenes/explosion1.png");
		rutaImagenes.add("imagenes/explosion2.png");
		rutaImagenes.add("imagenes/explosion3.png");
		rutaImagenes.add("imagenes/explosion4.png");
		rutaImagenes.add("imagenes/explosion5.png");
		rutaImagenes.add("imagenes/explosion6.png");

		return rutaImagenes;
	}

	private Iterable<ExplosionVista> obtenerExplosionesMagicasVista(ObjetoMapa atacado, 
			Iterable<String> rutaImagenes)
	{
		Explosion explosion = new Explosion(atacado.obtenerX()-160, atacado.obtenerY()-160);

		ArrayList<ExplosionVista> explosionesVista = new ArrayList<ExplosionVista>();
		for(String rutaImagen : rutaImagenes) {
			ExplosionVista explosionVista = new ExplosionVista(explosion, rutaImagen);
			explosionesVista.add(explosionVista);
		}
		return explosionesVista;
	}

	private Iterable<ExplosionVista> obtenerExplosionesVista(ObjetoMapa atacado, 
			Iterable<String> rutaImagenes)
	{
		Explosion explosion = new Explosion(atacado.obtenerX(), atacado.obtenerY() );

		ArrayList<ExplosionVista> explosionesVista = new ArrayList<ExplosionVista>();
		for(String rutaImagen : rutaImagenes) {
			ExplosionVista explosionVista = new ExplosionVista(explosion, rutaImagen);
			explosionesVista.add(explosionVista);
		}
		return explosionesVista;
	}

	private void agregarExplosionesVista(Iterable<ExplosionVista> explosionesVista) {
		for(ExplosionVista explosionVista : explosionesVista) {
			objsMapaVista.add(explosionVista);
			repintar();

			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
			}
			objsMapaVista.remove(explosionVista);
		}
	}




	public void agregar(ObjetoMapaVista objMapaVista) {
		objsMapaVista.add(objMapaVista);
	}

	public void agregarVistaACrear(ObjetoMapaVista objMapaVista) {
		objsMapaACrearVista.add(objMapaVista);
	}

	public void borrar(ObjetoMapa objMapa) {
		ObjetoMapaVista objMapaVista = obtenerObjMapaVista(objMapa);
		objsMapaVista.remove(objMapaVista);
	}

	public ObjetoMapaVista obtenerObjMapaVista(ObjetoMapa objMapa) {
		for(ObjetoMapaVista objMapaVista : objsMapaVista) {
			if( objMapaVista.esDeObjMapa(objMapa) ) {
				return objMapaVista;
			}
		}
		for(ObjetoMapaVista objMapaACrearVista : objsMapaACrearVista) {
			if( objMapaACrearVista.esDeObjMapa(objMapa) ) {
				return objMapaACrearVista;
			}
		}
		return null;
	}




	public void dibujarDatos(Graphics2D g) {
		ObjetoMapa objMapaPropioSeleccionado = escenario.obtenerObjMapaPropioSeleccionado();
		ObjetoMapa objMapaContrarioSeleccionado = escenario.obtenerObjMapaContrarioSelecionado();

		ObjetoMapaVista objMapaPropioSeleccionadoVista = obtenerObjMapaVista(objMapaPropioSeleccionado);
		ObjetoMapaVista objMapaContrarioSeleccionadoVista = obtenerObjMapaVista(objMapaContrarioSeleccionado);

		dibujarDatos(g, objMapaPropioSeleccionadoVista, 175);
		dibujarDatos(g, objMapaContrarioSeleccionadoVista, 400);
		dibujarDatosJugador(g);
	}

	private void dibujarDatos(Graphics2D g, ObjetoMapaVista objMapaVista, int ancho) {
		if(objMapaVista != null) {
			objMapaVista.dibujarDatos(g, ancho);
		}
		else {
			g.setColor(Color.GREEN);
			g.drawString("NOMBRE: ", ancho, 20);
			g.drawString("VIDA: ", ancho, 35);

			g.drawString("X: ", ancho, 50);
			g.drawString("Y: ", ancho, 65);
			g.setColor(Color.BLACK);
		}
	}
	
	private void dibujarDatosJugador(Graphics2D g) {
		Jugador jugTurno = juego.obtenerJugadorTurno();
		JugadorVista jugTurnoVista = new JugadorVista(jugTurno);
		jugTurnoVista.dibujarDatos(g, 20);
	}

	public void agregarAdvertencia(String advertencia) {
		this.advertencia = advertencia;
	}

	public void dibujarAdvertencia(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawString(this.advertencia, Constantes.ANCHO_VENTANA / 2 - 50, 20);
		this.advertencia = "";
		g.setColor(Color.BLACK);
	}



}