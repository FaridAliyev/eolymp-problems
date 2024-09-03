package solutions.week4.heap;

import java.util.Scanner;

public class SortingTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Time[] arr = new Time[n + 1];
        for (int i = 1; i <= n; i++) {
            int hours = scanner.nextInt();
            int minutes = scanner.nextInt();
            int seconds = scanner.nextInt();
            arr[i] = new Time(hours, minutes, seconds);
        }
        heapSort(arr, n);
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static boolean compare(Time a, Time b) {
        if ((a.hours == b.hours) && (a.minutes == b.minutes)) return a.seconds > b.seconds;
        if (a.hours == b.hours) return a.minutes > b.minutes;
        return a.hours > b.hours;
    }

    public static void heapify(Time[] a, int i, int n) {
        int largest = 0;
        int l = left(i);
        int r = right(i);

        if (l <= n && compare(a[l], a[i])) largest = l;
        else largest = i;
        if (r <= n && compare(a[r], a[largest])) largest = r;

        if (largest != i) {
            Time temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }
    }

    public static void buildHeap(Time[] a, int n) {
        for (int i = n / 2; i > 0; i--)
            heapify(a, i, n);
    }

    public static void heapSort(Time[] a, int n) {
        buildHeap(a, n);
        for (int i = n; i >= 2; i--) {
            Time temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            heapify(a, 1, i - 1);
        }
    }

    private record Time(int hours, int minutes, int seconds) {
        @Override
        public String toString() {
            return String.format("%d %d %d", hours, minutes, seconds);
        }
    }
}
