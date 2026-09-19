package Basic_Exercises;

import java.util.ArrayList;
import java.util.List;

public class greatestCandyNumber {
    public static void main(String[] args) {
        int[] candies = {4,2,1,1,2};
        System.out.println(numberOfCandies(candies, 1));
    }

    public static List<Boolean> numberOfCandies(int[] candies, int extraCandies){
        int greatest = checkGreatest(candies);
        List<Boolean> checker = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            checker.add(candies[i]+extraCandies >= greatest);
        }
        return checker;
    }

    public static int checkGreatest(int[] candies){
        int greatest = 0;
        for(int i = 0; i < candies.length; i++){
            if(candies[i] > greatest) greatest = candies[i];
        }
        return greatest;
    }
}
