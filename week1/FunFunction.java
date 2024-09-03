package solutions.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FunFunction {
    private static final Map<Pair, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(solve(x, y));
    }

    public static int solve(int x, int y) {
        if (x <= 0 || y <= 0) {
            return 0;
        }
        Pair pair = new Pair(x, y);
        if (map.getOrDefault(pair, -1) != -1) {
            return map.get(pair);
        }
        if (x <= y) {
            int num = solve(x - 1, y - 2) + solve(x - 2, y - 1) + 2;
            map.put(pair, num);
            return num;
        }
        int num2 = solve(x - 2, y - 2) + 1;
        map.put(pair, num2);
        return num2;
    }

    private record Pair(int first, int second) {

    }
}


