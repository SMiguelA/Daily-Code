package Recursivity;

import java.util.Arrays;

public class ReversedString {
    public static void main(String[] args) {
        System.out.println(reversString("JAVA"));
    }

    public static String reversString(String str){
        if(str.isEmpty()) return "";
        // Obtenemos last character
        char miniStr = str.charAt(str.length() - 1);
        // With substring(0, str.length()-1) we create a whole new string without the last letter
        return miniStr + reversString(str.substring(0,str.length()-1));
    }
}
