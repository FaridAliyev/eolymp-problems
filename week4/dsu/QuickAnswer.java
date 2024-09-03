package solutions.week4.dsu;

import java.util.Scanner;

public class QuickAnswer {
    private static final int[] arr = new int[100001];
    private static final int[] depth = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] id = new int[n + 1];
            int maxId = n + 1;
            int yes = 0;
            int no = 0;

            for (int i = 1; i <= 100000; ++i) {
                arr[i] = i;
                depth[i] = 0;
            }

            for (int i = 1; i <= n; i++) {
                id[i] = i;
            }

            loop:
            while (scanner.hasNext()) {
                String command = scanner.next();
                switch (command) {
                    case "c" -> {
                        int u = scanner.nextInt();
                        int v = scanner.nextInt();
                        union(id[u], id[v]);
                    }
                    case "q" -> {
                        int u = scanner.nextInt();
                        int v = scanner.nextInt();
                        int r1 = representative(id[u]);
                        int r2 = representative(id[v]);
                        if (r1 == r2) yes++;
                        else no++;
                    }
                    case "d" -> {
                        int v = scanner.nextInt();
                        id[v] = maxId;
                        maxId++;
                    }
                    default -> {
                        break loop;
                    }
                }
            }
            System.out.printf("%d , %d\n", yes, no);
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
    }

    public static int representative(int v) {
        if (v == arr[v]) return v;
        return arr[v] = representative(arr[v]);
    }
}
