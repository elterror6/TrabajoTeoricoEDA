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
		// TODO El elemento puede no implementar la clase Element.
		Node <V> find = null;
		if (this.root != null) {
			if (((Element) element).getID() > this.root.getID()) {
				find = search (((innerNode<V>) this.root).getRightChild(),element);
			} else if (((Element) element).getID() < this.root.getID()) {
				find = search (((innerNode<V>) this.root).getRightChild(),element);
			} else {
				find = this.root;
			}
		}
		return find;
	}
	
	/**
	 * Este método busca recursivamente un nodo con el elemento dado. Si el identificador
	 * del elemento es mayor que la del nodo actual va hacia el hijo derecho, si es menor
	 * hacia el hijo izquierdo y si es igual lo devuelve.
	 * 
	 * @param node el nodo en el que esta actualmente.
	 * @param element el elemento que se quiere buscar.
	 * @return El nodo que se esta buscando, si no existe devuelve <b>null</b>.
	 */
	private Node<V> search (Node<V> node, V element) {
		// TODO El elemento puede no implementar la clase Element.
		Node <V> find = null;
		if (node.getElement() != null) {
			if (((Element) element).getID() > node.getID()) {
				find = search(((innerNode<V>) node).getRightChild(),element); 
			} else if (((Element) element).getID() < node.getID()) {
				find = search(((innerNode<V>) node).getRightChild(),element); 
			} else {
				find = node;
			}
		}
		return find;
	}
	
	/**
	 * Este método realiza una inserción de un elemento en el árbol. La inserción es igual
	 * que en un árbol de búsqueda binario, pero no puede haber dos nodos rojos de seguido,
	 * para conseguir eso se comprueba si el tío del nodo insertado es rojo o negro o nulo,
	 * si el tío es rojo se cambian a negro el nodo padre y el nodo tío y el abuelo cambia
	 * a rojo, y así hasta que se llega al nodo raíz, que debe ser negro, si el tío del nodo
	 * es negro o nulo dependiendo de si el padre es hijo opuesto al nodo o no se hace una
	 * rotación doble o simple.
	 */
	@Override
	public void insertion(V element) {
		Node<V> node = new innerNode<>(element);
		Node<V> n, aux;
		// Look where can i put the new node
		if (this.root == null) {
			this.root = node;
		} else {
			n = this.root;
			while (n.getElement() != null) {
				if (n.getID() > node.getID()) {
					n = ((innerNode<V>) n).getRightChild();
				} else if (n.getID() < node.getID()) {
					n = ((innerNode<V>) n).getLeftChild();
				}
			}
			n = ((innerNode<V>) n).getParent();
			if (n.getID()>node.getID()) {
				((innerNode<V>) n).setRightChild(node);
				n = ((innerNode<V>) n).getRightChild();
			} else if (n.getID()>node.getID()) {
				((innerNode<V>) n).setRightChild(node);
				n = ((innerNode<V>) n).getLeftChild();
			}
			// Look if i must balance the tree
			if (((innerNode<V>)((innerNode<V>) n).getParent()).getColor()) {
				if (((innerNode<V>)((innerNode<V>) n).getUncle()).getColor()) {
					while (((innerNode<V>)n).getParent() != null) {
						((innerNode<V>)((innerNode<V>) n).getParent()).setColor(false);
						((innerNode<V>)((innerNode<V>) n).getUncle()).setColor(false);
						((innerNode<V>)((innerNode<V>)((innerNode<V>) n).getParent()).getParent()).setColor(true);
						n = ((innerNode<V>)((innerNode<V>)((innerNode<V>) n).getParent()).getParent()).getParent();
					}
					((innerNode<V>) this.root).setColor(false);				
				} else {
					boolean doubleR = (((innerNode<V>) n).isRightChild() && !((innerNode<V>)((innerNode<V>) n).getParent()).isRightChild()) || (!((innerNode<V>) n).isRightChild() && ((innerNode<V>)((innerNode<V>) n).getParent()).isRightChild());
					if (doubleR) {
						aux = ((innerNode<V>) n).getParent();
						rotation(!((innerNode<V>) n).isRightChild(),n);
						rotation(!((innerNode<V>) aux).isRightChild(),aux);
					} else {
						rotation(!((innerNode<V>) n).isRightChild(),n);
					}
				}
			}
		}
		
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
			this.color = true;
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
		 * Este método colorea el nodo de rojo (si <b>color</b> es <b>true</b>) o a negro (si <b>color</b> es <b>true</b>).
		 * @param color si es <b>true</b> es un nodo rojo, si no es negro.
		 */
		public void setColor(boolean color) {
			this.color = color;
		}

		/**
		 * Este método conecta el nodo a un nodo padre.
		 * 
		 * @param parent nuevo nodo padre del nodo.
		 */
		public void setParent(Node<V> parent) {
			this.parent = parent;
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
		
		/**
		 * Este método devuelve el nodo tío del nodo.
		 * 
		 * @return El nodo tío del nodo.
		 */
		public Node<V> getUncle () {
			Node<V> uncle = null;
			Node<V> parent = this.parent;
			Node<V> grandparent = ((innerNode<V>) parent).getParent();
			
			if (((innerNode<V>) grandparent).getLeftChild().getID() == parent.getID()) {
				uncle = ((innerNode<V>) grandparent).getRightChild();
			} else {
				uncle = ((innerNode<V>) grandparent).getLeftChild();
			}
			
			return uncle;
		}
		/**
		 * Este método devuelve si el nodo es un hijo derecho o no.
		 * 
		 * @return <b>true</b> si el nodo es un hijo derecho.
		 */
		public boolean isRightChild () {
			boolean r = false;
			if (((innerNode<V>) this.parent).rightChild.getID() == this.ID) {
				r = true;
			}
			return r;
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


