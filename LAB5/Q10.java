//Revisando tiempo computacional
//Q10
public static void main(String[] args) {
	q10();
    }
public static void q10() {	
	int n = 10;
	for (int i = 0; i < n; i++) {
		System.out.println(i+" Lineal");
	}

	for (int j = 0; j < n; j++) {
		System.out.println(j+" Lineal");
	}
}
//Ambos son n, tomamos el mayor O(n)
