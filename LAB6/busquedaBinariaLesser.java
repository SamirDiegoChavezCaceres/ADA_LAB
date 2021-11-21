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
//Ejercicio3
//Busca el menor numero en un arreglo desplazado
public class busquedaBinariaLesser {
    public static void main(String[] args){
        int[]b = {45,77,84,90,5,12,17,23,38};
        System.out.println(busquedaBinariaMenorDesplazado(b));
    }
    public static int busquedaBinariaMenorDesplazado(int[]array){
        int L = 0;
        int R = array.length - 1;
        int mid;
        while(L <= R){
            mid = L + ((R-L)/2);
            if(L == R) //Cuando solo quede un elemento
                return L;
            if (mid < R && array[mid+1] < array[mid]) //Si mid + 1 es el min
                return mid+1;
            if (mid > L && array[mid] < array[mid - 1]) //Si somos el min
                return mid;
            if (array[R] > array[mid]) 
                R = mid - 1;
            else
                L = mid + 1;
        }
        return -1;
    }
}
