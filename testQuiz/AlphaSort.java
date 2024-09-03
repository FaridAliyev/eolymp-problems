package solutions.testQuiz;

import java.util.Scanner;

public class AlphaSort {
    private static final String[] arr = new String[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            arr[i++] = scanner.next();
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
        String x = arr[L];
        int i = L - 1, j = R + 1;
        while (true) {
            do j--; while (compare(arr[j], x));
            do i++; while (compare(x, arr[i]));
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static boolean compare(String a, String b) {
        int i;
        for (i = 0; i < a.length() && i < b.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                return c1 > c2;
            }
            return Character.toLowerCase(c1) > Character.toLowerCase(c2);
        }
        return i != a.length();
    }

    public static void swap(int index1, int index2) {
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
