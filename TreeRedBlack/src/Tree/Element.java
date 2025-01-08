package Tree;

/**
 * Esta interfaz define la existencia de un número entero usado
 * como ID para guardar en un nodo de un árbol binario.
 * <br><b>CUIDADO:</b> Hay que incluir un método <b>equals()</b>
 * en la clase que vaya a implementar esta interfaz.
 */
public interface Element {
	
	/**
	 * Este método devuelve el ID del elemento.
	 *
	 * @return Un número entero que es el ID del elemento
	 */
	public abstract int getID ();
	
}
