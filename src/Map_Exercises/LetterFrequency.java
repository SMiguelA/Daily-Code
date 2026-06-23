package Map_Exercises;

import java.util.HashMap;
import java.util.Map;

public class LetterFrequency {
    public static void main(String[] args) {
        System.out.println(getFrequency("banana"));
    }
    public static Map<String, Integer> getFrequency(String word){
        Map<String, Integer> map = new HashMap<>();
        for(String letter : word.split("")){
            map.put(letter, map.getOrDefault(letter, 0)+1);
        }
        return map;
    }
}
