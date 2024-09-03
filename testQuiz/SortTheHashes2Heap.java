package solutions.testQuiz;

import java.util.Scanner;

public class SortTheHashes2Heap {
    private static final String[] arr = new String[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (scanner.hasNext()) {
            arr[i++] = scanner.next();
        }
        heapSort(arr, i - 1);
        printArray(i);
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void heapify(String a[], int i, int n) {
        int largest = 0;
        int l = left(i);
        int r = right(i);

        if (l <= n && compare(a[l], a[i])) largest = l;
        else largest = i;
        if (r <= n && compare(a[r], a[largest])) largest = r;

        if (largest != i) {
            String temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }
    }

    public static void buildHeap(String[] a, int n) {
        for (int i = n / 2; i > 0; i--)
            heapify(a, i, n);
    }

    public static void heapSort(String[] a, int n) {
        buildHeap(a, n);
        for (int i = n; i >= 2; i--) {
            String temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            heapify(a, 1, i - 1);
        }
    }

    public static boolean compare(String a, String b) {
        int hash1 = calculateHash(a);
        int hash2 = calculateHash(b);
        if (hash1 == hash2) return a.compareTo(b) > 0;
        return hash1 > hash2;
    }

    public static int calculateHash(String s) {
        if (s.equals("ADAUniversity")) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += c;
        }
        return sum;
    }

    public static void swap(int index1, int index2) {
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
