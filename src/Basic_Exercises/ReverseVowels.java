package Basic_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReverseVowels {
    public static void main(String[] args) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'));
        System.out.println(revers("leetcode",vowels));
    }

    public static String revers(String str, List<Character> vowels){
        char[] newStr = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            while(left < right && !vowels.contains(newStr[left])) left++;
            while(left < right && !vowels.contains(newStr[right])) right--;

            char letter = newStr[left];
            newStr[left] = newStr[right];
            newStr[right] = letter;

            left++;
            right--;
        }
        return new String(newStr);
    }
}
