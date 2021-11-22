
package LAB7;

/**
 *
 * autor: Chavez Caceres Samir 
 * ejercicio: Caps Lock
 * proposito: Dado una cadena si se lee $ se concatena si se lee @ se convierte a uppercase todo lo
 *          contenido en el queue y lo que se inserte en adelante
 *            
 */
public class capsLockBuffer {
    public static void main(String[] args) throws ExceptionIsEmpty {
        //abc$d@ef$@g$
        String[]str = {"a","b","c","$","d","@","e","f","$","@","g","$",};
        System.out.println(capsLock(str));
    }

    public static String capsLock(String[] str) throws ExceptionIsEmpty {
        QueueLink<String> q = new QueueLink<String>();
        String sentence = "", aux;
        boolean upper = false;
        for (String str1 : str) {
            if(str1.equals("@")){
                upper = !upper;
                QueueLink<String> qUp = new QueueLink<String>();
                while(!q.isEmpty()){
                    aux = q.dequeue();
                    if(aux.charAt(0) > 91){
                        aux = aux.toUpperCase();
                    } else {
                        aux = aux.toLowerCase();
                    }
                    qUp.enqueue(aux);
                }
                q = qUp;
            }
            if(str1.equals("$")){
                while(!q.isEmpty()){
                    sentence = sentence + q.dequeue();
                }
            }
            if(upper && !str1.equals("@") && !str1.equals("$"))
                q.enqueue(str1.toUpperCase());
            else if (!str1.equals("@") && !str1.equals("$"))
                q.enqueue(str1);
        }
        return sentence;
    }
}
