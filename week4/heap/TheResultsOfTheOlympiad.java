package solutions.week4.heap;

import java.util.Scanner;

public class TheResultsOfTheOlympiad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Member[] arr = new Member[n + 1];
        for (int i = 1; i <= n; i++) {
            int score = scanner.nextInt();
            arr[i] = new Member(i, score);
        }
        heapSort(arr, n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static boolean compare(Member a, Member b) {
        if (a.score == b.score) return a.id > b.id;
        return a.score < b.score;
    }

    public static void heapify(Member a[], int i, int n) {
        int largest = 0;
        int l = left(i);
        int r = right(i);

        if (l <= n && compare(a[l], a[i])) largest = l;
        else largest = i;
        if (r <= n && compare(a[r], a[largest])) largest = r;

        if (largest != i) {
            Member temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }
    }

    public static void buildHeap(Member[] a, int n) {
        for (int i = n / 2; i > 0; i--)
            heapify(a, i, n);
    }

    public static void heapSort(Member[] a, int n) {
        buildHeap(a, n);
        for (int i = n; i >= 2; i--) {
            Member temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            heapify(a, 1, i - 1);
        }
    }

    private record Member(int id, int score) {
        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}
