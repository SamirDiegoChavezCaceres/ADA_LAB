/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB4;

/**
 *
 * @author Usuario
 */
public class ejercicios {
    public static void main(String[] args) {
        int[]array = {4,5,6,2,7,8,9};
        System.out.println("El mayor de todo el arreglo es:"+greatestNumber(array));
    }
    
    //ejercicio1
    //encuentra el mayor numero en un tiempo n
    public static int greatestNumber(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length ; i++)
            if(max < array[i])
                max = array[i];
        return max;
    }
    
    //ejercicio2
    //encuentra un indice par y el numero de esa posicion se imprime sumado a cada numero del arreglo
    public static void every_other(int[] array){ //----- >  O(n^2)
        for (int i = 0; i < array.length ; i++)// O(n) * n =  ----- > O(n^2)
            if(i % 2 == 0)// O(1)*n = ----- > O(n)
                for (int j = 0; j < array.length ; j++)// ----- > n veces
                    System.out.println(array[j] + array[i]);//------> O(1)
    }
    
    //ejercicio3
    //Dado un arreglo busca dos numeros diferentes indices que sumados den cierto numero en este caso 10
    public static boolean twoSum(int[] array){ //----- >  O(n^2)al tenes un for dentro de otro for
        for (int i = 0; i < array.length ; i++)
            for (int j = 0; j < array.length ; j++)// ----- > n veces
                if (i != j && array[j] + array[i] == 10)
                    return true;
        return false;
    }
    
    //ejercicio4
    //Dado dos strings busca si needle esta dentro de la cadena haystack
    public static boolean find_needle(String needle, String haystack){ //O(n*m) donde n es la longitud de needle y
        int needle_index = 0;                                           // m la longitud de haystack
        int haystack_index = 0;
        boolean foundneedle = false;
        
        while(haystack_index < haystack.length()){
            if(needle.charAt(needle_index) == haystack.charAt(haystack_index)){
                foundneedle = true;
                while(needle_index < needle.length())
                    if(needle.charAt(needle_index) != haystack.charAt(haystack_index))
                        foundneedle = false;
            }
            if(foundneedle)
                return true;
            needle_index = 0;
            haystack_index += 1;
        }
        return false;
    }
}
