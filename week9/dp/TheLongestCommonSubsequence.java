package solutions.week9.dp;

import java.util.Scanner;

public class TheLongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n + 1];

        for (int i = 1; i <= n; i++)
            x[i] = scanner.nextInt();

        int m = scanner.nextInt();
        int[] y = new int[m + 1];

        for (int i = 1; i <= m; i++)
            y[i] = scanner.nextInt();

        int[][] dp = new int[2][m + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (x[i] == y[j])
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                else
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);

        System.out.println(dp[n % 2][m]);
    }
}
