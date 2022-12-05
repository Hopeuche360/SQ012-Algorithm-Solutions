package week_seven;

import java.util.ArrayList;
import java.util.List;

/**
 * Task
 * Write a function that counts how many different ways you can make change for an amount of money given an array of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2:
 *
 * 1+1+1+1, 1+1+2, 2+2.
 * The order of coins does not matter:
 *
 * 1+1+2 == 2+1+1
 * Also, assume that you have an infinite ammount of coins.
 *
 * Your function should take an amount to change and an array of unique denominations for the coins.
 *
 * Specification
 * Challenge.countChange(money, coins)
 * Parameters
 * money: Integer - Number to make change for
 *
 * coins: Integer[] - Array of denominations
 *
 * Return Value
 * Integer - Number of ways change can be made
 *
 * Examples
 * money	coins	Return Value
 * 4	[1,2]	3
 * 10	[5,2,3]	4
 * 11	[5,7]	0
 */

public class Monday {

    public static void main(String[] args) {
        System.out.println(countChange(4, new ArrayList<>(List.of(1, 2))));
    }

    public static int countChange(int money, ArrayList<Integer> coins) {
        return countChange(money, coins, 0);
    }

    public static int countChange(int money, ArrayList<Integer> coins, int i) {
        if (money == 0) return 1;
        else if (money < 0 || i >= coins.size()) return 0;
        return countChange(money - coins.get(i), coins, i) + countChange(money, coins, i + 1);
    }
}
