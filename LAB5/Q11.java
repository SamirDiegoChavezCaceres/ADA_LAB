public static void q11() {	
	p = 0
	for (i = 1; i < n; i = i * 2) {
		p++;
		System.out.println(i+" Log");
	}
	//Vimos que este era Log(n) pero la complejidad pasa a traves de esta variable p

	for (j = 1; j < p; j = j * 2) {
		System.out.println(j+" Log de log");
	}
}
//por lo que en este caso la complejidad seria O(log(log(n)))