package solutions.week6.quickSort;

import java.util.Scanner;

public class FindAnElement {
    private static final int[] arr = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (k > n) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(kth(n - k + 1, 1, n));
    }

    public static int kth(int k, int left, int right) {
        if (left == right) return arr[left];
        int pos = partition(left, right);
        if (k <= pos) return kth(k, left, pos);
        else return kth(k, pos + 1, right);
    }

    public static int partition(int L, int R) {
        int x1 = arr[L], x2 = arr[R], x3 = arr[(L + R) / 2];
        int x = Math.min(Math.min(x1, x2), x3), i = L - 1, j = R + 1;
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
