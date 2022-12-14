package week_three;

import java.util.ArrayList;
import java.util.List;

/**
 *Task
 * Consider an array where each element in the array contains a positive integer digit. Taken as a whole, such an array represents a positive integer number. The rightmost position of the array represents the least siginificant digit of the number.
 *
 * An example digit array is [4, 2] which represents the integer 42.
 *
 * In this challenge, you will write a function to increment the number in the digit array by 1. For example, upArray([4, 2]) will return the array [4, 3].
 *
 * Here is the complete specification for upArray:
 *
 * Challenge.upArray(arr)
 * increases the digit array value by one
 *
 * Parameters
 * arr: Integer[] - an array of integers to be increased.
 *
 * Return Value
 * Integer[] - an array with the new value.
 *
 * Constraints
 * Parameter array will not be empty
 * Array will only contain non-negative single digit integers
 * Array will not contain leading zeroes unless its length is exactly 1
 * Examples
 * arr	Return Value
 * [5,7,4]	[5,7,5]
 * [4,3,9]	[4,4,0]
 * [9]	[1,0]
 */

public class Tuesday {

    public static void main(String[] args) {
        System.out.println(upArray(new ArrayList<>(List.of(4, 2))));
    }

    public static ArrayList<Integer> upArray(ArrayList<Integer> num) {
        var res = new ArrayList<Integer>();
        int rem = 1;

        for (int i = num.size() - 1; i >= 0; i--) {
            res.add((num.get(i) + rem) % 10);
            rem = num.get(i) + rem > 9 ? 1 : 0;
        }

        if (rem > 0)  {
            res.add(rem);
        }

        java.util.Collections.reverse(res);
        return res;
    }
}
