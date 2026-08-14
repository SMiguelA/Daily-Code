package Dinamic_Programing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        final Map<Long, Long> memo = new HashMap<>();
        System.out.println(linearFibonacci(50L));
    }

    // O(2)n - Demaciado lento, realiza consultas repetidas
    public static int findFibonacci(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        return findFibonacci(num-1) + findFibonacci(num-2);
    }

    // Recursividad arreglada con memoizacion (objetivo de la programacion dinamica) - O(n)
    public static long dinamicFibonacci(Long num, Map<Long, Long> memo){
        System.out.println(memo);
        if(memo.containsKey(num)) return memo.get(num);

        if(num <= 1){
            memo.put(num, num);
            return num;
        }else{
            long result = dinamicFibonacci(num-1, memo) + dinamicFibonacci(num-2, memo);
            memo.put(num, result);
            return result;
        }
    }

    //Solucion mas simple y lineal - Solo para fibonacci o problemas simples
    public static long linearFibonacci(long num){
        final List<Long> memo = new ArrayList<>(List.of(0L,1L));
        for(long flag = 2; flag<=num; flag++){
            // Casteamos long a int para poder hacer las consultas
            memo.add((memo.get((int) (flag-1))+memo.get((int) (flag-2))));
        }
        // mismo casteo para obtener el resultado sin cambiar el valor del index
        return memo.get((int) num);
    }
}
