/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;

/**
 * autor: Chavez Caceres Samir 
 * ejercicio: MaximalSquare
 * proposito: Se busca el mayor cuadrado posible dado una matriz
 */
public class MaximalSquare {
    public static void main(String[] args) {
        int[][] mtr = {{0, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1},
                        {0, 0, 1, 1, 1}};
        System.out.println(maxSquare(mtr));
    }
    public static int maxSquare(int[][]matr){
        int[][] memo = new int[matr.length + 1][matr[0].length + 1];
        int max = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (matr[i][j] == 1){       //Como en el problema de pathfind se usa soluciones anteriores para hallar la 
                                            //solucion y se escribe en memo.
                    memo[i+1][j+1] = Math.min(Math.min(memo[i+1][j], memo[i][j+1]), memo[i+1][j]) + 1; 
                    max = Math.max(max, memo[i][j]);
                                            //el maximo se almacena en una variable
                }
            }
        }
        return (int) Math.pow(max, 2);
    }
}
