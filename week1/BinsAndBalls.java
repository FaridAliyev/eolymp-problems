package solutions.week1;

import java.util.Scanner;

public class BinsAndBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(solve(n));
    }

    public static long solve(long n) {
        long modulo = (long) Math.pow(10, 9) + 7;
        return (n  * modExpo(n - 1, n - 1, modulo)) % modulo;
    }

    public static long modExpo(long x, long n, long m) {
        if (n == 0) return 1;
        if (n % 2 == 0) return modExpo((x * x) % m, n / 2, m);
        return (x * modExpo(x, n - 1, m)) % m;
    }
}
