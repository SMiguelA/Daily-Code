package Recursivity;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(5));
    }

    public static int findFactorial(int num){
        int n=1;
        if(num > 0){
            n = num * findFactorial(num - 1);
        }
        return n;
    }
}
