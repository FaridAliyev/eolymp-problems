package solutions.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    private static final Map<Integer, Integer> fibonacci = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    public static Integer solve(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (fibonacci.getOrDefault(n, -1) != -1) {
            return fibonacci.get(n);
        }
        Integer num = solve(n - 1) + solve(n - 2);
        fibonacci.put(n, num);
        return num;
    }
}
