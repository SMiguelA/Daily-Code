package Map_Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>(List.of("Hello", "Bye", "I'm not", "Hello", "Hello", "Bye", "Bye", "Bye", "Hello"));
        System.out.println(WordFrequency.frequency(wordsList));
    }
    public static String frequency(List<String> words){
        String frequentWord = "";
        int flag = 0;
        Map<String, Integer> wordsFrequency = new HashMap<>();
        for(int i=0; i<words.size(); i++){
            wordsFrequency.put(words.get(i), wordsFrequency.getOrDefault(words.get(i),0)+1);
            if(wordsFrequency.get(words.get(i)) > flag){
                frequentWord = words.get(i);
                flag = wordsFrequency.get(words.get(i));
            }
        }
        return  frequentWord;
    }
}
