package solutions.week11.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    private static final int[][] g = new int[101][101];
    private static final int[] dist = new int[101];
    private static int n, s, f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        f = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                g[i][j] = scanner.nextInt();

        bfs(s);
        if (dist[f] < 0) dist[f] = 0;
        System.out.println(dist[f]);
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
