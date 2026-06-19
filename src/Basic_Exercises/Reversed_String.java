package Basic_Exercises;

public class Reversed_String {
    public static void main(String[] args) {
        System.out.println(Reversed_String.reverse("adiooooos"));

    }

    public static String reverse(String str) {
        String newStr = "";
        for (String character : str.split("")) {
            newStr = character + newStr;
        }
        return newStr;
    }
}
