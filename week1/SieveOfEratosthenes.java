package solutions.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        printList(solve(a, b));
    }

    public static List<Integer> solve(int a, int b) {
        List<Integer> list = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;
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

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
