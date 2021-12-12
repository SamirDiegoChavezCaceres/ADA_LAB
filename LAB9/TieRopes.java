/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;

/**
 *  autor: Chavez Caceres Samir 
 * ejercicio: TieRopes
 * proposito: Dado un grupo de segmentos representados por su largo en un arreglo
 *          se busca la cantidad de maxima longitud al atar segmentos adyacentes.
 */
public class TieRopes {
    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 1;
        A[5] = 1;
        A[6] = 3;
        System.out.println(solution(4, A));
    }
    public static int solution(int K, int[] A) {
        /*
        Vamos recorriendo el arreglo sumando y si se llega a sobrepasar K se suma el contador
        para si tener la cantidad de veces que se tiene una long igual o superior a K
        */
        int cont = 0, lenTie = 0;
        for(int i = 0; i < A.length ; i++) { //Recorremos el arreglo buscando la 
                    //linea mas o igual de larga que k, sumando + 1 al contador
            lenTie += A[i];
            if (lenTie >= K) {
                cont += 1;
                lenTie = 0;
            }
        }
        return cont;
    }
}
