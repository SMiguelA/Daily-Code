package Map_Exercises;

import java.util.HashMap;
import java.util.Map;

public class CountVocals {
    public static void main(String[] args) {
        System.out.println(countVocals("abecedario"));
    }

    public static Map<String, Integer> countVocals(String text){
        Map<String, Integer> map = new HashMap<>();
        map.put("a",0);
        map.put("e",0);
        map.put("i",0);
        map.put("o",0);
        map.put("u",0);
        for(String letter : text.split("")){
            if(map.containsKey(letter)){
                map.put(letter, map.get(letter)+1);
            }
        }
        return map;
    }
}
