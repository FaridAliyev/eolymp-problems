package solutions.week8.dijkstra;

import java.util.*;

public class DistanceBetweenTheVerticesPq {
    private static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();
        List<List<Edge>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int b = scanner.nextInt();
            int e = scanner.nextInt();
            int w = scanner.nextInt();

            g.get(b).add(new Edge(e, w));
            g.get(e).add(new Edge(b, w));
        }

        dijkstra(g, n, s, f);
    }

    private static void dijkstra(List<List<Edge>> g, int n, int s, int f) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.dist));
        pq.add(new Edge(s, 0));

        List<Long> dist = new ArrayList<>(Collections.nCopies(n + 1, INF));

        dist.set(s, 0L);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.node;

            if (e.dist > dist.get(v)) {
                continue;
            }

            for (int j = 0; j < g.get(v).size(); j++) {
                Edge edge = g.get(v).get(j);
                int to = edge.node;
                long cost = edge.dist;
                if (dist.get(v) + cost < dist.get(to)) {
                    dist.set(to, dist.get(v) + cost);
                    pq.add(new Edge(to, dist.get(to)));
                }
            }
        }

        if (dist.get(f) == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dist.get(f));
        }
    }

    private record Edge(int node, long dist) {

    }
}
