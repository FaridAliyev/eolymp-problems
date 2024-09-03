package solutions.week9.dp;

import java.util.Scanner;

public class CuttingAStick {
    private static int[][] dp;
    private static int[] m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int l = scanner.nextInt();
            if (l == 0) break;
            int n = scanner.nextInt();
            m = new int[n + 2];
            dp = new int[n + 2][n + 2];
            m[0] = 0;
            m[n + 1] = l;
            for (int i = 1; i <= n; i++) {
                m[i] = scanner.nextInt();
            }
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.printf("The minimum cutting is %d.\n", f(0, n + 1));
        }
    }

    private static int f(int a, int b) {
        if (b - a == 1) return 0;
        if (dp[a][b] != Integer.MAX_VALUE) return dp[a][b];
        for (int i = a + 1; i < b; i++) {
            int temp = m[b] - m[a] + f(a, i) + f(i, b);
            if (temp < dp[a][b]) dp[a][b] = temp;
        }
        return dp[a][b];
    }
}
