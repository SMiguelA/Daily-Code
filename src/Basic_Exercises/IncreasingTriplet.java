package Basic_Exercises;

import java.util.Arrays;

public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        System.out.println(haveTriplet(nums));
    }

    public static boolean haveTriplet(int[] nums){
        int length = nums.length;
        int[] lower = new int[length];
        int[] higher = new int[length];

        lower[0] = nums[0];
        for(int i = 1; i < length; i++){
            lower[i] = Math.min(nums[i], lower[i-1]);
        }

        higher[length-1] = nums[length-1];
        for(int i = length-2; i >= 0; i--){
            higher[i] = Math.max(nums[i], higher[i+1]);
        }

        for(int i = 0; i < length; i++){
            if(lower[i] < nums[i] && nums[i] < higher[i]) return true;
        }
        return false;
    }
}
