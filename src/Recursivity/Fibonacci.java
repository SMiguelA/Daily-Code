package Recursivity;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(findFibonacci(5));
    }

    public static int findFibonacci(int num){
        if(num <=1) return num;
        return findFibonacci(num-1)+findFibonacci(num-2);
    }
}
