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
 * ejercicio: ShortestRoutesI
 * proposito: Encontramos el menor camino de cada ciudad a la ciudad de Syrjälä
 */
public class ShortestRoutesI { //se usara dijkstra para encontrar la menor distancia de cada ciudad a la ciudad de Syrjala
    static class E {
        int destino, peso;
        E(int destino, int peso) {
            this.destino = destino; this.peso = peso;
        }
    }
    static ArrayList[] arreglos;
    static final long INF = 0x3f3f3f3f3f3f3f3fL; //numero max
    static long[] minDist;
    public static void main(String[] args) throws IOException {
        _Scanner sc = new _Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arreglos = new ArrayList[n];
        for (int i = 0; i < n; i++)
            arreglos[i] = new ArrayList<E>(); // inicializacion de la matriz
        while (m > 0) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int w = sc.nextInt();
            arreglos[i].add(new E(j, w));// la ciudad i tendra en otro arreglo las ciudades destino con su coste
            m--;
        } //se guardan los datos en la matriz
        minDist = new long[n];
        Arrays.fill(minDist, INF); //Arreglo que contendra las distancias minimas a cada nodo
        minDist[0] = 0;
        //https://algorithms.tutorialhorizon.com/dijkstra-algorithm-implementation-treeset-and-pair-class/
        TreeSet<Integer> pq = new TreeSet<>((i, j) -> minDist[i] == minDist[j] ? i - j : minDist[i] < minDist[j] ? -1 : 1); //TreeSet para dijkstra
        pq.add(0);//agregamos la menor distancia q en un inicio es 0  
        Integer aux;
        while ((aux = pq.pollFirst()) != null) {
            int i = aux;
            ArrayList<E> ady = arreglos[i]; //obtenemos adyacentes
            for (E e : ady) { //para cada ciudad adyacente
                long d = minDist[i] + e.peso; //min distancia acumulada + el 
                if (minDist[e.destino] > d) { //nos quedamos con la distancia minima
                    if (minDist[e.destino] != INF)
                        pq.remove(e.destino); //removemos el camino desactualizado
                    minDist[e.destino] = d;// actualizamos el min destino
                    pq.add(e.destino); // añadimos el camino actualzado
                }
            }
        }
        for (int i = 0; i < n; i++)
            pw.print(minDist[i] + " "); //imprimimos los caminos minimos
        pw.println();
        pw.close();
    }
    static class _Scanner {  //Scanner para procesar los datos
        InputStream is;     //https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
        _Scanner(InputStream is) {
            this.is = is;
        }
        byte[] bb = new byte[1 << 15];
        int k, l;
        byte getc() throws IOException {
            if (k >= l) {
                k = 0;
                l = is.read(bb); //if (l < 0) return -1;
            }
            return bb[k++];
        }
        byte skip() throws IOException {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }
        int nextInt() throws IOException {
            int n = 0;
            for (byte b = skip(); b > 32; b = getc())
                n = n * 10 + b - '0';
            return n;
        }
    }
}
