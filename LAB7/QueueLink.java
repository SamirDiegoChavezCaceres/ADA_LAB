package LAB7;
/**
 *
 * autor: Chavez Caceres Samir 
 * proposito: implementacion queue con lista enlazada
 *            
 */

public class QueueLink<E> implements Queue<E> {
	
	protected Node<E> front;
	protected Node<E> back;
	
	public QueueLink() {
		this.front = null;
		this.back = null;
	}

	@Override
	public void enqueue(E x) {
		if(this.isEmpty()) {
			this.front = new Node<E>(x);
			this.back = front;
		} else {
			this.back.setNext(new Node<E>(x));
			this.back = this.back.getNext();
		}
	}

	@Override
	public E dequeue() throws ExceptionIsEmpty {
		if(this.isEmpty()) {
			throw new ExceptionIsEmpty("Queue vacio");
		} else {
			E aux = this.front.getData();
			this.front = this.front.getNext();
			return aux;
		}
	}

	@Override
	public E front() throws ExceptionIsEmpty {
		if(this.isEmpty()) {
			throw new ExceptionIsEmpty("Queue vacio");
		}
		return front.getData();
	}

	@Override
	public E back() throws ExceptionIsEmpty {
		if(this.isEmpty()) {
			throw new ExceptionIsEmpty("Queue vacio");
		}
		return back.getData();
	}

	@Override
	public boolean isEmpty() {
		return this.front == null;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "\nCola Vacia\n";
		}
		String str="[";
		Node<E> aux = this.front;
		for(; aux!=null; aux = aux.getNext()) {
			str = str + aux.getData() + " ";
		}
		str = str + "]    /////// Frente: " + front.getData() + " Final: " + back.getData();
		return str;
	}
}
