package solutions.week11.bfs;

import java.util.*;

public class Arson {
    private static final List<List<Integer>> g = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();
    private static int[] dist;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        Arrays.fill(dist, -1);
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int id = scanner.nextInt();
            dist[id] = 0;
            q.add(id);
        }

        bfs();

        int max = -1, id = -1;
        for (int i = 1; i <= n; i++)
            if (dist[i] > max) {
                max = dist[i];
                id = i;
            }
        System.out.println(dist[id]);
        System.out.println(id);
    }

    private static void bfs()
    {
        while(!q.isEmpty())
        {
            int v = q.poll();
            for(int i = 0; i < g.get(v).size(); i++)
            {
                int to = g.get(v).get(i);
                if (dist[to] == -1)
                {
                    q.add(to);
                    dist[to] = dist[v] + 1;
                }
            }
        }
    }
}
