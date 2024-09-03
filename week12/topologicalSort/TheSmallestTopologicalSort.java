package solutions.week12.topologicalSort;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TheSmallestTopologicalSort {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static List<Integer> top;
    private static int[] inDegree;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
            if (inDegree[i] == 0) pq.add(i);

        top = new ArrayList<>();
        while (!pq.isEmpty()) {
            int v = pq.poll();
            top.add(v);
            for (int to : g.get(v)) {
                inDegree[to]--;
                if (inDegree[to] == 0) pq.add(to);
            }
        }

        if (top.size() < n)
            System.out.println("-1");
        else {
            for (int x : top) System.out.print(x + " ");
        }
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
        st = new StringTokenizer("");
    }

    public String next() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
