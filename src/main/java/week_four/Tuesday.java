package week_four;

import java.util.ArrayList;
import java.util.List;

/**
 * Task
 * You are given an array of up to four non-negative integers, each less than 256.
 *
 * Your task is to pack these integers into one number M so that the first element of the array occupies the first (or least significant) 8 bits of M; the second element occupies next 8 bits, and so on.
 *
 * Return the obtained integer M as unsigned integer.
 *
 * Note
 * As indicated the first 8 bits are the least significant bits of M, meaning the right-most bits of the integer.
 * For further clarification see the following example.
 *
 * Specification
 * Challenge.arrayPacking(array)
 * Parameters
 * array: List<Integer> - up to four unsigned integers
 *
 * Return Value
 * Integer - an unsigned integer
 *
 * Constraints
 * array.length == 3
 *
 * 0 ≤ array[i] < 256
 *
 * Example
 * For [24, 85, 0] the output should be 21784
 *
 * [24,       85,       0       ] - The initial array
 * [00011000, 01010101, 00000000] - Translate each number to Binary
 *    000000000101010100011000    - Compact to a single number
 *             21784              - Translate to Decimal
 */

public class Tuesday {

    public static void main(String[] args) {
        System.out.println(arrayPacking(new ArrayList<>(List.of(24, 85, 0))));
    }

    public static int arrayPacking(ArrayList<Integer> integer) {
        String bit = "";
        // convert each of the list item to binary and join
        for (int i = 0; i <= integer.size() - 1; i++) {
            bit = bit + convertToBinary(integer.get(i));
        }
        //convert the concatenated binaries back to decimal
        return convertToDecimal(bit);
    }

    //sub-method to convert from decimal to binary
    public static String convertToBinary(int decimal) {
        String[] bits = {"0", "0", "0", "0", "0", "0", "0", "0"};
        int i = 0;
        while (decimal > 0) {
            bits[i] = Integer.toString(decimal % 2);
            decimal = decimal / 2;
            i++;
        }
        return String.join("", bits);
    }

    //sub-method to convert from binary to decimal
    public static int convertToDecimal(String binary) {
        int decimal = 0;
        String[] bitArray = binary.split("");
        for (int i = 0; i < binary.length(); i++) {
            decimal = decimal + Integer.parseInt(bitArray[i]) * (int) Math.pow(2, i);
        }
        return decimal;
    }
}
