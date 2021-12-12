/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;
import java.util.*;
/**
 *  autor: Chavez Caceres Samir 
 * ejercicio: BankQueue
 * proposito: Tenemos que obtener la mayor ganacia en una cola larga de un banco. 
 */
public class Bank_Queue {
    /* input
    4 4
    1000 1
    2000 2
    500 2
    1200 0
    */
    public static void main(String[] args) {
        maxGanancia();
    }
/*
Solucion
    Se ordena a los clientes por la cantidad de deposito
    Segunda prioridad es el tiempo de paciencia
    mientras tengamos tiempo
        atendemos a un cliente
        tambien bajamos el tiempo de espera de los demas 
*/
    public static void maxGanancia() {
        class Cliente implements Comparable<Cliente> { //se implementara un priority queue por ello
            //hacemos uso de un objeto cliente 
            int dinero;
            int tiempoEspera;

            public Cliente(int c, int t) {
                this.dinero = c;
                this.tiempoEspera = t;
            }

            //@override
            public int compareTo(Cliente p) {
                if (dinero < p.dinero) return -1;
                if (dinero > p.dinero) return 1;
                if (tiempoEspera < p.tiempoEspera) return -1;
                if (tiempoEspera > p.tiempoEspera) return 1;
                return 0;
            }
        }   
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), T = in.nextInt();
        long totaldinero = 0, aux = 0;
        PriorityQueue<Cliente> pq = new PriorityQueue<Cliente>(N, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            pq.add(new Cliente(in.nextInt(), in.nextInt()));
        } // llenamos el priority queue con los clientes

        boolean[] select = new boolean[T];
        Cliente nextCliente;
        while (aux < N && !pq.isEmpty()) {
            nextCliente = (Cliente)pq.poll(); //atendemos a un cliente
            int start = nextCliente.tiempoEspera; 

            while (start >= 0 && select[start]) {
                start--; //bajamos el tiempo de espera
            }

            if (start != -1) { //si no se acaba el tiempo de espera continuamos
                aux++;
                select[start] = true;
                totaldinero += nextCliente.dinero;
            }
        }
        System.out.println(totaldinero);  
    }

    
}
