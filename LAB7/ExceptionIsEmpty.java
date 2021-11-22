package LAB7;
/**
 *
 * autor: Chavez Caceres Samir 
 * proposito: Excepcion esta vacio
 *            
 */

public class ExceptionIsEmpty extends Exception {
	public ExceptionIsEmpty(String msg) {
		super(msg);
	}
	public ExceptionIsEmpty() {
		super();
	}
}
