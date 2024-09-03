package solutions.week9.dp;

import java.util.Scanner;

public class Frog {
    private static final int[] dp = new int[100001];
    private static final int[] height = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            height[i] = scanner.nextInt();
        }
        dp[1] = 0;
        dp[2] = Math.abs(height[1] - height[2]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + (Math.abs(height[i] - height[i - 1])), dp[i - 2] + (Math.abs(height[i] - height[i - 2])));
        }
        System.out.println(dp[n]);
    }
}
