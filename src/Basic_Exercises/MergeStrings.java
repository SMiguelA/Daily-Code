package Basic_Exercises;

public class MergeStrings {
    public static void main(String[] args) {
        System.out.println(mergeStrings("ab","pqrs"));
    }

    public static String mergeStrings(String str1, String str2){
        String newStr = "";
        for(int i = 0; i < Math.max(str1.length(), str2.length()); i++){
            newStr = newStr.concat(String.valueOf(i <= str1.length()-1 ? str1.charAt(i) : ""));
            newStr = newStr.concat(String.valueOf(i <= str2.length()-1 ? str2.charAt(i) : ""));
        }
        return newStr;
    }
}
