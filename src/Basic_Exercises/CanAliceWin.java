package Basic_Exercises;

public class CanAliceWin {
    public static void main(String[] args) {
        int[] nums = {5,5,5,25};
        System.out.println(ifWinable(nums));
    }

    public static boolean ifWinable(int[] nums){
        int single = 0;
        int doubleNums = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 10) doubleNums += nums[i];
            else single += nums[i];
        }

        return single != doubleNums;
    }
}
