/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB7;
import java.util.*;
/**
 *
 * autor: Chavez Caceres Samir 
 * ejercicio: Interview Wait
 * proposito: Devuelve el tiempo hasta cuando  te toque se entrevistado
 *          dado las peculiares caractericticas de eleccion del entrevistador
 *            
 */
public class waitInterview {
    public static void main(String[] args) throws ExceptionIsEmpty {
        int[]str = {4,-1,5,2,3};
        System.out.println(whatTimeWait(str));
    }

    public static int whatTimeWait(int[] num) throws ExceptionIsEmpty {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for(int i : num){
            dq.addLast(i);
        }
        int time = 0,firts,last;
        while(!dq.isEmpty()){
            firts = dq.pollFirst();
            last = dq.pollLast();
            if(firts == -1 || last == -1)
                break;
            if(firts >= last){
                time = time + firts;
                dq.pollFirst();
            } else {
                time = time + last;
                dq.pollLast();
            } 
        }
        return time;
    }
}
