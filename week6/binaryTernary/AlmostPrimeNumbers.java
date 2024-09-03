package solutions.week6.binaryTernary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlmostPrimeNumbers {
    private static final int[] prime = new int[1000000];
    private static final List<Long> almostPrime = new ArrayList<>();
    public static final long almostMax = 1000000000000L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fillPrimes();
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 1) {
                long currentPower = i;
                while (currentPower * i <= almostMax) {
                    almostPrime.add(currentPower * i);
                    currentPower *= i;
                }
            }
        }
        Collections.sort(almostPrime);
        for (int i = 0; i < n; i++) {
            long low = scanner.nextLong();
            long high = scanner.nextLong();
            System.out.println(upperBound(0, almostPrime.size(), high) - upperBound(0, almostPrime.size(), low - 1));
        }
    }

    public static long upperBound(long left, long right, long x) {
        while (left < right) {
            int middle = (int) ((left + right) / 2);
            if (x >= almostPrime.get(middle)) left = middle + 1;
            else right = middle;
        }
        return left;
    }

    public static void fillPrimes() {
        prime[0] = prime[1] = 0;
        for (int i = 2; i < prime.length; i++) {
            if (isPrime(i)) {
                prime[i] = 1;
            }
        }
    }

    public static boolean isPrime(int num) {
        boolean prime = true;
        int sqrt = (int) Math.floor(Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
