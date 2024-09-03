package solutions.week3.graph;

import java.util.Scanner;

public class BobInWonderland {
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
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] > 2) {
                count += degree[i] - 2;
            }
        }
        System.out.println(count);
    }
}
