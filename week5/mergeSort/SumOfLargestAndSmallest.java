package solutions.week5.mergeSort;

import java.util.Scanner;

public class SumOfLargestAndSmallest {
    private static final int[] arr = new int[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMin(1, n) + findMax(1, n));
    }

    public static int findMin(int left, int right) {
        if (left == right) return arr[left];
        int middle = (left + right) / 2;
        int u = findMin(left, middle);
        int v = findMin(middle + 1, right);
        return Math.min(u, v);
    }

    public static int findMax(int left, int right) {
        if (left == right) return arr[left];
        int middle = (left + right) / 2;
        int u = findMax(left, middle);
        int v = findMax(middle + 1, right);
        return Math.max(u, v);
    }
}
