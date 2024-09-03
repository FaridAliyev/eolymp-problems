package solutions.week6.quickSort;

import java.util.Scanner;

public class KthMinimum {
    private static final long[] arr = new long[50001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        fillArray(n);
        System.out.println(kth(k, 1, n));
    }

    public static long kth(int k, int left, int right) {
        if (left == right) return arr[left];
        int pos = partition(left, right);
        if (k <= pos) return kth(k, left, pos);
        else return kth(k, pos + 1, right);
    }

    public static int partition(int L, int R) {
        long x = arr[L];
        int i = L - 1, j = R + 1;
        while (true) {
            do j--; while (arr[j] > x);
            do i++; while (arr[i] < x);
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static void swap(int index1, int index2) {
        long temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void fillArray(int n) {
        long mod = 1743;
        for (int i = 1; i <= n; i++) {
            arr[i] = ((132 * modExpo(i, 3, mod)) % mod + (77 * modExpo(i, 2, mod)) % mod + (1345L * i) % mod + 1577) % mod;
        }
    }

    public static long modExpo(long x, long n, long m) {
        if (n == 0) return 1;
        if (n % 2 == 0) return modExpo((x * x) % m, n / 2, m);
        return (x * modExpo(x, n - 1, m)) % m;
    }
}
