public class ejercicio3 {
    public static void main(String[] args) {
        int[]array = {4,5,6,2,7,8,9};
    }
  
    //ejercicio3
    //Dado un arreglo busca dos numeros diferentes indices que sumados den cierto numero en este caso 10
    public static boolean twoSum(int[] array){ //----- >  O(n^2)al tenes un for dentro de otro for
        for (int i = 0; i < array.length ; i++)
            for (int j = 0; j < array.length ; j++)// ----- > n veces
                if (i != j && array[j] + array[i] == 10)
                    return true;
        return false;
    }
}
