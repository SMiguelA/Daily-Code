package Basic_Exercises;

import java.util.HashMap;
import java.util.Map;

public class Ocurrences {
    public static void main(String[] args) {
        System.out.println(findSecuence("aaaa"));
    }
    // Maximum Length Substring With Two Occurrences
    // Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
    public static int findLength(String str){
        int count=0;
        int maxCount=0;
        final Map<String,Integer> map=new HashMap<>();
        final String[] character = str.split("");

        for(int i =0;i< character.length;i++){
            map.put(character[i], map.getOrDefault(character[i], 0)+1);
            count++;
            if(map.get(character[i])>2){
                map.clear();
                count = 0;
            }
            if(count > maxCount) maxCount=count;
        }
        return maxCount;
    }

    // No funciona, podria conciderar usar solo un array y no una hash table, usando dos punteros en un array
    // Retornar el numero de caracteres en una secuencia donde solo se pueden repetir dos letras

    public static int findSecuence(String str){
        int left=0;
        int maxCount=0;
        final String[] strArr = str.split("");
        final Map<String,Integer> map=new HashMap<>();
        for(int right=0;right <strArr.length;right++){
            map.put(strArr[right], map.getOrDefault(strArr[right],0)+1);
            while(map.get(strArr[right])>2){
                int leftVal = map.get(strArr[left])-1;
                map.put(strArr[left], leftVal);
                if(map.get(strArr[left]) == 0){
                    map.remove(strArr[left]);
                }
                left++;
            }
            maxCount = Math.max(maxCount, right - left +1);
        }
        return maxCount;
    }
}
