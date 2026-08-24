package Basic_Exercises;

//You are given a positive integer array nums.
//
//The element sum is the sum of all the elements in nums.
//The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
//Return the absolute difference between the element sum and digit sum of nums.
//
//Note that the absolute difference between two integers x and y is defined as |x - y|.
public class DifferenceOnSum {
    public static void main(String[] args) {
        int[] nums = {2,7,8,10,8,10,1,10,5,9};
        System.out.println(findDigitAndElementSum(nums));
    }

    public static int findDigitAndElementSum(int[] nums){
        int elementTotal = 0;
        int digitTotal = 0;

        for(int i = 0; i < nums.length; i++){
            elementTotal += nums[i];
            if(nums[i] >= 10) digitTotal += sumDigits(nums[i]);
            else digitTotal += nums[i];
        }

        if(elementTotal > digitTotal) return elementTotal - digitTotal;
        else return digitTotal - elementTotal;
    }

    public static int sumDigits(int num){
        int total = 0;
        while(num != 0){
            total += num%10;
            num = num/10;
        }
        System.out.println(total);
        return total;
    }
}
