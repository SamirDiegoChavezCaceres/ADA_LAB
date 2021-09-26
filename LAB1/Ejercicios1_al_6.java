/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package LAB1;

/**
 *
 * @author Usuario
 */
public class Ejercicios1_al_6 {
    public static void main(String args[]) {
        System.out.println("Hello, world!");
        int[] numb = {1,2,3,4};
        System.out.println(""+sumaArray(numb));
        invArray(numb);
        printArray(numb);
        iParArray(numb);
        System.out.println(printAscendt(9,6,7));
        System.out.println(frame("Hello World"));
        System.out.println(frame("Hello World", 3));
    }
    
//Ejercicio1
    public static int sumaArray(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length ; i++)
            sum = sum + numbers[i];
        return sum;
    }
    
//Ejercicio2
    public static void invArray(int[] numbers) {
        for(int i = 1; i <= Math.ceil(numbers.length/2) ; i++){
            int aux = numbers[i - 1];
            numbers[i - 1] = numbers[numbers.length - i];
            numbers[numbers.length - i] = aux;
        }
    }
    
//Ejercicio3
    public static void iParArray(int[] numbers) {
        String par = "", impar = "";
        for(int i = 0; i < numbers.length ; i++)
            if(numbers[i] % 2 == 0)
                par = par + numbers[i] + " ";
            else
                impar = impar + numbers[i] + " ";
        System.out.println("pares: "+par);
        System.out.println("impares: "+impar);
    }
    
//Ejercicio4
    public static String printAscendt(int a, int b, int c){
        if(a < b) {
            if(a < c) {
                if(b < c)
                    return a+" "+b+" "+c;
                return a+" "+c+" "+b;
            }
        } else {
            if(b < c) {
                if(a < c)
                    return b+" "+a+" "+c;
                return b+" "+c+" "+a;
            }
        }
        if(b < a)
            return c+" "+b+" "+a;
        return c+" "+a+" "+b;
    }
    
//Ejercicio5
    public static String frame(String str){
        return frame(str,1);
    }
    
//Ejercicio6
    public static String frame(String str, int a){
        String start = getStartF(a, " ");
        String end = getEndF(a, " ");
        String horz1 = getStartF(a, "*");
        String horz2 = start;
        String horzSTR = start;
        for(int i = 0 ; i < str.length() ; i++) {
            horz1 = horz1 + "*";
            horz2 = horz2 + " ";
        }
        horz1 = horz1 + getEndF(a, "*");
        horz2 = horz2 + end;
        horzSTR = horzSTR + str + end;
        str = horz1 + horz2 + horzSTR + horz2 + horz1;
        return str;
    }
    
//Metodos auxiliares
    public static void printArray(int[] numb){
        for(int i = 0; i < numb.length ; i++)
            System.out.print(numb[i]+",");
        System.out.println();
    }
    
    public static String getStartF(int a, String b){
        String horz = "*";
        for(int i = 0 ; i < a ; i++)
            horz = horz + b;
        return horz;
    }
    
    public static String getEndF(int a, String b){
        String horz = "*";
        for(int i = 0 ; i < a ; i++)
            horz = b + horz;
        return horz+"\n";
    }
}
