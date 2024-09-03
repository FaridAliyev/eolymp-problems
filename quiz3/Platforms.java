package solutions.quiz3;

import java.util.*;

public class Platforms {
    private static final int[] dp = new int[100001];
    private static final int[] height = new int[100001];
    private static final int[] steps = new int[100001];
    private static final int[] p = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            height[i] = scanner.nextInt();
        }
        dp[1] = 0;
        dp[2] = Math.abs(height[1] - height[2]);
        steps[1] = 1;
        steps[2] = 2;
        p[1] = -1;
        p[2] = 1;
        for (int i = 3; i <= n; i++) {
            int cost1 = dp[i - 1] + (Math.abs(height[i] - height[i - 1]));
            int cost2 = dp[i - 2] + ((Math.abs(height[i] - height[i - 2])) * 3);
            int min = Math.min(cost1, cost2);
            if (min == cost1) {
                steps[i] = steps[i - 1] + 1;
                p[i] = i - 1;
            } else {
                steps[i] = steps[i - 2] + 1;
                p[i] = i - 2;
            }
            dp[i] = min;
        }
        System.out.println(dp[n]);
        System.out.println(steps[n]);
        List<Integer> list = new ArrayList<>();
        int i = n;
        list.add(n);
        while (i != -1) {
            if (p[i] != -1) list.add(p[i]);
            i = p[i];
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.print(list.get(j) + " ");
        }
    }
}