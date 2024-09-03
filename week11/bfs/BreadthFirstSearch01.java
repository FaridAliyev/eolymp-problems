package solutions.week11.bfs;

import java.util.*;

public class BreadthFirstSearch01 {
    private static final List<List<Pair>> g = new ArrayList<>();
    private static List<Integer> dist;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            g.get(a).add(new Pair(b, w));
            g.get(b).add(new Pair(a, w));
        }
        bfs(s);
        System.out.println(dist.get(d));
    }

    private static void bfs(int start) {
        dist = new ArrayList<>(Collections.nCopies(n + 1, Integer.MAX_VALUE));
        dist.set(start, 0);
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);

        while (!q.isEmpty()) {
            int v = q.removeFirst();
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i).first;
                int w = g.get(v).get(i).second;
                if (dist.get(to) > dist.get(v) + w) {
                    dist.set(to, dist.get(v) + w);
                    if (w == 1)
                        q.addLast(to);
                    else
                        q.addFirst(to);
                }
            }
        }
    }

    private record Pair(int first, int second) {

    }
}
