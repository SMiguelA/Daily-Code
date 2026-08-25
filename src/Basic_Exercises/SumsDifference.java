package Basic_Exercises;

public class SumsDifference {
    public static void main(String[] args) {
        System.out.println(differenceSums(5, 6));
    }

    public static int differenceSums(int n, int m){
        int num1 = 0;
        int num2 = 0;
        for(int i = 1; i <= n; i++){
            if(i % m != 0) num1 += i;
            if(i % m == 0) num2 += i;
        }
        return num1-num2;
    }
}
