package Basic_Exercises;
import java.util.Arrays;

public class MinNumber {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 3};
        System.out.println(Arrays.toString(numberGame(nums)));
    }

    public static int[] numberGame(int[] nums){
        nums = Arrays.stream(nums).sorted().toArray();
        int[] newNumsArr = new int[nums.length];
        for(int i=0; i<newNumsArr.length; i++){
            if(nums[i] != 0 && newNumsArr[i] == 0){
                newNumsArr[i] = nums[i+1];
                newNumsArr[i+1] = nums[i];

                nums[i] = 0;
                nums[i+1] = 0;
            }
        }
        return newNumsArr;
    }
}
