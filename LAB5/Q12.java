//Revisando tiempo computacional
//Q12
public static void main(String[] args) {
	q12();
}
public static void q12() {
	int n = 10;
	for (int i = 0; i < n; i++) {
		for (int j = 1; j < n; j = j * 2) {
			System.out.println(j+" n log");
		}
	}
}
//el primero es n y el segundo es log n, multiplicando O(nlog(n))
