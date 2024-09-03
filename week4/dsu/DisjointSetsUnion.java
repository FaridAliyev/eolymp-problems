package solutions.week4.dsu;

import java.util.Scanner;

public class DisjointSetsUnion {
    private static final int[] arr = new int[300001];
    private static final int[] depth = new int[300001];
    private static final int[] min = new int[300001];
    private static final int[] max = new int[300001];
    private static final int[] length = new int[300001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            depth[i] = 0;
            min[i] = i;
            max[i] = i;
            length[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            String command = scanner.next();
            switch (command) {
                case "union" -> {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    union(u, v);
                }
                case "get" -> {
                    int v = scanner.nextInt();
                    int r = representative(v);
                    System.out.printf("%d %d %d\n", min[r], max[r], length[r]);
                }
            }
        }
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
        if (min[r1] < min[r2]) {
            min[r2] = min[r1];
        }
        if (max[r1] > max[r2]) {
            max[r2] = max[r1];
        }
        length[r2] += length[r1];
    }

    public static int representative(int v) {
        if (v == arr[v]) return v;
        return arr[v] = representative(arr[v]);
    }
}
