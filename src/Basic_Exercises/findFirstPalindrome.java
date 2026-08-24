package Basic_Exercises;

public class findFirstPalindrome {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(findPalindrome(words));
    }

    public static String findPalindrome(String[] strs) {
        for (int i = 0; i < strs.length; i++){
            if(isPalindrome(strs[i])){
                return strs[i];
            }
        }
        return "";
    }

//    public static boolean isPalindrome(String str){
//        String newStr = "";
//        for(int i=str.length(); i > 0; i--){
//            newStr += str.charAt(i - 1);
//        }
//        System.out.println(newStr);
//        return newStr.equals(str);
//    }

    // now using the StringBuilder option for java
    public static boolean isPalindrome(String str){
        StringBuilder newStr = new StringBuilder(str).reverse();
        return newStr.toString().equals(str);
    }
}
