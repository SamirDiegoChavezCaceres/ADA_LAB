
package LAB7;

import java.util.*;

/**
 *
 * autor: Chavez Caceres Samir 
 * ejercicio: Merge k Sorted List
 * proposito: Une una cantidad K de listas ordenadas en una sola lista ordenada
 *            
 */
public class mergeKList {
    public static void main(String[] args) throws ExceptionIsEmpty {
        int[][]str = {{1,4,5},{1,3,4},{2,6}};
        mergeList(str);
    }

    public static void mergeList(int[][] lists) throws ExceptionIsEmpty {
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int[] list : lists){
            for(int i : list){
                pq.add(i);
            }
        }
        System.out.print("[");
        while(!pq.isEmpty())
            System.out.print(pq.poll()+",");
        System.out.print("]");
    }
}
