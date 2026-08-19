package Recursivity;

public class SumRange {
    public static void main(String[] args) {
        System.out.println(sumRange(2345));
    }

    public static int sumRange(int num){
        int n = num % 10;
        if(num == 0) return n;
        else return sumRange(num/10) + n;
    }
}
