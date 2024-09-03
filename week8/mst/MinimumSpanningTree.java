package solutions.week8.mst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumSpanningTree {
    private static final int MAXV = 20001;
    private static final int MAXE = 100001;
    private static final Edge[] e = new Edge[MAXE];
    private static final int[] arr = new int[MAXV];
    private static final int[] size = new int[MAXV];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            e[i] = new Edge(a, b, c);
        }
        Arrays.sort(e, 0, m, Comparator.comparingInt(e -> e.dist));
        int res = 0;
        for (int i = 0; i < m; i++)
            if (union(e[i].u, e[i].v) == 1) res += e[i].dist;
        System.out.println(res);
    }

    private static int union(int x, int y) {
        x = repr(x);
        y = repr(y);
        if (x == y) return 0;
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        arr[y] = x;
        size[x] += size[y];
        return 1;
    }

    private static int repr(int n) {
        if (n == arr[n]) return n;
        return arr[n] = repr(arr[n]);
    }

    private record Edge(int u, int v, int dist) {

    }
}
