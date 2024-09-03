package solutions.week8.dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class MathematicalPlatforms {
    private static final long INF = Long.MAX_VALUE / 2;
    private static final long[] energy = new long[4001];
    private static final int[] used = new int[4001];
    private static final int[] height = new int[4001];


    public static void main(String[] args) {
        Arrays.fill(energy, INF);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            height[i] = scanner.nextInt();
        }
        int s = 1;
        int f = n;
        energy[s] = 0;
        for (int i = 1; i < n; i++) {
            long min = INF;
            int v = -1;
            for (int j = 1; j <= n; j++) {
                if (used[j] == 0 && energy[j] < min) {
                    min = energy[j];
                    v = j;
                }
            }

            if (v < 0) break;

            for (int j = 1; j <= n; j++)
                if (used[j] == 0) relax(v, j);

            used[v] = 1;
        }

        System.out.println(energy[f]);
    }

    private static void relax(int i, int j) {
        long cost = calculateCost(i, j);
        if (energy[i] + cost < energy[j]) {
            energy[j] = energy[i] + cost;
        }
    }

    private static long calculateCost(int i, int j) {
        return (long) (i - j) * (i - j) * (height[i] - height[j]) * (height[i] - height[j]);
    }
}
