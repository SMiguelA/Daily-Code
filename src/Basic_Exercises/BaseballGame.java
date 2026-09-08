package Basic_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame {
    public static void main(String[] args) {
        String[] opts = {"1","C"};
        System.out.println(points(opts));
    }

    public static int points(String[] opts){
        List<Integer> records = new ArrayList<>();
        for(int i = 0;i < opts.length; i++){
            switch (opts[i]) {
                case "+" -> records.add(records.getLast() + records.get(records.size()-2));
                case "D" -> records.add(records.getLast() * 2);
                case "C" -> records.removeLast();
                default -> records.add(Integer.parseInt(opts[i]));
            }
        }
        return sum(records);
    }

    public static int sum(List<Integer> nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
