package solutions.week5.mergeSort;

import java.util.Scanner;

public class MergeThreeSequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] a2 = new int[m];
        for (int i = 0; i < m; i++) {
            a2[i] = scanner.nextInt();
        }
        int l = scanner.nextInt();
        int[] a3 = new int[l];
        for (int i = 0; i < l; i++) {
            a3[i] = scanner.nextInt();
        }
        int[] res = merge(merge(a1, a2), a3);
        for (int i :
                res) {
            System.out.print(i + " ");
        }
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int p = 0;
        int q = 0;
        int i;
        for (i = 0; p < a1.length && q < a2.length; i++) {
            res[i] = a1[p] < a2[q] ? a1[p++] : a2[q++];
        }
        while (p < a1.length) {
            res[i++] = a1[p++];
        }
        while (q < a2.length) {
            res[i++] = a2[q++];
        }
        return res;
    }
}
