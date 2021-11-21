public class greatestNumber {
    public static void main(String[] args) {
        int[]array = {4,5,6,2,7,8,9};
        System.out.println("El mayor de todo el arreglo es:"+greatestNumber1(array));
    }
    
    //ejercicio1
    //encuentra el mayor numero en un tiempo n
    public static int greatestNumber1(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length ; i++)
            if(max < array[i])
                max = array[i];
        return max;
    }
}
