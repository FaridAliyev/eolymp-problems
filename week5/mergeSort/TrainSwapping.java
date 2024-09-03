package solutions.week5.mergeSort;

import java.util.Scanner;

public class TrainSwapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int[] a = new int[l];
            for (int j = 0; j < l; j++) {
                a[j] = scanner.nextInt();
            }
            int res = 0;
            for (int k = 0; k < l - 1; k++) {
                for (int j = k + 1; j < l; j++)
                    if (a[k] > a[j]) res++;
            }
            System.out.printf("Optimal train swapping takes %d swaps.\n", res);
        }
    }
}
