package org.example.queues;

import java.util.*;
// 1 2
//  3
//  3 2 1
//  1 2 3
//  3 2 1
//5 4
//
//
 //3 2 1
// 5 4 3 2 1
// 1 4 2 5 3
public class Towers {
    public static void main(String[] args) {
        List<Integer>[] solve = Solve(List.of(4, 5, 1, 2, 3));
        for (int i = 0;i<5;i++) {
            System.out.println(solve[i]);
        }

    }

    static List<Integer>[] Solve(List<Integer> arr) {
        List<Integer>[] out = new ArrayList[arr.size()];
        Set<Integer> visited = new HashSet<>();
        List<Integer> sortedList = new ArrayList<>(arr);
        sortedList.sort(Comparator.reverseOrder());
        Queue<Integer> sortedQueue = new LinkedList<>(sortedList);

        for (int i =0;i<arr.size();i++) {
            List<Integer> l = new ArrayList<>();
            if (arr.get(i) < sortedQueue.peek()) {
                visited.add(arr.get(i));
            } else {
                l.add(sortedQueue.poll());
                while (visited.contains(sortedQueue.peek())) {
                    Integer polled = sortedQueue.poll();
                    l.add(polled);
                    visited.remove(polled);
                }
                out[i] = l;
            }
        }
        return out;
    }
}
