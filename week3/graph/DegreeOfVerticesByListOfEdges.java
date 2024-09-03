package solutions.week3.graph;

import java.util.Scanner;

public class DegreeOfVerticesByListOfEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] degree = new int[n];
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            degree[from]++;
            degree[to]++;
        }
        for (int i = 0; i < degree.length; i++) {
            System.out.println(degree[i]);
        }
    }
}
