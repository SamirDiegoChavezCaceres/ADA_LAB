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
//Ejercicio2
//Señala el primer mayor elemento respecto a un numero
public class busquedaBinariaGreatest {
    public static void main(String[] args){
        int[]a = {5,12,17,23,38,45,77,84,90};
        System.out.println(busquedaBinariaPrimerMayor(22, a));
    }
    public static int busquedaBinariaPrimerMayor(int target, int[]array){
        int L = 0;
        int R = array.length - 1;
        int mid;
        while(L <= R){
            mid = L + ((R-L)/2);
            if(array[mid] == target)
                return mid + 1;
            if(array[mid] < target) //Solo se busca en los menores hasta llegar al menor del numero indicado
                if(array[mid + 1] > target)
                    return mid + 1;
                else
                    L = mid + 1;
            else
                R = mid - 1;
        }
        return -1;
    }
}
