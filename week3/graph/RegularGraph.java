package solutions.week3.graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RegularGraph {
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
        Set<Integer> distinct = Arrays.stream(degree).boxed().collect(Collectors.toSet());
        boolean allEqual = distinct.size() == 1;
        System.out.println(allEqual ? "YES" : "NO");
    }
}
