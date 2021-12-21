/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_11;

import java.util.*;

/**
 *autor: Chavez Caceres Samir 
 * ejercicio: Gruop Anagram
 * proposito: Agrupamos los anagramas en subgrupos
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(arr));
    }
    public static List<List<String>> solution(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>(); // si nos dan nada

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray(); //para ordenarlos
            Arrays.sort(chars); 
            //ordenan (aet)
            anagramMap.computeIfAbsent(String.valueOf(chars), (key) -> new ArrayList<>()).add(str); 
                //Si el key no a sido definido se define automaticamente
            System.out.println(anagramMap);
        }
        return new ArrayList<List<String>>(anagramMap.values()); 
    }
}
