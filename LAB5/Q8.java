//Revisando tiempo computacional
//Q8
package LAB5;
public class Q8 {
public static void main(String[] args) {
	q8();
}
public static void q8() {	
	int n = 10;
	for (int i = n; i >= 1; i = i/2) {
		System.out.println(i+" Log en base 2");
	}
}
}
//Es lo mismo que q8 solo que empezamos de n y vamos disminuyendo por mitad log2(n) = O(log2n)
