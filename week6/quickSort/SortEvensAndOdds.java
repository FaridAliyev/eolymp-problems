package solutions.week6.quickSort;

import java.util.Scanner;

public class SortEvensAndOdds {
    private static final int[] arr = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(0, n - 1);
        printArray(n);
    }

    public static void quickSort(int L, int R) {
        if (L < R) {
            int q = partition(L, R);
            quickSort(L, q);
            quickSort(q + 1, R);
        }
    }

    public static int partition(int L, int R) {
        int x = arr[L], i = L - 1, j = R + 1;
        while (true) {
            do j--; while (compare(arr[j], x));
            do i++; while (compare(x, arr[i]));
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static boolean compare(int a, int b) {
        if (Math.abs(a % 2) != Math.abs(b % 2)) return Math.abs(a % 2) < Math.abs(b % 2);
        if (a % 2 == 0) return a < b;
        return a > b;
    }

    public static void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
