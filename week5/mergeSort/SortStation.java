package solutions.week5.mergeSort;

import java.util.Scanner;

public class SortStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        int[] m = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; ++i) {
            m[i] = scanner.nextInt();
            if (i == 0) {
                max[i] = m[i];
            } else {
                if (max[i - 1] > m[i]) {
                    max[i] = max[i - 1];
                } else {
                    max[i] = m[i];
                }
            }
        }
        boolean possible = true;
        for (int i = n - 1; i > 0; i--) {
            if (m[i] < max[i] && (m[i] + max[i] > maxWeight)) {
                possible = false;
                break;
            }
        }
        System.out.println(possible ? "Yes" : "No");
    }
}
