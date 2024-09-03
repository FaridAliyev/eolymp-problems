package solutions.week11.bfs;

import java.util.*;

public class MaximumByMinimum {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static int[] dist;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            g.get(to).add(from);
        }
        bfs(s);
        int max = dist[1];
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        System.out.println(max);
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
