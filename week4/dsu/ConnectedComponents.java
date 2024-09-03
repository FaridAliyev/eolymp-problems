package solutions.week4.dsu;

import java.util.Scanner;

public class ConnectedComponents {
    private static final int[] arr = new int[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int v = scanner.nextInt();
                if (i < j && v == 1) union(i, j);
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == arr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void union(int a, int b) {
        int r1 = representative(a);
        int r2 = representative(b);
        if (r1 == r2) return;
        arr[r1] = r2;
    }

    public static int representative(int v) {
        while (v != arr[v]) v = arr[v];
        return v;
    }
}
