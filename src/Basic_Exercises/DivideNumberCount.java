package Basic_Exercises;

import java.util.Arrays;

public class DivideNumberCount {
    public static void main(String[] args) {
        System.out.println(countDigitsPerNumber(1248));
    }

    public static int countDigitsPerNumber(int num){
        if(Integer.toString(num).length() == 1) return 1;
        int count = 0;
        String[] nums = Integer.toString(num).split("");
        for(int i = 0; i < nums.length; i++){
            if((num % toInteger(nums[i])) == 0){
                count++;
            }
        }
        return count;
    }

    public static int toInteger(String str){
        return Integer.parseInt(str);
    }
}
