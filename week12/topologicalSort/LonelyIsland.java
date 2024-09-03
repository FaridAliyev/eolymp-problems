package solutions.week12.topologicalSort;

import java.util.*;

public class LonelyIsland {
    private static final double EPS = 1e-9;
    private static final List<List<Integer>> g = new ArrayList<>();
    private static final List<Integer> inDegree = new ArrayList<>();
    private static final List<Integer> outDegree = new ArrayList<>();
    private static final List<Double> prob = new ArrayList<>();
    private static final Deque<Integer> q = new ArrayDeque<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
            inDegree.add(0);
            outDegree.add(0);
            prob.add(0D);
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            outDegree.set(a, outDegree.get(a) + 1);
            inDegree.set(b, inDegree.get(b) + 1);
        }

        for (int i = 1; i < inDegree.size(); i++)
            if (inDegree.get(i) == 0) q.addLast(i);

        prob.set(r, 1D);
        while (!q.isEmpty()) {
            int v = q.removeFirst();
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i);
                prob.set(to, prob.get(to) + (prob.get(v) / outDegree.get(v)));
                inDegree.set(to, inDegree.get(to) - 1);
                if (inDegree.get(to) == 0) q.addLast(to);
            }
        }

        double max = 0;
        for (int i = 1; i <= n; i++)
            if (outDegree.get(i) == 0 && prob.get(i) > max) max = Math.max(max, prob.get(i));

        for (int i = 1; i <= n; i++)
            if (outDegree.get(i) == 0 && Math.abs(prob.get(i) - max) <= EPS)
                System.out.println(i + " ");
    }
}