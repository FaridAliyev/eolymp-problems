package solutions.week6.binaryTernary;

import java.util.Scanner;

public class NthIntegerDivisibleByAOrB {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int a = scanner.nextInt();
    private static final int b = scanner.nextInt();
    private static final int n = scanner.nextInt();

    public static void main(String[] args) {
        int res = binarySearch(1, 1000000000);
        System.out.println(res);
    }

    public static int binarySearch(int left, int right) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (f(middle) >= n) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    public static int f(int n) {
        return (int) ((n / a) + (n / b) - (n / lcm(a, b)));
    }

    public static long lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static long gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) return gcd(a % b, b);
        return gcd(a, b % a);
    }
}
