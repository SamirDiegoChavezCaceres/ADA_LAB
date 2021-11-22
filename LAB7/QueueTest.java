package LAB7;
/**
 *
 * autor: Chavez Caceres Samir 
 * proposito: test de queue link
 *            
 */
public class QueueTest {
	public static void main(String[]args) {
		try {
			Queue<String> q1 = new QueueLink<String>();
			q1.enqueue("Juan");
			q1.enqueue("Maria");
			q1.enqueue("Rosa");
			q1.enqueue("Patty");
			q1.enqueue("Luis");
			
			
			//q1.enqueue("Mauri");
			
			System.out.println(q1);
			while(!q1.isEmpty()) {
				System.out.println("elemento eliminado : " + q1.dequeue());
				System.out.println(q1);
				//Juan Maria Rosa Patty Luis
			}
			System.out.println("Insertando de nuevo");
			q1.enqueue("Maria");
			q1.enqueue("Rosa");
			q1.enqueue("Patty");
			System.out.println(q1);
			
			q1.dequeue();
			System.out.println(q1);
			
		} catch (ExceptionIsEmpty x) {
			System.out.println(x.getMessage());
		}
	}
}
