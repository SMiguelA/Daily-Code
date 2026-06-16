import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();
        boolean palindrome = isPalindrome(text);
        System.out.println("The string " + text + (palindrome?" is a palindrome.":" is not a palindrome"));
    }

    public static boolean isPalindrome(String text){
        return text.equals(Reversed_String.reverse(text));
    }
}
