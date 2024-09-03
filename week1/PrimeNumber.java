package solutions.week1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(solve(num));
    }

    public static String solve(int num) {
        if (num == 1) {
            return "No";
        }
        String result = "Yes";
        int sqrt = (int) Math.floor(Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                result = "No";
                break;
            }
        }
        return result;
    }
}
