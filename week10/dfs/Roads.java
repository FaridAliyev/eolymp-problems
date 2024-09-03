package solutions.week10.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Roads {
    private static final List<List<Integer>> g = new ArrayList<>();
    private static final List<Integer> used = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
            used.add(0);
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }
        int res = 0;
        for (int i = 1; i <= n; i++)
            if (used.get(i) == 0) {
                dfs(i);
                res++;
            }
        System.out.println(res - 1);
    }

    private static void dfs(int v) {
        used.set(v, 1);
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            if ((used.get(to) == 0)) dfs(to);
        }
    }
}
