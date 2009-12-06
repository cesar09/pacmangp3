package View;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import Model.excepciones.PosicionInvalidaException;
import Model.juego.Juego;
import Model.viviente.Pacman;
import Model.Punto;


public class PacmanVivo implements ObjetoVivo, Posicionable{

	private Pacman pacman;	
	private Mesa mesa;

	public PacmanVivo(Punto posicionInicial, Juego juego) throws PosicionInvalidaException{
		this.pacman = new Pacman(posicionInicial, juego);
	}
	
	public void vivir() {
		//el controlador hace un pacman.ir_a_donde_se_apreto_la_tecla()!!
		this.pacman.vivir();
	}

	public int getX() {
		return 32 * this.pacman.getPosicion().y();
	}

	public int getY() {
		return 32 * this.pacman.getPosicion().x();
	}	
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
		
}