public static void q6() {	
	p = 0
	for (i = 1; p <= n; i++) {
		p = p + i;
		System.out.println(i+";"+p+"  raiz cuadrada");
	}
}
//En este caso la condicion del for es la que aumenta + 1 +2 +3 +...n, por lo
//que estaria acabando en un tiempo menor a n en el caso anterior donde
//esta acumulacion solo afectaba al limite i O(n^2), pero en este afecta a lo que se
//acumula p, el o de n seria O(n^1/2)