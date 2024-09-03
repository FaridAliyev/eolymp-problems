package solutions.week4.dsu;

import java.util.Scanner;

public class MailOfTheSponsor {
    private static final int[] arr = new int[100001];
    private static final int[] depth = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            depth[i] = 0;
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
            }
        }
        System.out.println(count - 1);
    }

    public static void union(int a, int b) {
        int r1 = representative(a);
        int r2 = representative(b);
        if (r1 == r2) return;
        if (depth[r1] > depth[r2]) {
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }

        arr[r1] = r2;
        if (depth[r2] == depth[r1]) depth[r2]++;
    }

    public static int representative(int v) {
        if (v == arr[v]) return v;
        return arr[v] = representative(arr[v]);
    }
}
