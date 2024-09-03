package solutions.week5.mergeSort;

import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        split(a, 1, n);
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void merge(int[] a, int bleft, int bright, int cleft, int cright) {
        int i, left = bleft, len = cright - bleft + 1;
        int[] res = new int[len];
        for (i = 0; i < len; i++) {
            if ((bleft > bright) || (cleft > cright)) break;
            if (a[bleft] <= a[cleft]) res[i] = a[bleft++];
            else res[i] = a[cleft++];
        }
        while (bleft <= bright) res[i++] = a[bleft++];
        while (cleft <= cright) res[i++] = a[cleft++];
        for (i = left; i < left + len; i++) a[i] = res[i - left];
    }


    public static void split(int[] a, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            split(a, l, middle);
            split(a, middle + 1, r);
            merge(a, l, middle, middle + 1, r);
        }
    }
}
