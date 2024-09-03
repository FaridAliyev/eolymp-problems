package solutions.week7.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {
    private static final int[] m = new int[10010];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        Arrays.fill(m, 0);
        m[0] = 1;
        while (scanner.hasNextInt()) {
            int w = scanner.nextInt();
            for (int i = s; i >= w; i--)
                if (m[i - w] == 1) m[i] = 1;
        }
        for (int i = s; ; i--) {
            if (m[i] > 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
