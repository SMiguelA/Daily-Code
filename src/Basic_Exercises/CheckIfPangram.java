package Basic_Exercises;

import java.util.HashMap;
import java.util.Map;

public class CheckIfPangram {
    public static void main(String[] args) {
        System.out.println(verifyPangram("leetcode"));
    }

    public static boolean verifyPangram(String str){
        String[] strArr = str.split("");
        Map<String, Integer> alphabetCount = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < strArr.length; i++){
            alphabetCount.put(strArr[i], alphabetCount.getOrDefault(strArr[i], 0)+1);
        }
        if(alphabetCount.size() == 26){
            flag = true;
        }
        return flag;
    }
}
