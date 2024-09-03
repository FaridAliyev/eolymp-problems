package solutions.week4.heap;

import java.util.Scanner;

public class MaxHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = n / 2; i > 0; i--)
            heapify(arr, i, n);

        for(int i = 1; i <=n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void heapify(int[] a, int i, int n) {
        int largest = 0;
        int l = left(i);
        int r = right(i);

        if (l <= n && a[l] > a[i]) largest = l;
        else largest = i;
        if (r <= n && a[r] > a[largest]) largest = r;

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }
    }

}
