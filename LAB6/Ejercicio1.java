/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB6;

/**
 *
 * @author Usuario
 */
//Ejercicio1
//Señaal si un numero es un cuadrado perfecto
public class Ejercicio1 {
    public static void main(String[] args){
        int[]a = {5,12,17,23,38,45,77,84,90};
        System.out.println(busquedaBinariaCuadrado(16));
        System.out.println(busquedaBinariaCuadrado(20));
    }
    public static boolean busquedaBinariaCuadrado(int n){
        int[]array = generateArray(n);
        int target = 1;
        int L = 0;
        int R = array.length - 1;
        int mid = 0;
        while(L <= R){
            mid = L + ((R-L)/2);
            if(array[mid]*array[mid] == n) //Si la mitad al cuadrado es n es true
                return true;
            if(array[mid] < target)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return false;
    }
    
    private static int[] generateArray(int n) {
        int[] a = new int[n];
        for(int i = 0; i < n ; i++)
            a[i] = i+1;
        return a;
    }
}
