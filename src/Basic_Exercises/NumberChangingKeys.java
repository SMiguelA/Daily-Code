package Basic_Exercises;

public class NumberChangingKeys {
    public static void main(String[] args) {
        System.out.println(countChangesOnKey("AaAaAaaA"));
    }

    public static int countChangesOnKey(String str){
        int count = 0;
        str = str.toLowerCase();
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) != str.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
