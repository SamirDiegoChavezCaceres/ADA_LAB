/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB6;
import java.util.*;
/**
 *
 * @author Usuario
 */
//DFS iterativo
//Hace un recorrido DFS iterativo
//Al parecer no funciona correctamente
public class DFS_Iterative {
    public static void main(String[] args) {
        String[][]a = {{"#","#","#","#","#","#"},
                        {"#","0","0","0","0","#"},
                        {"#","0","0","0","0","#"},
                        {"#","0","0","0","0","#"},
                        {"#","0","0","0","#","0"},
                        {"#","#","#","#","0","0"}};
        DFS_iterative(a, 1, 1, 1+";"+1);
        for (String[] a1 : a) {
            for (String item : a1) {
                System.out.print(item+"/");
            }
            System.out.println();
        }
        //El grafo tiene v(coordenadas donde proviene su conexion) V(1,1) significaria
        //que el padre de este nodo es el nodo 1,1
    }
    public static void DFS_iterative(String[][]tablero, int x, int y, String ant){
        Stack<String> stack = new Stack<>();
        stack.add(x+"1"+y);
        tablero[y][x] = "1";
        while (!stack.isEmpty()){
            String v = stack.lastElement();
            System.out.println(v);
            stack.pop();
            String[] coorde = coordString(v.charAt(0), v.charAt(2));
            tablero[v.charAt(2)-48][v.charAt(0)-48] = "1"; //marca como visitado
            ant = (v.charAt(0)-48)+";"+(v.charAt(2)-48);
            for(String str : coorde){
                int tempX = str.charAt(0) - 48;
                int tempY = str.charAt(2) - 48;
                if(tempX >= 0 && tempY >= 0 && tempX < tablero[0].length && tempY < tablero.length) {
                    if(tablero[tempY][tempX].charAt(0) == '0'){
                        stack.push(str);
                    }
                }
            }
        }
    }
    //retorna un arreglo de los posibles mov de nuestro nodo
    public static String[] coordString(int x, int y){
        x = x - 48;
        y = y - 48;
        String[]coords = {(x-1)+";"+(y),(x)+";"+(y-1),(x)+";"+(y+1),(x+1)+";"+(y)};
        return coords;
    }
}
