package solutions.week11.bfs;

import java.util.*;

public class ShortestEvenPath {
    private static List<List<Integer>> g = new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();
        for (int i = 0; i < 2 * n + 1; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.get(2 * u).add(2 * v - 1);
            g.get(2 * v - 1).add(2 * u);
            g.get(2 * v).add(2 * u - 1);
            g.get(2 * u - 1).add(2 * v);
        }
        n = 2 * n;
        dist = new int[n + 1];
        bfs(2 * s - 1);
        System.out.println(dist[2 * d - 1]);
    }

    private static void bfs(int start) {
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i);
                if (dist[to] == -1) {
                    q.add(to);
                    dist[to] = dist[v] + 1;
                }
            }
        }
    }
}
