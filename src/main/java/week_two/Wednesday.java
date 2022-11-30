package week_two;

/**
 *Task
 * Finish the function numberToOrdinal, which should take a number and return it as a string with the correct ordinal indicator suffix (in English). For example, 1 turns into "1st".
 *
 * For the purposes of this challenge, you may assume that the function will always be passed a non-negative integer. If the function is given 0 as an argument, it should return the string "0" without a suffix.
 *
 * To help you get started, here is an excerpt from Wikipedia's page on Ordinal Indicators:
 *
 * st is used with numbers ending in 1 (e.g. 1st, pronounced first)
 * nd is used with numbers ending in 2 (e.g. 92nd, pronounced ninety-second)
 * rd is used with numbers ending in 3 (e.g. 33rd, pronounced thirty-third)
 * As an exception to the above rules, all the "teen" numbers ending with 11, 12 or 13 use -th (e.g. 11th, pronounced eleventh, 112th, pronounced one hundred [and] twelfth)
 * th is used for all other numbers (e.g. 9th, pronounced ninth).
 * Specification
 * numberToOrdinal(number)
 * take a number and return it as a string with the correct English ordinal indicator suffix
 *
 * Parameters
 * number: Number - The number to be converted to a string ordinal
 *
 * Return Value
 * String - Returns a string ordinal based on the number.
 *
 * Constraints
 * 0 ≤ number ≤ 10000
 *
 * Examples
 * number	Return Value
 * 1	"1st"
 * 2	"2nd"
 * 3	"3rd"
 * 4	"4th"
 * 21	"21st"
 */


public class Wednesday {

    public static void main(String[] args) {
        System.out.println(numberToOrdinal(34));
    }

    public static String numberToOrdinal(int number) {
        String[] suffixes = {"th", "st", "nd", "rd"};
        int v = number % 100;

        if (0 == number) {
            return "0";
        }
        else if (Math.abs(v - 20) % 10 < suffixes.length) {
            return number + suffixes[Math.abs(v-20)%10];
        }
        else if (v < suffixes.length) {
            return number + suffixes[v];
        }

        return number + suffixes[0];
    }
}
