
package LAB8;

import java.util.*;

/**
 *
 * autor: Chavez Caceres Samir 
 * ejercicio: Caps Lock
 * proposito: Dado una cadena si se lee $ se concatena si se lee @ se convierte a uppercase todo lo
 *          contenido en el queue y lo que se inserte en adelante
 *            
 */
public class capsLockBuffer {
    public static void main(String[] args) {
        //abc$d@ef$@g$
        String[]str = {"a","b","c","$","d","@","e","f","$","@","g","$",};
        System.out.println(capsLock(str));
    }

    public static String capsLock(String[] str)  {
        Queue<String> q = new LinkedList<String>();
        String sentence = "", aux;
        boolean upper = false;
        for (String str1 : str) {
            if(str1.equals("@")){
                upper = !upper;
                Queue<String> qUp = new LinkedList<String>();
                while(!q.isEmpty()){
                    aux = q.poll();
                    if(aux.charAt(0) > 91){
                        aux = aux.toUpperCase();
                    } else {
                        aux = aux.toLowerCase();
                    }
                    qUp.add(aux);
                }
                q = qUp;
            }
            if(str1.equals("$")){
                while(!q.isEmpty()){
                    sentence = sentence + q.poll();
                }
            }
            if(upper && !str1.equals("@") && !str1.equals("$"))
                q.add(str1.toUpperCase());
            else if (!str1.equals("@") && !str1.equals("$"))
                q.add(str1);
        }
        return sentence;
    }
}
