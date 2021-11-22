package LAB7;
/**
 *
 * autor: Chavez Caceres Samir 
 * proposito: test para stack link
 *            
 */
public class TestStack {
	public static void main(String[]args) {
		try {
			Stack<Integer> s1 = new StackLink<Integer>();
			s1.push(10);
			s1.push(30);
			s1.push(50);
			s1.push(20);
			s1.push(24);
			System.out.println(s1);
			while(!s1.isEmpty()) {
				System.out.println("tope: " + s1.top());
				System.out.println("elemento eliminado : " + s1.pop());
				System.out.println(s1);
				//24 20 50 30 10
			}
			System.out.println("Insertando de nuevo");
			s1.push(50);
			s1.push(20);
			s1.push(24);
			System.out.println(s1);
			System.out.println("tope: " + s1.top());

			System.out.println("elemento eliminado : " + s1.pop());
			System.out.println(s1);
			System.out.println("tope: " + s1.top());
			
		} catch (ExceptionIsEmpty x) {
			System.err.println(x.getMessage());
		}
	}
}
