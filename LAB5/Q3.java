//Revisando tiempo computacional
//Q2
package LAB5;
public class Q3 {
public static void main(String[] args) {
	q3();
}
public static void q3() {
	int  n = 10;
	
	for (int i = 0; i < n; i=i+5) {
		System.out.println(i+" Lineal");
	}
}
}
//Al ser solo una constante n/2 no afectaria a la notacion O(n)
//0 2 4 6 ... n - 2
