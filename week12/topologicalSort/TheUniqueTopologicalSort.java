package solutions.week12.topologicalSort;

import java.util.*;

public class TheUniqueTopologicalSort {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static final List<Integer> inDegree = new ArrayList<>();
    private static final Set<Integer> minHeap = new HashSet<>();
    private static int flag = 1;

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

        while (!minHeap.isEmpty()) {
            if (minHeap.size() > 1) {
                flag = 0;
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
        System.out.println(flag == 1 ? "YES" : "NO");
    }
}
