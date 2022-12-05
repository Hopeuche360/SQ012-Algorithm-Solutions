package week_nine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of buildings and a direction that all of the buildings face, return an array of the indices of the buildings that can see the sunset.
 *
 * A building can see the sunset if it's strictly taller than all of the buildings that come after it in the direction that it faces.
 *
 * The input array named buildings contains positive, non-zero integers representing the heights of the buildings. A building at index i thus has a height denoted by buildings[i]. All of the buildings face the same direction, and this direction is either east or west, denoted by the input string named direction, which will always be equal to either "EAST" or "WEST". In relation to the input array, you can interpret these directions as right for east and left for west.
 *
 * Important note: the indices in the ouput array should be sorted in ascending order.
 *
 * Aim for a Linear Time solution
 *
 * see README.md file [Sunset Views] in this package
 *
 * Sample Input #1
 * buildings = [3, 5, 4, 4, 3, 1, 3, 2]
 * direction = "EAST" // -> Right
 *
 * Sample Output #1
 * [1, 3, 6, 7] // The indexes of the buildings that can see the Sun
 * As shown in the image above, with the building's height and their indexes, only the buildings that have a clear view in the East direction are returned. When the direction is WEST, the returned values are different.
 *
 * Sample Input #2
 * buildings = [3, 5, 4, 4, 3, 1, 3, 2]
 * direction = "WEST" // <- Left
 *
 * Sample Output #2
 * [0, 1]
 */

public class Monday {

    public static void main(String[] args) {
        System.out.println(sunsetViews(new int[] {3, 5, 4, 4, 3, 1, 3, 2}, "WEST"));
    }

    // O(n) time | O(n) space - where n is the length of the input array
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> candidateBuildings = new ArrayList<Integer>();

        int startIdx = buildings.length - 1;
        int step = -1;

        if (direction.equals("EAST")) {
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        while (idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];

            while (candidateBuildings.size() > 0
                    && buildings[candidateBuildings.get(candidateBuildings.size() - 1)] <= buildingHeight) {
                candidateBuildings.remove(candidateBuildings.size() - 1);
            }

            candidateBuildings.add(idx);

            idx += step;
        }

        if (direction.equals("WEST")) {
            Collections.reverse(candidateBuildings);
        }

        return candidateBuildings;
    }
}
