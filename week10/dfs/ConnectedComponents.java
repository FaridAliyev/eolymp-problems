package solutions.week10.dfs;

import java.util.Scanner;

public class ConnectedComponents {
    private static final int[][] g = new int[101][101];
    private static final int[] used = new int[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scanner.nextInt();
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) {
                dfs(i, n);
                res++;
            }
        System.out.println(res);
    }

    private static void dfs(int v, int n) {
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if ((g[v][i] == 1) && (used[i] == 0)) dfs(i, n);
    }
}
