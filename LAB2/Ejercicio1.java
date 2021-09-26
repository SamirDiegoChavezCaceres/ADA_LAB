/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB2;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class Ejercicio1 {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Inicio prueba ejercicio1
        /*
        int n,k;
        System.out.println("n y k");
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println("Son divisibles: "+divisibles(n, k));
        */
        //fin prueba
        int[] test = {5,40,2,11,6,9,98,7};
        //prueba ejer2
        System.out.println("Existe?: "+busquedaLineal(test, 9));
        //prueba ejer3
        insertionSort(test);
        for(int i = 0; i < test.length ; i++)
            System.out.print(test[i]+", ");
        System.out.println(" ");
        
        //pruebas Para el grafico
        Random rnd = new Random();
        //10000
        int[] test1 = new int[10000];
        for(int i = 0; i < test1.length ; i++)
            test1[i] = rnd.nextInt(test1.length);
        //100000
        int[] test2 = new int[100000];
        for(int i = 0; i < test2.length ; i++)
            test2[i] = rnd.nextInt(test2.length);
        //1000000
        int[] test3 = new int[1000000];
        for(int i = 0; i < test3.length ; i++)
            test3[i] = rnd.nextInt(test3.length);
        //10000000
        int[] test4 = new int[10000000]; 
        for(int i = 0; i < test4.length ; i++)
            test4[i] = rnd.nextInt(test4.length);
        
        double inicio, fin;
        //Pruebas BusquedaSecuencial
        //10000
        int a = test1[10000-1];
        inicio = System.currentTimeMillis();
        System.out.println("Esta: "+busquedaLineal(test1, a));
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        
        //100000
        a = test2[100000-1];
        inicio = System.currentTimeMillis();
        System.out.println("Esta: "+busquedaLineal(test2, a));
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        
        //1000000
        a = test3[1000000-1];
        inicio = System.currentTimeMillis();
        System.out.println("Esta: "+busquedaLineal(test3, a));
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        
        //10000000
        a = test4[10000000-1];
        inicio = System.currentTimeMillis();
        System.out.println("Esta: "+busquedaLineal(test4, a));
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        /*
        System.out.println("\n");
        //Pruebas InsertionSort
        //10000
        inicio = System.currentTimeMillis();
        insertionSort(test1);
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        
        //100000
        inicio = System.currentTimeMillis();
        insertionSort(test2);
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        
        //1000000
        inicio = System.currentTimeMillis();
        insertionSort(test3);
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        
        //10000000
        inicio = System.currentTimeMillis();
        insertionSort(test4);
        fin = System.currentTimeMillis();
        System.out.println(fin-inicio);
        */
    }
    //Ejercicio1
    public static int divisibles(int n, int k){
        int count = 0;
        if(n <= 10000000 && k<= 10000000){
            System.out.println("Ingrese n datos por favor");
            for(int i = 0 ; i<n ; i++){
                int entry = sc.nextInt();
                if(entry < 1000000000){
                    count += (entry % k == 0)? 1:0;
                } else {
                    System.out.println("datos de entrada menores a 10^9");
                    i--;
                }
            }
            return count;
        } else {
            System.out.println("datos de entrada menores a 10^7");
        }
        return -1;
    }
    
    //Ejercicio2
    public static boolean busquedaLineal(int[]A, int t){
        for(int i = 0; i<A.length; i++)
            if(A[i] == t)
                return true;
        return false;
    }
    
    //Ejercicio3
    public static void insertionSort(int[]A){
        for(int j = 1; j<A.length ; j++){
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key){
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }
}
