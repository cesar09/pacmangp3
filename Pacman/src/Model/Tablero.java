package Model;


import Model.excepciones.PosicionInvalidaException;

public class Tablero {
	
	private final int MAX_POS_X;
	private final int MAX_POS_Y;
	private Casillero matriz[][];
	private Fantasma fantasmas[];
	private Pacman pacman;
	
	public Tablero(){
		pacman = new Pacman();
		MAX_POS_X = 8;
		MAX_POS_Y = 8;
		matriz = new Casillero[MAX_POS_X][MAX_POS_Y];
		/*Modificar cada Fantasma() por el fantasma que corresponda*/
		fantasmas[0] = new FantasmaRojo();
		fantasmas[1] = new FantasmaRosa();
		fantasmas[2] = new FantasmaNaranja();
		fantasmas[3] = new FantasmaAzul();
		fantasmas[4] = new FantasmaVerde();
		
	}
	
	public Casillero getCasillero(Punto punto){
		return matriz[punto.x()][punto.y()];
	}
	
	public void resetearPosiciones() throws PosicionInvalidaException{		
		try{
			final Punto punto;
			punto = new Punto(5,5);
			pacman.setPosicion(punto);
			punto.x(4);
			punto.y(4);
			for (Fantasma f : fantasmas){
				f.setPosicion(punto);
			}
		}catch(PosicionInvalidaException e){
			throw new PosicionInvalidaException();
		}
		
	}
	
	public final int getMaxPosX() {
		return this.MAX_POS_X;
	}
	
	public final int getMaxPosY() {
		return this.MAX_POS_X;
	}

}
