package solutions.week11.bfs;

import java.util.*;

public class Beehives {
    private static List<List<Integer>> g = new ArrayList<>();
    private static int[] dist, prev;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 0; i < n; i++)
                if (i >= g.size()) g.add(new ArrayList<>());
                else g.set(i, new ArrayList<>());

            dist = new int[n];
            prev = new int[n];
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                g.get(u).add(v);
                g.get(v).add(u);
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.min(res, bfs(i));
                if (res == 3) break;
            }

            System.out.print("Case " + cs + ": ");
            if (res == Integer.MAX_VALUE) System.out.println("impossible");
            else System.out.println(res);
        }
    }

    private static int bfs(int start) {
        int res = Integer.MAX_VALUE;
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Arrays.fill(prev, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i);
                if (to == prev[v]) continue;
                if (dist[to] == -1) {
                    q.add(to);
                    prev[to] = v;
                    dist[to] = dist[v] + 1;
                } else {
                    res = Math.min(res, dist[to] + dist[v] + 1);
                    if (res == 3) return 3;
                }
            }
        }
        return res;
    }
}
