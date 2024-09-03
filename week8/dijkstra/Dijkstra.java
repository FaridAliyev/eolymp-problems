package solutions.week8.dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    private static final int INF = 2000000000;
    private static final int[][] g = new int[2001][2001];
    private static final int[] used = new int[2001];
    private static final int[] dist = new int[2001];


    public static void main(String[] args) {
        for (int[] ints : g) {
            Arrays.fill(ints, INF);
        }
        Arrays.fill(dist, INF);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scanner.nextInt();
            }
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
                if (used[j] == 0 && g[v][j] != -1) relax(v, j);

            used[v] = 1;
        }

        if (dist[f] == INF) System.out.println(-1);
        else System.out.println(dist[f]);
    }

    private static void relax(int i, int j) {
        if (dist[i] + g[i][j] < dist[j])
            dist[j] = dist[i] + g[i][j];
    }
}
