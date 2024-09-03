package solutions.week2.stackqueue;

import java.util.*;

public class SuperMinimum {
    private static final Deque<Integer> deque = new ArrayDeque<>();
    private static final Deque<Integer> mn = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int i = 0;
        for (; i < k; i++) {
            int num = scanner.nextInt();
            add(num);
        }
        for (; i < n; i++) {
            getMinimum();
            int num = scanner.nextInt();
            int removed = deque.removeFirst();
            if (mn.getFirst() == removed) {
                mn.removeFirst();
            }
            add(num);
        }
        getMinimum();
    }

    public static void add(int num) {
        deque.addLast(num);
        if (mn.isEmpty()) {
            mn.addLast(num);
        } else {
            while (!mn.isEmpty() && num < mn.getLast()) {
                mn.removeLast();
            }
            mn.addLast(num);
        }
    }

    public static void getMinimum() {
        System.out.print(mn.getFirst() + " ");
    }
}
