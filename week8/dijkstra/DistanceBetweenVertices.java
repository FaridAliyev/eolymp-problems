package solutions.week8.dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class DistanceBetweenVertices {
    private static final int INF = 2000000000;
    private static final int[][] g = new int[1001][1001];
    private static final int[] used = new int[1001];
    private static final int[] dist = new int[1001];


    public static void main(String[] args) {
        for (int[] ints : g) {
            Arrays.fill(ints, INF);
        }
        Arrays.fill(dist, INF);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();
        for (int i = 1; i <= m; i++) {
            int b = scanner.nextInt();
            int e = scanner.nextInt();
            int w = scanner.nextInt();
            g[b][e] = g[e][b] = w;
        }
        dist[s] = 0;
        for (int i = 1; i < n; i++) {
            int min = INF, v = -1;
            for (int j = 1; j <= n; j++) {
                if (used[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    v = j;
                }
            }

            if (v < 0) break;

            for (int j = 1; j <= n; j++)
                if (used[j] == 0) relax(v, j);

            used[v] = 1;
        }

        System.out.println(dist[f]);
    }

    private static void relax(int i, int j) {
        if (dist[i] + g[i][j] < dist[j]) {
            dist[j] = dist[i] + g[i][j];
        }
    }
}
