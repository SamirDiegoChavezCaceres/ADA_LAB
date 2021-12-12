/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;
import java.io.*;
import java.util.*;
/**
 *autor: Chavez Caceres Samir 
 * ejercicio: Watering Grass
 * proposito: calcular la cantidad minima de aspersores
    que se deben enctopeer en orden para que el riego sea sobre
    toda la banda

 */
/* generamos un arreglo con las posiciones de los asperores y
    su zona de riego

    Ubicamos la mitad para calcular las distancias y zonas de
    posible riego que se pueden utilizar usando pitagoras. 

    luego ordenamos segun las posiciones x de nuestros aspersores. 

    Se prueba con los mas cercanos a la
    izquierda e ir acumulando 

*/
public class Watering_Grass {
    public static void main (String [] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String s;
        while ((s=br.readLine())!=null) {
            StringTokenizer st=new StringTokenizer(s);
            int N=Integer.parseInt(st.nextToken());
            int L=Integer.parseInt(st.nextToken());
            int W=Integer.parseInt(st.nextToken());
            double wMitad=W/2.0;

            ArrayList<Double []> list=new ArrayList<>();
            for (int n=0;n<N;n++) {
                st=new StringTokenizer(br.readLine());
                double l=Double.parseDouble(st.nextToken());
                double r=Double.parseDouble(st.nextToken());
                if (r>wMitad) {
                    double c=Math.sqrt(r*r-wMitad*wMitad);
                    list.add(new Double [] {Math.max(0, l-c), l+c});
                }
            }

            list.add(new Double [] {L+W+2.0, L+W+2.0});
            Collections.sort(list, (a,b) -> {
                int cmp=Double.compare(a[0],b[0]);
                return cmp==0 ? Double.compare(a[1], b[1]) : cmp;
            }); //Se leen datos y llenamos en el arreglo para despues ordenarlos

            double tope=0;
            int idx=0, sol=0;
            while (idx<list.size() && tope<L) {
                boolean flag=false;
                double aux=tope;
                for (;idx<list.size();idx++) {
                    if (list.get(idx)[0] <= aux) {
                        tope=Math.max(list.get(idx)[1], tope);
                        flag=true;
                    } else break;
                } //recorremos ese arreglo 
                if (flag) sol++;
                else {
                    tope=-1;
                    break;
                }
            }
            if (tope<L) System.out.println(-1);
            else System.out.println(sol);
        }
    }

}
