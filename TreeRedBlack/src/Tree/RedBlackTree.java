package Tree;

public class RedBlackTree <V> implements BinaryTree <V> {

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
	
	public class innerNode <V> implements Node <V>{
		private int ID;
		private V element;
		
		private Node<V> parent;
		private Node<V> rightChild;
		private Node<V> leftChild;
		
		boolean color;
		
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
			
			this.rightChild = null;
			this.leftChild = null;
		}
		
		
		public Node<V> getParent() {
			return parent;
		}


		public void setParent(Node<V> parent) {
			this.parent = parent;
			if  (((innerNode<V>)this.parent).getColor()) {
				this.color = !((innerNode<V>)this.parent).getColor();
			} else {
				this.color = !((innerNode<V>)this.parent).getColor();
			}
		}


		public Node<V> getRightChild() {
			return rightChild;
		}


		public void setRightChild(Node<V> rightChild) {
			this.rightChild = rightChild;
		}


		public Node<V> getLeftChild() {
			return leftChild;
		}


		public void setLeftChild(Node<V> leftChild) {
			this.leftChild = leftChild;
		}


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


