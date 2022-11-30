package week_one;

/**
 * Task
 * Write a program to determine if a string contains all unique characters. Return true if it does and false otherwise.
 *
 * The string may contain any of the 128 ASCII characters.
 *
 * Specification
 * has_unique_chars(str)
 * Parameters
 * str: String - The string that may or may not contain all unique characters
 *
 * Return Value
 * Boolean - True if all characters in the string are unique
 *
 * Examples
 * str	Return Value
 * "abcdefg"	true
 * "abbcdefg"	false
 */

public class Monday {

    public static void main(String[] args) {
        System.out.println(hasUniqueChars("Hope"));
        System.out.println(hasUniqueCharsII("Essential"));
    }

    //method 1 O(n^2) time complexity
    public static boolean hasUniqueChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
    //method 2 O(n) time complexity
    public static boolean hasUniqueCharsII(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) return false;
        }
        return true;
    }
}
