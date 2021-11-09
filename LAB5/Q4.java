//Revisando tiempo computacional
//Q4
package LAB5;
public class Q4 {
public static void main(String[] args) {
	q4();
}
public static void q4() {	
	int n = 10;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			System.out.println(i+";"+j+"  Cuadratico");
		}
	}
}
}

//Al ser dos bucles anidados seria n^2 osea n veces n
