package solutions.week7.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int min = Math.min(w, n);
        int sum = 0;
        for (int i = n - 1; i > n - 1 - min; i--) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
