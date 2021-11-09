//Revisando tiempo computacional
//Q5
public static void main(String[] args) {
	q5();
}
public static void q5() {	
	int n = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i; j++) {
			System.out.println(i+" "+j+"   Cuadratico");
		}
	}
}
//Es como una piramide 0+1+2+3+4+...+n, lo cual seria la formula de suma de numeros consecutivos
// n(n+1)/2 lo cual es (n^2+n)/2 seria un O(n^2) 
