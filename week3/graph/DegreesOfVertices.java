package solutions.week3.graph;

import java.util.Scanner;

public class DegreesOfVertices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }
}
