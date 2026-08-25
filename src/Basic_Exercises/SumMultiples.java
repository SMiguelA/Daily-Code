package Basic_Exercises;

public class SumMultiples {
    public static void main(String[] args) {
        System.out.println(sumTotal(7));
    }

    public static int sumTotal(int num){
        int count = 0;
        for(int i = 1; i <= num; i++){
            if(i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
                count += i;
            }
        }
        return count;
    }

}
