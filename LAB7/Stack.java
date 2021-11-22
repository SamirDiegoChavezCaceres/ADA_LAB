package LAB7;
/**
 *
 * autor: Chavez Caceres Samir 
 * proposito: interfaz de stack
 *            
 */
public interface Stack<E> {
	public void push(E x);
	public E pop() throws ExceptionIsEmpty;
	public E top() throws ExceptionIsEmpty;
	public boolean isEmpty();
}
