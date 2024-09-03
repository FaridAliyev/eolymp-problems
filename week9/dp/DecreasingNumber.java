package solutions.week9.dp;

import java.util.Scanner;

public class DecreasingNumber {
    private static final int[] d = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        d[1] = 0;
        for (int i = 2; i <= 1000000; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
        }
        while (scanner.hasNextInt()){
            System.out.println(d[scanner.nextInt()]);
        }
    }
}
