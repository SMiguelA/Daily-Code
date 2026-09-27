package Basic_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverse("a good   example"));
    }

    public static String reverse(String str){
        List<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
        StringBuilder newStr = new StringBuilder();
        for(int i = words.size() - 1; i >= 0; i--){
            if(!words.get(i).isBlank()) newStr.append(words.get(i)).append(" ");
        }
        return newStr.toString().strip();
    }
}
