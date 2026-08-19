package Basic_Exercises;

import java.util.Arrays;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(0));
    }

    public static int addDigits(int num) {
        int total = sumDigits(num);
        while(castToString(total).length() > 1){
            total = sumDigits(total);
        }
        return total;
    }

    public static int sumDigits(int nums){
        String numsString = Integer.toString(nums);
        return Arrays.stream(numsString.split("")).mapToInt(Integer::parseInt).sum();
    }

    public static String castToString(int num) {
        return Integer.toString(num);
    }
}
