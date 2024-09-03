package solutions.week10.dfs;

import java.util.Scanner;

public class IsThereACycle {
    private static final int[][] g = new int[51][51];
    private static final int[] used = new int[51];
    private static int flag = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                g[i][j] = scanner.nextInt();

        for (int i = 1; i <= n; i++)
            if (used[i] == 0) dfs(i, n);

        System.out.println(flag);
    }

    private static void dfs(int v, int n) {
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if (g[v][i] == 1) {
                if (used[i] == 1) flag = 1;
                else if (used[i] == 0) dfs(i, n);
            }
        used[v] = 2;
    }
}
