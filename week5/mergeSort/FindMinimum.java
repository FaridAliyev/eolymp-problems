package solutions.week5.mergeSort;

import java.util.Scanner;

public class FindMinimum {
    private static final int[] arr = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(1, n));
    }

    public static int solve(int left, int right) {
        if (left == right) return arr[left];
        int middle = (left + right) / 2;
        int u = solve(left, middle);
        int v = solve(middle + 1, right);
        return Math.min(u, v);
    }
}
