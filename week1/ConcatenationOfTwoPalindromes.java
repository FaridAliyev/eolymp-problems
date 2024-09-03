package solutions.week1;

import java.util.Scanner;

public class ConcatenationOfTwoPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, k));
    }

    public static long solve(int n, int k) {
        long modulo = (long) Math.pow(10, 9) + 7;
        long sum = 0;
        for (int i = 1; i <= n - 1; i++) {
            sum += (modExpo(k, (i + 1) / 2, modulo) * modExpo(k, (n - i + 1) / 2, modulo)) % modulo;
        }
        return sum % modulo;
    }

    public static long modExpo(long x, long n, long m) {
        if (n == 0) return 1;
        if (n % 2 == 0) return modExpo((x * x) % m, n / 2, m);
        return (x * modExpo(x, n - 1, m)) % m;
    }
}
