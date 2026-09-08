package Basic_Exercises;

public class ConsecutiveOdds {
    public static void main(String[] args) {
        int[] nums = {1,2,34,3,4,5,7,23,12};
        System.out.println(consecutiveOdds(nums));
    }

    public static boolean consecutiveOdds(int[] nums){
        for(int flag = nums.length-1; flag > 0; flag--){
            if(flag-2 >= 0 && nums[flag] % 2 != 0 && nums[flag-1] % 2 != 0 && nums[flag-2] % 2 != 0){
                return true;
            }
        }
        return false;
    }
}
