package by.belstu.istomin.helpers;

import java.util.Random;

public class NumberGenerator {
    public static int[] getRandomArray(int n) {
        int minLength = 5;
        int maxLength = 10;
        int arrayLength = getRandomArrayLength(minLength, maxLength);
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = new Random().ints(-n, n).findFirst().getAsInt();
        }
        return arr;
    }
    private static int getRandomArrayLength(int min, int max){
        return new Random().ints(min, max).findFirst().getAsInt();
    }
}
