package solutions.week4.dsu;

import java.util.Scanner;

public class Connectivity {
    private static final int[] arr = new int[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            union(u, v);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == arr[i]) {
                count++;
                if (count > 1) {
                    break;
                }
            }
        }
        System.out.println(count == 1 ? "YES" : "NO");
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
