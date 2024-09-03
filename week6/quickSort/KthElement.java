package solutions.week6.quickSort;

import java.util.Scanner;

public class KthElement {
    private static final int[] arr = new int[2001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(kth(k, 1, n));
    }

    public static int kth(int k, int left, int right) {
        if (left == right) return arr[left];
        int pos = partition(left, right);
        if (k <= pos) return kth(k, left, pos);
        else return kth(k, pos + 1, right);
    }

    public static int partition(int L, int R) {
        int x = arr[L], i = L - 1, j = R + 1;
        while (true) {
            do j--; while (arr[j] > x);
            do i++; while (arr[i] < x);
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
