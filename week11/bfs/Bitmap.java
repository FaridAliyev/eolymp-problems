package solutions.week11.bfs;

import java.util.*;

public class Bitmap {
    private static final Queue<Pair> q = new ArrayDeque<>();
    private static final String[] g = new String[1001];
    private static final int[][] dist = new int[1001][1001];
    private static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (int[] ints :
                    dist) {
                Arrays.fill(ints, -1);
            }
            scanner.nextLine();
            for (int j = 1; j <= n; j++) {
                g[j] = scanner.nextLine();
                g[j] = " " + g[j];
            }
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (g[j].charAt(k) == '1') {
                        q.add(new Pair(j, k));
                        dist[j][k] = 0;
                    }
                }
            }
            bfs();
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    System.out.print(dist[j][k] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int x = temp.x;
            int y = temp.y;

            int d = dist[x][y] + 1;
            add(x + 1, y, d);
            add(x - 1, y, d);
            add(x, y + 1, d);
            add(x, y - 1, d);
        }
    }

    private static void add(int x, int y, int d) {
        if ((x < 1) || (x > n) || (y < 1) || (y > m)) return;
        if (dist[x][y] != -1) return;
        dist[x][y] = d;
        q.add(new Pair(x, y));
    }

    private record Pair(int x, int y) {

    }
}