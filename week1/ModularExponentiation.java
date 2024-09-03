package solutions.week1;

import java.util.Scanner;

public class ModularExponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(solve(x, n, m));
    }

    public static long solve(long x, long n, long m) {
        if (n == 0) return 1;
        if (n % 2 == 0) return solve((x * x) % m, n / 2, m);
        return (x * solve(x, n - 1, m)) % m;
    }
}
