package LAB7;
/**
 *
 * autor: Chavez Caceres Samir 
 * proposito: implementacion de stack con listas enlazadas
 *            
 */
public class StackLink <E> implements Stack<E>{
	private Node<E> tope;
	
	public StackLink() {
		this.tope = null;
	}
	
	@Override
	public void push(E x) {
		this.tope = new Node<E>(x, this.tope);
	}

	@Override
	public E pop() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Pila vacia");
		} else {
			Node<E> aux = this.tope;
			this.tope = this.tope.getNext();
			return aux.getData();
		}
	}

	@Override
	public E top() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Pila vacia");
		} else {
			return this.tope.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return this.tope == null;
	}
	
	public String toString() {
		String str="";
		Node<E> aux = this.tope;
		for(; aux!=null; aux = aux.getNext()) {
			str = str + "\n" + aux.getData();
		}
		return str;
	}
}
