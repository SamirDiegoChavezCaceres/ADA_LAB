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
 * ejercicio: Backspace
 * proposito: Dado un teclado, si se llega a leer # significa borrar
 *            
 */
public class Backspace {
    public static void main(String[] args) throws ExceptionIsEmpty {
        String[]str = {"a","b","c","#","d","e","#","#","f","#","g","h","i","#","j","k","l","m","n","#","o","p","#",};
        System.out.println(backSpace(str));
    }

    public static String backSpace(String[] str) throws ExceptionIsEmpty {
        Deque<String> dq = new ArrayDeque<String>();
        String sentence = "";
        for (String str1 : str) {
            if(str1.equals("#")){
                dq.pollLast();
            }
            if(!str1.equals("#"))
                dq.addLast(str1);
        }
        while(!dq.isEmpty())
            sentence = sentence + dq.pollFirst();
        return sentence;
    }
}
