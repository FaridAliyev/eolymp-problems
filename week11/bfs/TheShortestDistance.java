package solutions.week11.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class TheShortestDistance {
    private static final int[][] g = new int[1001][1001];
    private static final int[] dist = new int[1001];
    private static int n, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                g[i][j] = scanner.nextInt();

        bfs(x);
        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    private static void bfs(int start) {
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int to = 1; to <= n; to++)
                if (g[v][to] == 1 && dist[to] == -1) {
                    q.add(to);
                    dist[to] = dist[v] + 1;
                }
        }
    }
}
