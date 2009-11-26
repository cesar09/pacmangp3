package Model;

import java.util.ArrayList;
import java.util.Random;

public class EstrategiaImpredecible extends Estrategia {

	@Override
	public Direcciones calcularNuevaDireccion(Punto posicionYo,
			Punto posicionEl, Direcciones dirActual, Tablero tablero) {
		
		ArrayList<Direcciones> dirPosibles;
		Random random = new Random();
		int eleccion;
		
		if (posicionYo == null)
			throw new NullPointerException();
		if (posicionEl == null)
			throw new NullPointerException();
		if (dirActual == null)
			throw new NullPointerException();
		if (tablero == null)
			throw new NullPointerException();
		
		dirPosibles = direccionesPosibles(posicionYo, tablero);		
		if (!puedeDoblar(dirActual, dirPosibles)) return dirActual;
		eleccion = random.nextInt(dirPosibles.size() - 1);
		return dirPosibles.get(eleccion);
	}

}
