package solutions.week4.heap;

import java.util.Scanner;

public class IsItHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean isHeap = true;
        for (int i = 1; i < n / 2 + 1; i++) {
            if (2 * i <= n) {
                if (!(arr[i] <= arr[2 * i])) {
                    isHeap = false;
                    break;
                }
            }
            if (2 * i + 1 <= n) {
                if (!(arr[i] <= arr[2 * i + 1])) {
                    isHeap = false;
                    break;
                }
            }
        }
        System.out.println(isHeap ? "YES" : "NO");
    }
}
