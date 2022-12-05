package week_five;

import java.util.Arrays;

/**
 * Write a function that takes in a non-empty array of integers and returns an array of the same length, where each element in the output array is equal to the product of every other number in the input array.
 *
 * In other words, the value at output[i] is equal to the product of every number in the input array other than input[i].
 *
 * Sample Input
 * [5, 1, 4, 2]
 * Sample Output
 * [8, 40, 10, 20]
 *
 * // 8 is equal to 1 x 4 x 2
 * // 40 is equal to 5 x 4 x 2
 * // 10 is equal to 5 x 1 x 2
 * // 20 is equal to 5 x 1 x 4
 */

public class Monday {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiplyArray(new int[] {5, 1, 4, 2})));
    }

    public static int[] multiplyArray(int[] array) { //2, 3, 2, 1, 4
        int[] multipliedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int multiple = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j)
                    multiple = multiple * array[j];
            }
            multipliedArray[i] = multiple;
        }
        return multipliedArray;
    }

}
