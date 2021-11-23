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
 * ejercicio: Evaluate Reverse Polish Notation
 * proposito: evalua la notacion polaca y da el resultado
 *            
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[]str = {"10","6","9","3","+","-11","*","/","*","17","+","5","+",};
        System.out.println(reversePolishNotation(str));
    }

    public static String reversePolishNotation(String[] str) {
        Stack<String> stack = new Stack<String>();
        int result, op1, op2, flag;
        result = 0;
        for (String str1 : str) {
            flag = -1;
            if (str1.equals("+")){
                flag = 0;
            }
            if (str1.equals("-")){
                flag = 1;
            }
            if (str1.equals("/")){
                flag = 2;
            }
            if (str1.equals("*")){
                flag = 3;
            }
            if(flag != -1) {
                
                op1 = Integer.parseInt(stack.pop());
                op2 = Integer.parseInt(stack.pop());
                if(flag == 0)
                    result = op2 + op1;
                if(flag == 1)
                    result = op2 - op1;
                if(flag == 2)
                    result = op2 / op1;
                if(flag == 3)
                    result = op2 * op1;
                stack.push(result+"");
            } else
                stack.push(str1);
        }
        return stack.pop();
    }
    
}
