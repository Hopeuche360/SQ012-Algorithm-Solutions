package week_four;

import java.util.ArrayList;
import java.util.List;

/**
 * Task
 * Given an array of 2k integers (for some integer k, which will be betwen 0 and 5 inclusive), perform the following operations until the array contains only one element:
 *
 * On the 1st, 3rd, 5th, etc. iterations (1-based) replace each pair of consecutive elements with their sum;
 * On the 2nd, 4th, 6th, etc. iterations replace each pair of consecutive elements with their product.
 * After the algorithm has finished, there will be a single element left in the array. Return that element.
 *
 * Specification
 * Challenge.packArray(arr)
 * Parameters
 * arr: Integer[] - An array of integers to be packed
 *
 * Return Value
 * Integer - The final product
 *
 * Constraints
 * arr.length == 2k
 *
 * 0 ≤ k ≤ 5
 *
 * -9 ≤ arr[i] ≤ 99
 *
 * Example
 * For arr = [1, 2, 3, 4, 5, 6, 7, 8], the output should be 186.
 *
 * We have [1, 2, 3, 4, 5, 6, 7, 8] -> [3, 7, 11, 15] -> [21, 165] -> [186], so the answer is 186.
 */

public class Monday {

    public static void main(String[] args) {
        System.out.println(packArray(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8))));
    }

    public static int packArray(ArrayList<Integer> arr) {
        for (int i = 0; arr.size() > 1; i++) {
            final var next = new ArrayList<Integer>();

            for (int j = 0; j < arr.size(); j += 2) {
                int x = arr.get(j);
                int y = arr.get(j + 1);
                next.add(i % 2 == 0 ? x + y : x * y);
            }

            arr = next;
        }

        return arr.get(0);
    }

}
