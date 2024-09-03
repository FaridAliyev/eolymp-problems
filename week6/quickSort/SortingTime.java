package solutions.week6.quickSort;

import java.util.Scanner;

public class SortingTime {
    private static final Time[] arr = new Time[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int hours = scanner.nextInt();
            int minutes = scanner.nextInt();
            int seconds = scanner.nextInt();
            arr[i] = new Time(hours, minutes, seconds);
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
        Time x = arr[L];
        int i = L - 1, j = R + 1;
        while (true) {
            do j--; while (compare(arr[j], x));
            do i++; while (compare(x, arr[i]));
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static void swap(int index1, int index2) {
        Time temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static boolean compare(Time a, Time b) {
        if ((a.hours == b.hours) && (a.minutes == b.minutes)) return a.seconds > b.seconds;
        if (a.hours == b.hours) return a.minutes > b.minutes;
        return a.hours > b.hours;
    }

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private record Time(int hours, int minutes, int seconds) {
        @Override
        public String toString() {
            return String.format("%d %d %d", hours, minutes, seconds);
        }
    }
}
