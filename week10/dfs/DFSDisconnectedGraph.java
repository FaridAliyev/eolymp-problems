package solutions.week10.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class DFSDisconnectedGraph {
    private static final int[][] g = new int[101][101];
    private static final int[] used = new int[101];
    private static final int[] d = new int[101];
    private static final int[] f = new int[101];
    private static int t = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g[a][b] = g[b][a] = 1;
        }
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) {
                dfs(i, n);
            }

        Arrays.fill(used,0);
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) dfs1(i, n);
    }

    private static void dfs(int v, int n) {
        d[v] = t++;
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if ((g[v][i] == 1) && (used[i] == 0)) dfs(i, n);
        f[v] = t++;
    }

    static void dfs1(int v, int n) {
        used[v] = 1;
        System.out.println("Vertex: " + v + ", Gray " + d[v] + ", Black " + f[v]);
        for (int i = 1; i <= n; i++)
            if (g[v][i] == 1 && used[i] == 0) dfs1(i, n);

    }
}
