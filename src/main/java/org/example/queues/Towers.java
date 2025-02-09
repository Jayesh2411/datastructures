package org.example.queues;

import java.util.*;
/**
 *Your task is to construct a tower in
 *
 *  days by following these conditions:
 *
 *     Every day you will be provided with one disk of a distinct size.
 *     The disk with larger sizes should be placed at the bottom of the tower.
 *     The disk with smaller sizes should be placed at the top of the tower.
 *
 * The order in which tower should be constructed is as follows:
 *
 *     You cannot put a new disk on the top of the tower until all the larger disks are given to you are placed.
 *
 * Print
 *  lines displaying the disk sizes that can be put on the tower on the
 *
 *  day.
 *
 * Input format
 *
 *     First line:
 *
 *  (total number of disks that are given to you in the
 * subsequent days)
 * Second line:
 *  integers in which the  integers denote the size of the disks which are given to you on the
 *
 *      day.
 *
 * Note: All the disk sizes are distinct integers in the range of
 *
 * .
 *
 * Output format
 *
 * Print
 *  lines. On the
 *
 *  line print the size of disks that can be placed on the top of the tower in descending order of the disk sizes.
 *
 * Note: If on the
 *  day no disks can be placed, then leave that line empty.
 */
public class Towers {
    public static void main(String[] args) { //4
        List<List<Integer>> result = Solve(List.of(4, 5, 1, 2, 3)); // 5 4 3 2 1
        for (List<Integer> r: result) {
            if (r.getFirst() == -1) {
                System.out.println(" ");
            } else {
                System.out.println(r);
            }
        }
    }

    static List<List<Integer>> Solve(List<Integer> arr) {
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        sortedQueue.addAll(arr);
        List<List<Integer>> resultList = new ArrayList<>(new ArrayList<>());
        for (int i = 0;i< arr.size(); i++) {
            List<Integer> l = new ArrayList<>();
            if (!sortedQueue.isEmpty() &&
                    arr.get(i) < sortedQueue.peek()) {
                l.add(-1);
                queue.add(arr.get(i));
            } else {
                l.add(sortedQueue.poll());
                l.addAll(queue);
                for (Integer k : l){
                    sortedQueue.remove(k);
                }
                queue.clear();
            }
            resultList.add(l);
        }
        return resultList;
    }
}
