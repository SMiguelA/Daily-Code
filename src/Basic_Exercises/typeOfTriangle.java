package Basic_Exercises;

import java.util.HashMap;
import java.util.Map;

public class typeOfTriangle {
    public static void main(String[] args) {
        int[] nums = {5,3,8};
        System.out.println(defineType(nums));
    }

    public static String defineType(int[] nums){
        Map<Integer, Integer> counter = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0)+1);
        }
        // check if triangle
        if(!(nums[0]+nums[1] > nums[2] && nums[0]+nums[2] > nums[1] && nums[1]+nums[2] > nums[0])) return "none";
        if(counter.containsValue(2)) return "isosceles";
        else if(counter.containsValue(3)) return "equilateral";
        else return "scalene";
    }
}
