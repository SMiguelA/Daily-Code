package Basic_Exercises;
import java.util.ArrayList;
import java.util.List;

// Dando un target, identificar los primeros dos numeros que al sumarce den como resultado el target otorgado
public class SumSortedArr {
    public static void main(String[] args) {
        int target = 9;
        List<Integer> nums = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7));
        System.out.println(SumSortedArr.getNumbers(nums, target));
    }

    public static List<Integer> getNumbers(List<Integer> nums, int target) {
        List<Integer> sumNums = new ArrayList<>();
        int flag = nums.size()-1;
        for(int i = 0; i<nums.size(); i++){
            if(nums.get(i) + nums.get(flag) > target){
                flag = flag-1;
            } else if (nums.get(i) + nums.get(flag) == target) {
                sumNums.add(i);
                sumNums.add(flag);
            }
        }
        if(sumNums.isEmpty()){
            System.out.println("No hay numeros para sumar el target");
        }
        return sumNums;
    }
}
