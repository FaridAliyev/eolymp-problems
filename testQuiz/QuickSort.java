package solutions.testQuiz;

import java.util.Scanner;

public class QuickSort {
    private static final int[] arr = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNextInt()) {
            arr[i++] = scanner.nextInt();
        }
        quickSort(0, i - 1);
        printArray(i);
    }

    public static void quickSort(int L, int R) {
        if (L < R) {
            int q = partition(L, R);
            quickSort(L, q);
            quickSort(q + 1, R);
        }
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

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
