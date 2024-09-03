package solutions.week1;

import java.util.Scanner;

public class Primes {
    private static final int[] primeCountAt = new int[10000001];

    public static void main(String[] args) {
        fillArray();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            solve(scanner.nextInt(), scanner.nextInt());
        }
    }

    public static void solve(int m, int n) {
        System.out.println(primeCountAt[n] - primeCountAt[m - 1]);
        System.out.println();
    }

    public static void fillArray() {
        primeCountAt[0] = primeCountAt[1] = 0;
        int count = 0;
        for (int i = 2; i < primeCountAt.length; i++) {
            if (isPrime(i)) {
                count++;
            }
            primeCountAt[i] = count;
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
