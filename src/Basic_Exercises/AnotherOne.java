package Basic_Exercises;

import java.util.Arrays;

public class AnotherOne {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(products(nums)));
    }

    public static int[] products(int[] nums){
        int left = 0;
        int right= nums.length-1;

        int[] arrProdcuts = new int[nums.length];
        Arrays.fill(arrProdcuts, 1);

        int productLeft = 1;
        int productRight = 1;

        while(left < nums.length){

            arrProdcuts[left] *= productLeft;
            productLeft *= nums[left];

            arrProdcuts[right] *= productRight;
            productRight *= nums[right];

            left++;
            right--;
        }

        return arrProdcuts;
    }
}
