package solutions.testQuiz;

import java.util.Scanner;

public class SortTheHashes {
    private static final String[] arr = new String[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            arr[i++] = scanner.next();
        }
        split(arr, 0, i - 1);
        printArray(i);
    }


    public static void merge(String[] a, int bleft, int bright, int cleft, int cright) {
        int i, left = bleft, len = cright - bleft + 1;
        String[] res = new String[len];
        for (i = 0; i < len; i++) {
            if ((bleft > bright) || (cleft > cright)) break;
            if (!compare(a[bleft], a[cleft])) res[i] = a[bleft++];
            else res[i] = a[cleft++];
        }
        while (bleft <= bright) res[i++] = a[bleft++];
        while (cleft <= cright) res[i++] = a[cleft++];
        for (i = left; i < left + len; i++) a[i] = res[i - left];
    }

    public static void split(String[] a, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            split(a, l, middle);
            split(a, middle + 1, r);
            merge(a, l, middle, middle + 1, r);
        }
    }

    public static boolean compare(String a, String b) {
        int hash1 = calculateHash(a);
        int hash2 = calculateHash(b);
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

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
