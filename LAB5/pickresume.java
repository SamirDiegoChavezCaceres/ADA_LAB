# 5. What is the time complexity in terms of O()?
O(log_2(n))

public static String pick_resume(String resumes){
    String eliminate = "top";
    
    while (resumes.length > 1){
        if (eliminate.equals("top")) {
            resumes = resumes.substring(resumes.length / 2, resumes.length - 1);
            eliminate = "bottom";
        }
        else if (eliminate == ("bottom")) {
            resumes = resumes.substring(0, resumes.length / 2);
            eliminate = "top";
        }
    }
    return resumes[0];
}
//reduce la cadena en la mitad hasta llega a 1 caracter
//Se esta reduciendo a la mitad la condicion en cada iteracion y empezados desde n que es
//la long de la cadena por lo que la complejidad seria log2(n) = O(log2(n))