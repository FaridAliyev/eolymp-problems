package solutions.week9.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = scanner.nextInt();

        int[] lis = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(lis, 0, len, x[i]);
            if (pos < 0) pos = -(pos + 1);
            lis[pos] = x[i];
            if (pos == len) len++;
        }
        System.out.println(len);
    }
}
