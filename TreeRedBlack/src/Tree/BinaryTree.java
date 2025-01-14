package Tree;

/**
 * Esta interfaz define la funcionalidad de un árbol binario en donde
 * los elementos se guardan en nodos.
 *
 * @param <V> El tipo de elemento que se va a guardar en el nodo. Este debe implementar la interfaz <b>Element</b>.
 */
public interface BinaryTree <V> {
	
	/**
	 * Busca un elemento dentro del arbol. Si no existe devuelve <b>null</b>.
	 *
	 * @param element El elemento que se quiere buscar en el arbol.
	 * @return El nodo buscado. En caso de que el nodo no exista devuelve <b>null</b>.
	 */
	public abstract Node<V> search (V element);
	
	/**
	 * Inserta un nuevo elemento en el arbol. En caso de que ya exista
	 * no se insertará el elemento.
	 *
	 * @param element El elemento que se desea insertar en el árbol.
	 */
	public abstract void insertion (V element);
	
	/**
	 * Elimina un elemento en el árbol y devuelve el nodo eliminado.
	 * En caso de que no exista se devolverá <b>null</b>.
	 *
	 * @param element El elemento que se quiere eliminar del árbol.
	 * @return El nodo eliminado el árbol. Si no existe el elemento devuelvo <b>null</b>.
	 */
	public abstract Node<V> delete (V element);
}
