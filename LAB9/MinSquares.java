/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;

/**
 * autor: Chavez Caceres Samir 
 * ejercicio: Rectangle cutting
 * proposito: Halla el numero minimo de cortes para tener cuadrados
 */
public class MinSquares {
    public static void main(String[] args) {
        System.out.println(minCutSquares(2, 8));
    }
    public static int minCutSquares(int w, int h){
        int[][]square = new int[w+1][h+1]; //se crea un array bidimensional
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= h; j++) { //recorremos este array
                if (i == j) {
                    square[i][j] = 0;
                } else {
                    square[i][j] = w*h;
                    /*System.out.println("pre "+i+"i j"+j);
                    printBi(square);*/
                    for (int k = 1; k < i; k++) { //se comprueba si hay menores
                        /*System.out.println("i "+i);
                        System.out.println("min("+square[i][j]+","+"square[k][j]://"+square[k][j]+"+square[i-k][j]+1://"+(square[i-k][j]+1)+" = "+(square[k][j]+square[i-k][j]+1)+")");
                        */square[i][j] = Math.min(square[i][j], square[k][j]+square[i-k][j]+1);
                       // printBi(square);
                    }
                    for (int k = 1; k < j; k++) { //se comprueba si hay menores
                        /*System.out.println("j "+j);
                        System.out.println("min("+square[i][j]+","+"square[i][k]://"+square[i][k]+"+square[i][j-k]+1://"+(square[i][j-k]+1)+" = "+(square[i][k]+square[i][j-k]+1)+")");
                        */square[i][j] = Math.min(square[i][j], square[i][k]+square[i][j-k]+1);
                        //printBi(square);
                    }
                }
            }
        }
        //printBi(square);
        return square[w][h];
    }
    /*public static void printBi(int[][]square){
        for(int x = 0; x < square.length; x++){
                        for(int y = 0; y < square[0].length; y++){
                            if(square[x][y]>=10)
                                System.out.print(square[x][y]+" ");
                            else
                                System.out.print(" "+square[x][y]+" ");
                        }
                        System.out.println();
                    }
    }*/
}
