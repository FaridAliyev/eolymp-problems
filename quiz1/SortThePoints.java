package solutions.quiz1;

import java.util.Scanner;

public class SortThePoints {
    private static final Point[] arr = new Point[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[i++] = new Point(x, y);
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
        Point x = arr[L];
        int i = L - 1, j = R + 1;
        while (true) {
            do j--; while (compare(arr[j], x));
            do i++; while (compare(x, arr[i]));
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static void swap(int index1, int index2) {
        Point temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static boolean compare(Point a, Point b) {
        if (a.x == b.x) return a.y < b.y;
        return a.x > b.x;
    }

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private record Point(int x, int y) {
        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }
    }
}
