package Model;

import java.lang.Math;

/* Clase utilizada para representar las posiciones de los objetos Vivientes en el tablero.
 * Puede tomar valores negativos, por lo tanto la validación de las posiciones debe hacerse en la clase
 * que lo utilice.
 */

public class Punto {
	private int x;
	private int y;
	
	public int x() {
		return x;
	}
	public void x(int x) {
		this.x = x;
	}
	
	public int y() {
		return y;
	}
	public void y(int y) {
		this.y = y;
	}
	
	public void aumentarX(){
		this.x =+ 1;
	}
	
	public void disminuirX(){
		this.x =- 1;
	}
	
	public void aumentarY(){
		this.y =+ 1;
	}
	
	public void disminuirY(){
		this.y =- 1;
	}
	
	public double distanciaAOtroPunto(Punto otroPunto){
		return Math.sqrt(Math.pow(this.x()+otroPunto.x(), 2) + Math.pow(this.y()+otroPunto.y(), 2));
	}


}
