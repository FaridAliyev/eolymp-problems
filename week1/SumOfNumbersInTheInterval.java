package solutions.week1;

import java.util.Scanner;

public class SumOfNumbersInTheInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(solve(a, b));
    }

    public static long solve(long a, long b) {
        return (a + b) * (b - a + 1) / 2;
    }
}
