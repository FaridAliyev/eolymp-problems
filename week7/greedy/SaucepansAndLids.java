package solutions.week7.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class SaucepansAndLids {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] radiiS = new int[n];
        int[] radiiL = new int[m];
        for (int i = 0; i < n; i++) {
            radiiS[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            radiiL[i] = scanner.nextInt();
        }
        Arrays.sort(radiiS);
        Arrays.sort(radiiL);
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            while (start < m) {
                if (radiiL[start] >= radiiS[i]) {
                    start++;
                    count++;
                    break;
                }
                start++;
            }
        }
        System.out.println(count);
    }
}
