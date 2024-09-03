package solutions.week8.mst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LandlineTelephoneNetwork {
    private static final int INF = Integer.MAX_VALUE;
    private static final int MAXV = 20001;
    private static final int MAXE = 100001;
    private static final Edge[] e = new Edge[MAXE];
    private static final int[] arr = new int[MAXV];
    private static final int[] size = new int[MAXV];
    private static final int[] insecure = new int[MAXV];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        if (m == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < p; i++) {
            insecure[scanner.nextInt()] = INF;
        }
        int counter = 0;
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int dist = scanner.nextInt();
            if (m == 1) {
                System.out.println(dist);
                return;
            }
            if ((insecure[u] > 0) && (insecure[v] == 0))
                insecure[u] = Math.min(insecure[u], dist);
            if ((insecure[v] > 0) && (insecure[u] == 0))
                insecure[v] = Math.min(insecure[v], dist);
            if ((insecure[u] == 0) && (insecure[v] == 0))
                e[counter++] = new Edge(u, v, dist);
        }
        Arrays.sort(e, 0, counter, Comparator.comparingInt(e -> e.dist));
        int count = 0;
        long res = 0;
        for (int i = 0; i < counter; i++) {
            if (union(e[i].u, e[i].v) == 1) {
                res += e[i].dist;
                count++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (insecure[i] > 0) {
                res += insecure[i];
                count++;
            }
        }

        if ((count != n - 1) || (res > INF)) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
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
