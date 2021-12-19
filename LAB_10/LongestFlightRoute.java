/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_10;
import java.io.*;
import java.util.*;
/**
 *  autor: Chavez Caceres Samir 
 * ejercicio: LongestFlightRoute
 * proposito: muestra la maxima cantidad de ciudades a visitar en un viaje de Syrjälä y Lehmälä
 */
public class LongestFlightRoute { //Se hace uso de TopoSort y un array de apoyo para el path a seguir
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList[] adys = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adys[i] = new ArrayList<Integer>(); //inicializacion de array de adyacentes
        int[] nDegree = new int[n]; //matriz para guardar los nDegrres de cada nodo
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            adys[i].add(j); //que ciudades puede visitar
            nDegree[j]++; //que cantidad de ciudades lo visitan
        }
        //hacemos uso del topoSort y guardaremos las respuestas en una matriz
        int[] aux = new int[n]; //pila aux de topoSort
        int head = 0, cnt = 0;
        for (int i = 0; i < n; i++)
            if (nDegree[i] == 0)
                aux[head + cnt++] = i; //si el nodo tiene un nDegree de 0 se anade a la cola
        int[] dp = new int[n]; //memory array para guardar el numero de soluciones
        int[] path = new int[n]; //guarda la ruta de ciudades a visitar en la solucion
        dp[0] = 1;
        while (cnt > 0) { //mientras aux no este vacio
            int i = aux[head++]; cnt--; //eliminamos el nodo de menor nDegree
            ArrayList<Integer> ady = adys[i]; //obtenemos los nodos adyacentes de ese nodo
            for (int j : ady) {
                if (--nDegree[j] == 0) //se baja el nDegree de los nodos adyacentes
                    aux[head + cnt++] = j; //Y si es nDegree de 0 se inserta en la cola aux
                if (dp[i] != 0) 
                    if (dp[j] < dp[i] + 1) { 
                        dp[j] = dp[i] + 1; //se acumula el numero se soluciones
                        path[j] = i; //agregamos el path
                    }
            }
        }
        int k = dp[n - 1]; //impresion de resultados
        if (k == 0) //si no hay resultados se imprime impossible
            pw.println("IMPOSSIBLE");
        else {
            for (int h = k - 1, i = n - 1; h >= 0; h--, i = path[i])
                aux[h] = i;
            pw.println(k);
            for (int h = 0; h < k; h++)
                pw.print(aux[h] + 1 + " ");
            pw.println();
        }
        pw.close();
    }
}
