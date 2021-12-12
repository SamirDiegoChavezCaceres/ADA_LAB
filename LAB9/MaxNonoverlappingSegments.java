/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;

/**
 *  autor: Chavez Caceres Samir 
 * ejercicio: MaxNonoverlappingSegments
 * proposito: Dado un grupo de segmentos representados en dos arreglos
 *          Se busca la maxima cantidad de segmentos no superpuestos que se pueda tener.
 */
public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        int[] A = new int[5];
        int[] B = new int[5];
        A [0] = 1; B [0] = 5;
        A [1] = 3; B [1] = 6;
        A [2] = 7; B [2] = 8;
        A [3] = 9; B [3] = 9;
        A [4] = 9; B [4] = 10;
        System.out.println(solution(A, B));
    }
    public static int solution(int[] a, int[] b) {
        if(a.length == 0){
            return 0;
        }
        //Tenemos dos arrays, donde B contiene donde acaba el array
        //Y el A contiene donde comienza
        //Por lo que si son dos distintos index y A > B
        //No se estan superponiendo por lo que
        //el numero maximo de segmentos no superpuestos aumenta en 1
        //en caso contrario no aumenta
        int max = 1, mayorB = 0;
        for(int i = 1; i <= b.length - 1; i++) {
            if(a[i] > b[mayorB]) {
                max+=1;
                mayorB = i; // Conserva el index B actual, para compararlo con el siguiente A
            }
        }
        return max;
    }
}
