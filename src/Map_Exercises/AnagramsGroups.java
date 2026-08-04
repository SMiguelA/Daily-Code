package Map_Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsGroups {
    public static void main(String[] args) {
        System.out.println(AnagramsGroups.groupWords(new ArrayList<>(List.of("eat","tea","tan","ate","nat","bat"))));
    }

    public static List<List<String>> groupWords (List<String> words){
        List<List<String>> groups = new ArrayList<>(List.of());
        Map<String, Integer> map;
        boolean flag = false;
        for(String word:words){
            map = AnagramsGroups.createDictionary(word);

            for(List<String> group:groups){
                if(AnagramsGroups.checkIfAnagram(group,map)){
                    group.add(word);
                }else{
                    flag = false;
                }
            }

            if(!flag){
                groups.add(new ArrayList<>(List.of(word)));
                flag = true;
            }
        }
        return groups;
    }

    public static boolean checkIfAnagram(List<String> comparationList, Map<String, Integer> letters){
        Map<String, Integer> mapCopy = new HashMap<>(letters);
        for(String word:comparationList){
            for(String letter:word.split("")){
                if(letters.containsKey(letter) && letters.get(letter) != 0){
                    letters.put(letter, letters.get(letter) - 1);
                }else if(letters.containsKey(letter) && letters.get(letter) == 0){
                    letters.remove(letter);
                }
            }
            if(letters.isEmpty()){
                return true;
            }
            letters = new HashMap<>(mapCopy);
        }
        return false;
    }

    public static Map<String, Integer> createDictionary(String word){
        Map<String, Integer> map = new HashMap<>();

        for(String letter:word.split("")){
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        return map;
    }
}
