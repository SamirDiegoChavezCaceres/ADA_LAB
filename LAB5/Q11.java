//Revisando tiempo computacional
//Q11
package LAB5;
public class Q11 {
public static void main(String[] args) {
	q11();
    }
public static void q11() {	
	int n = 10;
	int p = 0;
	for (int i = 1; i < n; i = i * 2) {
		p++;
		System.out.println(i+" Log");
	}
	//Vimos que este era Log(n) pero la complejidad pasa a traves de esta variable p

	for (int j = 1; j < p; j = j * 2) {
		System.out.println(j+" Log de log");
	}
}
}
//por lo que en este caso la complejidad seria O(log(log(n)))
