package solutions.week3.graph;

import java.util.Scanner;

public class NumberOfHangingVertices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += scanner.nextInt();
            }
            if (sum == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
