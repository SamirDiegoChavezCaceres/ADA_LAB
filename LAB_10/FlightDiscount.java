/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_10;
import java.io.*;
import java.util.*;
/**
 * autor: Chavez Caceres Samir 
 * ejercicio: FlightDiscount
 * proposito: calcular el minimo costo de Syr a Metsala pero con la oportunidad de tener un descuento de 50% en un viaje
 */
public class FlightDiscount { //se usara dijkstra pero con dos nodos uno que tenga la ruta sin descuento otra que la tenga
    static final long INF = Long.MAX_VALUE;
    static class E { //clase edge arista
        int j, peso; 
        E(int j, int peso) {
            this.j = j; this.peso = peso;
        }
    }
    static class V { //clase vertice
        ArrayList<E> ady = new ArrayList<>();
        int i; //indice en el arreglo
        long costeAcumulado = INF;
        V(int i) {
            this.i = i;
        }
    }
    public static void main(String[] args) throws IOException {
        _Scanner sc = new _Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        V[] vert = new V[n * 2]; //se dobla el espacio del array para guardar el nodo con su 
        //coste normal y tambien con su coste con cupon
        for (int i = 0; i < n * 2; i++)
            vert[i] = new V(i); //inicializacion de los nodos
        for (int h = 0; h < m; h++) { //inicializacion de los edges
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int c = sc.nextInt();
            vert[i * 2 + 0].ady.add(new E(j * 2 + 0, c));   //tendremos dos mismos vertices uno que tenga la ruta con descuento
            vert[i * 2 + 1].ady.add(new E(j * 2 + 1, c));   //otra que tenga la cuota normal
            vert[i * 2 + 0].ady.add(new E(j * 2 + 1, c / 2));
        }
        //Dijkstra
        TreeSet<V> pq = new TreeSet<>((u, v) -> u.costeAcumulado == v.costeAcumulado ? u.i - v.i : u.costeAcumulado < v.costeAcumulado ? -1 : 1);
        vert[0].costeAcumulado = vert[1].costeAcumulado = 0; //coste total minimo
        pq.add(vert[0]);
        pq.add(vert[1]);
        V u;
        while ((u = pq.pollFirst()) != null) {
            if (u == vert[n * 2 - 1]) { //si nos encontramos con el ultimo nodo
                System.out.println(u.costeAcumulado);
                return;
            }
            for (E e : u.ady) { //para cada nodo adyacente
                V v = vert[e.j];
                long c = u.costeAcumulado + e.peso;
                if (v.costeAcumulado == INF) { //si es la primera vez que visitamos el nodo
                    v.costeAcumulado = c;
                    pq.add(v);
                } else if (v.costeAcumulado > c) {//nos quedamos con el minimo coste
                    pq.remove(v);
                    v.costeAcumulado = c;
                    pq.add(v);
                }
            }
        }
    }
    static class _Scanner { //Scanner para procesar los datos
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
