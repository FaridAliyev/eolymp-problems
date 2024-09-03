package solutions.week8.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JurassicJigsaw {
    private static final int INF = Integer.MAX_VALUE;
    private static final int MAX = 5001;
    private static final int[] used = new int[MAX];
    private static final int[] min_e = new int[MAX];
    private static final int[] end_e = new int[MAX];
    private static final String[] str = new String[MAX];
    private static final List<String> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }
        Arrays.fill(min_e, Integer.MAX_VALUE);
        Arrays.fill(end_e, -1);
        double dist = 0;
        int cur = 0;
        min_e[cur] = 0;
        used[cur] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (used[j] == 0 && (strDifference(str[cur], str[j], k) < min_e[j])) {
                    min_e[j] = strDifference(str[cur], str[j], k);
                    end_e[j] = cur;
                }
            }
            int min = INF;
            for (int j = 0; j < n; j++) {
                if (used[j] == 0 && (min_e[j] < min)) {
                    min = min_e[j];
                    cur = j;
                }
            }

            edges.add(cur + " " + end_e[cur]);

            used[cur] = 1;
            dist += min_e[cur];
        }

        String numberAsString = Double.toString(dist);
        String integerPart = numberAsString.split("\\.")[0];
        System.out.println(integerPart);

        for (String s :
                edges) {
            System.out.println(s);
        }
    }

    private static int strDifference(String a, String b, int k) {
        int diff = 0;
        for (int i = 0; i < k; ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }
}
