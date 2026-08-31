package Basic_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWords {
    public static void main(String[] args) {
        String[] nums = {"abc","bcd","aaaa","cbc"};
        System.out.println(findWordsByCharacter(nums, 'z'));
    }

    public static List<Integer> findWordsByCharacter(String[] strings, char flag){
        List<Integer> indexes = new ArrayList<>();
        String newFlag = Character.toString(flag);
        for(int i = 0; i < strings.length; i++){
            if(strings[i].contains(newFlag)){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
