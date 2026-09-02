package Basic_Exercises;

import java.util.Arrays;

public class AquaresArrs {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(squaresInSortedArr(nums)));
    }

    public static int[] squaresInSortedArr(int[] nums){
        int[] newArr = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            newArr[i] = nums[i]*nums[i];
        }
        return Arrays.stream(newArr).sorted().toArray();
    }
}
