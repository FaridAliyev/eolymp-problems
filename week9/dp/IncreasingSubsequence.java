package solutions.week9.dp;

import java.util.Arrays;
import java.util.Scanner;

public class IncreasingSubsequence {
    private static int size;
    private static final int[] x = new int[100001];
    private static final int[] lis = new int[100001];
    private static final int[] L = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(lis, 0, len, x[i]);
            if (pos < 0) pos = -(pos + 1);
            lis[pos] = x[i];
            L[i] = pos;
            if (pos == len) len++;
        }
        System.out.println(len);
        size = len - 1;
        printSequence(n - 1);
    }

    private static void printSequence(int pos) {
        if (size < 0) return;
        while (L[pos] != size) pos--;
        size--;
        printSequence(pos - 1);
        System.out.print(x[pos] + " ");
    }
}
