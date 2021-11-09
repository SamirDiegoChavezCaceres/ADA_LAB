public class ejercicio4 {
    public static void main(String[] args) {
        int[]array = {4,5,6,2,7,8,9};
    }
    //ejercicio4
    //Dado dos strings busca si needle esta dentro de la cadena haystack
    public static boolean find_needle(String needle, String haystack){ //O(n*m) donde n es la longitud de needle y
        int needle_index = 0;                                           // m la longitud de haystack
        int haystack_index = 0;
        boolean foundneedle = false;
        
        while(haystack_index < haystack.length()){
            if(needle.charAt(needle_index) == haystack.charAt(haystack_index)){
                foundneedle = true;
                while(needle_index < needle.length())
                    if(needle.charAt(needle_index) != haystack.charAt(haystack_index))
                        foundneedle = false;
            }
            if(foundneedle)
                return true;
            needle_index = 0;
            haystack_index += 1;
        }
        return false;
    }
}
