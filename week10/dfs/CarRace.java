package solutions.week10.dfs;

import java.util.Scanner;

public class CarRace {
    private static final int[][] g = new int[1001][1001];
    private static final int[] used = new int[1001];
    private static int flag = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g[a][b] = g[b][a] = 1;
        }
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) dfs(i, n);

        System.out.println(flag == 1 ? "YES" : "NO");
    }

    private static void dfs(int v, int n) {
        dfs(v, -1, n);
    }

    private static void dfs(int v, int prev, int n) {
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if ((i != prev) && g[v][i] == 1)
                if (used[i] == 1) flag = 1;
                else dfs(i, v, n);
    }
}
