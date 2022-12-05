package week_five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Task
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 *
 * individual integers
 * or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17".
 * Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.
 *
 * Documentation
 * Challenge.rangeCompact(nums)
 * Parameters
 * nums: Integer[] - An ordered list of unique integers
 *
 * Return Value
 * String - formatted string with range format
 *
 * Example:
 *
 * Solution.rangeCompact(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
 * // returns "-6,-3-1,3-5,7-11,14,15,17-20"
 */

public class Tuesday {

    public static void main(String[] args) {
        System.out.println(rangeCompact(new ArrayList<>(List.of(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20))));
    }

    public static String rangeCompact(final ArrayList<Integer> arr) {
        List<String> ans = new ArrayList<String>();
        int[] rngInd = new int[] {-1,-1};
        int n1, n2;

        for (int i = 1 ; i <= arr.size(); i++) {

            n1 = arr.get(i-1);
            n2 = (i == arr.size()) ? n1+2 : arr.get(i);

            if (n1+1 == n2) {
                if (rngInd[0] == -1) {
                    rngInd = new int[] {i-1,i};
                } else {
                    rngInd[1] = i;
                }
            } else {
                if (rngInd[0] != -1) {
                    n1 = arr.get(rngInd[0]);
                    n2 = arr.get(rngInd[1]);
                    if (rngInd[0] + 1 == rngInd[1]) {
                        ans.add(String.valueOf(n1));
                        ans.add(String.valueOf(n2));
                    } else {
                        ans.add( Arrays.asList(n1, n2)
                                .stream()
                                .map( n -> String.valueOf(n) )
                                .collect(Collectors.joining("-")) );
                    }
                    rngInd = new int[] {-1,-1};
                } else {
                    ans.add(String.valueOf(n1));
                }
            }
        }

        return String.join(",", ans.toArray(new String[0]));
    }
}
