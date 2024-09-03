package solutions.week10.dfs;

import java.util.*;

public class Dwarves {
    private final static List<List<Integer>> g = new ArrayList<>();
    private static final Map<String, Integer> map = new HashMap<>();
    private static int[] used;
    private static int n, flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stat = scanner.nextInt();

        for (int i = 0; i < 10001; i++) {
            g.add(new ArrayList<>());
        }

        n = 0;
        for (int i = 0; i < stat; i++) {
            String s1 = scanner.next();
            char ch = scanner.next().charAt(0);
            String s2 = scanner.next();

            if (!map.containsKey(s1)) map.put(s1, ++n);
            if (!map.containsKey(s2)) map.put(s2, ++n);

            Integer from = map.get(s1), to = map.get(s2);
            if (ch == '<')
                g.get(from).add(to);
            else
                g.get(to).add(from);
        }

        used = new int[n + 1];
        flag = 0;

        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) dfs(i);
            if (flag == 1) break;
        }
        System.out.println(flag == 1 ? "impossible" : "possible");
    }

    private static void dfs(int v) {
        if (flag == 1) return;
        used[v] = 1;
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            if (used[to] == 1) {
                flag = 1;
                return;
            }
            if (used[to] == 0) dfs(to);
        }
        used[v] = 2;
    }
}
