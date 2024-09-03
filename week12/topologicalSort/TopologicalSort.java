package solutions.week12.topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static final List<Integer> top = new ArrayList<>();
    private static int[] used;
    private static int flag = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        used = new int[n + 1];
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
        }

        for (int i = 1; i <= n; i++)
            if (used[i] == 0) dfs(i);

        if (flag == 1) System.out.println("-1");
        else
            for (int i = top.size() - 1; i >= 0; i--)
                System.out.print(top.get(i) + " ");
    }

    private static void dfs(int v) {
        used[v] = 1;
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            if (used[to] == 1) flag = 1;
            if (used[to] == 0) dfs(to);
        }
        used[v] = 2;
        top.add(v);
    }
}
