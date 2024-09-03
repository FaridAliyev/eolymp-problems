package solutions.week10.dfs;

import java.util.Scanner;

public class IsItATree {
    private static final int[][] g = new int[101][101];
    private static final int[] used = new int[101];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int edgeCount = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scanner.nextInt();
                edgeCount += g[i][j];
            }
        }
        edgeCount /= 2;
        dfs(1, n);
        System.out.println(count == n && edgeCount == n - 1 ? "YES" : "NO");
    }

    private static void dfs(int v, int n) {
        used[v] = 1;
        count++;
        for (int i = 1; i <= n; i++)
            if ((g[v][i] == 1) && (used[i] == 0)) dfs(i, n);
    }
}
