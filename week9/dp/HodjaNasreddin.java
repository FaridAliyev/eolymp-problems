package solutions.week9.dp;

import java.util.Scanner;

public class HodjaNasreddin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int mod = 9929;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = (a[i - 1][j] + a[i][j - 1]) % mod;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 || j == n - 1) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = (b[i + 1][j] + b[i][j + 1]) % mod;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                sum = (sum + (((long) a[i][j] * b[i][j]) % mod)) % mod;
            }
        }
        System.out.println(sum);
    }
}

