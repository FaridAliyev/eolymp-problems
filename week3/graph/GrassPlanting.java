package solutions.week3.graph;

import java.util.Scanner;

public class GrassPlanting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] degree = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            degree[from]++;
            degree[to]++;
        }
        int max = degree[0];

        for (int i = 1; i < degree.length; i++)
            if (degree[i] > max)
                max = degree[i];

        System.out.println(max + 1);
    }
}
