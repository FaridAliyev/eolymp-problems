package solutions.week3.graph;

import java.util.Scanner;

public class CitiesAndRoads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n * n; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum / 2);
    }
}
