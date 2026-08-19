package Map_Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsByLength {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("Hello", "Sun", "Hola", "The", "Old", "Bu"));

        System.out.println(WordsByLength.groupWords(words));
    }
    public static Map<Integer, List<String>> groupWords(List<String> words){
        Map<Integer, List<String>> groups = new HashMap<>();
        int flag;
        for(String word:words){
            flag = word.length();
            if(groups.containsKey(flag)){
                groups.get(flag).add(word);
            }else{
                groups.put(flag, new ArrayList<>(List.of(word)));
            }
        }
        return groups;
    }
}
