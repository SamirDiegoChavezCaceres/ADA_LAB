/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB7;

/**
 *
 * @author Usuario
 */
//DFS RECURSIVO
//Hace un recorrido DFS recursivo
public class DFSrecursivo {
    public static void main(String[] args) {
        String[][]a = {{"#","#","#","#","#","#"},
                        {"#","0","0","0","0","#"},
                        {"#","0","0","0","0","#"},
                        {"#","0","0","0","0","#"},
                        {"#","0","0","0","#","0"},
                        {"#","#","#","#","0","0"}};
        DFS_recursive(a, 1, 1, "1");
        for (String[] a1 : a) {
            for (String item : a1) {
                System.out.print(item+"/");
            }
            System.out.println();
        }
        //El grafo tiene v(coordenadas donde proviene su conexion) V(1,1) significaria
        //que el padre de este nodo es el nodo 1,1
    }
    public static void DFS_recursive(String[][]tablero, int x, int y, String ant){
        tablero[y][x] = "1";
        String[] coorde = coordString(x, y);
        for(int i = 0; i<coorde.length ; i++){
            int tempX = coorde[i].charAt(0) - 48;
            int tempY = coorde[i].charAt(2) - 48;
            
            System.out.println(coorde[i]);
            if(tempX >= 0 && tempY >= 0 && tempX < tablero[0].length && tempY < tablero.length){
                if(tablero[tempY][tempX].charAt(0) == '0'){
                    tablero[tempY][tempX] = "1";
                    DFS_recursive(tablero, tempX, tempY, "1");
                }
            }
        }
    }
    //retorna un arreglo de los posibles mov de nuestro nodo
    public static String[] coordString(int x, int y){
        String[]coords = {(x-1)+";"+(y),(x)+";"+(y-1),(x)+";"+(y+1),(x+1)+";"+(y)};
        return coords;
    }
}
