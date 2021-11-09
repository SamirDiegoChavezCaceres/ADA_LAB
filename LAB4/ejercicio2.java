public class ejercicio2 {
    public static void main(String[] args) {
        int[]array = {4,5,6,2,7,8,9};
      
    }
    
    //ejercicio2
    //encuentra un indice par y el numero de esa posicion se imprime sumado a cada numero del arreglo
    public static void every_other(int[] array){ //----- >  O(n^2)
        for (int i = 0; i < array.length ; i++)// O(n) * n =  ----- > O(n^2)
            if(i % 2 == 0)// O(1)*n = ----- > O(n)
                for (int j = 0; j < array.length ; j++)// ----- > n veces
                    System.out.println(array[j] + array[i]);//------> O(1)
    }
}
