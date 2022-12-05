package week_nine;

import java.util.ArrayList;
import java.util.List;

/**
 * Task
 * Scheduling is how the processor decides which jobs (processes) get to use the processor and for how long. This can cause a lot of problems. For example, a long-running process might use the entire CPU and block all the other processes from executing. One solution is Shortest Job First (SJF), which you will implement in this challenge.
 *
 * SJF works by letting the shortest jobs take the CPU first. If the jobs are the same size then break the tie with First In First Out (FIFO). The idea is that the shorter jobs will finish quicker, so theoretically jobs won't get frozen because of large jobs. (In practice they're frozen because of small jobs).
 *
 * Specification
 * Challenge.sjf(jobs, index)
 * Returns the clock-cycles (cc) of when the process will be executed for a given index
 *
 * Parameters
 * jobs: Integers[] - A non-empty array of positive integers representing the clock cycles needed to finish a job.
 *
 * index: Integer - A positive integer that respresents the job we're interested in
 *
 * Return Value
 * Integer - A number representing the clock cycles it takes to complete the job at index.
 *
 * Examples
 * jobs	index	Return Value
 * [3,10,20,1,2]	0	6
 * [3,10,10,20,1,2]	2	26
 * Example
 * SJF([3, 10, 20, 1, 2], 0)
 * Here, we have 5 jobs scheduled with times 3, 10, 20, 1 and 2. We want to determine when the job at the 0th index will complete, based on the second argument to the SJF function. The job we're interested in takes 3 time units to complete.
 *
 * at 0cc [3, 10, 20, 1, 2] jobs[3] starts
 * at 1cc [3, 10, 20, 0, 2] jobs[3] finishes, jobs[4] starts
 * at 3cc [3, 10, 20, 0, 0] jobs[4] finishes, jobs[0] starts
 * at 6cc [0, 10, 20, 0, 0] jobs[0] finishes
 * so:
 *
 * SJF([3,10,20,1,2], 0) == 6
 */

public class Tuesday {

    public static void main(String[] args) {
        System.out.println(sjf(new ArrayList<>(List.of(3, 10, 20, 1, 2)), 0));
    }

    public static int sjf(ArrayList<Integer> jobs, int index) {
        int res = 0;
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i) < jobs.get(index) || (jobs.get(i) == jobs.get(index) && i <= index)) {
                res += jobs.get(i);
            }
        }
        return res;
    }
}
