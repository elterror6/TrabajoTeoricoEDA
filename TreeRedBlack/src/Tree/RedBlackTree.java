package Tree;

public class RedBlackTree <V> implements BinaryTree <V> {
	/** Este atributo representa el nodo raíz o padre del árbol rojo-negro. */
	private Node<V> root;
	
	/**
	 * Instancia un nuevo árbol rojo-negro vacío.
	 */
	public RedBlackTree () {
		this.root = null;
	}
	/**
	 * Este método devuelve el nodo raíz del árbol.
	 * 
	 * @return El nodo raíz (<b>root</b>) del arbol.
	 */
	public Node<V> getRoot() {
		return this.root;
	}
	
	/**
	 * Este método es utilizado para rotar a la derecha (si <b>side</b> es <b>true</b>)
	 * o a la izquierda (si <b>size</b> es <b>false</b>) un nodo pasado por parámetro.
	 * Este método se utiliza en la inserción de un nuevo nodo o en la eliminación de
	 * un nodo existente en el árbol para equilibrarlo.
	 * 
	 * @param side indica el lado de rotación. Si es <b>true</b> rota el nodo <b>node</b>
	 * a la derecha, si no lo rota a la izquierda.
	 * @param node es el nodo que se quiere rotar.
	 */
	private void rotation (boolean side, Node<V> node) {
		Node<V> x;
		if (side) {
			// Simple Right rotation
			x = ((innerNode<V>) node).getLeftChild();
			((innerNode<V>) node).setLeftChild(((innerNode<V>)x).getRightChild());
			((innerNode<V>) x).setRightChild(node);
			((innerNode<V>) node).setParent(x);
		} else {
			// Simple Left rotation
			x =((innerNode<V>) node).getRightChild();
			((innerNode<V>) node).setRightChild(((innerNode<V>) x).getLeftChild());
			((innerNode<V>) x).setLeftChild(node);
			((innerNode<V>) node).setParent(x);
		}
	}

	@Override
	public Node<V> search(V element) {
		// TODO Realizar método que busque un elemento en un árbol rojo-negro
		return null;
	}

	@Override
	public void insertion(V element) {
		// TODO Realizar método que inserte un elemento en un árbol rojo-negro
		
	}

	@Override
	public Node<V> delete(V element) {
		// TODO Realizar método que elimine un elemento en un árbol rojo-negro
		return null;
	}
	/**
	 * Esta clase representa un nodo interno en un árbol rojo-negro.
	 * 
	 * @param <V> El tipo de elemento que contiene.
	 */
	public class innerNode <V> implements Node <V>{
		/** Este atributo representa el identificador del nodo. */
		private int ID;
		/** Este atributo representa el elemento contenido en el nodo. */
		private V element;
		/** Este atributo representa el nodo padre del nodo. */
		private Node<V> parent;
		/** Este atributo representa el nodo hijo derecho del nodo. */
		private Node<V> rightChild;
		/** Este atributo representa el nodo hijo izquierdo del nodo. */
		private Node<V> leftChild;
		/** Este atributo representa el color del nodo, si es <b>true</b> el nodo es rojo, si es <b>false</b> es negro. */
		boolean color;
		/**
		 * Instancia un nuevo nodo interno con un elemento contenido.
		 * 
		 * @param element elemento que va estar contenido en el nodo.
		 */
		public innerNode (V element) {
			if (element instanceof Element) {
				this.ID = ((Element) element).getID();
			} else if (element instanceof Integer || element instanceof Long ||
					element instanceof Short) {
				this.ID =(int) element;
			} else if (element instanceof String) {
				this.ID = ((String) element).hashCode();
			}
			this.element = element;
			this.rightChild = new innerNode<V>();
			this.leftChild = new innerNode<V>();
		}
		
		/**
		 * Instancia un nuevo nodo que representa un nodo hoja.
		 */
		public innerNode () {
			this.element = null;
			this.color = false;
		}
		
		/**
		 * Este método devuelve el nodo padre del nodo.
		 * 
		 * @return El nodo padre del nodo.
		 */
		public Node<V> getParent() {
			return parent;
		}

		/**
		 * Este método conecta el nodo a un nodo padre. Si el nodo
		 * es un nodo hoja entonces no cambia el color del nodo.
		 * 
		 * @param parent nuevo nodo padre del nodo.
		 */
		public void setParent(Node<V> parent) {
			this.parent = parent;
			if (this.element != null) {
				if  (((innerNode<V>)this.parent).getColor()) {
					this.color = !((innerNode<V>)this.parent).getColor();
				} else {
					this.color = !((innerNode<V>)this.parent).getColor();
				}
			}	
		}

		/**
		 * Este método devuelve el hijo derecho del nodo.
		 * 
		 * @return El hijo derecho del nodo.
		 */
		public Node<V> getRightChild() {
			return rightChild;
		}

		/**
		 * Este método introduce un nuevo hijo derecho al nodo.
		 * 
		 * @param rightChild nuevo hijo derecho.
		 */
		public void setRightChild(Node<V> rightChild) {
			this.rightChild = rightChild;
		}

		/**
		 * Este método devuelve el hijo izquierdo del nodo.
		 * 
		 * @return El hijo izquierdo del nodo.
		 */
		public Node<V> getLeftChild() {
			return leftChild;
		}

		/**
		 * Este método introduce un nuevo hijo izquierdo al nodo.
		 * 
		 * @param leftChild nuevo hijo izquierdo.
		 */
		public void setLeftChild(Node<V> leftChild) {
			this.leftChild = leftChild;
		}

		/**
		 * Este método devuelve el color del nodo.
		 * 
		 * @return El color del nodo.
		 */
		public boolean getColor() {
			return color;
		}
		
		@Override
		public int getID() {
			return this.ID;
		}

		@Override
		public V getElement() {
			return this.element;
		}
		
	}
}


