package solutions.week9.dp;

import java.util.Scanner;

public class LCS2 {
    private static final int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = " " + scanner.nextLine();
        int n = x.length() - 1;
        String y = " " + scanner.nextLine();
        int m = y.length() - 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (x.charAt(i) == y.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        int i = n, j = m;
        StringBuilder res = new StringBuilder();
        while (i >= 1 && j >= 1)
            if (x.charAt(i) == y.charAt(j)) {
                res.append(x.charAt(i));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        System.out.println(res.reverse());
    }
}
