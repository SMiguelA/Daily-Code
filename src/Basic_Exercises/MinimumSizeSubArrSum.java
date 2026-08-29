package Basic_Exercises;

// #209: Minimum Size Subarray Sum
public class MinimumSizeSubArrSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(subArrSum(nums, 11));
    }

    public static int subArrSum(int[] nums, int target){
        int minLength = nums.length + 1;
        int count = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            count += nums[right];
            while(count >= target){
                if(minLength > (right - left + 1)){
                    minLength = right  - left + 1;
                }
                count -= nums[left];
                left++;
            }
        }
        if(minLength == nums.length + 1){
            return 0;
        }
        return minLength;
    }
}
