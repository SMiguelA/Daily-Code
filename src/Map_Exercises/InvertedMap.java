package Map_Exercises;

import java.util.HashMap;
import java.util.Map;

public class InvertedMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

        System.out.println(map);
        System.out.println(InvertedMap.reverseMap(map));
    }
    public static Map<Integer, String> reverseMap(Map<String, Integer> map) {
        Map<Integer, String> reversedMap = new HashMap<>();
        for(String key : map.keySet()){
            reversedMap.put(map.get(key), key);
        }
        return reversedMap;
    }
}
