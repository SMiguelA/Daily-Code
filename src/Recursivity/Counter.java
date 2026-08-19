package Recursivity;

public class Counter {
    public static void main(String[] args) {
        countDown(5);
    }

    public static void countDown(int num){
        if(num == 0) System.out.println("Despegue!");
        else {
            System.out.println(num);
            countDown(num-1);
        }
    }
}
