package solutions.testQuiz;

import java.util.Scanner;

public class SortTheHashes2 {
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
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
