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
 * ejercicio: RoadReparation
 * proposito: para reparar unas carreteras rotas necesitamos encontrar el menor 
 * costo de repararlas y las ciudades esten conectadas 
 */

//Para la resolucion usaremos el algoritmo Kruskal que calcula el MST para el menor coste
public class RoadReparation {
    static class E { //clase Edge
        int iCiudad, jCiudad, peso;
        E(int i, int j, int peso) {
            this.iCiudad = i; this.jCiudad = j; this.peso = peso;
        }

        @Override
        public String toString() {
            return iCiudad+""+jCiudad+""+peso; //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    static int[] visited; //arreglo para saber que nodos estan visitados
    static int find(int i) {
        return visited[i] < 0 ? i : (visited[i] = find(visited[i])); //encontramos aquellos no visitados
    } 
    static boolean join(int i, int j) { //comprobamos si un nodo esta conectado a otro
        i = find(i); 
        j = find(j); 
        if (i == j) //si estan conectados se pasa a retornar false
            return false;
        if (visited[i] > visited[j]) //en otro caso se procede a poner 1
            visited[i] = j;
        else {
            if (visited[i] == visited[j])
                visited[i]--;
            visited[j] = i; 
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //vertices
        int m = Integer.parseInt(st.nextToken()); //enlaces
        visited = new int[n];
        Arrays.fill(visited, -1);
        E[] grafo = new E[m]; //es un grafo que almacena edge osea aristas
        for (int h = 0; h < m; h++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1; //se trabaja con indices para
            int j = Integer.parseInt(st.nextToken()) - 1; //el array visited
            int w = Integer.parseInt(st.nextToken());
            grafo[h] = new E(i, j, w); //creando aristas
        }
        Arrays.sort(grafo, (e, f) -> e.peso - f.peso); // Se ordenan los enlaces por el peso
        long rpta = 0; //peso total
        for (int h = 0; h < m && n > 1; h++) { //n = vertices
            E e = grafo[h];// agarramos el menor peso de cada enlace
            if (join(e.iCiudad, e.jCiudad)) { //vemos su estan ya conectados
                rpta += e.peso; //se acumula el peso min
                n--; //solo necesitamos revisar n-1 vertices
            }
        }
        System.out.println(n == 1 ? rpta : "IMPOSSIBLE");
    }
}
