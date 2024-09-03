package solutions.week9.dp;

import java.util.Scanner;

public class CutAString {
    private static String s;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(f(0, n - 1));
    }

    private static int f(int l, int r) {
        if (l > r) return 0;
        if (l == r) return 1;
        if (dp[l][r] != Integer.MAX_VALUE) return dp[l][r];
        int res = dp[l][r];
        if (s.charAt(l) == s.charAt(r)) {
            res = Math.min(res, f(l + 1, r - 1));
        }
        for (int i = l; i < r; i++) {
            res = Math.min(res, f(l, i) + f(i + 1, r));
        }
        return dp[l][r] = res;
    }
}
