package solutions.week9.dp;

import java.util.Scanner;

public class ThreeSequences {
    private static final int[] a = new int[110];
    private static final int[] b = new int[110];
    private static final int[] c = new int[110];
    private static final int[][][] dp = new int[110][110][110];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        for (int i = 1; i <= m; i++) {
            b[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        for (int i = 1; i <= k; i++) {
            c[i] = scanner.nextInt();
        }

        for (int u = 1; u <= n; u++)
            for (int v = 1; v <= m; v++)
                for (int w = 1; w <= k; w++) {
                    if ((a[u] == b[v]) && (a[u] == c[w]))
                        dp[u][v][w] = dp[u - 1][v - 1][w - 1] + 1;
                    else
                        dp[u][v][w] = Math.max(dp[u - 1][v][w], Math.max(dp[u][v - 1][w], dp[u][v][w - 1]));
                }
        System.out.println(dp[n][m][k]);
    }
}
