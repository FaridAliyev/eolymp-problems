package solutions.week3.graph;

import java.util.Scanner;

public class ListToMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                int val = scanner.nextInt();
                matrix[i][val - 1] = 1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
