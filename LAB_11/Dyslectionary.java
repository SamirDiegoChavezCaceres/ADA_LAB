/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_11;
import java.util.*;
import java.io.*;
/**
 *autor: Chavez Caceres Samir 
 * ejercicio: Dyslectionary
 * proposito: Ordenar "al reves" una cantidad de palabras justificandolas
 */
public class Dyslectionary {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        boolean end = false; //flag
        while (scan.hasNext()) {
            ArrayList<String> palabras = new ArrayList<>();
            int max = 0; // para la justificacion

            while (true) { //procesamos un "parrafo"
                String palabra = scan.nextLine();
                if (!scan.hasNext()) //si ya no hay para seguir leendo en todo el archivo
                    end = true;
                if (palabra.isEmpty()) //si acabo el parrafo
                    break;
                max = palabra.length() > max ? palabra.length() : max;//mayor string
                palabras.add(palabra);
                if (end)
                    break;
            }

            for (int i = 0; i < palabras.size(); i++) { //justificacion
                String palabra = palabras.get(i);
                int spaces = max - palabra.length(); //max - letras

                for (int z = 0; z < spaces; z++)
                    palabra = " " + palabra;

                palabras.set(i, palabra);
            }

            Collections.sort(palabras, new Comparator<String>() { //ordenacion al reves
                public int compare(String str1, String str2) {
                    for (int i = str1.length() - 1; i >= 0; i--)
                        if (str1.charAt(i) != str2.charAt(i))
                            return str1.charAt(i) - str2.charAt(i);

                    return 0;
                }
            });

            for (String palabra : palabras) //impresion
                System.out.println(palabra);

            if (!end)
                System.out.println();
        }

        scan.close();
    }

}
