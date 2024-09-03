package solutions.week7.greedy;

import java.util.Scanner;

public class AladdinsKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[s + 1];
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();
            for (int j = 0; j < s; j++) {
                if (j + w <= s && arr[j] + v > arr[j + w]) {
                    arr[j + w] = arr[j] + v;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
