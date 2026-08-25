package Basic_Exercises;

public class XorInArray {
    public static void main(String[] args) {
        System.out.println(findXor(4, 3));
    }

    public static int findXor(int n, int start){
        int xor = 0;
        int[] nums = new int[n];
        for(int i=0; i < nums.length; i++){
            nums[i] = start + 2 * i;
            xor ^= nums[i];
        }

        return xor;
    }
}
