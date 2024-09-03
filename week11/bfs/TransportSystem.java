package solutions.week11.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class TransportSystem {
    private static int[][] g;
    private static int[] distS, distF;
    static int n, m, s, f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        f = scanner.nextInt();
        g = new int[n + 1][n + 1];
        distS = new int[n + 1];
        distF = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g[a][b] = g[b][a] = 1;
        }
        bfs(s, distS);
        bfs(f, distF);
        int optDistance = distS[f];
        int res = 0;
        for (int i = 1; i <= n; i++)
            for (int j = i + 1; j <= n; j++)
                if (g[i][j] == 0) {
                    if ((distS[i] + distF[j] + 1 >= optDistance) &&
                            (distS[j] + distF[i] + 1 >= optDistance))
                        res++;

                }

        System.out.println(res);
    }

    static void bfs(int start, int[] dist) {
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
