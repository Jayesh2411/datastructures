package org.example.queues;


import java.util.*;

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
