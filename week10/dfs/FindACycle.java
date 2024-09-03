package solutions.week10.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindACycle {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static final List<Integer> path = new ArrayList<>();
    private static  int[] used;
    private static int flag, n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        used = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
        }

        for (int i = 1; i <= n; i++)
            if (used[i] == 0) {
                dfs(i);
                if (flag == 1) break;
            }

        if (flag == 1) {
            int i = path.size() - 2;
            int to = path.get(path.size() - 1);

            while (path.get(i) != to) i--;
            System.out.println("YES");

            for (; i < path.size() - 1; i++)
                System.out.print(path.get(i) + " ");

        } else System.out.println("NO");
    }

    private static void dfs(int v) {
        if (flag == 1) return;
        used[v] = 1;
        path.add(v);
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            if (used[to] == 1) {
                path.add(to);
                flag = 1;
                return;
            } else dfs(to);
            if (flag == 1) return;
        }
        used[v] = 2;
        path.remove(path.size() - 1);
    }
}
