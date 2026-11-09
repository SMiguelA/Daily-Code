package Basic_Exercises;

import java.util.Arrays;

public class NewExcercises {
    public static void main(String[] args) {
        int[] nums = {1,3,0,4,12,0};
        movingArr(nums);
    }

    public static void movingArr(int[] nums){
        if(nums.length == 1) return;
        int left = 0;

        for(int right = 0; right<nums.length; right++){
            if(nums[right] != 0){
                int num = nums[right];
                nums[right] = nums[left];
                nums[left] = num;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
