package org.example.queues;

import java.util.*;

/**
 * Problem
 * <a href="https://www.hackerearth.com/problem/algorithm/empty-array-31ed638c/">...</a>
 * You are given two arrays each of size, and consisting of the first  positive integers each exactly once, that is, they are permutations.
 * Your task is to find the minimum time required to make both the arrays empty. The following two types of operations can be performed any number of times each taking 1 second:
 *     In the first operation, you are allowed to rotate the first array clockwise.
 *     In the second operation, when the first element of both the arrays is the same, they are removed from both the arrays and the process continues.
 * Print the total time taken required to empty both the array.
 */

class EmptyArrays {
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        s.nextLine();

        System.out.println(emptyArrays(s.nextLine().split(" "), s.nextLine().split(" ")));
    }

    static int emptyArrays(String[] arr1, String[] arr2) {
        Queue<String> q1 = new LinkedList<>(Arrays.asList(arr1));
        Queue<String> q2 = new LinkedList<>(Arrays.asList(arr2));
        Counter counter = new Counter();
        while (!q1.isEmpty()) {
            if (isQueueFirstElementSame(q1, q2)) {
                counter.increment();
                q1.remove();
                q2.remove();
            } else {
                while (!q1.isEmpty()) {
                    counter.increment();
                    rotateClockwise(q1);
                    assert q1.peek() != null;
                    if (isQueueFirstElementSame(q1, q2)) {
                        break;
                    }
                }
            }
        }
        return counter.getVal();
    }

    private static boolean isQueueFirstElementSame(Queue<String> q1, Queue<String> q2) {
        return Objects.equals(q1.peek(), q2.peek());
    }

    static void rotateClockwise(Queue<String> q) {
        String first = q.poll();
        q.add(first);
    }


    static class Counter {
        private int val = 0;

        public int getVal() {
            return val;
        }

        public void increment() {
            this.val = val + 1;
        }
    }
}
