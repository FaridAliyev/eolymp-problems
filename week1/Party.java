package solutions.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Party {
    private static final Map<Pair, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, k));
    }

    public static int solve(int n, int k) {
        if (n == k) return 1;
        if (k == 0) return 1;
        Pair pair = new Pair(n, k);
        if (map.getOrDefault(pair, -1) != -1) {
            return map.get(pair);
        }
        int num = (solve(n - 1, k - 1) + solve(n - 1, k)) % 9929;
        map.put(pair, num);
        return num;
    }

    private record Pair(int n, int k) {

    }
}
