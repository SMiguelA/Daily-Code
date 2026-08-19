package Basic_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UniqueCharacter {
    public static void main(String[] args) {
        System.out.println(findFirst("loveleetcode"));
    }

//    public static int findFirst(String str){
//        int flag = -1;
//        String[] strArr = str.split("");
//        int count = 0;
//        for (int i=0; i < strArr.length; i++){
//            for (int f = 0; f < strArr.length; f++){
//                if(!Objects.equals(strArr[i], strArr[f]) && f != i){
//                    count++;
//                }else if(Objects.equals(strArr[i], strArr[f]) && f != i){
//                    count = 0;
//                    break;
//                }
//            }
//            if (count != 0) return i;
//        }
//        return flag;
//    }

    // Optimal solution
    public static int findFirst(String str){
        Map<String, Integer> frequency = new HashMap<>();
        String[] strArr = str.split("");
        for (int i = 0; i < strArr.length; i++){
            frequency.put(strArr[i], frequency.getOrDefault(strArr[i],0)+1);
        }

        for(int i = 0; i < strArr.length; i++){
            if(frequency.get(strArr[i]) == 1) return i;
        }

        return -1;
    }
}
