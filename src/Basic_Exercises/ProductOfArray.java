package Basic_Exercises;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("Products: " + Arrays.toString(products(nums)));
    }

    public static int[] products(int[] nums){
        int[] products = new int[nums.length];
        Arrays.fill(products, 1);
        int leftProduct = 1;
        int rightProduct = 1;

        int derIzq = nums.length-1;

        for(int izqDer = 0; izqDer < nums.length; izqDer++){
            products[izqDer] *=  leftProduct;
            leftProduct *= nums[izqDer];

            products[derIzq] *= rightProduct;
            rightProduct *= nums[derIzq];

            derIzq--;
        }

        return products;
    }
}
