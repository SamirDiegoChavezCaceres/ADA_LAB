//Revisando tiempo computacional
//PICK NEEDLE
package LAB5;
public class needlestack {
public static void main(String[] args) {
	System.out.println(find_needle("cadabra","abracadabra"));
        System.out.println("Bye");
}
//pick_neddle esta en el lab anterior se copia lo que envie
//Dado dos strings busca si needle esta dentro de la cadena haystack
    public static boolean find_needle(String needle, String haystack){ //O(n*m) donde n es la longitud de needle y
        int needle_index = 0;                                           // m la longitud de haystack
        int haystack_index = 0;
        boolean foundneedle;
        
        while(haystack_index < haystack.length()){
            if(needle.charAt(needle_index) == haystack.charAt(haystack_index)){
                foundneedle = true;
                int aux = haystack_index;
                while(needle_index < needle.length() && foundneedle){
                    if(needle.charAt(needle_index) != haystack.charAt(aux) && foundneedle)
                        foundneedle = false;
                    aux++;
                    needle_index++;
                }
                needle_index = 0;
                if(foundneedle)
                    return true;
            } 
            haystack_index++;
        }
        return false;
    }
}
