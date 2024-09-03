package solutions.week9.dp;

import java.util.Scanner;

public class MaximumSumBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int maxPrev = Integer.MIN_VALUE;
                maxPrev = Math.max(maxPrev, dp[i - 1][j]);
                if (j > 0) {
                    maxPrev = Math.max(maxPrev, dp[i - 1][j - 1]);
                }
                if (j < m - 1) {
                    maxPrev = Math.max(maxPrev, dp[i - 1][j + 1]);
                }
                dp[i][j] += maxPrev;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int j = 0; j < m; ++j) {
            res = Math.max(res, dp[n - 1][j]);
        }
        System.out.println(res);
    }
}
