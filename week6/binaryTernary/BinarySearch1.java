package solutions.week6.binaryTernary;

import java.util.Scanner;

public class BinarySearch1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            System.out.println(upperBound(arr, 0, n, x) - lowerBound(arr, 0, n, x));
        }
    }

    public static int lowerBound(int[] arr, int left, int right, int x) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (x <= arr[middle]) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    public static int upperBound(int[] arr, int left, int right, int x) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (x >= arr[middle]) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}
