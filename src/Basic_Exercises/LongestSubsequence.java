package Basic_Exercises;

import java.util.ArrayList;
import java.util.List;

public class LongestSubsequence {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2,3,4));
        System.out.println(findLongest(list));
    }

    // Encontrar el numero total de la subsecuencia de numeros cuyo XOR en bits es diferente a cero
    // Se utiliza el operador bit para calcular un xor: ^
    // Solo tener en cuenta, el xor cambia si le quitamos un solo numero al array, por ende si [...] es 0 la espuesta es el length original -1 y ya
    public static int findLongest(List<Integer> numList){
        int xorValue = calculateXor(numList);

        if(xorValue != 0 ) return numList.size();

        for(int num: numList){
            if(num != 0){
                return numList.size()-1;
            }
        }

        return 0;
    }

    public static int calculateXor(List<Integer> numList){
        int xor = 0;
        for(int i = 0; i < numList.size(); i++){
            xor ^= numList.get(i);
        }
        return xor;
    }
}
