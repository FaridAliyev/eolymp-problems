package solutions.week12.topologicalSort;

import java.util.*;

public class Avengers {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static final List<Integer> inDegree = new ArrayList<>();
    private static final Set<Integer> minHeap = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
            inDegree.add(0);
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            inDegree.set(b, inDegree.get(b) + 1);
        }

        for (int i = 1; i < inDegree.size(); i++)
            if (inDegree.get(i) == 0) minHeap.add(i);

        int x = -1, y = -1;

        while (!minHeap.isEmpty()) {
            if (minHeap.size() > 1) {
                x = minHeap.stream().findFirst().get();
                y = minHeap.stream().skip(1).findFirst().get();
                break;
            }
            int v = minHeap.stream().findFirst().get();
            minHeap.remove(v);
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i);
                inDegree.set(to, inDegree.get(to) - 1);
                if (inDegree.get(to) == 0) minHeap.add(to);
            }
        }

        if (x == -1)
            System.out.println(-1);
        else {
            int z = 1;
            while (z == x || z == y) z++;
            System.out.printf("%d %d %d\n", x, y, z);
        }
    }
}
