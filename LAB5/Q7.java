//Revisando tiempo computacional
//Q7
public static void main(String[] args) {
	q7();
}
public static void q7() {	
	int n = 10;
	for (int i = 1; i < n; i = i*2) {
		System.out.println(i+" Log");
	}
}
//Seria 2^k en caso de que afectara n pero como afecta a i ... 2^k = n 
//k = log2(n) = O(logn)
