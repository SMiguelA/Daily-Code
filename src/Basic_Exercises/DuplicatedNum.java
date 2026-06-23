package Basic_Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicatedNum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of( 7, 1, 2, 2, 6, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> duplicatedOnesArr = DuplicatedNum.duplicatedOnes(list);
        System.out.println(duplicatedOnesArr);
    }

    public static List<Integer> duplicatedOnes(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int valor: arr){
            map.put(valor,map.getOrDefault(valor,0)+1);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (int valor: map.keySet()){
            if(map.get(valor)>1){
                list.add(valor);
            }
        }
        return list;
    }
}
