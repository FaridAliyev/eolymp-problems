package solutions.week12.topologicalSort;

import java.util.Scanner;

public class AreaOfTheRoom {
    private static char[][] m;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = new char[n + 1][n];
        for (int i = 1; i <= n; i++)
            m[i] = ("*" + scanner.next()).toCharArray();

        int i = scanner.nextInt();
        int j = scanner.nextInt();
        dfs(i, j);
        System.out.println(cnt);
    }

    private static void dfs(int i, int j) {
        if (m[i][j] == '*') return;
        cnt++;
        m[i][j] = '*';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
