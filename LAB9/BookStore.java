/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;


/**
 * autor: Chavez Caceres Samir 
 * ejercicio: Book Shop
 * proposito: Basandose en el problema de la mochila, se resuelve el problema
 *          de la eleccion de libros, costo/paginas maximizando la cantidad de paginas
 */
public class BookStore {
    public static void main(String[] args) {
        int[] costo = {1,2,10,6,5,1,7,4,10,4};
        int[] paginas = {6,3,8,1,7,3,8,6,5,6};
	System.out.println(BackPack(costo,paginas, 10, 10));
    }
    public static int BackPack(int []W, int []C, int n, int M) {
        int [][] B = new int [n+1] [M+1];
        for(int i=0; i<=n; i++)
            B[i][0] = 0;
        for(int i=0; i<=M; i++)
            B[0][i] = 0;
        for(int i=1; i<=n; i++){
            for(int w=1; w<=M; w++){
                if(w - W[i-1] < 0){
                    B[i][w] = B[i-1][w];
                } else {
                    if( B[i-1][w] > (C[i-1] + B[i-1][w-W[i-1]]))
                        B[i][w] = B[i-1][w];
                    else
                        B[i][w] = C[i-1] + B[i-1][w-W[i-1]];
                }
            }
        }
        return B[B.length-1][B[0].length-1];
    }
}
/*
Para probarlo en el juez online se tuvo que modificar la manera de recibir los parametros
import java.util.*;
class h {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	int M = input.nextInt();
	int []W = new int [n];
	int []C = new int [n];
	for(int i = 0; i < n; i++){
		W[i] = input.nextInt();
	}
	for(int i = 0; i < n; i++){
		C[i] = input.nextInt();
	}
		int [][] B = new int [n+1] [M+1];
			for(int i=0; i<=n; i++)
				B[i][0] = 0;
			for(int i=0; i<=M; i++)
				B[0][i] = 0;
			for(int i=1; i<=n; i++){
				for(int w=1; w<=M; w++){
					if(w - W[i-1] < 0){
						B[i][w] = B[i-1][w];
					} else {
						if( B[i-1][w] > (C[i-1] + B[i-1][w-W[i-1]]))
							B[i][w] = B[i-1][w];
						else
							B[i][w] = C[i-1] + B[i-1][w-W[i-1]];
					}
				}
			}
			System.out.println(B[B.length-1][B[0].length-1]);
	}
}
*/