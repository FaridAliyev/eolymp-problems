package solutions.week3.graph;

import java.util.Scanner;

public class MultiEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            if(++matrix[from][to] > 1){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
