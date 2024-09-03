package solutions.week6.binaryTernary;

import java.util.Scanner;

public class MinimumIncrements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int left = arr[0];
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (checkSuitable(arr, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = left++;
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (d[i] - arr[i]);
        }
        System.out.println(count);
    }

    public static boolean checkSuitable(int[] arr, int candidate) {
        boolean suitable = true;
        for (int i = 0; i < arr.length; i++) {
            if (candidate < arr[i]) {
                suitable = false;
                break;
            }
            candidate++;
        }
        return suitable;
    }
}
