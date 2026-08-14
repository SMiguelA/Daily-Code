package Basic_Exercises;

import java.util.HashMap;
import java.util.Map;

public class Ocurrences {
    public static void main(String[] args) {
        System.out.println(findLength("bcbbbcba"));
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
}
