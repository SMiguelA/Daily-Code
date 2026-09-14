package Basic_Exercises;

public class gcdOfStrings {
    public static void main(String[] args) {
        System.out.println(greatestCommonStr("AAAAAB", "AAA"));
    }
    // greatest common divisor
    public static String greatestCommonStr(String str1, String str2){
        if(!(str1 + str2).equals(str2 + str1)) return "";
        // Solo extraigo el substring desde 0 hasta el maximo comun divisor
        // String.substring(i,x) me extrae un rango de letras desde i hasta x
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    // formula general para encontrar el maximo commun divisor
    private static int gcd(int num1, int num2){
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }
}
