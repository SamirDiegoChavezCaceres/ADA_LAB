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
 * ejercicio: Shortest_RoutesII
 * proposito: Se desea encontrar la min distancia entre dos ciudades dado una serie
 * de peticiones
 */
public class Shortest_RoutesII { //Se usara para la solucion floyd warshall el caul tiene una matriz de los menores recorridos
    static final long INF = 0x3f3f3f3f3f3f3f3fL; //numero max
    public static void main(String[] args) throws IOException {
        _Scanner sc = new _Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        long[][] matriz = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matriz[i][j] = INF;
            matriz[i][i] = 0;
        } // se rellena la matriz
        while (m > 0) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int w = sc.nextInt();
            if (matriz[i][j] > w)
                matriz[j][i] = matriz[i][j] = w;
            m--;
        } //se inicializa la matriz para floyd warshall
        for (int k = 0; k < n; k++) //algoritmo floyd warshall
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++) {
                    long a = matriz[i][k] + matriz[k][j];
                    if (matriz[i][j] > a)
                        matriz[j][i] = matriz[i][j] = a;
                }
        while (q-- > 0) { //proceso de lectura de queries consultas y la impresion de los resultados
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            long a = matriz[i][j];
            pw.println(a == INF ? -1 : a); //su la posicion en ese lugar de la matriz sigue siendo INF es porq no esta conectado
        }
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
                l = is.read(bb);
                if (l < 0) return -1;
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
