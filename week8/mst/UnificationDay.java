package solutions.week8.mst;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class UnificationDay {
    private static final int MAX = 5001;
    private static final int[] x = new int[MAX];
    private static final int[] y = new int[MAX];
    private static final int[] used = new int[MAX];
    private static final int[] min_e = new int[MAX];
    private static final int[] end_e = new int[MAX];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        Arrays.fill(min_e, Integer.MAX_VALUE);
        Arrays.fill(end_e, -1);
        double dist = min_e[1] = 0;
        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++)
                if (used[j] == 0 && (v == -1 || min_e[j] < min_e[v])) v = j;

            used[v] = 1;
            if (end_e[v] != -1) dist += Math.sqrt(dist2(v, end_e[v]));

            for (int to = 0; to < n; to++) {
                int dV_TO = dist2(v, to);
                if (used[to] == 0 && (dV_TO < min_e[to])) {
                    min_e[to] = dV_TO;
                    end_e[to] = v;
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(6));
        String formattedNumber = decimalFormat.format(dist);
        System.out.println(formattedNumber);
    }

    private static int dist2(int i, int j) {
        return (x[j] - x[i]) * (x[j] - x[i]) + (y[j] - y[i]) * (y[j] - y[i]);
    }
}
