// 5. What is the time complexity in terms of O()?
//O(log_2(n))
//Revisando tiempo computacional
//PICK RESUME
package LAB5;
public class pickresume {
public static void main(String[] args) {
	System.out.println(pick_resume("abrac"));
}
public static String pick_resume(String resumes){
    String eliminate = "top";
    
    while (resumes.length() > 1){
        if (eliminate.equals("top")) {
            resumes = resumes.substring(resumes.length() / 2, resumes.length() - 1);
            eliminate = "bottom";
        }
        else if (eliminate.equals("bottom")) {
            resumes = resumes.substring(0, resumes.length() / 2);
            eliminate = "top";
        }
    }
    return resumes;
}
}
//reduce la cadena en la mitad hasta llega a 1 caracter
//Se esta reduciendo a la mitad la condicion en cada iteracion y empezados desde n que es
//la long de la cadena por lo que la complejidad seria log2(n) = O(log2(n))
