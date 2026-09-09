package Basic_Exercises;

public class challenge657 {
    public static void main(String[] args) {
        System.out.println(circle("LL"));
    }

    public static boolean circle(String moves){
        int y = 0;
        int x = 0;

        for(int i = 0; i < moves.length(); i++){
            switch (moves.charAt(i)){
                case 'U' -> y += 1;
                case 'D' -> y -= 1;
                case 'L' -> x -= 1;
                case 'R' -> x += 1;
            }
        }

        return x == 0 && y == 0;
    }
}
