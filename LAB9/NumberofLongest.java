/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;
import java.util.*;
/**
 * autor: Chavez Caceres Samir 
 * ejercicio: number of longest increasing subsequence
 * proposito: Encuentra la cantidad de subsecuencias crecientes en un array
 */
public class NumberofLongest {
    public static void main(String[] args) {
      int[]a = {1,3,5,4,7};
      System.out.println(findLongestNumber(a));
    }
    public static int findLongestNumber(int[] nums) {
        int n = nums.length;
        
        int[] length = new int[n]; 
        int[] count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) // por si cumple lapropiedad de ser ascendente
                    continue;
                if (length[j] + 1 > length[i]) { //se almacena la max long
                    length[i] = length[j] + 1;
                    count[i] = count[j];
                }
                else if (length[j] + 1 == length[i])
                    count[i] += count[j];
            }
        }
        //una vez finalizado se busca el mas largo
        int max_length = 0;
        for(int i : length)
            max_length = Math.max(i, max_length);
        
        int number = 0;
        for(int i = 0; i < n; i++) { // se cuentan los espacios que tenga el subarray
                                    // mas largo y se actualiza el contador number
            if (length[i] == max_length)
                number += count[i];
        }
        return number;
    }
}
