package solutions.week7.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AddAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            long temp = scanner.nextInt();
            q.add(temp);
        }

        long cost = 0;
        while (q.size() > 1) {
            long temp = q.poll();
            temp += q.poll();
            q.add(temp);
            cost += temp;
        }
        System.out.println(cost);
    }
}
