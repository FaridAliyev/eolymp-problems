package solutions.week6.binaryTernary;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            System.out.println(binarySearch(arr, 0, n - 1, scanner.nextInt()) ? "YES" : "NO");
        }
    }

    public static boolean binarySearch(int[] arr, int left, int right, int x) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (x > arr[middle]) left = middle + 1;
            else right = middle;
        }
        return arr[left] == x;
    }
}
