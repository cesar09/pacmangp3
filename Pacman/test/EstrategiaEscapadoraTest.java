import Model.*;
import junit.framework.TestCase;


public class EstrategiaEscapadoraTest extends TestCase {
	
	EstrategiaPerseguidora estrategia;
	Juego juego;
	Tablero tablero;
	Pacman pacman;
	Fantasma fantasma;

	protected void setUp() throws Exception {
		super.setUp();
		estrategia = new EstrategiaPerseguidora();
		juego = new Juego();
		tablero = juego.getTablero();
		tablero.inicializar();
		pacman = tablero.getPacman();
		fantasma = tablero.getFantasma(0);
	}

	public void testCalcularNuevaDireccion() {
		
		Direcciones direccion;
		Punto posicionFantasma = fantasma.getPosicion();
		
		direccion = estrategia.calcularNuevaDireccion(posicionFantasma,
				pacman.getPosicion(), fantasma.getDireccionActual(), tablero);
		switch(direccion){
		case ARRIBA:
			fantasma.irArriba();
			posicionFantasma.disminuirX();
			assertEquals(posicionFantasma,fantasma.getPosicion());
			break;
		case ABAJO:
			fantasma.irAbajo();
			posicionFantasma.aumentarX();
			assertEquals(posicionFantasma,fantasma.getPosicion());
			break;
		case DERECHA:
			fantasma.irADerecha();
			posicionFantasma.aumentarY();
			assertEquals(posicionFantasma,fantasma.getPosicion());
			break;
		case IZQUIERDA:
			fantasma.irAIzquierda();
			posicionFantasma.disminuirY();
			assertEquals(posicionFantasma,fantasma.getPosicion());
			break;
		}
		
	}
	
	public void testCalcularNuevaDireccionTableroNulo() {

		try{
			estrategia.calcularNuevaDireccion(fantasma.getPosicion(),
					pacman.getPosicion(), fantasma.getDireccionActual(), null);
			fail("Deberia lanzar exepcion por elemento nulo");
		}catch(NullPointerException e){
			assertTrue(true);
		}
		
	}
	
	public void testCalcularNuevaDireccionDireccionNula() {

		try{
			estrategia.calcularNuevaDireccion(fantasma.getPosicion(),
					pacman.getPosicion(), null, tablero);
			fail("Deberia lanzar exepcion por elemento nulo");
		}catch(NullPointerException e){
			assertTrue(true);
		}
		
	}
	
	public void testCalcularNuevaDireccionPosicionYoNula() {
		
		try{
			estrategia.calcularNuevaDireccion(null, pacman.getPosicion(),
					fantasma.getDireccionActual(), tablero);
			fail("Deberia lanzar exepcion por elemento nulo");
		}catch(NullPointerException e){
			assertTrue(true);
		}
	}
	
	public void testCalcularNuevaDireccionPosicionElNula() {
		
		try{
			estrategia.calcularNuevaDireccion(fantasma.getPosicion(),
					null, fantasma.getDireccionActual(), tablero);
			fail("Deberia lanzar exepcion por elemento nulo");
		}catch(NullPointerException e){
			assertTrue(true);
		}
	}

}
