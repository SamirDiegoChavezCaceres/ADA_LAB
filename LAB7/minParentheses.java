/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB7;

import java.util.Stack;

/**
 *
 * autor: Chavez Caceres Samir 
 * ejercicio: Minimum Add to Make Parentheses Valid
 * proposito: Devuelve la cantidad necesario de parentesis que deben colocarse en un string
 *            
 */
public class minParentheses {
    public static void main(String[] args) {
        String[]str = {"(",")",")",")","(","(",};
        System.out.println(minParenthesesToBeAdd(str));
    }

    public static int minParenthesesToBeAdd(String[] str) {
        Stack<String> stack = new Stack<String>();
        String aux;
        int len = 0;
        boolean push;
        for (String str1 : str) {
            push = true;
            if(str1.equals(")")){
                try {
                    if((aux = stack.peek()) != null)
                        if(aux.equals("(")){
                            stack.pop();
                            len--;
                            push = false;
                        } 
                } catch (Exception ex) {}
            } 
            if(push){
                stack.push(str1);
                len++;
            }
        }
        return len;
    }
}
