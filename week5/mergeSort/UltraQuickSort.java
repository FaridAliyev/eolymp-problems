package solutions.week5.mergeSort;

import java.util.Scanner;

public class UltraQuickSort {
    private static long inversions = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;
            inversions = 0;
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            split(a, 0, n - 1);
            System.out.println(inversions);
        }
    }

    public static void merge(long[] a, int bleft, int bright, int cleft, int cright) {
        int i, left = bleft, len = cright - bleft + 1;
        long[] res = new long[len];
        for (i = 0; i < len; i++) {
            if ((bleft > bright) || (cleft > cright)) break;
            if (a[bleft] <= a[cleft]) res[i] = a[bleft++];
            else {
                res[i] = a[cleft++];
                inversions += (bright - bleft + 1);
            }
        }
        while (bleft <= bright) res[i++] = a[bleft++];
        while (cleft <= cright) res[i++] = a[cleft++];
        for (i = left; i < left + len; i++) a[i] = res[i - left];
    }

    public static void split(long[] a, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            split(a, l, middle);
            split(a, middle + 1, r);
            merge(a, l, middle, middle + 1, r);
        }
    }
}
