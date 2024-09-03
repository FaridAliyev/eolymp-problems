package solutions.week7.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] profits = new int[n];
        Integer[] partialSums = new Integer[n];
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += profits[i];
            if (sum < 0) {
                partialSums[i] = 0;
                sum = 0;
            } else partialSums[i] = sum;
        }
        System.out.println(Collections.max(Arrays.asList(partialSums)));
    }
}
