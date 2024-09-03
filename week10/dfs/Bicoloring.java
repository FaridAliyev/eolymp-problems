package solutions.week10.dfs;

import java.util.Scanner;

public class Bicoloring {
    private static int[][] g;
    private static int[] used;
    private static int n, l, error;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) break;
            l = scanner.nextInt();
            g = new int[n + 1][n + 1];
            used = new int[n + 1];

            for (int i = 0; i < l; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                g[a][b] = g[b][a] = 1;
            }

            error = 0;
            dfs(1, 1);
            System.out.println(error == 1 ? "NOT BICOLOURABLE." : "BICOLOURABLE.");
        }
    }

    private static void dfs(int v, int color) {
        if (error == 1) return;
        used[v] = color;
        for (int i = 1; i <= n; i++)
            if (g[v][i] == 1) {
                if (used[i] == 0) dfs(i, 3 - color);
                else if (used[v] == used[i]) error = 1;
            }
    }
}
