package Map_Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckIfAnagram {
    public static void main(String[] args) {
        System.out.println(CheckIfAnagram.cheackAnagram(new ArrayList<>(List.of("roMa", "AmoR"))));
    }

    public static boolean cheackAnagram(List<String> words){
        Map<String, Integer> wordCount = new HashMap<>();
        for(String letter:words.getFirst().toLowerCase().split("")){
            wordCount.put(letter, wordCount.getOrDefault(letter, 0) + 1);
        }
        for(String letter:words.getLast().toLowerCase().split("")){
            if(wordCount.containsKey(letter) && wordCount.get(letter) != 0){
                wordCount.put(letter, wordCount.get(letter) - 1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
