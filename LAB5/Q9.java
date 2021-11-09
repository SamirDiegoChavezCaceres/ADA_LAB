//Revisando tiempo computacional
//Q9
package LAB5;
public class Q9 {
public static void main(String[] args) {
	q9();
}
public static void q9() {
    int n = 10;
	for (int i = 0; i * i < n; i++) {
		System.out.println(i+" raiz cuadrada");
	}
}
}
//Como se esta afectando a i, y no a n i^2 = n, i = O(n^(1/2))
