package Basic_Exercises;

public class MaxWordsInSentences {
    public static void main(String[] args) {
        String[] sentences = {"please wait", "continue to fight", "continue to win"};
        System.out.println(findMaxWordsFound(sentences));
    }

    public static int findMaxWordsFound(String[] strings){
        int count = 0;
        for(int i = 0; i < strings.length; i++){
            int flag = strings[i].split(" ").length;
            if(flag > count){
                count = flag;
            }
        }
        return count;
    }
}
