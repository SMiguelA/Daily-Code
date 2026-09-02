package Basic_Exercises;

public class ProductAndSum {
    public static void main(String[] args) {
        System.out.println(difference(4421));
    }

    public static int difference(int num){
        int sum = 0;
        int product = 1;
        int flag;
        while(num > 0){
            flag = num % 10;
            sum += flag;
            product *= flag;

            num /= 10;
        }
        return product - sum;
    }
}
