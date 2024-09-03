package solutions.week6.binaryTernary;

import java.util.Scanner;

public class TernarySearchInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            System.out.println(ternarySearch(arr, 0, n - 1, scanner.nextInt()) ? "YES" : "NO");
        }
    }

    public static boolean ternarySearch(int[] arr, int left, int right, int x) {
        int g, h;
        while (left < right) {
            g = left + (right - left) / 3;
            h = left + 2 * (right - left) / 3;
            if (arr[g] == x) return true;
            if (arr[h] == x) return true;
            if (x > arr[h]) left = h + 1;
            else if (x < arr[g]) right = g - 1;
            else {
                left = g + 1;
                right = h - 1;
            }
        }
        return arr[left] == x;
    }
}
