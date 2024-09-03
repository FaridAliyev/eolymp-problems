package solutions.week11.bfs;

import java.util.*;

public class LongestPathInATree {
    private static final List<List<Road>> m = new ArrayList<>();
    private static final Deque<Long> q = new ArrayDeque<>();
    private static List<Long> d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            m.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int b = scanner.nextInt();
            int e = scanner.nextInt();
            long dist = scanner.nextLong();
            m.get(b).add(new Road(e, dist));
            m.get(e).add(new Road(b, dist));
        }
        d = new ArrayList<>(Collections.nCopies(n + 1, 0L));
        for (int i = 0; i < n + 1; i++) d.set(i, (long) -1);
        d.set(1, 0L);
        int v = bfs(1);
        for (int i = 0; i < d.size(); i++) d.set(i, (long) -1);
        d.set(v, 0L);
        v = bfs(v);
        System.out.println(d.get(v));
    }

    private static int bfs(int v) {
        q.clear();
        q.add((long) v);
        while (!q.isEmpty()) {
            int first = Math.toIntExact(q.removeFirst());
            for (int i = 0; i < m.get(first).size(); i++) {
                int to = m.get(first).get(i).v;
                if (d.get(to) == -1) {
                    d.set(to, d.get(first) + m.get(first).get(i).dist);
                    q.add((long) to);
                }
            }
        }
        int n = d.size();
        int maxIndex = -1;
        long maxValue = Long.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (d.get(i) > maxValue) {
                maxValue = d.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private record Road(int v, long dist) {

    }
}
