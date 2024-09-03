package solutions.week3.graph;

import java.util.Scanner;

public class CompleteGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            if (from == to) {
                System.out.println("NO");
                return;
            }
            matrix[from][to]++;
            matrix[to][from]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 0) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
