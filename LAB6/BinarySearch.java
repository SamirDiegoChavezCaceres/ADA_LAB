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
public class BinarySearch {
    public static void main(){
        int[]a = {5,12,17,23,38,45,77,84,90};
        System.out.println(busquedaBinaria(12, a));
    }
    public static int busquedaBinaria(int target, int[]array){
        int L = 0;
        int R = array.length - 1;
        int mid = 0;
        while(L <= R){
            mid = L + (R-L)/2;
            if(array[mid] == target)
                return mid;
            if(array[mid] < target)
                L = mid + 1;
            else
                L = mid - 1;
        }
        return -1;
    }
}
