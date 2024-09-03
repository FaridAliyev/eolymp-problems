package solutions.week4.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Queue {
    private static final PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long t = scanner.nextLong();
            if (pq.size() != k) pq.add(t);
            else {
                long temp = pq.remove();
                pq.add(t + temp);
            }
        }
        while (pq.size() > 1) pq.remove();
        System.out.println(pq.peek());
    }
}
