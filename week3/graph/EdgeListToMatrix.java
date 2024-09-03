package solutions.week3.graph;

import java.util.Scanner;

public class EdgeListToMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            matrix[from][to] = matrix[to][from] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
