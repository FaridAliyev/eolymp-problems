package solutions.week1;

import java.util.*;

public class AllDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        ArrayList<Long> divisors = solve(n);
        Collections.sort(divisors);
        printList(divisors);
    }

    public static ArrayList<Long> solve(long n) {
        Set<Long> set = new HashSet<>();
        int sqrt = (int) Math.floor(Math.sqrt(n));
        for (long i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        return new ArrayList<>(set);
    }

    public static void printList(ArrayList<Long> list) {
        for (Long i : list) {
            System.out.print(i + " ");
        }
    }
}
