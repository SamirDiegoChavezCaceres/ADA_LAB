/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB3;

import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class BusquedaBinaria {
    public static void main(String[] args) {
        int[]numeritos = {5,12,17,23,38,45,77,84,90};
        int[]numeritos2 = {17,12,15,23,38,45,84,84,84};
        System.out.println("Numero ubicado en: "+ binarysearch(numeritos, 23));
        System.out.println("Numero ubicado en: "+ binarysearch(numeritos, 80));
    }

    public static int binarysearch(int[]a,int b){
        //Busca creando "subarrays" basandose en las posiciones
        int alta, baja, media;
        baja = 0;
        alta = a.length - 1;
        while (baja <= alta){
            media = (alta + baja)/2;
            if (a[media] == b)
                return media;
            else if (b < a[media])
                alta = media - 1;
            else
                baja = media + 1;
        }
        return -1;
    }
    
}
