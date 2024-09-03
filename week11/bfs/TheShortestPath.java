package solutions.week11.bfs;

import java.util.*;

public class TheShortestPath {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static int[] dist, parent;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        dist = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        bfs(a);

        if (parent[b] == -1)
            System.out.println(-1);
        else {
            System.out.println(dist[b]);
            List<Integer> path = new ArrayList<>();
            path.add(b);

            while (parent[b] != -1) {
                b = parent[b];
                path.add(b);
            }

            for (int i = path.size() - 1; i >= 0; i--)
                System.out.print(path.get(i) + " ");
        }
    }

    private static void bfs(int start) {
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Arrays.fill(parent, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i);
                if (dist[to] == -1) {
                    q.add(to);
                    dist[to] = dist[v] + 1;
                    parent[to] = v;
                }
            }
        }
    }
}
