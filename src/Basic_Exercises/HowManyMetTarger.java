package Basic_Exercises;

public class HowManyMetTarger {
    public static void main(String[] args) {
        int[] hours = {0,1,2,3,4};
        System.out.println(howManyMetTarget(hours, 2));
    }

    public static int howManyMetTarget(int[] hours, int target){
        int count = 0;
        for(int i = 0; i < hours.length; i++){
            if(hours[i] >= target){
                count++;
            }
        }
        return count;
    }

}
