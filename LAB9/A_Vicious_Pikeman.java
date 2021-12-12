/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;
import java.util.*;
/**
 *autor: Chavez Caceres Samir 
 * ejercicio: Avicius Pikeman
 * proposito: Se busca tener la cantidad 
    maxima de ejercicios que puede resolver y
    la penalizacion que recibira al realizar los ejercicios
 */
public class A_Vicious_Pikeman {
    //Para resolver de una manera rapida lo mas razonable es escoger los 
    //menos pesados primero
    public static void main(String[] args) {
        int n = 1,t = 3;
        int a = 2,b = 2,c = 2,t0 = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(t0);
        for (int i = 0; i < n ; i++){ //Procesamos los datos de acuerdo a, ABC para el concursante
            list.add(((a*list.get(list.size()-1)+b) % 1000000007) + 1);
        }
        Collections.sort(list); //lo ordenamos para tomar los menos pesados primero
        //se ingresa en numero y el tiempo
        int[] l = solution(n,t,list);
        for(int num: l)
            System.out.print(num+",");
    }
    public static int[] solution(int n, int t, ArrayList<Integer>list){
        int total= 0, p = 0;
        int[] ret = new int[2];
        for (int i=0;i < list.size(); i++){
            if (total + list.get(i) > t){ //si llegamos al limite de tiempo devolvemos en donde estamos
                ret[0] = i;
                ret[1] = p;
                return ret;
            }
            total += list.get(i);// en caso contrario continuamos agregando
            p = (p + total) % 1000000007;
        }
        ret[0] = n;
        ret[1] = p;
        return ret;//por si no alcanzamos el limite a pesar de sobrepasar todo el limite
    }
    
}
