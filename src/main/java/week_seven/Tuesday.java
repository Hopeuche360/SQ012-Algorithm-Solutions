package week_seven;

/**
 * Task
 * Given a string, s, we define a substring, s', of s to be a string that occurs in s (i.e., a string matching some contiguous block of characters in s).
 *
 * Complete the count_binary_substrings function. It has one parameter: a string, s, consisting of only 0s and 1s. The function must return an integer denoting the total number of substrings of s satisfying both of the following two conditions:
 *
 * The 0s and 1s are grouped consecutively (e.g., 01, 10,0011, 1100, 000111, etc.).
 * The number of 0s in the substring is equal to the number of 1s in the substring
 * Specification
 * Challenge.countBinarySubstrings(s)
 * Parameters
 * s: String - a string consisting of only 0s and 1s.
 *
 * Return Value
 * Integer - denoting the total number of substrings of s satisfying the conditions.
 *
 * Constraints
 * 5 ≤ s.length ≤ 5 × 100
 * String s consists of 0s and 1s only
 * Examples
 * s	Return Value
 * Example 1	"00110"	3
 * Example 2	"10101"	4
 * Example 3	"10001"	2
 * Explanation for example 1 ("00110")
 * There are three substrings having equal numbers of consecutively grouped 0s and 1s:
 *
 * "0011", which is a substring of the characters from s0 to s3 (inclusive).
 * "01", which is a substring of the characters from s1 to s2 (inclusive).
 * "10", which is a substring of the characters from s3 to s4 (inclusive).
 * Thus, we return 3 as our answer.
 *
 * Explanation for example 2 ("10101")
 * There are four substrings having equal numbers of consecutively grouped 0s and 1s:
 *
 * "10", which is a substring of the characters from s0 to s1 (inclusive).
 * "01", which is a substring of the characters from s1 to s2 (inclusive).
 * "10", which is a substring of the characters from s2 to s3 (inclusive).
 * "01", which is a substring of the characters from s3 to s4 (inclusive).
 * Thus, we return 4 as our answer.
 *
 * Explanation for example 3 ("10001")
 * There are two substrings having equal numbers of consecutively grouped 0s and 1s:
 *
 * "10", which is a substring of the characters from s0 to s1 (inclusive).
 * "01", which is a substring of the characters from s3 to s4 (inclusive).
 * Thus, we return 2 as our answer.
 */

public class Tuesday {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10001"));
    }

    public static int countBinarySubstrings(String str) {
        int count = 0;
        // previous and current group size
        int previous = 0;
        int current = 1;
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                count += Math.min(previous, current);
                previous = current;
                current = 1;
            } else {
                ++current;
            }
        }
        return count + Math.min(previous, current);
    }
}
