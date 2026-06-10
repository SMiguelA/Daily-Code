public class FizzBuzz {
    public static void main(String[] args) {
        String flag = "";
        for(int i=1;i<=100;i++){
            if(i%15==0){
                flag = "FizzBuzz";
            } else if (i%5==0) {
                flag = "Buzz";
            } else if (i%3==0) {
                flag = "Fizz";
            }else{
                flag = Integer.toString(i);
            }
            System.out.println(flag);
        }

    }
}
