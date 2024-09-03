package solutions.week6.binaryTernary;

import java.util.Arrays;
import java.util.Scanner;

public class CountTheTriplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int lowerBound = lowerBound(a, 0, n, b[i]);
            int upperBound = upperBound(c, 0, n, b[i]);
            sum = sum + ((long) lowerBound * (n - upperBound));
        }
        System.out.println(sum);
    }

    public static int lowerBound(long[] arr, int left, int right, long x) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (x <= arr[middle]) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    public static int upperBound(long[] arr, int left, int right, long x) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (x >= arr[middle]) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}
