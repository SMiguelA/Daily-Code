package Basic_Exercises;

public class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return checkCanPlaceFlowers(flowerbed, n);
    }

    public static boolean checkCanPlaceFlowers(int[] flowerbed, int flowers){
        int count = 0;

        if(flowerbed.length == 1 && flowers == 0 && flowerbed[0] == 1) return true;
        if(flowerbed.length == 1) return flowerbed[0] == 0;


        for(int i = 0; i < flowerbed.length; i++){
            if(count == flowers) return true;
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                count++;
                flowerbed[i] = 1;
            }
            else if(i == flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0) count ++;
            else if(i != 0 && i+1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
            System.out.println(count);
        }

        return count == flowers;
    }
}