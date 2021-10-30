

//pick_neddle esta en el lab anterior se copia lo que envie
/*Dado dos strings busca si needle esta dentro de la cadena haystack
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
    }*/
# 5. What is the time complexity in terms of O()?
# O(log_2(n))
# resumes is an array
def pick_resume(resumes):
    eliminate = "top"
    
    while resumes.length > 1:
        if eliminate == "top":
            resumes = resumes[resumes.length / 2, resumes.length - 1]
            eliminate = "bottom"
        elif eliminate == "bottom":
            resumes = resumes[0, resumes.length / 2]
            eliminate = "top"
        end
    end
    return resumes[0]
end
//reduce la cadena en la mitad hasta llega a 1 caracter
//Se esta reduciendo a la mitad la condicion en cada iteracion y empezados desde n que es
//la long de la cadena por lo que la complejidad seria log2(n) = O(log2(n))



// Review of Time Complexity
// Q1: What is the time complexity of
for (i = 0; i < n; i++) {
    statement;
}

// Es n ya que lo maximo que puede durar el for es hasta n ya que i se incrementa, hasta que
// sea igual a n


// Q2: What is the time complexity of
for (i = n; i > 0; i--) {
    statement;
}
// Tambien es n ya que en este caso i va disminuyendo de n hasta 0


// Q3: What is the time complexity of
for (i = 0; i < n; i=i+5) {
    statement;
}
//Al ser solo una constante n/2 no afectaria a la notacion O(n)
0 2 4 6 ... n - 2

// Q4: What is the time complexity of
for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
        statement;
    }
}

//Al ser dos bucles anidados seria n^2 osea n veces n

// Q5: What is the time complexity of
for (i = 0; i < n; i++) {
    for (j = 0; j < i; j++) {
        statement;
    }
}

//Es como una piramide 0+1+2+3+4+...+n, lo cual seria la formula de suma de numeros consecutivos
// n(n+1)/2 lo cual es (n^2+n)/2 seria un O(n^2) 



// Q6: What is the time complexity of
p = 0
for (i = 1; p <= n; i++) {
    p = p + i;
}
//En este caso la condicion del for es la que aumenta + 1 +2 +3 +...n, por lo
//que estaria acabando en un tiempo menor a n en el caso anterior donde
//esta acumulacion solo afectaba al limite i O(n^2), pero en este afecta a lo que se
//acumula p, el o de n seria O(n^1/2)


// Q7: What is the time complexity of
for (i = 1; i < n; i = i*2) {
    statement;
}
//Seria 2^k en caso de que afectara n pero como afecta a i ... 2^k = n 
//k = log2(n) = O(logn)


// Q8: What is the time complexity of
for (i = n; i >= 1; i = i/2) {
    statement;
}
//Es lo mismo que q8 solo que empezamos de n y vamos disminuyendo por mitad log2(n) = O(log2n)


// Q9: What is the time complexity of
for (i = 0; i * i < n; i++) {
    statement;
}
//Como se esta afectando a i, y no a n i^2 = n, i = O(n^(1/2))



// Q10: What is the time complexity of
for (i = 0; i < n; i++) {
    statement;
}

for (j = 0; j < n; j++) {
    statement;
}

//Ambos son n, tomamos el mayor O(n)



// Q11: What is the time complexity of
p = 0
for (i = 1; i < n; i = i * 2) {
    p++;
}
//Vimos que este era Log(n) pero la complejidad pasa a traves de esta variable p

for (j = 1; j < p; j = j * 2) {
    statement;
}
//por lo que en este caso la complejidad seria O(log(log(n)))


// Q12: What is the time complexity of
for (i = 0; i < n; i++) {
    for (j = 1; j < n; j = j * 2) {
        statement;
    }
}
//el primero es n y el segundo es log n, multiplicando O(n*log(n))






