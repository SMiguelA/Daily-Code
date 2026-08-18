package Dinamic_Programing;

import java.util.Arrays;

// There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.
// In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the
// value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value,
// and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide
// which row will be thrown away. The next round starts with the remaining row.
// The game ends when there is only one stone remaining. Alice's score is initially zero.
// Return the maximum score that Alice can obtain.

public class StoneGameV {
    public static void main(String[] args) {
        int[] stones = {10,9,8,7,6,5,4,3,2,1};
        int score = 0;
        System.out.println(findMaxAliceScore(stones, score));
    }

    public static int findMaxAliceScore(int[] stones, int score){

        if(stones.length == 1) return score;
        int half = stones.length / 2;

        int[] firstRow = Arrays.copyOfRange(stones, 0, half);
        int firstRowScore = 0;
        int[] secondRow = Arrays.copyOfRange(stones, half, stones.length);
        int secondRowScore = 0;

        for(int i = 0; i < stones.length; i++){
            if(i < half){
                firstRow[i] = stones[i];
                firstRowScore += stones[i];
            }else{
                secondRow[i-half] = stones[i];
                secondRowScore += stones[i];
            }
        }

        score += Math.min(firstRowScore, secondRowScore);

        if(firstRowScore < secondRowScore){
            stones =  firstRow;
        }else{
            stones =  secondRow;
        }

        System.out.println("Stones: "+ Arrays.toString(stones));
        System.out.println("Min score: "+score);

        return findMaxAliceScore(stones, score);
    }
}
