package solutions.week1;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solve(nums));
    }

    public static int solve(int[] nums) {
        int gcd = gcd(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }
        return gcd;
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) return gcd(a % b, b);
        return gcd(a, b % a);
    }
}
