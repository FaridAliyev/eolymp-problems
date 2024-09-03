package solutions.quiz4;

import java.util.Scanner;

public class DirectedGraphTimestamps {

    private static final int[][] g = new int[101][101];
    private static final int[] used = new int[101];
    private static final int[] d = new int[101];
    private static final int[] f = new int[101];
    private static int t = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            for (int j = 0; j < a; j++) {
                int v = scanner.nextInt();
                g[i][v] = 1;
            }
        }
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) {
                dfs(i, n);
            }

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d %d\n", d[i], f[i]);
        }
    }

    private static void dfs(int v, int n) {
        d[v] = t++;
        used[v] = 1;
        for (int i = 1; i <= n; i++)
            if ((g[v][i] == 1) && (used[i] == 0)) dfs(i, n);
        f[v] = t++;
    }

}
