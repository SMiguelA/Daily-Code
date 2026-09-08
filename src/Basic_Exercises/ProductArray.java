package Basic_Exercises;

import java.math.BigInteger;

public class ProductArray {
    public static void main(String[] args) {
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(signOfProduct(nums));
    }

    public static int signOfProduct(int[] nums){
        BigInteger product = BigInteger.valueOf(1);
        for(int i = 0; i < nums.length; i++){
            product = product.multiply(BigInteger.valueOf(nums[i]));
            if(product.equals(BigInteger.valueOf(0))) return 0;
            System.out.println("Numero: "+nums[i]+" multiplicacion:"+product);
        }
        return signFunc(product);
    }

    public static int signFunc(BigInteger num){
        return num.compareTo(BigInteger.valueOf(0));
    }
}
