package Tree;

/**
 * Esta interfaz representa un nodo de una estructura de árbol.
 *
 * @param <V> El tipo del elemento que va a contener el nodo.
 */
public interface Node <V> {
	
	/**
	 * Este método devuelve el ID del elemento.
	 *
	 * @return El ID del elemento.
	 */
	public abstract int getID ();
	
	/**
	 * Este método devuelve el elemento contenido en el nodo.
	 *
	 * @return El elemento contenido.
	 */
	public abstract V getElement ();
}
